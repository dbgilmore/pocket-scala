package transform.map

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class TagQueryStringMapper_UnitTest extends AnyFunSuite with Matchers {

  test("_untagged_ is mapped") {
    TagQueryStringMapper.map(Some("untagged")) shouldBe "&tag=_untagged_"
  }

  test("15 is mapped") {
    TagQueryStringMapper.map(Some("15")) shouldBe "&tag=15"
  }

  test("None is mapped") {
    TagQueryStringMapper.map(None) shouldBe ""
  }
}
