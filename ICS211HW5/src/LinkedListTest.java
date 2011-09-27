import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;


public class LinkedListTest {

  LinkedList<Integer> list;
  LinkedList<Integer> listCopy = new LinkedList<Integer>();
  
  @Before
  public void setUp() throws Exception {
    list = new LinkedList<Integer>();
    list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
    //listCopy.add(1);listCopy.add(2);listCopy.add(3);listCopy.add(4);listCopy.add(5);
  }

  @Test
  public void testOriginalList() {

    for (int i : list){
      System.out.print(i + ";");
    }
    System.out.println("");
    
    assertEquals(1, list.getElementAt(0).intValue());
    assertEquals(2, list.getElementAt(1).intValue());
    assertEquals(3, list.getElementAt(2).intValue());
    assertEquals(4, list.getElementAt(3).intValue());
    assertEquals(5, list.getElementAt(4).intValue());
    
  }  
  
  @Test
  public void testDeleteFirstElement() {

    Iterator<Integer> iter = list.iterator();
    for(int i = 1; i < 2; i++){
      iter.next();
    }
    iter.remove();
    
    for (int i : list){
      System.out.print(i + ";");
    }
    System.out.println("");
    
    assertEquals(2, list.getElementAt(0).intValue());
    assertEquals(3, list.getElementAt(1).intValue());
    assertEquals(4, list.getElementAt(2).intValue());
    assertEquals(5, list.getElementAt(3).intValue());
  }
  
  @Test
  public void testDeleteSecondElement() {

    Iterator<Integer> iter = list.iterator();
    for(int i = 1; i < 3; i++){
      iter.next();
    }
    iter.remove();
    
    for (int i : list){
      System.out.print(i + ";");
    }
    System.out.println("");
    
    assertEquals(1, list.getElementAt(0).intValue());
    assertEquals(3, list.getElementAt(1).intValue());
    assertEquals(4, list.getElementAt(2).intValue());
    assertEquals(5, list.getElementAt(3).intValue());
  }
  
  @Test
  public void testDeleteThirdElement() {

    Iterator<Integer> iter = list.iterator();
    for(int i = 1; i < 4; i++){
      iter.next();
    }
    iter.remove();
    
    for (int i : list){
      System.out.print(i + ";");
    }
    System.out.println("");
    
    assertEquals(1, list.getElementAt(0).intValue());
    assertEquals(2, list.getElementAt(1).intValue());
    assertEquals(4, list.getElementAt(2).intValue());
    assertEquals(5, list.getElementAt(3).intValue());
  }
  
  @Test
  public void testDeleteLastElement() {

    Iterator<Integer> iter = list.iterator();
    for(int i = 1; i < 6; i++){
      iter.next();
    }
    iter.remove();
    
    for (int i : list){
      System.out.print(i + ";");
    }
    System.out.println("");    
    
    assertEquals(1, list.getElementAt(0).intValue());
    assertEquals(2, list.getElementAt(1).intValue());
    assertEquals(3, list.getElementAt(2).intValue());
    assertEquals(4, list.getElementAt(3).intValue());
  }
  
  @Test(expected=IllegalStateException.class)
  public void testCallRemoveTwiceSinceLastNext() {

    Iterator<Integer> iter = list.iterator();

    iter.next();
    iter.remove();
    iter.remove();
    
  }
  
  @Test
  public void testRemoveFirstElement() {

    list.remove(0);
    
    for (int i : list){
      System.out.print(i + ";");
    }
    System.out.println("");
    
    assertEquals(2, list.getElementAt(0).intValue());
    assertEquals(3, list.getElementAt(1).intValue());
    assertEquals(4, list.getElementAt(2).intValue());
    assertEquals(5, list.getElementAt(3).intValue());
  }
  
  @Test
  public void testRemoveSecondElement() {

    list.remove(1);
    
    for (int i : list){
      System.out.print(i + ";");
    }
    System.out.println("");
    
    assertEquals(1, list.getElementAt(0).intValue());
    assertEquals(3, list.getElementAt(1).intValue());
    assertEquals(4, list.getElementAt(2).intValue());
    assertEquals(5, list.getElementAt(3).intValue());
  }
  
  @Test
  public void testRemoveThirdElement() {

    list.remove(2);
    
    for (int i : list){
      System.out.print(i + ";");
    }
    System.out.println("");
    
    assertEquals(1, list.getElementAt(0).intValue());
    assertEquals(2, list.getElementAt(1).intValue());
    assertEquals(4, list.getElementAt(2).intValue());
    assertEquals(5, list.getElementAt(3).intValue());
  }
  
  @Test
  public void testRemoveLastElement() {

    list.remove(4);
    
    for (int i : list){
      System.out.print(i + ";");
    }
    System.out.println("");    
    
    assertEquals(1, list.getElementAt(0).intValue());
    assertEquals(2, list.getElementAt(1).intValue());
    assertEquals(3, list.getElementAt(2).intValue());
    assertEquals(4, list.getElementAt(3).intValue());
  }
  
  @Test
  public void testRemoveFirstObject() {

    list.remove(Integer.valueOf(1));
    
    for (int i : list){
      System.out.print(i + ";");
    }
    System.out.println("");
    
    assertEquals(2, list.getElementAt(0).intValue());
    assertEquals(3, list.getElementAt(1).intValue());
    assertEquals(4, list.getElementAt(2).intValue());
    assertEquals(5, list.getElementAt(3).intValue());
  }
  
  @Test
  public void testRemoveSecondObject() {

    list.remove(Integer.valueOf(2));
    
    for (int i : list){
      System.out.print(i + ";");
    }
    System.out.println("");
    
    assertEquals(1, list.getElementAt(0).intValue());
    assertEquals(3, list.getElementAt(1).intValue());
    assertEquals(4, list.getElementAt(2).intValue());
    assertEquals(5, list.getElementAt(3).intValue());
  }
  
  @Test
  public void testRemoveThirdObject() {

    list.remove(Integer.valueOf(3));
    
    for (int i : list){
      System.out.print(i + ";");
    }
    System.out.println("");
    
    assertEquals(1, list.getElementAt(0).intValue());
    assertEquals(2, list.getElementAt(1).intValue());
    assertEquals(4, list.getElementAt(2).intValue());
    assertEquals(5, list.getElementAt(3).intValue());
  }
  
  @Test
  public void testRemoveLastObject() {

    list.remove(Integer.valueOf(5));
    
    for (int i : list){
      System.out.print(i + ";");
    }
    System.out.println("");    
    
    assertEquals(1, list.getElementAt(0).intValue());
    assertEquals(2, list.getElementAt(1).intValue());
    assertEquals(3, list.getElementAt(2).intValue());
    assertEquals(4, list.getElementAt(3).intValue());
  }
  
  @Test
  public void testRemoveMethodTailBehavior() {

    list.remove(Integer.valueOf(5));
    list.remove(Integer.valueOf(3));
    list.remove(Integer.valueOf(2));
    
  }
  

}
