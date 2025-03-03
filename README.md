# SMILemu

* Forked from: https://github.com/cbrunschen/SMILemu
* Inserted graphic from: https://github.com/cbrunschen/Graphic

## How to run:

* Download or clone this repo locally.
* Make sure you have scala tools including sbt or else install from here: https://www.scala-lang.org/download/ 
* Type `sbt run` 
  * select `Main` for simple print of registers or 
  * select `com.brunschen.christian.smil.SMILApp` to start the Swing GUI App

## How to build jar

* Type `sbt "clean;assembly"`
* The path-to-jar in target is printed.
* Run with `java -jar path-to-jar/SMILemu.jar`


