package calculator;

/**
 * Custom Exception if a Bad type has been entered. 
 *
 * @author Sayed_Ismail_Ahmed
 *
 */
public class BadTypeException extends Exception { // Exception for BadType
  /**
   * BadTypeException for incorrect type.
   * 
   */
  private static final long serialVersionUID = 1L;
  
  /**
   * Method to handle exception.
   *
   * @param message to display to user.
   *
   */
  public BadTypeException(String message) {
    super(message); // Returns the message through Super Class Exception
  }
}
