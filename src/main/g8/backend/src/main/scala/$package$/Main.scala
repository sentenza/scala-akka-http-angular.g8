package $package$

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import scala.io.StdIn
// Server dependencies
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}
// Utils
import $package$.utils.Configuration
// models
import $package$.models.User
// http
import $package$.http.HttpService
// services
import $package$.services.{ AppService, UsersService }

import $package$.utils.Persistence

/**
 * The main class that will start the server.
 * It manages the exit point of the application
 */
object Main extends App with Configuration {
  // to run the route
  implicit val system: ActorSystem = ActorSystem()
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  // for the future map/flatmap at the end and future in fetchItem and saveOrder
  implicit val executionContext = system.dispatcher
  val persistence = new Persistence()
  val initialized = persistence.initDatabase()
  // using andThen() so we the Future won't complete but "keep going"
  // in order to mix it with the rest of futures using flatMap below
  val initDatabase = initialized.andThen {
    case Success(users) => users.foreach {
                  case User(id, email, password) =>
                    println("  " + id + "\t" + email + "\t" + password)
    }
  }

  // Flatten all the Futures into a single flow of actions
  val bindingFuture = initDatabase.flatMap { _ => // We are not collecting anything from the previous flow using _
    // Services
    val usersService = new UsersService(persistence)
    val appService = new AppService()
    // Main HTTP service
    val httpService = new HttpService(usersService, appService)

    // Only the last one, in this case will be returned as a Result of "binding"
    Http().bindAndHandle(httpService.routes, httpHost, httpPort)
  }

  bindingFuture.onComplete {
    case Success(b) => println(s"Service is up: \$b")
    case Failure(ex) =>
      println("**** ERROR ****")
      ex.printStackTrace()
  }

  println(s"Server online at http://\$httpHost:\$httpPort/v1")
  println("Press RETURN to stop")

  Await.result(system.whenTerminated, Duration.Inf)
}