package io

import conf.PocketConf
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import sttp.model.StatusCode

class RequestSender_UnitTest extends AnyFunSuite with Matchers {

  test("Program flow should execute as expected") {
    val conf = PocketConf("token", "key", "https://getpocket.com/v3/", 260)
    val requestSender = new RequestSender(conf)

    val response = requestSender.get(Nil)

    response.code shouldBe StatusCode.Forbidden
    response.statusText shouldBe "Forbidden"
  }
}
