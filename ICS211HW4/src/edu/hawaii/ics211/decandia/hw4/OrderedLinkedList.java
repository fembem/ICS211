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
   * @param key the key used for ordering
   * @param value the payload
   * @return the element replaced or null if no element with the same key was in the list
   */
  protected E add(String key, E value) {
    KeyedNode newNode = new KeyedNode(value, key);
    KeyedNode current = this.head;  //start at the head of the list
    E result = null;  // the value to return
    if (head == null) { // the list is empty
      this.head = newNode; // set a new KeyedNode as the head
      return null; // there is clearly no element being replaced
    }
    else if (current.next == null) {   //there is only one element in the list
      int newKeyWrtFirstElement = current.key.compareToIgnoreCase(key);
      if (newKeyWrtFirstElement > 0){
        this.head.next = newNode;
        newNode.next = null;
        return null;
      } else if (newKeyWrtFirstElement < 0) {
        KeyedNode oldFirst = this.head;
        this.head = newNode;
        newNode.next = oldFirst;
        oldFirst.next = null;
        return null;
      } else {
        result = this.head.object;
        this.head = newNode;
        return result;
      }
    }
    // advance head while there is a next element and the insertion key
    // is "bigger or equal" to the key of the next element after the next element
    while (current.next.next != null && current.next.next.key.compareToIgnoreCase(key) >= 0) {
      current = current.next;
    }
    // set the newNode to point to the element after the insertion point
    newNode.next = current.next;
    // set the node before the insertion point to point to the new node
    current.next = newNode;
    // set head to point to the node after the one just inserted
    current = newNode;

    if (current.next != null && current.next.key.compareToIgnoreCase(key) == 0) {
      result = current.object;
      current.next = current.next.next;
    }
    return result;
  }

}
