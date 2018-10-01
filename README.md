# scala-akka-http-angular.g8

A [Giter8][g8] template for a [Scala][scala] [Akka HTTP][akka] application wich will be shipped with an [Angular][angularweb] 6+ front end. To know more on how to create to create a new g8 template read the [official documentation][g8 docs].

NOTE: [SBT][sbt] is used to instantiate the skeleton

### About Akka HTTP and Angular

[Akka HTTP](https://doc.akka.io/docs/akka/current/guide/modules.html#http) is an Akka module, originating from spray.io, for building reactive REST services with an elegant DSL. Akka HTTP is a great toolkit for building backends for single-page or mobile applications. 

> Akka provides a library to construct or consume such HTTP services by giving a set of tools to create HTTP services (and serve them) and a client that can be used to consume other services. These tools are particularly suited to streaming in and out a large set of data or real-time events by leveraging the underlying model of Akka Streams.

## Getting Started

Choose a location on your file system for your project. The template will prompt you for a set of variables that will eventually init your new [Scala][scala]/[Angular][angularweb] project. Note that it can take from a few seconds to a few minutes for sbt to download dependencies.

To create your project, follow these steps:

1. Open a console and change into the directory you selected for your project.
2. Download an install [SBT][sbt] 
3. Run the following command:

```
$ sbt new sentenza/scala-akka-http-angular.g8
```

The template prompts for the a series of parameters. Press Enter to accept the defaults or specify your own values.

### Init the Angular Front End application

```bash
$ cd ui
$ npm install
```

And then, in order to load the development Angular server, one can simply execute `ng serve`. 

## Skeleton

The skeleton has a few things to make life a little easier:

* `.editorconfig` file for indentation
* `.gitignore` for obvious reasons

In the `build.sbt` file I arbitrarily chose some common libraries I use quite frequently for the skeleton:

* [typesafe config][config] for parsing `application.properties`

It has default `application.properties` and `logback.xml` resource files that are used. 

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
