package $package$

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
// http
// import $package$.http.HttpService

// models
// import $package$.models.User

// services
import $package.services.{AppService, UsersService}
import $package$.utils.Persistence

// Utils
import $package$.utils.Configuration

import scala.io.StdIn
// The Server dependencies
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

Object Main extends App with Configuration {
    println("I'm alive!")
}