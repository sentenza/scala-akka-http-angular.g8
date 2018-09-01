# scala-akka-http-angular.g8

A [Giter8][g8] template for a [Scala][scala] [Akka HTTP][akka] application wich will be shipped with an [Angular][angularweb] 6+ front end. To know more on how to create to create a new g8 template read the [official documentation][g8 docs].

NOTE: [SBT][sbt] is used to instantiate the skeleton

## Getting Started

Download an install [SBT][sbt] and run it on the command line to create a new [Scala][scala]/[Angular][angularweb] project using the skeleton:

```
$ sbt new sentenza/scala-akka-http-angular.g8.g8
```

The template parameters are as follows:

* `name` is the name of the path the skeleton will instantiate to;

Once instantiated, you'll need to...

## Skeleton

The skeleton has a few things to make life a little easier:

* `.editorconfig` file for indentation
* `.gitignore` for obvious reasons

In the `build.sbt` file I arbitrarily chose some common libraries I use quite frequently for the skeleton:

* [typesafe config][config] for parsing `application.properties`

It has default `application.properties` and `logback.xml` resource files that are used. And for the skeleton code, there are only three files:

* `Main.scala` is the entry point that runs a simple `IO` program.
* `Config.scala` has basic reading/writing of a JSON configuration file.
* `Opts.scala` handles a simple command line parsing example.

The default `Opts` implementation has the (optional, lazy) ability to load and parse a `Config` from disk on startup. This is there for applications that need project settings that should not be stored in the `application.properties` file: API keys, passwords, user settings, etc.

## Testing the template

Giter8 provides an useful command to [test the templates locally][g8 test]. Hence, in order to test this template before committing any changes one can simply move one folder up from the root folder of the project and execute the following command:

```bash
g8 file://scala-akka-http-angular.g8/ --name=sahatest --force
```

g8 will then create a new folder named `sahatest` where the template will be generated.

```bash
$ cd sahatest/
$ sbt
> project backend
> ~ compile
```

[g8]:               http://www.foundweekends.org/giter8/
[g8 docs]:          http://www.foundweekends.org/giter8/template.html
[g8 test]:          http://www.foundweekends.org/giter8/testing.html
[angularweb]:       https://angular.io/
[sbt]:              https://www.scala-sbt.org/index.html
[scala]:            http://www.scala.org
[akka]:             https://doc.akka.io/docs/akka-http/current/