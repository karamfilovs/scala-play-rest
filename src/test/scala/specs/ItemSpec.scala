package specs

import api.API
import org.scalatestplus.play.PlaySpec

class ItemSpec extends PlaySpec {
  val api = new API

  "Items" should {

    "be returned for user with valid credentials" in {
      val response = api.itemAPI.getAllItems
      response.status mustBe 200
      response.body must not be empty
    }
  }
}
