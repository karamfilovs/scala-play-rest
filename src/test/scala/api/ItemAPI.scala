package api

import play.api.libs.ws.WSResponse

class ItemAPI extends HTTPClient {
  private val ItemsUrl = "/clients"
  private val ItemUrl = "/client"

  def getAllItems: WSResponse = get(ItemsUrl)

  def getItem(id: Int): WSResponse = get(s"$ItemUrl/$id")

}
