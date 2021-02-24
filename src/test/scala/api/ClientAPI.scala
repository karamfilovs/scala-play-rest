package api

import play.api.libs.ws.WSResponse

class ClientAPI extends HTTPClient {
  private val ClientsUrl = "/clients"
  private val ClientUrl = "/client"

  def getAllClients: WSResponse = get(ClientsUrl)

  def getClient(id: Int): WSResponse = get(s"$ClientUrl/$id")

  def deleteClient(id: Int): WSResponse = delete(s"$ClientUrl/$id")

  def createClient(firmName: String, firmMol: String, firmTown: String = "Sofia", firmAddr: String = "Ivan Stranski 3", firmIsVatReg: Boolean = false): WSResponse = {
    val body =
      s"""{
         |    "firm_name": "$firmName",
         |    "firm_town": "$firmTown",
         |    "firm_addr": "$firmAddr",
         |    "firm_mol": "$firmMol",
         |    "firm_is_reg_vat": "$firmIsVatReg"
         |}""".stripMargin

    post(ClientUrl, body)
  }

  def updateClient(clientId: Int, firmName: String, firmMol: String, firmTown: String = "Sofia", firmAddr: String = "Ivan Stranski 3", firmIsVatReg: Boolean = false): WSResponse = {
    val body =
      s"""{
         |    "firm_name": "$firmName",
         |    "firm_town": "$firmTown",
         |    "firm_addr": "$firmAddr",
         |    "firm_mol": "$firmMol",
         |    "firm_is_reg_vat": "$firmIsVatReg"
         |}""".stripMargin

    put(s"$ClientUrl/$clientId", body)
  }
}
