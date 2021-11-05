package specs

class BankAccountSpec extends BaseSpec {

  "Bank accounts" should {
    "be returned for user with valid credentials" in {
      val response = api.bankAccountAPI.getAllBankAccounts
      response.status mustBe 200
      response.body must not be empty
    }
  }
}
