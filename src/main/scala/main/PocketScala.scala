package main

import conf.PocketConfParser
import io.{Reader, Tagger, Writer}

/**
 * Entry point for PocketScala app
 */
object PocketScala extends App {
  val conf = PocketConfParser.parse("pocket.conf")
  val writer = Writer(conf)
  writer.write()
  val reader = Reader(conf)
  val data = reader.read(tag = Some("_untagged_"), detailType = Some("complete"))
  val tagger = Tagger(conf)
  tagger.tag(data)
}

