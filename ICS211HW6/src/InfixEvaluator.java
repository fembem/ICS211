/** 
  * Does infix evaluation of an expression with *, /, +, - operators with floating
  * point constants and no parentheses.
  * @author         , Leo
  * @assignment     ICS 613 Assignment 6 
  * @date           October 9, 2011
  * @bugs           None
  */
import java.util.*;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/** Class that can evaluate a postfix expression.
*   @author Koffman & Wolfgang
*   @author ICS 211 Section 1, Leo , Assignment 6
* */

/*
 *   --when an operand is read, it is pushed onto the operand stack 
 *   --operators are:
 *    1)pushed onto the operator stack if the new operator has higher precedence than the old operator
 *    2)otherwise, the top of the operator stack is popped and evaluated with the top two elements of 
 *     the operand stack, the result is pushed onto the operand stack, and the new operator is 
 *     pushed onto the operator stack 
 *   --at the end of the expression, operators are popped off and evaluated (popping the operands 
 *     and pushing the results) until the operator stack is empty
 *   --at this point, the operand stack should have exactly one number in it 
 * 
 */


public class InfixEvaluator {

  /** A logger for debugging. */
  Logger logger = Logger.getLogger("com.mycompany.BasicLogging");
  
  /** The operand stack. */
  private Stack < Float > operandStack;
  
  /** The operator stack. */
  private Stack < Character > operatorStack;

  /**
   * Evaluates the current operation.
   * This function pops the two operands off the operand
   * stack and applies the operator.
   *
   * @author Koffman & Wolfgang
   * @param op A character representing the operator
   * @return The result of applying the operator
   */
  private float evalOp(char op) {
    // Pop the two operands off the stack.
    float rhs = operandStack.pop();
    float lhs = operandStack.pop();
    float result = 0;
    // Evaluate the operator.
    switch (op) {
      case '+':
        result = lhs + rhs;
        break;
      case '-':
        result = lhs - rhs;
        break;
      case '/':
        result = lhs / rhs;
        break;
      case '*':
        result = lhs * rhs;
        break;

    }
    return result;
  }

  /**
   * Determines whether a character is an operator.
   *
   * @author Koffman & Wolfgang
   * @param ch the character
   * @return true if the character is an operator
   */
  private boolean isOperator(char ch) {
    return OPERATORS.indexOf(ch) != -1;
  }

  /** Evaluates a postfix expression.
   *   @author Koffman & Wolfgang
   *   @author Leo 
   *   @param expression The expression to be evaluated
   *   @return The value of the expression
   *   @throws SyntaxErrorException if a syntax error is detected
   */
  public float eval(String expression) throws SyntaxErrorException {
    logger.info("---------------------------------");
    // Create an empty stack.
    operandStack = new Stack < Float > ();
    operatorStack = new Stack < Character > ();

    // Process each token.
    StringTokenizer tokens = new StringTokenizer(expression);
    try {
      while (tokens.hasMoreTokens()) {
        String nextToken = tokens.nextToken();
        logger.info("new token: " + nextToken);
        // Does it start with a digit?
        if (Character.isDigit(nextToken.charAt(0))) {
          // Get the float value.
          float value = Float.parseFloat(nextToken);
          // Push value onto operand stack.
          operandStack.push(value);
        } // Is it an operator?
        else if (isOperator(nextToken.charAt(0))) {
          
          char newOp = nextToken.charAt(0);
          logger.info("new op: " + newOp);
          
          if ( operatorStack.isEmpty() || 
              precedence(newOp) > precedence(operatorStack.peek()) ){
            operatorStack.push(newOp);
          } else {
            char oldOp = operatorStack.peek();
            logger.info("ol op: " + oldOp);
            //the top of the operator stack is popped and evaluated 
            //with the top two elements of the operand stack
            float result = evalOp(operatorStack.pop());
            // the result is pushed onto the operand stack
            operandStack.push(result);
            logger.info("pushed evalOp result: " + result);
            //the new operator is pushed onto the operator stack
            operatorStack.push(newOp);
          }
          
        }
        else {
          // Invalid character.
          throw new SyntaxErrorException(
              "Invalid character encountered");
        }
      } // End while.

      logger.info("no more tokens");
      
      // No more tokens
      //operators are popped off and evaluated 
      //(popping the operands and pushing the results)
      //until the operator stack is empty 
      while (!operatorStack.isEmpty()) {
        try{
          float result = evalOp(operatorStack.pop());
          operandStack.push(result);
          logger.info("pushed evalOp result: " + result);
        } catch (EmptyStackException ese) {
          throw new SyntaxErrorException(
              "operator on stack missing lhs or rhs argument");
        }
        
      }
      //at this point, the operand stack should have exactly one number in it 
      float answer = operandStack.pop();
      // Operand stack should be empty.
      if (operandStack.empty()) {
        logger.info("answer is: " + answer);
        return answer;
      }
      else {
        // Indicate syntax error.
        logger.severe("Operand stack orphan elements:");
        while (!operandStack.isEmpty()){
          logger.severe(operandStack.pop() + "; ");
        }
        throw new SyntaxErrorException(
            "Syntax Error: Stack should be empty");
      }
    
    }
    catch (EmptyStackException ex) {
      // Pop was attempted on an empty stack.
      throw new SyntaxErrorException(
          "Syntax Error: The stack is empty");
    }
    
  }
  
  // Constant
  /** A list of operators. */
  private static final String OPERATORS = "+-*/";
  
  /** The precedence of the operators, matches order in OPERATORS. */
  private static final int[] PRECEDENCE = {
      1, 1, 2, 2};
  
  /** Determine the precedence of an operator.
   * @param op The operator
   * @return the precedence
   */
  private int precedence(char op) {
    return PRECEDENCE[OPERATORS.indexOf(op)];
  }

  /** main method. Ask the user for a string and
   * call the InfixEvaluator to find the result of the given expression
   * @param args Not used
   */
  public static void main(String args[]) {
    String expression = JOptionPane.showInputDialog(
        "Enter an infix expression");
    try {
      float answer = new InfixEvaluator().eval(expression);
      JOptionPane.showMessageDialog(null, expression
            + " has result: " + answer);
    } catch ( SyntaxErrorException see) {
      JOptionPane.showMessageDialog(null, expression
          + " has syntax error: " + see.getMessage());      
    }
    System.exit(0);
  }
  
}

class SyntaxErrorException
extends Exception {
  private static final long serialVersionUID = 3190324611750565066L;

  /** Construct a SyntaxErrorException with the specified
  message.
  @param message The message
   */
  SyntaxErrorException(String message) {
    super(message);
  }
}