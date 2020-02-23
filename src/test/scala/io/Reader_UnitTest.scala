package io

import model.{Article, PocketResponse}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import sttp.client.Response
import sttp.model.StatusCode

class Reader_UnitTest extends AnyFunSuite with Matchers {

  test("Program flow should execute as expected") {
    val requestSender = new Requester[Seq[String], IOResponse] {
      override def get(options: Seq[String]): IOResponse = Response(Right("""{"list":{"id1":{"item_id":"id1","resolved_id":"id1","given_url":"www.pocket.com","resolved_url":"www.pocket.com","given_title":"givenTitle","resolved_title":"resolvedTitle","status":"active","word_count":"1000"}}}"""),StatusCode.Ok)
    }

    val reader = new Reader(requestSender)

    val response = reader.read(Some("_untagged_"))

    response shouldBe PocketResponse(Some(Map(
      ("id1", Article("id1", "id1", "www.pocket.com", "www.pocket.com", "givenTitle", "resolvedTitle", "active", "1000", None))
    )))
  }
}
