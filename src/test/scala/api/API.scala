package api

class API {
  lazy val clientAPI = new ClientAPI
  lazy val itemAPI = new ItemAPI
  lazy val bankAccountAPI = new BankAccountAPI

}
