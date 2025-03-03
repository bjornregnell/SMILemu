# SMILemu

* Forked from: https://github.com/cbrunschen/SMILemu
* Inserted code from: 
  * https://github.com/cbrunschen/Graphic
  * https://github.com/cbrunschen/Graphic_Swing
  * https://github.com/cbrunschen/SMILemu_Swing


## How to run 

* Download latest `SMILemu.jar` from here: https://github.com/bjornregnell/SMILemu/releases/latest/download/SMILemu.jar

* Run in terminal with: `java -jar SMILemu.jar`

* It may also work to just double-click on the jar.

## How to build and run locally:

* Download or clone this repo locally.
* Make sure you have scala tools including sbt or else install from here: https://www.scala-lang.org/download/ 
* Type `sbt run` 
  * type 1+ENTER for `[1] Main` to make a simple print of registers to terminal 
  * type 2+ENTER for `[2] com.brunschen.christian.smil.SMILApp` to start the Swing GUI App

## How to build jar

* Type `sbt assembly`
* The path-to-jar in target is printed in terminal.
* Run with `java -jar path-to-jar/SMILemu.jar`


