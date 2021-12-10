package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class for interface creation.
 *
 * @author Sayed_Ismail_Ahmed
 */
public class Calculator extends Application {

  /**
   * main method to launch arguments.
   *
   * @param args arguments from main
   */
  public static void main(String[] args) { // main launches arguments
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception { // stage creation method
    Parent root = FXMLLoader.load(getClass().getResource("/myView.fxml"));
    Scene scene = new Scene(root, 600, 400);
    primaryStage.setResizable(false);
    primaryStage.setScene(scene);
    primaryStage.show();    
  }
}