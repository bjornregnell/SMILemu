import com.brunschen.christian.smil.TapeReader
import com.brunschen.christian.smil.sound.SoundGenerator
import com.brunschen.christian.smil.ControlPanel
import com.brunschen.christian.smil.Typewriter

val smil = com.brunschen.christian.smil.SMIL()
def printRegisters(): Unit = 
  smil.processor().registers.foreach(println)

class FakeSoundGenerator extends SoundGenerator:
  override def stopDestination(finishPlaying: Boolean, retainData: Boolean): Unit = ()
  override def startDestination(): Unit = ()
  override def pushBufferToDestination(): Unit = ()
  override def canGenerateSound(): Boolean = false

class FakeTypewriter extends Typewriter.Default {
  var builder = StringBuilder()
  override def length(): Int = builder.length
  override def append(s: String): Unit = builder.append(s)
  override def text(): String = builder.toString
  override def clear(): Unit = builder = new StringBuilder()

}




@main def Main = 
  println("hello")
  smil.setTapeReader(TapeReader(null, 0, null))
  smil.setSoundGenerator(FakeSoundGenerator())
  smil.setControlPanel(ControlPanel(null, null))
  smil.setTypewriter(FakeTypewriter())
  smil.init();
  smil.tickClock().setWillWait(false)
  println("--- BEFORE ---")
  printRegisters()
  smil.processor().ar.clear()
  smil.processor().mr.setValue(2)
  smil.processor().md.setValue(3)
  println("--- AFTER SETTING VALUES ---")
  printRegisters()
  smil.processor().multiply()
  println("--- AFTER MULTIPLY ---")
  printRegisters()
  sys.exit(0)