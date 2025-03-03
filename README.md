# SMILemu

SMILemu is an emulator of Lund's first computer [SMIL](https://en.wikipedia.org/wiki/SMIL_(computer)). The emulator is written in Java by [Christian Brunschen](https://github.com/cbrunschen).

* The code is forked from: https://github.com/cbrunschen/SMILemu and then code from here is inserted to form a complete monorepo:
  * https://github.com/cbrunschen/Graphic
  * https://github.com/cbrunschen/Graphic_Swing
  * https://github.com/cbrunschen/SMILemu_Swing

The original code was based on ancient Java parts that are no longer part of a modern JVM. This monorepo removes old stuff and includes things to make it build for a modern JVM with Java 21 using the Scala build tool call [sbt](https://www.scala-sbt.org/).

## How to run 

* Download latest `SMILemu.jar` from here: https://github.com/bjornregnell/SMILemu/releases/latest/download/SMILemu.jar

* Run in terminal with: `java -jar SMILemu.jar`

* It may also work to just double-click on the jar.

## How to build and run locally:

* Make sure you have Scala-tools, esp. sbt, available by installing the Scala distribution from here: https://www.scala-lang.org/download/ 
* Download or clone this repo locally.
* Make sure you have scala tools including sbt or else install from here: https://www.scala-lang.org/download/ 
* Type `sbt run` 
  * type 1+ENTER for `[1] Main` to make a simple print of registers to terminal 
  * type 2+ENTER for `[2] com.brunschen.christian.smil.SMILApp` to start the Swing GUI App

## How to build jar

* Type `sbt assembly`
* The path-to-jar in target is printed in terminal.
* Run with `java -jar path-to-jar/SMILemu.jar`


