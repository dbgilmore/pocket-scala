package transform.map

/**
 * Object to convert a raw detailType string to a detail type query string
 */
object DetailTypeQueryStringMapper {

  /**
   * base detail type string
   */
  val detailTypeQueryString: String = "&detailType="

  /**
   * simple string
   */
  val simple: String = "simple"

  /**
   * complete string
   */
  val complete: String = "complete"


  /**
   * Function to convert a raw detaiLType string to a detail type query string
   * @param detailType The raw detail type string
   * @return detail type query string
   */
  def map(detailType: Option[String]): String = {
    detailType match {
      case Some("simple") => s"$detailTypeQueryString$simple"
      case Some("complete") => s"$detailTypeQueryString$complete"
      case _ => ""
    }
  }
}
