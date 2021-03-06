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
    assertNull(list.get(0));
  }
  
  @Test
  public void testInsertingIntoEmptyList() {
    OrderedLinkedList<String> list = new OrderedLinkedList<String>();
    list.add("tony", "tonyValue");
    assertTrue(list.get(0).equals("tonyValue"));
  }
  
  @Test
  public void testInsertingAtBeginningOfList() {
    OrderedLinkedList<Object> list = new OrderedLinkedList<Object>();
    list.add("paul", "paulValue");
    list.add("norris", "norrisValue");
    list.add("marion", "marionValue");
    list.add("linda", "lindaValue");
    assertTrue(list.get(0).equals("lindaValue"));
    assertTrue(list.get(1).equals("marionValue"));
    assertTrue(list.get(2).equals("norrisValue"));
    assertTrue(list.get(3).equals("paulValue"));

  }
  
  @Test
  public void testInsertingAfterBeginningOfList() {
    OrderedLinkedList<Object> list = new OrderedLinkedList<Object>();
    list.add("norris", "norrisValue");
    list.add("paul", "paulValue");
    assertTrue(list.get(0).equals("norrisValue"));
    assertTrue(list.get(1).equals("paulValue"));
  }
  
  @Test
  public void testInsertingDupilcates() {
    OrderedLinkedList<String> list = new OrderedLinkedList<String>();
    list.add("joe", "joeValue");
    list.add("john", "johnOriginal");
    list.add("leo", "leoOriginal");
    list.add("leo", "leoReplacement");
    list.add("tyler", "tylerValue");
    list.add("john", "johnReplacement");
    assertTrue(list.get(0).equals("joeValue"));
    assertTrue(list.get(1).equals("johnReplacement"));    
    assertTrue(list.get(2).equals("leoReplacement"));
    assertTrue(list.get(3).equals("tylerValue"));    
  }
  
  @Test
  public void testFind() {
    OrderedLinkedList<String> list = new OrderedLinkedList<String>();
    list.add("paul", "paulValue");
    list.add("norris", "norrisValue");
    list.add("marion", "marionValue");
    list.add("linda", "lindaValue");
    assertTrue(list.find("paul").equals("paulValue"));
    assertTrue(list.find("linda").equals("lindaValue")); 
    assertNull(list.find("jerry")); 
  }
  
  @Test
  public void testGet() {
    OrderedLinkedList<String> list = new OrderedLinkedList<String>();
    list.add("paul", "paulValue");
    list.add("norris", "norrisValue");
    list.add("marion", "marionValue");
    list.add("linda", "lindaValue");
    assertTrue(list.get(0).equals("lindaValue"));
    assertTrue(list.get(3).equals("paulValue"));
  }

  @Test
  public void testSize() {
    OrderedLinkedList<String> list = new OrderedLinkedList<String>();
    assertEquals(0, list.size());
    list.add("joe", "joeValue");
    assertEquals(1, list.size());
    list.add("john", "johnOriginal");
    assertEquals(2, list.size());
    list.add("leo", "leoOriginal");
    assertEquals(3, list.size());
    list.add("leo", "leoReplacement");
    assertEquals(3, list.size());
    list.add("tyler", "tylerValue");
    assertEquals(4, list.size());
    list.add("john", "johnReplacement");
    assertEquals(4, list.size());
  }
  
}
