scalaVersion := "3.6.3"
name := "SMILemu"
version := "1.0-SNAPSHOT"
crossPaths := false // drop off Scala suffix from artifact names.
autoScalaLibrary := false // exclude scala-library from dependencies

libraryDependencies ++= Seq(
   "org.apache.commons" % "commons-math3" % "3.1.1",
)
