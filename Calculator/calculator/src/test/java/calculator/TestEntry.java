package calculator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class TestEntry {

  private Entry test1;
  private Entry test2;

  @BeforeEach
  void createEntry() {
    test1 = new Entry(11.5f);
    test2 = new Entry(Symbol.PLUS); // Before each, creating two objects for use.
  }

  @Test
  void testEntryFloat() throws Exception {
    Entry test3 = new Entry(15.5f); // TEST #1 - Testing for creation of Float object
    assertEquals(15.5f, test3.getValue(), 15.5f,
        "TEST #1 - Test that new Entry returns correct float value");
  }

  @Test
  void testEntrySymbol() throws Exception {
    Entry test4 = new Entry(Symbol.MINUS); // TEST #2 - Testing for creation of Symbol object
    assertEquals(Symbol.MINUS, test4.getSymbol(),
        "TEST #2 Test that new Entry returns correct Symbol");
  }

  @Test
  void testEntryString() throws Exception {
    Entry test4 = new Entry("string"); // TEST #3 - Testing for creation of String object
    assertTrue(test4.getString().equals("string"),
        "TEST #3 Test that new Entry returns correct String");
  }

  @Test
  void testGetType() {
    test1.setType(Type.INVALID); // TEST #4 - Testing for Retrieval of object's value
    assertEquals(Type.INVALID, test1.getType(),
        "TEST #4 - Test that new Entry object returns correct Type value");
  }

  @Test
  void testGetString() throws Exception {
    test2.setString("five"); // TEST #5 - Testing for Retrieval of object's value
    assertTrue(test2.getString().equals("five"), "TEST #5 - testing if correct string returned");
  }

  @Test
  void testBadTypeException() throws Exception {
    final Entry test5 = new Entry(Symbol.PLUS); // TEST #6 - Testing BadtypeException thrown
    assertThrows(BadTypeException.class, new Executable() {
      public void execute() throws Throwable {
        test5.getString();
      }
    }, " TEST #6 - Bad Type exception Test");
  }



  @Test
  void testGetSymbol() throws Exception {
    Entry test6 = new Entry(Symbol.PLUS); // TEST #7 - Testing for Retrieval of object's value
    assertEquals(Symbol.PLUS, test6.getSymbol(), "TEST #7 - Test return correct symbol");
  }

  @Test
  void testGetValue() throws Exception {
    Entry test5 = new Entry(3.55f); // TEST #8 - Testing for Retrieval of object's value
    assertEquals(3.55f, test5.getValue(), 3.55f, "TEST #8 - Testing if returns correct float");
  }

  @Test
  void testSetType() {
    test1.setType(Type.INVALID); // TEST #9 - Testing for replacing an existing value.
    assertEquals(Type.INVALID, test1.getType(), "TEST #9 - Testing if setter works");
  }

  @Test
  void testSetString() throws Exception {
    test2.setString("five"); // TEST #10 - Testing for replacing an existing value.
    assertTrue(test2.getString().equals("five"),
        "TEST #10 - testing if correct string is set and returned");
  }

  @Test
  void testSetSymbol() throws Exception {
    test2.setSymbol(Symbol.MINUS); // TEST #11 - Testing for replacing an existing value.
    assertEquals(Symbol.MINUS, test2.getSymbol(),
        "TEST #11 - test if correct symbol is set and returned");
  }

  @Test
  void testSetValue() throws Exception {
    Entry test5 = new Entry(3.55f); // TEST #12 - Testing for replacing an existing value.
    assertEquals(3.55f, test5.getValue(), 3.55f,
        "TEST #12 - testing if correct float is set and returned");
  }

  @Test
  void testEqualsObject() {
    Entry test5 = new Entry(3.55f); // TEST #13 - Testing for equality between two objects
    Entry test6 = new Entry(3.55f);
    assertTrue(test5.equals(test6), "TEST #13 - test testing if objects are equal if same value");
  }

  @Test
  void testHashCode() {
    Entry test5 = new Entry(3.55f); // TEST #13 - Testing for same hash code between two objects
    Entry test6 = new Entry(3.55f);
    assertTrue(test5.equals(test6), "TEST #14 - testing if objects are equal if same hashcode");
  }

}
