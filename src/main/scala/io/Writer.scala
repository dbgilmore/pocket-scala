package io

import conf.PocketConf
import io.circe.Json
import model.AddRequest

import scala.io.Source
import io.circe.syntax._
import io.circe.generic.auto._
import java.io.PrintWriter

import sttp.model.StatusCode

class Writer(

              requestSender: Requester[Seq[String], IOResponse]) {

  def write(): IOResponse = {
    val fileName = "C:\\Users\\david\\Downloads\\articles.txt"

    val file = Source.fromFile(fileName)

    val jsonPayload = file.getLines.foldLeft(Seq.empty[AddRequest]) {
      case (result, line) => result :+ AddRequest("add", "", line)
    }

    file.close
    new PrintWriter(fileName).close()

    requestSender.modify(encoder(jsonPayload))
  }

  def encoder(data: Seq[AddRequest]): Json = {
    data.asJson
  }

}

object Writer {
  def apply(conf: PocketConf): Writer = {
    val requestSender = new RequestSender(conf)
    new Writer(requestSender)
  }
}
