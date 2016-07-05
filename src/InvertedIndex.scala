/**
  * Created by dittmar on 5/30/16.
  */
class InvertedIndex {
  var root = new TrieNode()

  /**
    * decorator method to start the recursive splitting of a word
    *
    * @param word
    */
  def add(word : String): Unit ={
    add(word.head.toString,word.tail,root)
  }

  /**
    * method to recursively split a string up char by char
    *
    * @param head
    * @param rest
    */
  def add(head : String, rest: String, node : TrieNode): Unit ={
    // add word to trie.
    if(node.children.isEmpty){
      // add head to the child.
      val newNode = new TrieNode
      newNode.character = head
      node.children = node.children + (head -> newNode)

      if(rest == "") {
        newNode.isWordEnd = true
        return
      }
      add(rest.head.toString, rest.tail, newNode)
    } else if(node.children.contains(head)) {
        val next = node.children.get(head).get
        if( rest == "" ){
          next.isWordEnd = true
          return
        }
        add(rest.head.toString, rest.tail, next)
      } else {
        // head is not part of the children so add it along with a new node
        val newNode = new TrieNode
        newNode.character = head
        node.children = node.children + (head -> newNode)
        if (rest == "") {
          node.isWordEnd = true
          return
        }
        add(rest.head.toString, rest.tail, newNode)
      }
    }

  def lookup(word : String): Boolean ={
    return lookup(word.head.toString,word.tail,root)
  }

  def lookup(head : String, rest : String, node : TrieNode): Boolean ={
    // head is not the ending character
    if(!node.children.contains(head)){
      return false
    }else{
      if(rest == ""){
        if(node.children.contains(head)){
          val tmp = node.children.get(head).get
          if(tmp.isWordEnd == true){
            return true;
          }
        }
      }else if(node.children.contains(head)){
        return lookup(rest.head.toString, rest.tail, node.children.get(head).get)
      }
    }
    return false;
  }
}
