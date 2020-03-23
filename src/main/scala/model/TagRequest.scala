package model

/**
 * Case class representing a request to tag an article
 * @param action The action to perform
 * @param item_id The article id
 * @param tags The tag value
 */
case class TagRequest(
                       action: String,
                       item_id: String,
                       tags: String
                     )
