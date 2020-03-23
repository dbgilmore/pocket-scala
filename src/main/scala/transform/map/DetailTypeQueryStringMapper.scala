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
   * Detail types that are allowed
   */
  val allowedDetailTypes: Seq[String] = Seq("simple", "complete")


  /**
   * Function to convert a raw detaiLType string to a detail type query string
   * @param detailType The raw detail type string
   * @return detail type query string
   */
  def map(detailType: Option[String]): String = {
    detailType match {
      case Some(detailTypeString) if allowedDetailTypes.contains(detailTypeString) => s"$detailTypeQueryString$detailTypeString"
      case _ => ""
    }
  }
}
