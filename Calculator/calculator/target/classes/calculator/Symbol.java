package calculator;

/**
 * Enumeration class holding Symbols of the calculator.
 *
 * @author Sayed_Ismail_Ahmed
 *
 */
public enum Symbol { // Enumeration class defining enumeration of Types.
  LEFTBRACKET("("), RIGHTBRACKET(")"), TIMES("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID("!");

  private final String displayName;

  /**
   * Constructor for displaying Symbol.
   *
   * @param display String value of Symbol.
   */
  Symbol(final String display) { // String constructor for Enumerations.
    this.displayName = display;
  }

  @Override
  public String toString() { // Overridden toString for returning String.
    return this.displayName;
  }



}
