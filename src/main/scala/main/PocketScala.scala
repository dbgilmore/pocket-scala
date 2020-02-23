package main

import conf.PocketConfParser
import io.Reader

/**
 * Entry point for PocketScala app
 */
object PocketScala extends App {
  val conf = PocketConfParser.parse("pocket.conf")
  val reader = Reader(conf)
  val data = reader.read(tag = Some("_untagged_"), detailType = Some("complete"))
  println(data)
}
