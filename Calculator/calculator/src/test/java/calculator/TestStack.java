package calculator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class TestStack {

  private Entry test1;
  private Entry test2;
  private Entry test3;
  private Stack st;


  @BeforeEach
  void createStack() { // Creation of stack for multiple objects
    test1 = new Entry(11);
    test2 = new Entry(Symbol.PLUS);
    test3 = new Entry("hello");
    st = new Stack();
  }

  @Test
  void testPush() { // TEST #1 - Testing for Entry objects to be pushed.
    st.push(test1); 
    st.push(test2);
    st.push(test3);
    assertEquals(3, st.size(), "TEST #1.1 - testing to see if size is correct after push");
    assertEquals(test3, st.top(), "TEST #1.2 - testing to see if top is correct");
  }

  @Test
  void testEmptyStack() throws Exception { // TEST #2 - Testing for working EmptyStackException
    assertThrows(EmptyStackException.class, new Executable() {
      public void execute() throws Throwable {
        st.pop();
      }
    }, "TEST #2 - Empty Stack exception");
  }

  @Test
  void testPop() { // TEST #3 - Testing for pushed objects to be popped
    st.push(test1);
    st.push(test2);
    st.push(test3);
    st.pop();
    assertEquals(test2, st.top(), "TEST #3.1 - testing if top of stack has changed after pop");
    assertTrue(st.pop().equals(test2), "TEST #3.2 - test to see if pop again returns next value");
  }

  @Test
  void testSize() { // TEST #4 - Testing for size update after push
    st.push(test1);
    st.push(test2);
    st.push(test3);
    assertEquals(3, st.size(), "TEST #4 - testing to check correct size after push");
  }

  @Test
  void testTop() { // TEST #5 - Testing for top value retrieval
    st.push(test1);
    st.push(test2);
    st.push(test3);
    assertEquals(test3, st.top(), "TEST #5.1 - testing to see top of stack");
    assertEquals(3, st.size(), "TEST #5.2 - testing to check size of top");
  }

}
