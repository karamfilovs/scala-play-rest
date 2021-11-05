package api

import dto.BankAccount
import play.api.libs.ws.WSResponse

class BankAccountAPI extends HTTPClient {
  private val BanksUrl = "/settings/bankaccounts"

  def getAllBankAccounts: WSResponse = get(BanksUrl)

  def createBankAccount(bankAccount: BankAccount): WSResponse = post(BanksUrl, bankAccount)
  def updateBankAccount(id: Int, bankAccount: BankAccount): WSResponse = post(BanksUrl + s"/$id", bankAccount)

  def getBankAccount(id: Int): WSResponse = get(s"$BanksUrl/$id")

  def deleteClient(id: Int): WSResponse = delete(s"$BanksUrl/$id")
}
