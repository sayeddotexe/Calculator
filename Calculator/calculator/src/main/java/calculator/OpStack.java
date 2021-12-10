package calculator;

import java.util.EmptyStackException;

/**
 * Class for OpStack to store float entries.
 *
 * @author Sayed_Ismail_Ahmed
 */
public class OpStack {
  
  private Node head;

  private class Node { // node constructor
    Stack value;
    Node next;
  }

  /**
   * Constructor for OpStack.
   */
  public OpStack() { // Stack constructor defining new objects head's as null.
    head = null;

  }

  /**
   * Method that takes in Symbol to push into stack.
   *
   * @param value of Symbol value.
   */
  public void push(Symbol value) { // method for pushing elements 
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
   *@return value of element popped.
   */
  public Symbol pop() throws EmptyStackException { // method for stack pop
    Symbol value;
    if (head == null) {
      throw new EmptyStackException();
    }
    try {
      value = head.value.pop().getSymbol();
    } catch (BadTypeException e) {
      value = Symbol.INVALID;
    }
    head = head.next;
    return value;
  }

  /**
   * Method for checking if OpStack is Empty. 
   *
   * @return boolean for empty.
   */
  public boolean isEmpty() { // method for empty stack check
    return head == null;
  }
  
  
  /**
   * Method that returns top element of stack.
   *
   * @return top containing top value
   * @throws Exception EmptyStackException for empty stack.
   */
  public Symbol top() throws Exception { // Returns preview of top element in stack.
    if (this.head == null) {
      throw new EmptyStackException();
    }
    Symbol top = this.head.value.top().getSymbol();
    return top;
    //return this.head.value.top().getSymbol();
  }

 

}
