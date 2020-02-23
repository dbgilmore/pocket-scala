package model

/**
 * Case class representing a response from Pocket
 * @param list A list of articles returned from Pocket
 */
case class PocketResponse(list: Option[Map[String, Article]])
