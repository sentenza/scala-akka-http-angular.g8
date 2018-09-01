package $package$.utils

import scala.concurrent.ExecutionContext
import scala.concurrent.Future

// Use H2Driver to connect to an H2 database
import slick.jdbc.H2Profile.api._
import $package$.models.User
import $package$.models.db.UsersTable


class Persistence(implicit executionContext: ExecutionContext)  {
  val db = Database.forConfig("h2mem1")
  val users = TableQuery[UsersTable]

  val setup = DBIO.seq(
    // Create the tables, including primary and foreign keys
    users.schema.create,

    // Insert some users
    users += User(Some(1), "first@x.test", "secret"),
    users += User(Some(2), "second@y.test", "secret2"),
    users += User(Some(3), "third@z.test", "secret3")
  )

  def initDatabase(): Future[Seq[User]] =
    db.run(setup.flatMap(_ => users.result))

  def fetchUsers(): Future[Seq[User]] = db.run(this.users.result)

  def countUsers(): Future[Int] = db.run(this.users.size.result)

}
