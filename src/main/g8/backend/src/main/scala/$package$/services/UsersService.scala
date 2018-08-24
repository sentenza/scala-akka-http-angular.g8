package $package$.services

import $package$.models.User
import $package$.utils.Persistence

import scala.concurrent.ExecutionContext
import scala.concurrent.Future

class UsersService(val persistence: Persistence)(implicit executionContext: ExecutionContext) {

  val getMe = () => "$github_id$"

  def getCount(): Future[Int] = persistence.countUsers()

  def retrieveUsers(): Future[Seq[User]] = persistence.fetchUsers()
}