package io

import conf.PocketConf
import io.circe._
import model.{PocketResponse, Tag, TagRequest}
import io.circe.syntax._
import io.circe.generic.auto._

class Tagger(
              requestSender: Requester[Seq[String], IOResponse],
              conf: PocketConf
            ) {

  def tag(articles: PocketResponse): Unit = {
    val tags = generateTimeTags(articles)
    val roundedTags = roundTags(tags)
    val videoTags = generateVideoTag(articles)

    val finalTags = (roundedTags ++ videoTags)
      .filter(_.tag != "0")

    val jsonTags = encoder(finalTags.map(tag => TagRequest("tags_add", tag.item_id, tag.tag)))

    requestSender.modify(jsonTags)
  }

  def generateTimeTags(articles: PocketResponse): Seq[Tag] = {
    articles.list.getOrElse(Map()).map { case (id, article) =>
      Tag(id, (article.word_count.toInt / conf.wordsPerMinute).toString)
    }.toSeq
  }

  def generateVideoTag(articles: PocketResponse): Seq[Tag] = {
    articles.list.getOrElse(Map()).map { case (id, article) =>
      if (article.has_video == "2") Tag(id, "video") else Tag(id, "0")
    }.toSeq
  }

  def roundTags(tags: Seq[Tag]): Seq[Tag] = {
    tags.map(tag => Tag(tag.item_id, round(tag.tag.toInt)))
  }

  def round(number: Int): String = {
    val tag = ((number.toDouble / 5).round * 5).toString

    if (tag.toInt < 15 && tag.toInt != 0) "short_reads" else tag
  }

  def encoder(data: Seq[TagRequest]): Json = {
    data.asJson
  }

}

object Tagger {
  def apply(conf: PocketConf): Tagger = {
    val requestSender = new RequestSender(conf)
    new Tagger(requestSender, conf)
  }
}
