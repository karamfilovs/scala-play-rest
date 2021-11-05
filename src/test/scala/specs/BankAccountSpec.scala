package specs

import api.API
import org.scalatestplus.play.PlaySpec

class BankAccountSpec extends PlaySpec {
  val api = new API

  "Bank accounts" should {

    "be returned for user with valid credentials" in {
      val response = api.bankAccountAPI.getAllBankAccounts
      response.status mustBe 200
      response.body must not be empty
    }
  }
}
