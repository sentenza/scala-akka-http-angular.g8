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

  println(s"Server online at http://\$httpHost:\$httpPort/v1")
  println("Press RETURN to stop")

  Await.result(system.whenTerminated, Duration.Inf)
}