name := "pocket"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "com.softwaremill.sttp.client" %% "core" % "2.0.0-RC6",
  "com.typesafe" % "config" % "1.4.0",
  "org.mockito" %% "mockito-scala" % "1.11.3",
  "org.mockito" %% "mockito-scala-scalatest" % "1.11.3"

)

libraryDependencies ++= circe
libraryDependencies ++= scalaTest

lazy val circe = {
  val version = "0.9.3"
  Seq(
    "io.circe" %% "circe-core" % version,
    "io.circe" %% "circe-parser" % version,
    "io.circe" %% "circe-java8" % version,
    "io.circe" %% "circe-generic" % version
  )
}

lazy val scalaTest = {
  val version = "3.1.1"
  Seq(
    "org.scalactic" %% "scalactic" % version,
    "org.scalatest" %% "scalatest" % version % "test"
  )
}

