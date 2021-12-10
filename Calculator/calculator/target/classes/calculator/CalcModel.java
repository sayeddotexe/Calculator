package calculator;


import java.util.ArrayList;
import java.util.EmptyStackException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller class for the interface.
 *
 * @author Sayed_Ismail_Ahmed
 */
public class CalcModel {

  boolean pressed;
  @FXML
  private Button rewind;
  @FXML
  private Button revpolish;
  @FXML
  private Button infix;
  @FXML
  private Label sho;
  @FXML
  private TextField expression;
  @FXML
  private Label answer;
  String last = "No Previous Expresion";
  ArrayList<String> entries = new ArrayList<String>();
  int press = 0;



  /**
   * Class for button press.
   *
   * @param event takes in action event
   * @throws Exception throws exception
   */
  public void infix(ActionEvent event) throws Exception { // method if infix button is pressed
    pressed = true;
    sho.setText("");
    answer.setText("");
    last = expression.getText().toString();
    evaluate(last, pressed);


  }

  /**
   * Class for button press.
   *
   * @param event takes in action event
   * @throws Exception throws exception
   */
  public void revpolish(ActionEvent event) throws Exception { // method if reverse polish is pressed
    pressed = false;
    sho.setText("");
    answer.setText("");
    last = expression.getText().toString();
    evaluate(last, pressed);

  }


  /**
   * Class for outputting evaluation.
   *
   * @param expr for expression input.
   * @param infix for boolean infix.
   * @throws Exception throws exception
   */
  public void evaluate(String expr, boolean infix) throws Exception {
    // evaluates infix and RP method
    if (infix == true) {
      try {
        StandardCalc sc = new StandardCalc();
        answer.setText("Answer: " + String.valueOf(sc.evaluate(expr)));
        entries.add(expr);
        press = 0;
      } catch (InvalidExpressionException | EmptyStackException e) { // Catch any sort of exception
        // and inform user
        sho.setText("Invalid Input");
      } catch (Exception e) {
        sho.setText("Invalid Input");
      }
    } else {
      try {
        RevPolishCalc rpc = new RevPolishCalc();
        answer.setText("Answer: " + String.valueOf(rpc.evaluate(expr)));
        entries.add(expr);
        press = 0;
      } catch (InvalidExpressionException | EmptyStackException e) {
        sho.setText("Invalid Input");
      } catch (Exception e) {
        sho.setText("Invalid Input");
      }

    }

  }

  /**
   * Rewind feature for previous expression entered.
   *
   * @param event action event.
   * @throws Exception out of bounds array.
   */
  public void rewind(ActionEvent event) throws Exception { // method for button to rewind

    try {
      String text = entries.get(entries.size() - press - 1);
      expression.setText(text);


    } catch (Exception e) {
      sho.setText("No Previous");
    }
    press++;


  }



}
