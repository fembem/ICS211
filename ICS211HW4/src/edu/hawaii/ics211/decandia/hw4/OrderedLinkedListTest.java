package edu.hawaii.ics211.dec.hw4;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OrderedLinkedListTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void test() {
    OrderedLinkedList<Object> list = new OrderedLinkedList<Object>(
        "john", "leo", "jerry", "amy", "tom", "barbara"
        );
    System.out.println(list);
    list.add("tony", null);
    System.out.println(list);
  }

}
