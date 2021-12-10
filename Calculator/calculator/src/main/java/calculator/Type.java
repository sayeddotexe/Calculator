package calculator;

/**
 * Enumeration class for the Types of input. 
 *
 * @author Sayed_Ismail_Ahmed
 */
public enum Type { // Enumeration class defining enumeration of Types.
  NUMBER("NUMBER"), SYMBOL("SYMBOL"), STRING("STRING"), INVALID("INVALID");

  private final String displayName;

  Type(final String display) { // String constructor for Enumerations.
    this.displayName = display;
  }

  @Override
  public String toString() { // Overridden toString for returning String.
    return this.displayName;
  }

}
