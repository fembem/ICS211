package edu.hawaii.ics211.dec.hw4;

import java.util.Scanner;

public class AddressBook {
  
  class AddressBookEntry{
    String name;
    String telNumber;
    
    public AddressBookEntry(String name, String telNumber) {
      super();
      this.name = name;
      this.telNumber = telNumber;
    }
    
    @Override
    public String toString() {
      return "(" + name + ", " + telNumber + ")";
    }
    
  }
  
  OrderedLinkedList<AddressBookEntry> entries = new OrderedLinkedList<AddressBookEntry>();
  
  public static void main(String[] args) {
    AddressBook addressBook = new AddressBook();
    System.out.println("Starting program, address book is empty.\n");
    Scanner scan = new Scanner(System.in);
    boolean quit = false;
    while (!quit) {
      System.out.print("enter one of: add, find, print, quit: ");
      String command = scan.nextLine();
      if(command.equals("add")){
        System.out.println("\tyou chose the add option");
        addressBook.addEntry(scan);
        System.out.println("The address book has " + addressBook.entries.size() 
            + " " + ((addressBook.entries.size() == 1)? "entry" : "entries")
            + "\n");
      } else if (command.equals("find")){
        System.out.println("\tyou chose the find option");
        addressBook.findEntry(scan);
      } else if (command.equals("print")){
        System.out.println("\tyou chose the print option");
        addressBook.print(scan);
      } else if (command.equals("quit")){
        System.out.println("Quitting...");
        quit = true;
      }
      else {
        System.out.println("That's not a valid option!!!\n");
      }
    }
  }
  
  private void addEntry(Scanner scan){
    System.out.print("enter name to add: ");
    String name = scan.nextLine();
    System.out.print("enter telephone number for '" + name + "': ");
    String telNumber = scan.nextLine();
    System.out.println("'" + name + "' added to telephone book, with number " 
        + " " + telNumber);
    entries.add(name, new AddressBookEntry(name, telNumber));
  }
  
  private void findEntry(Scanner scan){
    System.out.print("--enter name to find.");
    String name = scan.nextLine();
    AddressBookEntry entry  = entries.find(name);
    if(entry != null) {
      System.out.println("Entry found!");
      System.out.println("name:\t\t\t" + entry.name);
      System.out.println("tel number:\t\t" + entry.telNumber + "\n");
    }
  }

  private void print(Scanner scan){
    System.out.println("--------------------------");
    System.out.println("---Address Book Entries---");
    System.out.println("--------------------------" + "\n");
    for(AddressBookEntry entry : entries){
      System.out.println(entry.toString());
    }
    System.out.println("--------------------------" + "\n");
  }
  
}
