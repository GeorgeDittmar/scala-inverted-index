/**
  * Created by dittmar on 7/4/16.
  */
object Example extends App {
  val index = new InvertedIndex
  index.add("heh")
  index.add("he")
  index.add("hah")
  index.add("bab")

  println("Done adding word.")

  println(index.lookup("heh"))
  println(index.lookup("he"))
  println(index.lookup("bab1"))
  println(index.lookup("hah"))
  println(index.lookup("boba"))
}
