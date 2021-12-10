package calculator;

import java.util.EmptyStackException;

/**
 * Class for NumStack to store float entries.
 *
 * @author Sayed_Ismail_Ahmed
 */

public class NumStack {

  private Node head;

  private class Node { // constructor for node
    Stack value;
    Node next;
  }

  /**
   * constructor for the NumStack.
   */
  public NumStack() { // Stack constructor defining new objects head's as null.
    head = null;

  }

  /**
   * Method that takes in Float number to push into stack.
   *
   * @param value of float value.
   */
  public void push(float value) { // method for pushing elements
    Entry a = new Entry((float) value);
    Stack s = new Stack();
    s.push(a);
    Node oldHead = head;
    head = new Node();
    head.value = s;
    head.next = oldHead;

  }

  /**
   * Method that pops element from stack.
   *
   * @return value of element popped.
   */
  public float pop() throws EmptyStackException { // method for popping elements
    float value;
    if (head == null) {
      throw new EmptyStackException();
    }
    try {
      value = (float) head.value.pop().getValue();

    } catch (BadTypeException e) {
      System.out.println(e);
      value = 0;
    }
    head = head.next;
    return value;
  }

  /**
   * Method that checks if stack is empty.
   *
   * @return boolean
   */
  public boolean isEmpty() { // method for checking empty stack
    return head == null;
  }



}

