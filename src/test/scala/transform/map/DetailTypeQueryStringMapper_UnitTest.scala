package transform.map

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class DetailTypeQueryStringMapper_UnitTest extends AnyFunSuite with Matchers {

  test("simple is mapped") {
    DetailTypeQueryStringMapper.map(Some("simple")) shouldBe "&detailType=simple"
  }

  test("complete is mapped") {
    DetailTypeQueryStringMapper.map(Some("complete")) shouldBe "&detailType=complete"
  }

  test("unknown value is mapped") {
    DetailTypeQueryStringMapper.map(Some("unknown")) shouldBe ""
  }

  test("None is mapped") {
    DetailTypeQueryStringMapper.map(None) shouldBe ""
  }
}
