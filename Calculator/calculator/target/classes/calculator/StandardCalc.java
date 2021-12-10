package calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Class for StandardCalc to evaluate entries.
 *
 * @author Sayed_Ismail_Ahmed
 */
public class StandardCalc {

  /**
   * Constructor for StandardCalc.
   */
  public StandardCalc() {

  }

  /**
   * Method that ranks symbols by precedence.
   *
   * @param input for Symbol of entry
   * @return level of precedence
   * 
   */
  public int precedence(Symbol input) { // Precedence for infix
    int level = 0;
    switch (input) {
      case LEFTBRACKET: // level 0 for LB
        level = 0;
        break;
      case RIGHTBRACKET: // level 0 for RB
        level = 0;
        break;
      case PLUS: // level 1 for plus
        level = 1;
        break;
      case MINUS: // level 1 for minus
        level = 1;
        break;
      case DIVIDE: // level 2 for divide
        level = 2;
        break;
      case TIMES: // level 2 for times
        level = 2;
        break;
      default:
        level = 0;
        break;
    }
    return level;
  }

  /**
   * Method that evaluates a entry in reverse polish.
   *
   * @param what for what the expression is.
   * @return value after evaluation
   * @throws InvalidExpressionException for invalid expression.
   */
  public float evaluate(String what) throws Exception { // evaluation of expression
    OpStack ost = new OpStack();

    StrStack sst = new StrStack();

    String postfix1 = "";
    String[] expr = what.split("\\s+");
    boolean wchar = true;

    // testing if input is correct
    if (expr[expr.length - 1].equals("+") || expr[expr.length - 1].equals("-")
        || expr[expr.length - 1].equals("*") || expr[expr.length - 1].equals("/")) {
      wchar = false;
    }


    if (wchar == false) { // if input is incorrect throw exception
      throw new InvalidExpressionException("invalid expression");
    }



    for (int i = 0; i < expr.length; i++) {

      int cpred;
      int tpred = 0;
      try { // returns precedence for symbol

        tpred = precedence(ost.top());
      } catch (EmptyStackException e) {
        tpred = 0;
      }



      switch (expr[i]) { // switch case for each symbol
        case "+": // case for plus

          cpred = precedence(Symbol.PLUS);
          if (tpred > cpred) {
            sst.push(ost.pop().toString());
            ost.push(Symbol.PLUS);
          } else {
            ost.push(Symbol.PLUS);
          }
          break;
        case "-": // case for minus
          cpred = precedence(Symbol.MINUS);
          if (tpred > cpred) {
            sst.push(ost.pop().toString());
            ost.push(Symbol.MINUS);
          } else {
            ost.push(Symbol.MINUS);
          }
          break;
        case "*": // case for times
          cpred = precedence(Symbol.TIMES);
          if (tpred > cpred) {
            sst.push(ost.pop().toString());
            ost.push(Symbol.TIMES);
          } else {
            ost.push(Symbol.TIMES);
          }
          break;
        case "/": // case for divide
          cpred = precedence(Symbol.DIVIDE);
          if (tpred > cpred) {
            sst.push(ost.pop().toString());
            ost.push(Symbol.DIVIDE);
          } else {
            ost.push(Symbol.DIVIDE);
          }
          break;
        case "(": // case for LB
          cpred = precedence(Symbol.LEFTBRACKET);
          ost.push(Symbol.LEFTBRACKET);
          break;
        case ")": // case for RB
          cpred = precedence(Symbol.RIGHTBRACKET);
          boolean found = false;
          String popped;
          while (found == false) {
            popped = ost.pop().toString();
            if (!popped.equals("(")) {
              sst.push(popped);
            } else {
              found = true;
            }
          }
          break;
        default:
          sst.push(expr[i]);


      }

    }
    while (!ost.isEmpty()) {
      sst.push(ost.pop().toString());
    }

    // sorting out string to be passed onto reverse polish

    ArrayList<String> ar = new ArrayList<String>();
    int a = 0;
    while (!sst.isEmpty()) {
      if (a == 0) {
        ar.add(sst.pop());
      } else {
        ar.add(sst.pop());
        ar.add(" ");
      }

    }

    for (int i = 0; i < ar.size(); i++) {

      postfix1 = postfix1 + ar.get(ar.size() - i - 1) + " ";
    }


    RevPolishCalc rpCalc = new RevPolishCalc();


    return rpCalc.evaluate(postfix1);
  }



}
