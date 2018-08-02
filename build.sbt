name := "workspace-graph-research"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.3"

libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "2.3.0"

// https://mvnrepository.com/artifact/com.google.code.gson/gson
libraryDependencies += "com.google.code.gson" % "gson" % "1.7.1"

// https://mvnrepository.com/artifact/org.scalatest/scalatest
//libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0-SNAP10" % Test

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"