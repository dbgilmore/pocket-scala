package model

/**
 * Case class representing an article retrieved from getpocket.com
 *
 * @param item_id - A unique identifier matching the saved item. This id must be used to perform any actions through the v3/modify endpoint.
 * @param resolved_id - A unique identifier similar to the item_id but is unique to the actual url of the saved item. The resolved_id identifies unique urls. For example a direct link to a New York Times article and a link that redirects (ex a shortened bit.ly url) to the same article will share the same resolved_id. If this value is 0, it means that Pocket has not processed the item. Normally this happens within seconds but is possible you may request the item before it has been resolved.
 * @param given_url - The actual url that was saved with the item. This url should be used if the user wants to view the item.
 * @param resolved_url - The final url of the item. For example if the item was a shortened bit.ly link, this will be the actual article the url linked to.
 * @param given_title - The title that was saved along with the item.
 * @param resolved_title - The title that Pocket found for the item when it was parsed
 * @param status - 0, 1, 2 - 1 if the item is archived - 2 if the item should be deleted
 * @param word_count - How many words are in the article
 * @param tags - A JSON object of the user tags associated with the item
 */
case class Article(
                    item_id: String,
                    resolved_id: String,
                    given_url: String,
                    resolved_url: String,
                    given_title: String,
                    resolved_title: String,
                    status: String,
                    word_count: String,
                    tags: Option[Map[String, Tag]]
                  )
