package specs

import api.API
import org.scalatestplus.play.PlaySpec
import play.api.libs.json.Json

import java.time.LocalDateTime

class ItemSpec extends PlaySpec {
  val api = new API

  "Items" should {

    "be returned for user with valid credentials" in {
      val response = api.itemAPI.getAllItems
      response.status mustBe 200
      response.body must not be empty
    }
  }

  "Item" should {
    "be created with all mandatory fields" in {
      val response = api.itemAPI.createItem("My Item" + LocalDateTime.now, 10, "кг.")
      response.status mustBe 200
      response.body must include ("Артикула е създаден успешно!")
      val json = Json.parse(response.body)
      val id = (json \ "success" \ "id").as[Int]
      api.itemAPI.deleteItem(id)
    }
  }
}
