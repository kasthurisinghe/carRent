package lk.ijse.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class MainMenu {
    public Button rentalBtn;
    public Button cutomerBtn;
    public Button vehicleBtn;

    public void btnExitClickOnAction(ActionEvent actionEvent) {
        Platform.exit();
    }
}
