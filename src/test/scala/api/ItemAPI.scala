package api

import play.api.libs.ws.WSResponse

class ItemAPI extends HTTPClient {
  private val ItemsUrl = "/items"
  private val ItemUrl = "/item"

  def getAllItems: WSResponse = get(ItemsUrl)

  def getItem(id: Int): WSResponse = get(s"$ItemUrl/$id")

  def createItem(name: String, price: Int, unit: String): WSResponse = {
    val body =
      s"""{
         |    "name": "$name",
         |    "price_for_quantity": "$price",
         |    "quantity_unit": "$unit"
         |}""".stripMargin

    post(ItemUrl, body)
  }

  def deleteItem(id: Int): WSResponse = delete(s"$ItemUrl/$id")
}
