package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class scene4Controller {
	
	 private Stage stage;
	 private Scene scene;
	 private Parent root; 
	 
	 private void showKinosaal(Kinosaal kinosaal, Stage stage) {
		    GridPane gridPane = new GridPane();
		    gridPane.setAlignment(Pos.CENTER); // Zentriert das GridPane in der Scene
		    gridPane.setPadding(new Insets(10));
		    gridPane.setHgap(2);
		    gridPane.setVgap(10);

		    int maxSitzeProReihe = kinosaal.getMaxSitzeProReihe(); // Hier sollten Sie die maximale Anzahl von Sitzen pro Reihe berechnen
		    // Hinzufügen von ColumnConstraints für zentrierte Anordnung
		    for (int i = 0; i < maxSitzeProReihe; i++) {
		        ColumnConstraints column = new ColumnConstraints();
		        column.setHgrow(Priority.SOMETIMES);
		        gridPane.getColumnConstraints().add(column);
		    }

		    // Leinwand hinzufügen
		    Label leinwandLabel = new Label("Leinwand");
		    leinwandLabel.setMaxWidth(Double.MAX_VALUE);
		    leinwandLabel.setAlignment(Pos.CENTER);
		    GridPane.setHalignment(leinwandLabel, HPos.CENTER);
		    gridPane.add(leinwandLabel, 0, 0, maxSitzeProReihe, 1);

		    int rowIndex = 1;
		    char reihenBuchstabe = 'A'; // Start bei Buchstabe A
		    for (Reihe reihe : kinosaal.getSitzreihen()) {
		        int sitzeInReihe = reihe.getSitzplaetze().size();
		        int leadingColumns = (maxSitzeProReihe - sitzeInReihe) / 2; // Berechnet die Anzahl der führenden leeren Spalten

		        Label kategorieLabel = new Label("Kategorie: " + reihe.getKategorie().getName());
		        gridPane.add(kategorieLabel, 0, rowIndex, maxSitzeProReihe, 1);
		        rowIndex++;

		        for (int i = 0; i < sitzeInReihe; i++) {
		            Button sitzButton = new Button(String.valueOf(reihenBuchstabe) + (i + 1));
		            gridPane.add(sitzButton, leadingColumns + i, rowIndex);
		        }
		        rowIndex++;
		        reihenBuchstabe++;
		    }

		    // Zurück-Button
		    Button zurueckButton = new Button("Zurück zu Szene 4");
		    zurueckButton.setMaxWidth(Double.MAX_VALUE);
		    zurueckButton.setOnAction(event -> {
		        try {
		            // Annahme: Diese Methode existiert und schaltet zurück zu Szene 4
		            switchToScene2(event);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    });
		    gridPane.add(zurueckButton, 0, rowIndex, maxSitzeProReihe, 1);
		    GridPane.setHalignment(zurueckButton, HPos.CENTER);

		    Scene scene = new Scene(gridPane);
		    stage.setScene(scene);
		    stage.show();
		}




	
	 public void switchToScene51(ActionEvent event) throws IOException {
		    Kinosaal kinosaal = KinosaalVerwaltung.getKinosaalByName("Kino 1");
		    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("scene5-1.fxml"));
		    Parent root = loader.load();
		    scene51Controller controller = loader.getController();
		    controller.setStage(stage);

		    if (kinosaal != null) {
		        // Wenn Kinosaal existiert, zeigen Sie die Kinosaalübersicht an
		        System.out.println("Kinosaal gefunden: " + kinosaal);
		        showKinosaal(kinosaal, stage);
		    } else {
		        // Wenn kein Kinosaal existiert, laden Sie die Konfigurationsszene
		    	scene = new Scene(root);
		        stage.setScene(scene);
		        stage.show();
		    }
		}


	 public void switchToScene52(ActionEvent event) throws IOException {
		 Kinosaal kinosaal = KinosaalVerwaltung.getKinosaalByName("Kino 2");
		    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		    FXMLLoader loader = new FXMLLoader(getClass().getResource("scene5-2.fxml"));
		    Parent root = loader.load();
		    scene52Controller controller = loader.getController();
		    controller.setStage(stage);
		    if (kinosaal != null) {
		        // Wenn Kinosaal existiert, zeigen Sie die Kinosaalübersicht an
		        System.out.println("Kinosaal gefunden: " + kinosaal);
		        showKinosaal(kinosaal, stage);
		    } else {
		        // Wenn kein Kinosaal existiert, laden Sie die Konfigurationsszene
		        scene = new Scene(root);
		        stage.setScene(scene);
		        stage.show();
		    }
		}
	 public void switchToScene2(ActionEvent event) throws IOException {
		  Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 }


}
