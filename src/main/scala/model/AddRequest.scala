package model

/**
 * Case class representing a request to add articles
 * @param action The action to perform
 * @param item_id The article id
 * @param url The tag value
 */
case class AddRequest(
                       action: String,
                       item_id: String,
                       url: String
                     )
