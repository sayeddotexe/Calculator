package calculator;

/**
 * Class for entry into the calculator.
 *
 * @author Sayed_Ismail_Ahmed
 */

public class Entry { // Entry class to take in Entries from the calculator.
  private float number;
  private Symbol other;
  private String str;
  private Type type;

  /**
   * Constructor that takes in Float number for Entry.
   *
   * @param number of float value.
   */
  public Entry(float number) { // Entry constructor taking float parameter.
    this.number = number;
  }

  /**
   * Constructor that takes in Symbol entered.
   *
   * @param other of Symbol value.
   */
  public Entry(Symbol other) { // Entry constructor taking Symbol parameter.
    this.other = other;
  }

  /**
   * Constructor that takes in String for Entry.
   *
   * @param str value for entry.
   */
  public Entry(String str) { // Entry constructor taking String parameter.
    this.str = str;
  }



  /**
   * Gets the type stored in the object.
   *
   * @return type returns the type
   */
  public Type getType() { // getter for the value stored in the object.
    return type;
  }

  /**
   * Gets the string stored in the object and throws an exception if its the wrong type.
   *
   * @return String returns the string
   * @throws BadTypeException for incorrect type.
   */
  public String getString() throws BadTypeException { // getter for the value stored in the object.
    if (!(this.str instanceof String)) {
      throw new BadTypeException("Bad Type");
      // returns BadTypeException if the value is not a String.
    }
    return str;
  }

  /**
   * Gets Symbol stored in the object and throws an exception if its the wrong type.
   *
   * @return returns the symbol
   *
   * @throws BadTypeException for incorrect type.
   */
  public Symbol getSymbol() throws BadTypeException { // getter for the value stored in the object.
    if (!(this.other instanceof Symbol)) {
      throw new BadTypeException("Bad Type");
      // returns BadTypeException if the value is not a Symbol.
    }
    return other;
  }

  /**
   * Gets string stored in the object and throws exception if its the wrong type.
   *
   * @return returns the value
   *
   * @throws BadTypeException for incorrect type.
   */
  public float getValue() throws BadTypeException { // getter for the value stored in the object.
    // if (this.number % 1 == 0) { // original
    String str = String.valueOf(this.number);
    // char s = String.valueOf(this.number).charAt(1);

    boolean decimal = false;
    for (int i = 0; i < str.length(); i++) {
      if ((int) str.charAt(i) == 46) {
        decimal = true;
      }
    }



    if (decimal == false) {
      throw new BadTypeException("Bad Type");
      // returns BadTypeException if the value is not a float.
    }
    return number;
  }

  /**
   * Method that sets the type of the object when called.
   *
   * @param type Type data type.
   */
  public void setType(Type type) { // Setter of type Type for the objects type.
    this.type = type;
  }

  /**
   * Method that sets the String of the object when called.
   *
   * @param str String data type.
   */
  public void setString(String str) { // Setter of type String for the objects string.
    this.str = str;
  }

  /**
   * Method that sets the Symbol of the object when called.
   *
   * @param other Symbol data type.
   */
  public void setSymbol(Symbol other) { // Setter of type Symbol for the objects symbol.
    this.other = other;
  }

  /**
   * Constructor that sets the Float of the object when called.
   *
   * @param number float data type.
   */
  public void setValue(float number) { // Setter of type float for the objects number.
    this.number = number;
  }

  /**
   * Hash code method which returns the hash code.
   *
   * @return returns the hash code.
   */
  @Override
  public int hashCode() {

    return super.hashCode();
  }

  /**
   * equals method overridden.
   *
   * @return boolean value.
   */
  @Override
  public boolean equals(Object o) {
    if (o == null) { // If the parameter object is null return false.
      return false;
    }
    if (o == this) { // if the parameter object is equal to current object return true.
      return true;
    }

    if (!(o instanceof Entry)) { // if parameter object is not an instance of Entry return false.
      return false;
    }


    Entry c = (Entry) o; // Entry variable is equal to Parameter object o.

    return c.type == this.type && c.number == this.number && c.str == this.str;
    // return boolean if field values are same.
  }


  @Override
  public String toString() { // Overridden toString for returning String.
    return "type: " + this.type + " String: " + this.str + " number: " + this.number + " Symbol: "
        + this.other;
  }


}
