package transform.map

/**
 * Object to convert a raw state string to a state query string
 */
object StateQueryStringMapper {

  /**
   * raw state query string
   */
  val stateQueryString: String = "&state="

  /**
   * state values that are allowed
   */
  val allowedStates: Seq[String] = Seq("unread", "archived", "all")

  /**
   * Function to convert a raw state string to a state query string
   * @param state The state to convert
   * @return state query string
   */
  def map(state: Option[String]): String = {
    state match {
      case Some(tagString) if allowedStates.contains(tagString) => s"$stateQueryString$tagString"
      case _ => ""
    }
  }
}
