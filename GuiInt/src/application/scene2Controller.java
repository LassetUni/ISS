package application;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class scene2Controller {

 private Stage stage;
 private Scene scene;
 private Parent root; 

 public void switchToScene3(ActionEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("scene3.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 } 

 public void switchToScene4(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("scene4.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
 public void switchToScene11(ActionEvent event) throws IOException {
	  Parent root = FXMLLoader.load(getClass().getResource("scene11.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	 }
 public void switchToScene13(ActionEvent event) throws IOException {
	  Parent root = FXMLLoader.load(getClass().getResource("scene13.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	 }
 public void switchToScene1(ActionEvent event) throws IOException {
	  Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	 }



}


