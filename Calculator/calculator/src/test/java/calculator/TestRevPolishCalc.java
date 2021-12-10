package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class TestRevPolishCalc {

  @Test
  void testEvaluate() throws Exception { // TESTING Evaluation of different expressions
    RevPolishCalc rpn = new RevPolishCalc();
    assertEquals(6.1f, rpn.evaluate("3.5 2.6 +"), 6.1f,  // addition test
        "TEST #1 - addition Test for revpolishcalc");
    assertEquals(0.9f, rpn.evaluate("3.5 2.6 -"), 0.9f,     // subtraction test
        "TEST #2 - subtraction Test for revpolishcalc");
    assertEquals(9.1f, rpn.evaluate("3.5 2.6 *"), 9.1f,    // multiplication test
        "TEST #3 - multiplication Test for revpolishcalc");
    assertEquals(1.3f, rpn.evaluate("3.5 2.6 /"), 1.3f,     // division test
        "TEST #4 - division Test for revpolishcalc");
    assertEquals(4.33871f, rpn.evaluate("3.5 2.6 3.1 / +"), 4.33871f,      // tougher test 
        "TEST #5 - Tougher for revpolishcalc");
    
    
  }
  
  @Test
  void testInvalidExpressionException() throws Exception {
    RevPolishCalc rpn = new RevPolishCalc(); // TEST #6 - Testing BadtypeException thrown
    assertThrows(InvalidExpressionException.class, new Executable() {
      public void execute() throws Throwable {
        rpn.evaluate("3 + 3");
      }
    }, " TEST #6 - Invalid Expression exception Test");
  }

}
