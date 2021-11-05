package specs

import api.API
import com.google.gson.Gson
import org.scalatest.BeforeAndAfterAll
import org.scalatestplus.play.PlaySpec
import play.api.Logger

class BaseSpec extends PlaySpec with BeforeAndAfterAll{
  protected val api = new API
  protected val Gson: Gson = new Gson().newBuilder().setPrettyPrinting().create()
  private val logger: Logger = Logger(this.getClass)

 override def beforeAll()  = {
    logger.info("Starting tests")
  }


}
