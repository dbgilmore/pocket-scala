package transform.map

/**
 * Object to convert a raw tag string to a tag query string
 */
object TagQueryStringMapper {

  /**
   * raw tag query string
   */
  val tagQueryString: String = "&tag="

  /**
   * untagged
   */
  val untagged = "_untagged_"

  /**
   * Function to convert a raw tag string to a tag query string
   * @param tag The tag to convert
   * @return tag query string
   */
  def map(tag: Option[String]): String = {
    tag match {
      case Some("untagged") => s"$tagQueryString$untagged"
      case Some(tagString) => s"$tagQueryString$tagString"
      case None => ""
    }
  }
}
