package calculator;

import java.util.EmptyStackException;

/**
 * Class for StrStack to store String entries.
 *
 * @author Sayed_Ismail_Ahmed
 */
public class StrStack {
  
  private Node head;

  private class Node { // constructor for node
    Stack value;
    Node next;
  }

  /**
   * Constructor for StrStack.
   */
  public StrStack() { // Stack constructor defining new objects head's as null.
    head = null;

  }

  /**
   * Method that takes in String to push into stack.
   *
   * @param value of String value.
   */
  public void push(String value) { // pushes element onto stack
    Node oldHead = head;
    head = new Node();
    head.value = new Stack();
    head.next = oldHead;
    head.value.push(new Entry(value));
    //head.next = oldHead; was before
  }
  
  /**
   * Method that pops element from stack.
   *
   * @return value of popped element.
   * @throws EmptyStackException for empty stack.
   */
  public String pop() throws EmptyStackException { // pops element from stack
    String value;
    if (head == null) {
      throw new EmptyStackException(); // throws exception if empty
    }
    try {
      value = head.value.pop().getString();
    } catch (BadTypeException e) {
      value = null;
    }
    head = head.next;
    return value;
  }

  /**
   * Method for if String Stack is Empty. 
   *
   * @return boolean value for empty stack.
   */
  public boolean isEmpty() { // Checking if stack is empty
    return head == null;
  }
  
  
  
  /**
   * Method that returns top element of stack.
   *
   * @return top value of stack.
   * @throws Exception EmptyStackException for empty stack.
   */
  public String top() throws Exception { // Returns preview of top element in stack.
    if (this.head == null) {
      throw new EmptyStackException();
    }
    String top = this.head.value.top().getString();
    return top;
    //return this.head.value.top().getString();
  }

  

}
