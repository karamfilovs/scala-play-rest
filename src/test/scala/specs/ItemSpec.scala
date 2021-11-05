package specs

import dto.Item
import play.api.libs.json.Json

import java.time.OffsetDateTime

class ItemSpec extends BaseSpec {


  "Items" should {

    "be returned for user with valid credentials" in {
      val response = api.itemAPI.getAllItems
      response.status mustBe 200
      response.body must not be empty
    }
  }

  "Item" should {
    "be created with all mandatory fields" in {
      val item = Item("Coffee" + OffsetDateTime.now(), 10, "кг")
      val response = api.itemAPI.createItem(item)
      response.status mustBe 200
      response.body must include("Артикула е създаден успешно!")
      val json = Json.parse(response.body)
      val id = (json \ "success" \ "id").as[Int]
      api.itemAPI.deleteItem(id)
    }
  }
}
