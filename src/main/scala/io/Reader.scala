package io

import conf.PocketConf
import io.circe.Decoder
import io.circe.parser._
import model.PocketResponse
import io.circe.generic.auto._
import transform.map.{DetailTypeQueryStringMapper, StateQueryStringMapper, TagQueryStringMapper}

/**
 * Class for reading articles from Pocket
 * @param requestSender To send the request to Pocket
 */
class Reader(requestSender: Requester[Seq[String], IOResponse]) {

  /**
   * Function to read articles from Pocket
   * @param tag Which tags to filter the articles on
   * @param detailType Which level of detail is required
   * @return PocketResponse A list of articles read from Pocket
   */
  def read(
            tag: Option[String] = None,
            detailType: Option[String] = None,
            state: Option[String] = None
          ): PocketResponse = {

    val response = requestSender.get(
      Seq(
        DetailTypeQueryStringMapper.map(detailType),
        TagQueryStringMapper.map(tag),
        StateQueryStringMapper.map(state)
      )
    )

    val parsedResponse = for {
      rawResponse <- response.body
      parsedResponse <- decoder[PocketResponse](rawResponse)
    } yield parsedResponse

    parsedResponse match {
      case Left(sadError) =>
        println(sadError)
        throw new RuntimeException()
      case Right(happyResponse) =>
        println(s"Retrieved ${happyResponse.list.getOrElse(Map()).size} articles from Pocket")
        happyResponse
    }

  }

  /**
   * Function to decode the response from Pocket into a Scala case class
   * @param json The json returned from the request
   * @tparam A Type to decode to
   * @return Decoded JSON
   */
  def decoder[A: Decoder](json: String): Either[io.circe.Error, A] = {
    decode[A](json)
  }
}

/**
 * Companion factory object
 */
object Reader {

  /**
   * Function to create a new instance of Reader
   * @param conf Conf values
   * @return A new instance of Reader
   */
  def apply(conf: PocketConf): Reader = {
    val requestSender = new RequestSender(conf)
    new Reader(requestSender)
  }
}
