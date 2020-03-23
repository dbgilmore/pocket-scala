package transform.map

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class StateQueryStringMapper_UnitTest extends AnyFunSuite with Matchers {

  test("unread is mapped") {
    StateQueryStringMapper.map(Some("unread")) shouldBe "&state=unread"
  }

  test("archived is mapped") {
    StateQueryStringMapper.map(Some("archived")) shouldBe "&state=archived"
  }

  test("all is mapped") {
    StateQueryStringMapper.map(Some("all")) shouldBe "&state=all"
  }

  test("unknown value is mapped") {
    StateQueryStringMapper.map(Some("unknown")) shouldBe ""
  }

  test("None is mapped") {
    StateQueryStringMapper.map(None) shouldBe ""
  }
}
