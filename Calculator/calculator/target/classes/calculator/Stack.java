package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;


/**
 * Stack Class to take in Entries of the calculator.
 *
 * @author Sayed_Ismail_Ahmed
 *
 */
class Stack { // Stack class to store Entries on a stack.
  private Node head;
  private List<Entry> mylist;
  private Node pointer;
  private int size2;

  private class Node { // Node class to contain value and next item in stack.
    Node next;
    List<Entry> value;
  }

  public Stack() { // Stack constructor defining new objects head's as null.
    head = null;

  }

  /**
   * Pop Class retrieves top element from stack.
   *
   * @return top element from stack
   *
   * @throws EmptyStackException if stack is empty.
   */
  public Entry pop() throws EmptyStackException {
    // Pop method takes and returns top element off stack.
    if (head == null) {
      throw new EmptyStackException(); // EmptyStackException if stack is empty.
    }
    List<Entry> value = head.value;
    head = head.next;
    return value.get(0);

  }

  /**
   * Pushes an entry onto the stack.
   *
   * @param value Entry to be pushed onto stack
   */
  public void push(Entry value) { // Pushes new Entry onto the stack.
    Node oldhead = head;
    head = new Node();
    mylist = new ArrayList<Entry>(Arrays.asList(value));
    head.next = oldhead;
    head.value = mylist;
    // head.next = oldhead;

  }

  /**
   * Retrieves the size of the stack by counting each item in the stack.
   *
   * @return Stack size as integer.
   */
  public int size() { // Retrieves size of stack by iterating over each item.
    pointer = head;
    while (pointer != null) {
      size2 += 1;
      pointer = pointer.next;
    }
    return size2;
  }



  /**
   * provides a preview of the top stack entry without removing it from the stack.
   *
   * @return Element in the top of the stack.
   *
   * @throws EmptyStackException if the stack is empty.
   */
  public Entry top() throws EmptyStackException { // Returns preview of top element in stack.
    if (this.head == null) {
      throw new EmptyStackException();
    }
    return this.head.value.get(0);
  }


}


