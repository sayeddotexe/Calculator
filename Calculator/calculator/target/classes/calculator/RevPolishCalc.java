package calculator;



/**
 * Class for RevPolishCalc to evaluate entries.
 *
 * @author Sayed_Ismail_Ahmed
 */
public class RevPolishCalc {

  /**
   * constructor for RevPolish.
   */
  public RevPolishCalc() {

  }

 
  
  /**
   * Method that evaluates a entry in reverse polish.
   *
   * @param what for what the expression is.
   * @return value after evaluation
   * @throws InvalidExpressionException for invalid expression.
   */
  public float evaluate(String what) throws InvalidExpressionException { // evaluate expression
    // float value = 0;
    float val1;
    float val2;

    NumStack nst = new NumStack();

    String[] expr = what.split("\\s+");

    // test if input is valid

    if (String.valueOf(expr[expr.length - 1]).equals("+") == false
        && String.valueOf(expr[expr.length - 1]).equals("-") == false
        && String.valueOf(expr[expr.length - 1]).equals("*") == false
        && String.valueOf(expr[expr.length - 1]).equals("/") == false) {
      throw new InvalidExpressionException("invalid expression");
    }
    for (int i = 0; i < expr.length; i++) { // loop for symbol handling
      switch (expr[i]) {
        case "+": // case for plus
          float add = (float) nst.pop() + nst.pop();

          nst.push((float) add);


          break;
        case "-": // case for minus
          val1 = nst.pop();
          val2 = nst.pop();
          nst.push(val2 - val1);
          break;
        case "*": // case for times
          nst.push(nst.pop() * nst.pop());
          break;
        case "/": // case for divide
          val1 = nst.pop();
          val2 = nst.pop();
          nst.push(val2 / val1);
          break;
        default:
          nst.push(Float.valueOf(expr[i]));

      }
    }


    return nst.pop();
  }



}
