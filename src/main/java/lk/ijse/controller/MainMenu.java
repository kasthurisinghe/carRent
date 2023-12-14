package lk.ijse.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenu {
    public Button rentalBtn;
    public Button cutomerBtn;
    public Button vehicleBtn;
    public AnchorPane rootNode1;

    public void btnExitClickOnAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void btnClickOnCreateCustomerOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootnode = FXMLLoader.load(this.getClass().getResource("/view/customerDetails.fxml"));
        this.rootNode1.getChildren().clear();
        this.rootNode1.getChildren().add(rootnode);
    }

    public void btnVehicleRegistryClickOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootnode = FXMLLoader.load(this.getClass().getResource("/view/carDetails.fxml"));
        this.rootNode1.getChildren().clear();
        this.rootNode1.getChildren().add(rootnode);
    }

    public void btnBookingClickOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootnode = FXMLLoader.load(this.getClass().getResource("/view/bookingDetails.fxml"));
        this.rootNode1.getChildren().clear();
        this.rootNode1.getChildren().add(rootnode);
    }
}
