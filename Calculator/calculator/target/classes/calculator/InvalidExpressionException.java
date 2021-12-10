package calculator;

/**
 * Custom Exception if a Invalid Expression has been entered. 
 *
 * @author Sayed_Ismail_Ahmed
 *
 */
public class InvalidExpressionException extends Exception { // Exception for BadType
  /**
   * InvalidExpressionException for incorrect type.
   * 
   */
  private static final long serialVersionUID = 1L;

  /**
   * Method for Invalid Expression exception. 
   *
   * @param message takes in exception message
   */
  public InvalidExpressionException(String message) {
    super(message); // Returns the message through Super Class Exception
  }
}