/** 

  * Extends Prof. Biagioni's LinkedList class by making it iterable.
  * @author         , Leo
  * @assignment     ICS 613 Assignment 5
  * @date           September 25, 2011
  * @bugs           none known
  */
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A list implemented using a singly-linked list.
 *
 * @param <E> the element type
 * @author Edo Biagioni
 * @lecture ICS 211 Jan 27 (or later)
 * @date January 26, 2011
 */

public class LinkedList<E> implements Iterable<E>{

  // here, include the LinkedNode definition

  /**
   * A node in a singly-linked list.
   *
   * @param <T> the generic type
   * @author Edo Biagioni
   * @lecture ICS 211 Jan 27 or later
   * @date January 26, 2010
   */

  private static class LinkedNode<T> {
    
    /** The item. */
    private T item;
    
    /** The next. */
    private LinkedNode<T> next;

    /**
     * constructor to build a node with no successor.
     *
     * @param value the value
     */
    private LinkedNode(T value) {
      item = value;
      next = null;
    }

    /**
     * constructor to build a node with specified (maybe null) successor.
     *
     * @param value the value
     * @param reference the reference
     */
    private LinkedNode(T value, LinkedNode<T> reference) {
      item = value;
      next = reference;
    }
  }

  // end of the LinkedNode definition

  // this is the start of the linked list. If the list is empty, it is null
  /** The head. */
  protected LinkedNode<E> head;
  // this is the end of the linked list. If the list is empty, it is null
  /** The tail. */
  protected LinkedNode<E> tail;
  
  /** The size. */
  protected int size;

  // there are some relationships between the class variables. This
  // method checks that these relationships always hold. Any
  // property that always holds is called an invariant.

  // the property may not hold in the middle of a method,
  // so only call this at the beginning or end of a public method.

  /**
   * checks assertion.
   *
   * @param mustBeTrue the must be true
   */
  private void verify(boolean mustBeTrue) {
    if (!mustBeTrue) {
      throw new java.lang.AssertionError("assertion error");
    }
  }

  /**
   * checks class invariants.
   *
   */
  private void checkInvariants() {
    // uncomment the next line to skip the checks:
    // return;
    // either head and tail are both null, or neither is null.
    // size is zero if and only if they are null, and otherwise is positive
    verify((head == null) == (tail == null));
    verify((size == 0) == (head == null));
    verify(size >= 0);
    // if the list only has one element, head should be the same as tail
    // (and also if the list has no elements), otherwise they should differ
    verify((head == tail) == (size <= 1));
    // a non-null tail variable should always have a null "next" field
    verify((tail == null) || (tail.next == null));
    // check to make sure size is the same as the length of the list.
    // this code takes O(n), so comment it out if performance is important
    int measuredSize = 0;
    LinkedNode<E> node = head;
    // if visitedLast is null, the list is empty, and tail should also be null
    LinkedNode<E> visitedLast = null;
    while (node != null) {
      visitedLast = node;
      node = node.next;
      measuredSize++;
    }
    verify(measuredSize == size);
    // also make sure "last" really is the last node in the linked list
    verify(visitedLast == tail);
  }

  /**
   * initializes an empty linked list.
   */
  public LinkedList() {
    head = null;
    tail = null;
    size = 0;
    // one of the constructor's jobs is to make sure that the invariants hold.
    checkInvariants();
  }

  // these private (helper) methods simplify implementation of
  // the public "add" methods
  // the helper methods never modify "size", the public methods
  // take care of that, so the invariants probably do not hold at the end of
  // a helper methods

  /**
   * adds at the head of the list.
   *
   * @param value the value
   */
  private void addAtFront(E value) {
    head = new LinkedNode<E>(value, head);
    if (tail == null) {
      tail = head;
    }
  }

  /**
   * adds at the tail of the list. Assumes (and checks) that tail is not null
   *
   * @param value the value
   */
  private void addAtEnd(E value) {
    if (tail == null) {
      throw new RuntimeException("invalid call to addAtEnd, tail is null");
    }
    LinkedNode<E> newNode = new LinkedNode<E>(value);
    tail.next = newNode;
    tail = newNode;
  }

  /**
   * adds a value to the list after the given node.
   *
   * @param reference the reference
   * @param value the value
   */
  private void addAfter(LinkedNode<E> reference, E value) {
    LinkedNode<E> newNode = new LinkedNode<E>(value, reference.next);
    reference.next = newNode;
    if (reference == tail) { // if added at end, update tail value
      tail = newNode;
    }
  }

  /**
   * adds a value to the end of the list.
   *
   * @param value the value
   * @return true (the add always succeeds)
   */
  public boolean add(E value) {
    checkInvariants(); // useful for debugging
    if (head != null) {
      addAtEnd(value);
    }
    else {
      addAtFront(value);
    }
    size++;
    checkInvariants(); // invariants valid at start, are they still valid?
                       // i.e., did this method break the invariants?
    return true;
  }

  /**
   * returns the node at the requested position, may take time O(n).
   *
   * @param index the index
   * @return the requested node
   */
  private LinkedNode<E> nodeAtPosition(int index) {
    verify(index >= 0);
    LinkedNode<E> result = head;
    while (index > 0) {
      result = result.next;
      index--;
    }
    verify(result != null);
    return result;
  }

