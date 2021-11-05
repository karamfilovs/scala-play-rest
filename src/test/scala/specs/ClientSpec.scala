package specs

import api.API
import dto.Client
import org.scalatestplus.play.PlaySpec
import play.api.libs.json.Json

import java.time.OffsetDateTime

class ClientSpec extends PlaySpec {
  val api = new API

  "Clients" should {

    "be returned for user with valid credentials" in {
      val response = api.clientAPI.getAllClients
      response.status mustBe 200
      response.body must not be empty
    }
  }

  "Client" should {

    "be returned when client id is valid/existing" in {
      //Create new client
      val createResponse = api.clientAPI.createClient(Client("Pragmatic", "Sofia", "Ivan Stranski", "Alex Karamfilov", false))
      createResponse.status mustBe 200
      val json = Json.parse(createResponse.body)
      val id = (json \ "success" \ "id").as[Int]
      val response = api.clientAPI.getClient(id)
      response.status mustBe 200
      response.body must not be empty
      //Delete client so that the test can work again
      api.clientAPI.deleteClient(id)
    }

    "not be returned when id is invalid/not-existing" in {
      val response = api.clientAPI.getClient(3424242)
      response.status mustBe 404
      response.body must not be empty
      response.body must include("Клиента не е намерен")
    }

    "be created with valid information" in {
      val createResponse = api.clientAPI.createClient(Client("Pragmatic" + OffsetDateTime.now(), "Sofia", "Ivan Stranski", "Alex Karamfilov", false))
      createResponse.status mustBe 200
      createResponse.body must include("Клиента е създаден успешно!")
      val json = Json.parse(createResponse.body)
      val id = (json \ "success" \ "id").as[Int]
      api.clientAPI.deleteClient(id)
    }

    "be created with mandatory and optional fields" in {
      val client = Client("Pragmatic" + OffsetDateTime.now(), "Sofia", "Ivan Stranski", "Alex Karamfilov", false, "Germany")
      val createResponse = api.clientAPI.createClient(client)
      createResponse.status mustBe 200
      createResponse.body must include("Клиента е създаден успешно!")
      val json = Json.parse(createResponse.body)
      val id = (json \ "success" \ "id").as[Int]
      api.clientAPI.deleteClient(id)
    }


    "be deleted successfully with valid id" in {
      //Create new client
      val client = Client("Pragmatic" + OffsetDateTime.now(), "Sofia", "Ivan Stranski", "Alex Karamfilov", false, "Germany")
      val createResponse = api.clientAPI.createClient(client)
      createResponse.status mustBe 200
      val json = Json.parse(createResponse.body)
      val id = (json \ "success" \ "id").as[Int]
      //Delete client
      val response = api.clientAPI.deleteClient(id)
      response.status mustBe 200
      response.body mustBe "{\"success\":{\"message\":\"Клиента е изтрит\"}}"
    }

    "be updated when id is valid and body is valid" in {
      //Create new client
      val client = Client("ToBeUpdated", "Sofia", "Ivan Stranski", "Alex Karamfilov", false, "Germany")
      val createResponse = api.clientAPI.createClient(client)
      createResponse.status mustBe 200
      val json = Json.parse(createResponse.body)
      val id = (json \ "success" \ "id").as[Int]
      val response = api.clientAPI.updateClient(id, Client("Updated", "Sofia", "Updated Address", "Update Mol", false))
      response.status mustBe 200
      response.body must not be empty
      response.body must include("Клиента е редактиран успешно!")
      //Delete client so that the test can work again
      api.clientAPI.deleteClient(id)
    }


  }

}
