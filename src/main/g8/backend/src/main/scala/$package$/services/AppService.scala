package $package$.services

import $package$.utils.Configuration
import scala.concurrent.ExecutionContext

class AppService(implicit executionContext: ExecutionContext) extends Configuration {
  val fetchAppName: String = applicationName
}