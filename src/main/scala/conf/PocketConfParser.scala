package conf

import com.typesafe.config.{Config, ConfigFactory}

/**
 * Object for parsing a conf file
 */
object PocketConfParser {

  /**
   * Function for parsing the conf file
   * @param confLocation Location of the conf file
   * @return The parsed conf
   */
  def parse(confLocation: String): PocketConf = {

    val config: Config = ConfigFactory.load(confLocation)
    val consumerKey = config.getString("pocket.client.consumerKey")
    val accessToken = config.getString("pocket.user.accessToken")
    val baseURI = config.getString("pocket.baseURI")
    val wordsPerMinute = config.getInt("pocket.user.wordsPerMinute")

    PocketConf(consumerKey, accessToken, baseURI, wordsPerMinute)
  }
}

/**
 * Case class representing the PocketConf
 * @param consumerKey Consumer key of the client
 * @param accessToken Access token for the user
 * @param baseURI Base getpocket.com URI
 */
case class PocketConf(
                       consumerKey: String,
                       accessToken: String,
                       baseURI: String,
                       wordsPerMinute: Int
                     )
