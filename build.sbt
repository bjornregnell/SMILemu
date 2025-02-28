scalaVersion := "3.6.3"
name := "SMILemu"
version := "1.0-SNAPSHOT"
//crossPaths := false // drop off Scala suffix from artifact names.
//autoScalaLibrary := false // exclude scala-library from dependencies

Global / onChangedBuildSource := ReloadOnSourceChanges

libraryDependencies ++= Seq(
  "com.novocode" % "junit-interface" % "0.11" % Test,
)
