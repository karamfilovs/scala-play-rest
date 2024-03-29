name := "scala-play-rest"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % "test"
libraryDependencies += "com.typesafe.play" %% "play-logback" % "2.8.7"
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.9"
scalacOptions ++= Seq("encoding", "utf-8")