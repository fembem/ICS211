/** 

  * Driver class for the LinkedList class instantiated with String values.
  * @author         , Leo
  * @assignment     ICS 613 Assignment 1 
  * @date           September 25, 2011
  * @bugs           None
  */
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringListDriver {
  
  static LinkedList<String> stringList = new LinkedList<String>();
  
  /**
   * The main method.  Implements the UI.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    
    System.out.println("Starting program, string list is empty.\n");
    Scanner scan = new Scanner(System.in);
    boolean quit = false;
    while (!quit) {
      System.out.print("enter one of:\n" +
      		"(1) add at end\n" +
      		"(2) add at position\n" +
      		"(3) remove by index\n" +
      		"(4) remove by equality\n" +
      		"(5) create iterator\n" +
      		"(6) print\n" +
      		"(7) quit\n\n"
      		);
      String command = scan.nextLine();
      if(command.equals("1")){
        System.out.println("you chose the 'add at end' option");
        System.out.println("enter string to add");
        String addString = scan.nextLine();
        stringList.add(stringList.size(), addString);
        System.out.println("The list has " + stringList.size() 
            + " " + ((stringList.size() == 1)? "string" : "strings")
            + "\n");
      } else if (command.equals("2")){
        System.out.println("you chose the 'add at position' option");
        System.out.println("enter string to add");
        String addString = scan.nextLine();
        
        int position= -1;
        while(true){
          try { 
            System.out.println("enter integer position");
            position  = Integer.parseInt( scan.nextLine() );
          }
          catch (NumberFormatException nfe){
            System.out.println("not a number!!!!");
            continue;
          }
          if( position < 0 || position >= stringList.size() - 1){
            System.out.println("not in the legal index range!!");
            continue;
          } else {
            break;
          }
        }
        stringList.add(position, addString);
        System.out.println("The list now has " + stringList.size() 
            + " " + ((stringList.size() == 1)? "string" : "strings")
            + "\n");
      } else if (command.equals("3")){
        System.out.println("you chose the 'remove by index' option");
        
        int position= -1;
        while(true){
          try { 
            System.out.println("enter integer position");
            position  = Integer.parseInt( scan.nextLine() );
          }
          catch (NumberFormatException nfe){
            System.out.println("not a number!!!!");
            continue;
          }
          if( position < 0 || position >= stringList.size() - 1){
            System.out.println("not in the legal index range!!");
            continue;
          } else {
            break;
          }
        }
        String removee = stringList.remove(position);
        System.out.println("The removed string is: " + removee);
        System.out.println("The list now has " + stringList.size() 
            + " " + ((stringList.size() == 1)? "string" : "strings")
            + "\n");
      } else if(command.equals("4")){
        System.out.println("you chose the 'remove by equality' option");
        System.out.println("enter string to remove");
        String removeString = scan.nextLine();
        boolean listChanged = stringList.remove(removeString);
        System.out.println("The list was " + (listChanged ? "changed" : "unchanged") );
        System.out.println("The list now has " + stringList.size() 
            + " " + ((stringList.size() == 1)? "string" : "strings")
            + "\n");
      } else if (command.equals("5")){
        System.out.println("you chose the 'create iterator' option");
        Iterator<String> iter = stringList.iterator();
        
        boolean doneWithIterator = false;
        
        while(!doneWithIterator){
          System.out.print("enter one of:\n" +
              "(1) call hasNext on the iterator\n" +
              "(2) call next on the iterator\n" +
              "(3) call remove on the iterator\n" +
              "(4) quit the iterator\n\n"
              );
          command = scan.nextLine();
          if(command.equals("1")){
            System.out.println("Calling hasNext on the iterator");
            System.out.println("hasNext returned: " + iter.hasNext());
          }
          else if(command.equals("2")){
            System.out.println("Calling next on the iterator");
            try{
              System.out.println("Got string: " + iter.next());
            } catch (IllegalStateException ise) {
              System.out.println(ise);
            } catch (NoSuchElementException nsee) {
              System.out.println(nsee);
            }
          }
          else if(command.equals("3")){
            System.out.println("Calling remove on the iterator");
            try{
              iter.remove();
              System.out.println("The list now has " + stringList.size() 
                  + " " + ((stringList.size() == 1)? "string" : "strings")
                  + "\n");
            } catch (IllegalStateException ise) {
              System.out.println(ise);
            } 
          }
          else if(command.equals("4")){
            System.out.println("Quitting the iterator...");
            doneWithIterator = true;
          }
        }
        
      } else if (command.equals("6")){
        System.out.println("you chose the 'print' option");
        System.out.println(stringList);
      } else if (command.equals("7")){
        System.out.println("Quitting...");
        quit = true;
      }
      else {
        System.out.println("That's not a valid option!!!\n");
      }
    }
  }
  
}
