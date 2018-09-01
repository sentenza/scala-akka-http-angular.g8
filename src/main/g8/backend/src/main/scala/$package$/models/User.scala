package $package$.models

import spray.json.JsonFormat
import spray.json.DefaultJsonProtocol._

/**
 * This case class describes each User entity
 */
case class User(id: Option[Long], email: String, password: String)

/**
 * This companion object defines a JSON format writer (spray.json)
 */
object User {
  implicit val userWriter: JsonFormat[User] = jsonFormat3(User.apply _)
}