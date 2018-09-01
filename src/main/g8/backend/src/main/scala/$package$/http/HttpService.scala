package $package$.http

import akka.actor.ActorSystem
import scala.concurrent.ExecutionContext
import akka.http.scaladsl.server.Directives._
import $package$.http.routes.{AppServiceRoute, UsersServiceRoute}
import $package$.services.{AppService, UsersService}

/**
 * The HttpService will receive the other service and then it will init all the routers
 */
class HttpService(
    val usersService: UsersService,
    val appService: AppService
    )(implicit executionContext: ExecutionContext, actorSystem: ActorSystem) {

// Routers
  val usersRouter = new UsersServiceRoute(usersService)
  val appRouter = new AppServiceRoute(appService)

  val routes = {
    pathPrefix("v1") {
      usersRouter.routes ~
      appRouter.routes
    }
  }
}