  /**
   * adds a value to the list, in the given position.
   *
   * @param index the index
   * @param value the value
   */
  public void add(int index, E value) {
    checkInvariants();
    if ((index < 0) || (index > size)) {
      String badIndex = new String("index " + index + " must be between 0 and " + size);
      throw new IndexOutOfBoundsException(badIndex);
    }
    if (index == 0) {
      addAtFront(value);
    }
    else {
      addAfter(nodeAtPosition(index - 1), value);
    }
    size++;
    checkInvariants();
  }

  /**
   * concatenates the elements of the linked list, separated by " ==> ".
   *
   * @return the string representation of the list
   */
  public String toString() {
    checkInvariants();
    LinkedNode<E> node = head;
    StringBuffer result = new StringBuffer();
    while (node != null) {
      result.append(node.item.toString());
      node = node.next;
      if (node != null) {
        result.append(" ==> ");
      }
    }
    checkInvariants(); // make sure we didn't break anything
    return result.toString();
  }

  /**
   * unit test method -- basic testing of the functionality.
   *
   * @param arguments the arguments
   */
  public static void main(String[] arguments) {
    LinkedList<String> ll = new LinkedList<String>();
    System.out.println(ll);
    ll.add("foo");
    System.out.println(ll);
    ll.add(1, "bar");
    System.out.println(ll);
    ll.add("baz");
    System.out.println(ll);
    ll.add(0, "hello");
    System.out.println(ll);
    ll.add(1, "world");
    System.out.println(ll);
  }
  
  /**
   * Gets the element at a given position.
   *
   * @param position the position of the element to get
   * @return the element at the position
   */
  public E getElementAt(int position){
    LinkedNode<E> current = this.head;
    for(int i = 0;;i++){
      if(current == null) {
        throw new NoSuchElementException();
      }
      else if (i == position){
        return current.item;
      }
      else {
        current = current.next;
      }
    }
  }
  
  /**
   * Removes the.
   *
   * @param o the object to delete from the list
   * @return true, if anything was deleted
   */
  public boolean remove(Object o) {
    Iterator<E> iter = this.iterator();
    while(iter.hasNext()){
      if(o.equals(iter.next())){
        iter.remove();
        return true;
      }
    }
    return false;
  }
  
  /**
   * Size.
   *
   * @return the size of the list
   */
  public int size() {
    return size;
  }

  /**
   * Removes the.
   *
   * @param index the index of the item to delete
   * @return the e
   */
  public E remove(int index) {
    if (index < 0 || index >= this.size()) {
      throw new IndexOutOfBoundsException();
    }
    Iterator<E> iter = this.iterator();
    int position = 0;
    E item;
    while(iter.hasNext()){
      item = iter.next(); 
      if(position == index){
        iter.remove();
        return item;
      }
      position++;
    }
    return null;  
  }
  
  /* (non-Javadoc)
   * @see java.lang.Iterable#iterator()
   */
  @Override
  public Iterator<E> iterator() {
    return new LinkedListIterator(this);
  }
  
  /**
   * The Class LinkedListIterator.
   */
  class LinkedListIterator implements Iterator<E> {

    /** The list we are iterating over. */
    LinkedList<E> list;
    
    /** The current node: the one next() returns. */
    LinkedNode<E> current;
    
    /** The node before the last one whose value was returned. */
    LinkedNode<E> beforeLast = null;
    
    /** The last node whose value was returned. */
    LinkedNode<E> last = null;
    
    /** whether removed method was called since the last call to next. */
    boolean removeCalled = true;
    
    /**
     * Instantiates a new linked list iterator.
     *
     * @param list the list
     */
    public LinkedListIterator(LinkedList<E> list){
      this.list = list;
      this.current = head;
    }
    
    /* (non-Javadoc)
     * @see java.util.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {
      return current != null;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#next()
     */
    @Override
    public E next() {
      if(current == null){
        throw new NoSuchElementException("no elements left");
      }
      removeCalled = false;
      beforeLast = last;
      last = current;
      LinkedNode<E> oldValue = current;
      current = current.next;
      return oldValue.item;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#remove()
     */
    @Override
    public void remove() {
      if (this.removeCalled == true){
        throw new IllegalStateException();
      } // delete second element of list
      else if ( this.beforeLast == this.list.head) {
        
        if(this.list.tail == current){
          this.list.tail = this.list.head.next;
        }
        
        this.beforeLast.next = current;
        removeCalled = true;
        this.list.size--;
        return;
      } // delete first element of list
      else if(this.last == this.list.head){
        
        if(this.list.tail == current){
          this.list.tail = null;
        }
        
        this.list.head = current;
        removeCalled = true;
        this.list.size--;
        return;
      } // delete some other element of list
      else if (this.beforeLast == null || this.beforeLast.next == null) {
        throw new IllegalStateException();
      }
      else {
        if(this.list.tail == current){
          this.list.tail = this.beforeLast.next;
        }
        this.beforeLast.next = this.beforeLast.next.next;
        this.removeCalled = true;
        this.list.size--;
      }
    }
  }

}


