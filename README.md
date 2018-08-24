# scala-akka-http-angular.g8

A [Giter8][g8] template for a Scala Akka-HTTP application wich will be shipped with an Angular 6+ front end. To know more on how to create to create a new g8 template read the [official documentation][g8 docs].

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

[g8]: http://www.foundweekends.org/giter8/
[g8 docs]: http://www.foundweekends.org/giter8/template.html
[g8 test]: http://www.foundweekends.org/giter8/testing.html