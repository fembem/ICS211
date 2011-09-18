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
    OrderedLinkedList<Object> list = new OrderedLinkedList<Object>(
        );
    System.out.println(list);
  }
  @Test
  public void testSizeOneList() {
    OrderedLinkedList<Object> list = new OrderedLinkedList<Object>(
        );
    System.out.println(list);
    list.add("tony", null);
    System.out.println(list);
  }
  @Test
  public void testSizeTwoList() {
    OrderedLinkedList<Object> list = new OrderedLinkedList<Object>(
        "john"
        );
    System.out.println(list);
    list.add("tony", null);
    System.out.println(list);
  }
  @Test
  public void testSizeThreeList() {
    OrderedLinkedList<Object> list = new OrderedLinkedList<Object>(
        "john", "leo"
        );
    System.out.println(list);
    list.add("tony", null);
    System.out.println(list);
  }

}
