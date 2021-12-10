package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class TestStandardCalc {

  @Test
  void testEvaluate() throws Exception { // TESTING Evaluation of different expressions
    StandardCalc sc = new StandardCalc();
    assertEquals(8.0f, sc.evaluate("2 + 6"), 8.0f, "TEST #1 - addition Test Standardcalc");
    assertEquals(2.0f, sc.evaluate("8 - 6"), 2.0f, "TEST #2 - subtraction Test for Standardcalc");
    assertEquals(48.0f, sc.evaluate("8 * 6"), 48.0f,
        "TEST #3 - multiplication Test for Standardcalc");
    assertEquals(1.3333334f, sc.evaluate("8 / 6"), 1.3333334f,
        "TEST #4 - division Test for Standardcalc");
    assertEquals(38f, sc.evaluate("8 + 6 * 5"), 38f, "TEST #5 - harder Test for Standardcalc");
  }

  @Test
  void testInvalidExpressionException() throws Exception {
    StandardCalc sc = new StandardCalc(); // TEST #6 - Testing BadtypeException thrown
    assertThrows(InvalidExpressionException.class, new Executable() {
      public void execute() throws Throwable {
        sc.evaluate("3 3 +");
      }
    }, " TEST #6 - Invalid Expression exception Test");
  }

}
