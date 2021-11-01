package api

import play.api.libs.ws.WSResponse

class BankAccountAPI extends HTTPClient {
  private val BanksUrl = "/settings/bankaccounts"

  def getAllBankAccounts: WSResponse = get(BanksUrl)

  def getBankAccount(id: Int): WSResponse = get(s"$BanksUrl/$id")

  def deleteClient(id: Int): WSResponse = delete(s"$BanksUrl/$id")
}
