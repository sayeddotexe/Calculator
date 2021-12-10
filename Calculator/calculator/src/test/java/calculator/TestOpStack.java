package calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class TestOpStack {
  private OpStack nst;

  @BeforeEach
  void createStack() { // Creation of Stack before each test
    nst = new OpStack();
  }

  @Test
  void testPush() throws Exception { // TEST #1 - Testing for symbols pushed to stack
    nst.push(Symbol.DIVIDE);
    assertTrue(!(nst.isEmpty()), "TEST #1 - test to see if value is pushed");
    assertTrue(nst.top() == Symbol.DIVIDE, "#TEST #1.2 - test to see if value pushed is correct");
  }

  @Test
  void testPop() { // TEST #2 - Testing if stack pops correctly
    nst.push(Symbol.MINUS);
    nst.pop();
    assertTrue(nst.isEmpty(), "TEST #2 - test to see if its empty after popping");
  }

  @Test
  void testIsEmpty() { // TEST #3 - Testing if stack is empty 
    nst.push(Symbol.LEFTBRACKET);
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
