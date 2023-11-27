package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class scene3Controller {
	
	private Stage stage;
	private Scene scene;
	private Parent root; 
	
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField genreTextField;
    @FXML
    private TextField runtimeTextField;
    @FXML
    private Button addButton;
    @FXML
    private TableView<Film> tableView;
    @FXML
    private TableColumn<Film, String> titleColumn;
    @FXML
    private TableColumn<Film, String> genreColumn;
    @FXML
    private TableColumn<Film, Double> runtimeColumn;

    //private final ObservableList<Film> filmList = FXCollections.observableArrayList();
    private final ObservableList<Film> filmList = FilmListSingleton.getInstance().getFilmList();


    public void initialize() {
        // Set up TableView columns
    	titleColumn.setCellValueFactory(new PropertyValueFactory<>("titel"));
    	genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
    	runtimeColumn.setCellValueFactory(new PropertyValueFactory<>("laufzeit"));


        // Set TableView data source
        tableView.setItems(filmList);
    }

    @FXML
    private void addButtonClicked(ActionEvent event) {
    	System.out.println("Button geklickt");
        String title = titleTextField.getText();
        String genre = genreTextField.getText();
        double runtime = Double.parseDouble(runtimeTextField.getText());

        Film film = new Film(title, genre, runtime);
        filmList.add(film);

        // Clear text fields
        titleTextField.clear();
        genreTextField.clear();
        runtimeTextField.clear();
    }
    public void switchToScene2(ActionEvent event) throws IOException {
  	  Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
  	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  	  scene = new Scene(root);
  	  stage.setScene(scene);
  	  stage.show();
  	 }
}
