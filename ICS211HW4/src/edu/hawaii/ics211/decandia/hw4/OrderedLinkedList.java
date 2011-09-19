/** 

 * Does something.
 * @author         , Leo
 * @assignment     ICS 613 Assignment 1 
 * @date           September 1, 2011
 * @bugs           None
 */

package edu.hawaii.ics211.dec.hw4;

/**
 * An ordered linked list of E's where each node has a key that determines the ordering.
 * 
 * @param <E> the element type
 */
public class OrderedLinkedList<E> {

  public OrderedLinkedList(){
    
  }
  
  public OrderedLinkedList(String... keys) {
    for (String key : keys) {
      this.add(key, null);
    }
  }
  
  @Override
  public String toString() {
    StringBuffer result = new StringBuffer("(");
    KeyedNode current = this.head;
    while (current != null) {
      result.append(current.key);
      result.append(",");
      current = current.next;
    }
    // if there are any elements in the list
    if (current != this.head) {
      // chop off the last char and put ")" in its place
      result.setCharAt(result.length() - 1, ')');
    } else {
      result.append(")");
    }
    return result.toString();
  }

  /**
   * A node of the ordered linked list.
   */
  class KeyedNode {

    /** The payload. */
    E object;

    /** The next node. */
    KeyedNode next;

    /** The ordering key. */
    String key = null;

    /**
     * Instantiates a new keyed node.
     * 
     * @param object the object
     * @param key the key
     */
    public KeyedNode(E object, String key) {
      super();
      this.object = object;
      this.key = key;
    }

    @Override
    public String toString() {
      return key;
    }

  }

  /** The head. */
  KeyedNode head = null;

  /**
   * Adds the value E to the linked list.
   * 
   * @param insertionKey the key used for ordering
   * @param insertionValue the payload
   * @return the element replaced or null if no element with the same key was in the list
   */
  public E add(String insertionKey, E insertionValue) {
    KeyedNode newNode = new KeyedNode(insertionValue, insertionKey);
    E result = null;  // the value to return
    if (head == null) { // the list is empty
      this.head = newNode; // set a new KeyedNode as the head
      return null; // there is clearly no element being replaced
    } else if (insertionKey.compareToIgnoreCase(this.head.key) <= 0 ) {
      //insert at beginning of list
      KeyedNode oldFirst = this.head;
      this.head = newNode;
      newNode.next = oldFirst;
    } else {  //insert after beginning of list
      KeyedNode current = this.head;
      // advance head while there is a next element and the insertion key
      // is "bigger or equal" to the key of the next element
      while (current.next != null && insertionKey.compareToIgnoreCase(current.next.key) > 0) {
        assert current.next.key != null;
        current = current.next;
      }
      // set the newNode to point to the element after the insertion point
      newNode.next = current.next;
      // set the node before the insertion point to point to the new node
      current.next = newNode;
      
    }
    
    //see if the node after the newly inserted one has the same key
    if (newNode.next != null && newNode.next.key.compareToIgnoreCase(insertionKey) == 0) {
      //return the value of the duplicate
      result = newNode.next.object;
      //set the newly inserted node to point to whatever comes after the duplicate
      newNode.next = newNode.next.next;
    }
    
    return result;
  }
  
  public E find(String key){
    KeyedNode current = head;
    while (current != null){
      if(current.key.equalsIgnoreCase(key)){
        return current.object;
      }
      current = current.next;
    }
    return null;
  }
  
  public E get(int position){
    KeyedNode current = head;
    for(int i = 0; current != null; i++){
      if(i == position) return current.object;
      current = current.next;
    }
    return null;    
  }

}
