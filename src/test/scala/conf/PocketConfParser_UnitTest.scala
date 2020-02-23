package conf

import com.typesafe.config.ConfigException
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class PocketConfParser_UnitTest extends AnyFunSuite with Matchers {

  test("Valid file is parsed successfully") {
    val conf = PocketConfParser.parse("pocket.conf")

    conf.accessToken shouldBe "testAccessToken"
    conf.consumerKey shouldBe "testConsumerKey"
    conf.baseURI shouldBe "testBaseURI"
  }

  test("Invalid file should throw error") {
    intercept[ConfigException] {
      PocketConfParser.parse("invalid.conf")
    }
  }

  test("Missing file should throw error") {
    intercept[ConfigException] {
      PocketConfParser.parse("no.file")
    }
  }

}
