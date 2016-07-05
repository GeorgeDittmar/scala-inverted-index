import scala.collection.immutable.HashMap

/**
  * Created by dittmar on 5/30/16.
  */

class TrieNode{
  var character = ""
  var children : Map[String,TrieNode] = new HashMap[String,TrieNode]
  var isWordEnd = false
}
