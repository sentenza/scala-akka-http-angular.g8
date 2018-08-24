// Boilerplate to give the user a nice default project!
import scala.sys.process.Process
import sbt.complete.DefaultParsers._

lazy val akkaHttpVersion = "$akka_http_version$"
lazy val akkaVersion    = "$akka_version$"
lazy val scalaTestVersion = "$scala_test_version$"
lazy val slickVersion = "$slick_version$"
lazy val slf4jVersion = "$slf4j_version$"
lazy val h2Version = "$h2_version$"
lazy val ammoniteVersion = "$ammonite_version$"

lazy val npmVersion = taskKey[Unit]("Show npm version")
lazy val ngInit = taskKey[Unit]("Inits a new Angular application, using the ui folder")
lazy val updateNpm = taskKey[Unit]("Update npm")
lazy val npmTask = inputKey[Unit]("Run npm with arguments")

lazy val commonSettings = Seq(
    organization := "$organization$",
    name := "$name$",
    version := "$app_version$",
    scalaVersion := "$scala_version$"
)

lazy val rootSettings = Seq (
    npmVersion := {
        haltOnCmdResultError(Process("npm -version", baseDirectory.value / "ui").!)
    },
    ngInit := {
        haltOnCmdResultError(Process("npm install -g @angular/cli", baseDirectory.value).!)
        haltOnCmdResultError(Process("ng new ui --style scss", baseDirectory.value).!)
    },
    updateNpm := {
        println("Updating npm dependencies")
        haltOnCmdResultError(Process("npm install", baseDirectory.value / "ui").!)
      },
      npmTask := {
        val taskName = spaceDelimited("<arg>").parsed.mkString(" ")
        updateNpm.value
        val localNpmCommand = "npm " + taskName
        def buildWebpack() =
          Process(localNpmCommand, baseDirectory.value / "ui").!
        println("Building with Webpack : " + taskName)
        haltOnCmdResultError(buildWebpack())
    }
)

def haltOnCmdResultError(result: Int) {
  if (result != 0) {
    throw new Exception("Build failed.")
  }
}

lazy val root = (project in file("."))
  .settings(rootSettings)
  .aggregate(backend, ui)

lazy val backend = (project in file("backend"))
  .settings(
    commonSettings,
    // other settings
     libraryDependencies ++= Seq(
       "com.typesafe.akka"   %% "akka-http"            % akkaHttpVersion,
       "com.typesafe.akka"   %% "akka-http-spray-json" % akkaHttpVersion,
       "com.typesafe.akka"   %% "akka-http-xml"        % akkaHttpVersion,
       "com.typesafe.akka"   %% "akka-stream"          % akkaVersion,

       "com.typesafe.slick"  %% "slick"                % slickVersion,
       "org.slf4j"           %  "slf4j-nop"            % slf4jVersion,
       "com.h2database"      %  "h2"                   % h2Version,

       "com.typesafe.akka"   %% "akka-http-testkit"    % akkaHttpVersion   % Test,
       "com.typesafe.akka"   %% "akka-testkit"         % akkaVersion       % Test,
       "com.typesafe.akka"   %% "akka-stream-testkit"  % akkaVersion       % Test,
       "org.scalatest"       %% "scalatest"            % scalaTestVersion  % Test,
       "com.lihaoyi"         %  "ammonite"             % ammoniteVersion   % "test" cross CrossVersion.full

    )
  )

lazy val ui = (project in file("ui"))
  .settings(
    commonSettings,
    // other settings
)
