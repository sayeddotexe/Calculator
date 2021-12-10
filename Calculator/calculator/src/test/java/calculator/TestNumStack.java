package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class TestNumStack {
  private NumStack nst;

  @BeforeEach
  void createStack() { // Creation of NumStack for each test
    nst = new NumStack();
  }


  @Test
  void testPush() { // TEST #1 - Testing for floats pushed
    nst.push(5.0f);
    assertTrue(!(nst.isEmpty()), "TEST #1 - test to see if value is pushed");

  }

  @Test
  void testPop() { // TEST #2 - Testing for floats popped
    nst.push(5.0f);
    // nst.pop();
    // assertTrue(nst.isEmpty(), "test to see if its empty after popping");
    assertEquals(5.0f, nst.pop(), 5.0f,
        "#TEST #2 - Test that new Entry returns correct float value");
  }

  @Test
  void testIsEmpty() { // TEST #3 - Testing if stack is empty.
    nst.push(5.0f);
    assertTrue(!(nst.isEmpty()), "TEST #3 - test to see if its empty after pushing");
  }
  
  @Test
  void testEmptyStackException() throws Exception {

    assertThrows(EmptyStackException.class, new Executable() { // test #4 - Testing for empty stack

      public void execute() throws Throwable {
        nst.pop();
      }
    }, " TEST #4 - EmptyStack Expression exception Test handling");
  }

}
