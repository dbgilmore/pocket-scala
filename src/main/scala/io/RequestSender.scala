package io

import conf.PocketConf
import sttp.client._
import io.RequestSender._

/**
 * Class to send a request
 * @param conf Conf values
 */
class RequestSender(conf: PocketConf) extends Requester[Seq[String], IOResponse] {

  /**
   * Function for sending a GET request
   * @param queries Any additional query params to send with the request
   * @return The response from the request
   */
  def get(queries: Seq[String]): IOResponse = {

    val request = basicRequest.get(
      uri"${queries.foldLeft(buildBaseURI(conf, getRequestType))(_ + _)}"
    )

    request.header("Content-Type", "application/json")

    implicit val backend: SttpBackend[Identity, Nothing, NothingT] = HttpURLConnectionBackend()
    request.send()
  }

}

/**
 * Companion object
 */
object RequestSender {

  /**
   * get string
   */
  val getRequestType: String = "get"

  /**
   * Function to build URI
   * @param conf Conf values
   * @param endpoint get/modify/add
   * @return A URI
   */
  def buildBaseURI(conf: PocketConf, endpoint: String): String = {
    s"${conf.baseURI}${endpoint}?consumer_key=${conf.consumerKey}&access_token=${conf.accessToken}"
  }
}
