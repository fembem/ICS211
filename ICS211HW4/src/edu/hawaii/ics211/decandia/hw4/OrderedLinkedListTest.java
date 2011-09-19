package edu.hawaii.ics211.dec.hw4;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OrderedLinkedListTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testEmptyList() {
    System.out.println("testEmptyList");
    OrderedLinkedList<Object> list = new OrderedLinkedList<Object>(
        );
    System.out.println(list);
  }
  
  @Test
  public void testInsertingIntoEmptyList() {
    System.out.println("testInsertingIntoEmptyList");
    OrderedLinkedList<Object> list = new OrderedLinkedList<Object>(
        );
    System.out.println(list);
    list.add("tony", null);
    System.out.println(list);
  }
  
  @Test
  public void testInsertingAtBeginningOfList() {
    System.out.println("testInsertingIntoEmptyList");
    OrderedLinkedList<Object> list = new OrderedLinkedList<Object>(
        "paul");
    System.out.println(list);
    list.add("norris", null);
    System.out.println(list);
    list.add("marrion", null);
    System.out.println(list);
    list.add("linda", null);
    System.out.println(list);
  }
  
  @Test
  public void testInsertingIntoSizeOneListLarger() {
    System.out.println("testInsertingIntoSizeOneListLarger");
    OrderedLinkedList<Object> list = new OrderedLinkedList<Object>(
        "amy");
    System.out.println(list);
    list.add("tony", null);
    System.out.println(list);
  }
  
  @Test
  public void testInsertingIntoSizeOneListSmaller() {
    System.out.println("testInsertingIntoSizeOneListSmaller");
    OrderedLinkedList<Object> list = new OrderedLinkedList<Object>(
        "tony");
    System.out.println(list);
    list.add("amy", null);
    System.out.println(list);
  }
  
  @Test
  public void testInsertingIntoSizeTwoList() {
    System.out.println("testInsertingIntoSizeTwoList");
    OrderedLinkedList<Object> list = new OrderedLinkedList<Object>(
        "john", "jerry"
        );
    System.out.println(list);
    list.add("tony", null);
    System.out.println(list);
  }
  @Test
  public void testInsertingIntoSizeThreeList() {
    System.out.println("testInsertingIntoSizeThreeList");
    OrderedLinkedList<Object> list = new OrderedLinkedList<Object>(
        "john"
        );
    System.out.println(list);
    list.add("leo", null);
    System.out.println(list);
    list.add("amy", null);
    System.out.println(list);
    list.add("barbie", null);
    System.out.println(list);
  }
  
  @Test
  public void testInsertingDupilcates() {
    System.out.println("testInsertingDupilcates");
    OrderedLinkedList<String> list = new OrderedLinkedList<String>(
        );
    list.add("john", "original");
    System.out.println(list);
    list.add("leo", "original");
    System.out.println(list);
    list.add("leo", "replacement");
    System.out.println(list);
    list.add("john", "replacement");
    System.out.println(list);
  }

}
