package api

import dto.Client
import play.api.libs.ws.WSResponse

class ClientAPI extends HTTPClient {
  private val ClientsUrl = "/clients"
  private val ClientUrl = "/client"

  def getAllClients: WSResponse = get(ClientsUrl)

  def getClient(id: Int): WSResponse = get(s"$ClientUrl/$id")

  def deleteClient(id: Int): WSResponse = delete(s"$ClientUrl/$id")

  def createClient(client: Client): WSResponse = post(ClientUrl, client)

  def updateClient(clientId: Int, client: Client): WSResponse = put(s"$ClientUrl/$clientId", client)


}
