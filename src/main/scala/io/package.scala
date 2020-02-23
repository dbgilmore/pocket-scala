import sttp.client.{Identity, Response}

package object io {
  type IOResponse = Identity[Response[Either[String, String]]]
}
