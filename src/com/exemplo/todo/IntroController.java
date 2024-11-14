package com.exemplo.todo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class IntroController {

    @FXML
    private void goToMainView(ActionEvent event) {
        try {
            // Obtém o estágio atual a partir do evento
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            Parent mainRoot = FXMLLoader.load(getClass().getResource("MainView.fxml"));
            Scene mainScene = new Scene(mainRoot);
            mainScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setScene(mainScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
