package edu.manoa.ics211.dec.hw3;
/** 

  * Prints prime numbers up to n using the sieve of Eratosthenes.

  * @author         , Leo

  * @assignment     ICS 211 Assignment 3 

  * @date           September 11, 2011

  * @bugs           None

  */
public class SieveOfEratosthenes {

  /** The numbers from 1 to n. */
  private boolean[] numbers;
  
  /**
   * Instantiates a new sieve of Eratosthenes.
   *
   * @param n the n
   */
  public SieveOfEratosthenes(int n) {
    this.numbers = new boolean[n + 1];
    for(int i = 0; i < numbers.length; i++){
      numbers[i] = true;
    }
    runAlgorithm2();
  }
  
  /**
   * Mark multiples of n as not prime (false).
   *
   * @param n the n
   */
  private void markMultiplesOf(int n){
    for(int i = n + n; i < numbers.length; i += n) {
      numbers[i] = false;
    }
  }
  
  /**
   * Run algorithm1.
   */
  private void runAlgorithm1(){
    //printSieve();
    for(int i = 2; i < numbers.length; i++) {
      if(numbers[i]) {
        markMultiplesOf(i);
      }
      //printSieve();
    }
  }
  
  private void runAlgorithm2(){
    printSieve();
    for(int i = 2; i * i <= numbers.length; i++) {
      if(numbers[i]) {
        markMultiplesOf(i);
      }
      printSieve();
    }
  }
  
  /**
   * Prints the primes.
   */
  public void printPrimes(){
    for(int i = 2; i < numbers.length; i++) {
      if (numbers[i]) {
        System.out.println(i);
      }
    }
  }
  
  /**
   * Prints a header.
   * (for debugging)
   */
  private void printHeader() {
    for(int i = 0; i < numbers.length; i++) {
      System.out.print(i + " ");
    }
    System.out.println("");
  }
  
  /**
   * Prints the sieve.
   * (for debugging)
   */
  private void printSieve(){
    //printHeader();
    for(int i = 0; i < numbers.length; i++){
      System.out.print(i);
      if(numbers[i]){
        System.out.print("(T)");
      } else {
        System.out.print("(F)");
      }
      System.out.print(" ");
    }
    System.out.println("");
  }

  /**
   * Prints the correct usage.
   */
  private static void printCorrectUsage(){
    System.out.println("Correct usage:");
    System.out.println("java SieveOfEratosthenes n");
    System.out.println("(n is the maximium integer to check for primality)");    
  }
  
  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
    int n;
    if (args.length != 1){
      System.out.println("Incorrect usage.  Exiting...");
      printCorrectUsage();
      System.exit(1);      
    }
    try {
      n = Integer.parseInt(args[0]);
      SieveOfEratosthenes sieve = new SieveOfEratosthenes(n);
      sieve.printPrimes();
    } catch(NumberFormatException nfe) {
      System.out.println(args[0] + " is not a number.  Exiting...");
      printCorrectUsage();
      System.exit(1);
    }
  }
  
}
