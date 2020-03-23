package io

import io.circe.Json

/**
 * Base trait for something that can request
 *
 * @tparam A Type param for options passed in
 * @tparam B Type param for response
 */
trait Requester[A, B] {

  def get(options: A): B

  def modify(json: Json): B

}
