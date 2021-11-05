package api

import dto.Item
import play.api.libs.ws.WSResponse

class ItemAPI extends HTTPClient {
  private val ItemsUrl = "/items"
  private val ItemUrl = "/item"

  def getAllItems: WSResponse = get(ItemsUrl)

  def getItem(id: Int): WSResponse = get(s"$ItemUrl/$id")

  def createItem(item: Item): WSResponse = post(ItemUrl, item)

  def deleteItem(id: Int): WSResponse = delete(s"$ItemUrl/$id")

}
