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

  public OrderedLinkedList(String ... keys) {
    for(String key : keys){
      this.add(key, null);
    }
  }
  
  @Override
  public String toString() {
    StringBuffer result = new StringBuffer("(");
    KeyedNode head = this.head;
    while(head != null){
      result.append(head.object);
      result.append(", ");
    }
    //if there are any elements in the list
    if(result.length() != 0){
      //chop off the last char
      result.setLength(result.length());
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
    String key;

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
   * @param key the key used for ordering
   * @param value the payload
   * @return the element replaced or null if no element with the same key was in the list
   */
  protected E add(String key, E value) {
    //the value to return
    KeyedNode head = this.head; //use a local head vriable so we can advance it
    E result = null;
    if (head == null) {   //the list is empty
      head = new KeyedNode(value, key); //set a new KeyedNode as the head
      return null;  //there is clearly no element being replaced
    }
    //advance head while there is a next element and the insertion key
    //is "bigger or equal" to the key of the next element after the next element
    while (head.next.next != null && head.next.next.key.compareToIgnoreCase(key) >= 0) {
      head = head.next;
    }
    KeyedNode newNode = new KeyedNode(value, key);
    //set the newNode to point to the element after the insertion point
    newNode.next = head.next;
    //set the node before the insertion point to point to the new node
    head.next = newNode;
    //set head to point to the node after the one just inserted
    head = newNode;
    
    if(head.next!= null && head.next.key.compareToIgnoreCase(key) == 0){
      result = head.object;
      head.next = head.next.next;
    }
    return result;
  }

}
