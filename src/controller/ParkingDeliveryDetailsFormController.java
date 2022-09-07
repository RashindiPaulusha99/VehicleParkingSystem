package controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.tm.DeliveryDetails;
import view.tm.ParkedDetails;

import java.io.IOException;
import java.net.URL;

public class ParkingDeliveryDetailsFormController {
    public TableView<ParkedDetails> tblVehicle1;
    public AnchorPane parkingSystemContext;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colSlotNumber;
    public TableColumn colParkTime;
    public TableView<DeliveryDetails> tblVehicle2;
    public TableColumn colVehicleNumber1;
    public TableColumn colVehicleType1;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;
    public JFXButton btnPark;
    public JFXButton btnDelivery;

    public void initialize(){
        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colSlotNumber.setCellValueFactory(new PropertyValueFactory<>("slotNumber"));
        colParkTime.setCellValueFactory(new PropertyValueFactory<>("parkedTime"));

        colVehicleNumber1.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colVehicleType1.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory<>("leftTime"));

        loadAllParkingDetails();
        loadAllDeliveryDetails();
    }

    SelectVehicleFormController selectVehicleFormController=new SelectVehicleFormController();

    /* Load Parking details to table*/
    private void loadAllParkingDetails(){
        ObservableList<ParkedDetails> tmObservableList = FXCollections.observableArrayList();
        for (ParkedDetails temp: selectVehicleFormController.parkingArrayList) {
            tmObservableList.add(new ParkedDetails(temp.getVehicleNumber(),temp.getVehicleType(),temp.getSlotNumber(),temp.getParkedTime()));
        }
        tblVehicle1.setItems(tmObservableList);
    }

    /* Load Parking details to table*/
    private void loadAllDeliveryDetails(){
        ObservableList<DeliveryDetails> tmObservableList = FXCollections.observableArrayList();
        for (DeliveryDetails temp: selectVehicleFormController.deliveryArrayList) {
            tmObservableList.add(new DeliveryDetails(temp.getVehicleNumber(),temp.getVehicleType(),temp.getDriverName(),temp.getLeftTime()));
        }
        tblVehicle2.setItems(tmObservableList);
    }

    public void backToSelectVehicleForm(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/SelectVehicleForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) parkingSystemContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    /*Show leaving details table by disable parking details table*/
    public void btnDisableParking(ActionEvent actionEvent) {
        btnPark.setDisable(true);
        btnDelivery.setDisable(false);
        if (btnPark.isDisable()){
            tblVehicle1.setDisable(true);
            tblVehicle2.setDisable(false);
        }
    }

    /*Show parking details table by disable leaving details table*/
    public void btnDisableDelivery(ActionEvent actionEvent) {
        btnDelivery.setDisable(true);
        btnPark.setDisable(false);
        if (btnDelivery.isDisable()){
            tblVehicle2.setDisable(true);
            tblVehicle1.setDisable(false);
        }
    }

    public void openAdd(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicleDriverForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) parkingSystemContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
