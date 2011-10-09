/** 

  * Does something.
  * @author         , Leo
  * @assignment     ICS 613 Assignment 1 
  * @date           September 1, 2011
  * @bugs           None
  */
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The Class InfixEvaluatorTest.
 *
 * @author ICS 211 Section 1 Leo 
 */
public class InfixEvaluatorTest {

  /**
   * Simple.
   *
   * @throws SyntaxErrorException the syntax error exception
   */
  @Test
  public void testEval1() throws SyntaxErrorException  {
    float result = new InfixEvaluator().eval("2 + 2");
    assertEquals("2 + 2 = 4", 4.0 ,  result, 0.00001);
  }
  
  /**
   * Try floats now.
   *
   * @throws SyntaxErrorException the syntax error exception
   */
  @Test
  public void testEval2() throws SyntaxErrorException  {
    float result = new InfixEvaluator().eval("2.1 + 2.9");
    assertEquals("2.1 + 2.9 = 5", 5.0 , result, 0.00001);
  }
  
  /**
   * Add some associativity.
   *
   * @throws SyntaxErrorException the syntax error exception
   */
  @Test
  public void testEval3() throws SyntaxErrorException  {
    float result = new InfixEvaluator().eval("3 * 3 - 2 - 1 ");
    assertEquals("3 * 3 - 2 - 1 = 5", 6.0 , result, 0.00001);
  }
  
  /**
   * A more complicated expression.
   *
   * @throws SyntaxErrorException the syntax error exception
   */
  @Test
  public void testEval4() throws SyntaxErrorException  {
    float result = new InfixEvaluator().eval("1 + 2 + 1.5 * 8 / 3");
    assertEquals("1 + 2 + 1.5 * 8 / 3 = 5", 7.0 , result, 0.00001);
  }

  /**
   * Designed to fail.  Add some trailing operands to the expression.
   *
   * @throws SyntaxErrorException the syntax error exception
   */
  @Test (expected=SyntaxErrorException.class)
  public void testEval5() throws SyntaxErrorException {
    new InfixEvaluator().eval("1 + 2 + 1.5 * 8 / 3 11 12 13");
  }
  

}
