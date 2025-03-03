scalaVersion := "3.6.3"
name := "SMILemu"
version := "1.0-SNAPSHOT"
//crossPaths := false // drop off Scala suffix from artifact names.
//autoScalaLibrary := false // exclude scala-library from dependencies

Global / onChangedBuildSource := ReloadOnSourceChanges

scalacOptions := Seq("-encoding", "utf8", "-deprecation", "-unchecked", "-Werror", "-feature")

fork := true

javacOptions += "-Xlint:deprecation"

assembly / assemblyJarName := "SMILemu.jar"

assembly / mainClass := Some("com.brunschen.christian.smil.SMILApp")

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % Test,
)
