package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.AddDriver;
import model.AddVehicle;
import view.tm.AddDriverTMV;
import view.tm.AddVehicleTMV;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class AddVehicleDriverFormController {
    public AnchorPane addVehicleContext;
    public JFXTextField txtVehicleNumber;
    public JFXTextField txtWeight;
    public JFXTextField txtPassenger;
    public JFXButton btnSave;
    public JFXButton btnAddNewVehicle;
    public JFXTextField txtNIC;
    public JFXTextField txtDriverName;
    public JFXTextField txtLicense;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXButton btnSave1;
    public JFXButton btnNewDriver;
    public TableView<AddVehicleTMV> tblVehicle;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colWeight;
    public TableColumn colPassengers;
    public TableColumn colDelete1;
    public TableView<AddDriverTMV> tblDrivers;
    public TableColumn colDriverName;
    public TableColumn colNIC;
    public TableColumn colLicense;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDelete2;
    public JFXComboBox cmbVehicleType;

    static ArrayList<AddVehicle> addVehicleList = new ArrayList();
    static ArrayList<AddDriver> addDriverList = new ArrayList();

    static ArrayList<String> vehicleNumbers = new ArrayList();
    static ArrayList<String> driverNames = new ArrayList();

    String[] vehicleNumber = new String[14];
    String[] driverName = new String[16];

    /*Get vehicle number to ArrayList*/
    public void setVNData() {
        vehicleNumbers.add(txtVehicleNumber.getText());
    }

    /*Get driver name to ArrayList*/
    public  void  setDNData(){
        driverNames.add(txtDriverName.getText());
    }

    public void initialize() {
        cmbVehicleType.getItems().addAll(
                "BUS",
                "VAN",
                "CARGO LORRY"
        );

        colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colWeight.setCellValueFactory(new PropertyValueFactory<>("maximumWeight"));
        colPassengers.setCellValueFactory(new PropertyValueFactory<>("passengers"));
        colDelete1.setCellValueFactory(new PropertyValueFactory<>("btn"));

        colDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colLicense.setCellValueFactory(new PropertyValueFactory<>("drivingLicense"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colDelete2.setCellValueFactory(new PropertyValueFactory<>("btn"));
    }

    public boolean isExists(AddVehicle vehicles) {
        for (AddVehicle t : addVehicleList
        ) {
            if (t.getVehicleNumber().equalsIgnoreCase(vehicles.getVehicleNumber())) {
                return false;
            }
        }
        return true;
    }

    /*Save vehicle details*/
    public void saveDetailsOnAction(ActionEvent actionEvent) {
        AddVehicle vehicles = new AddVehicle(txtVehicleNumber.getText(), (String) cmbVehicleType.getValue(), txtWeight.getText(), txtPassenger.getText());
        if (isExists(vehicles)) {
            if (addVehicleList.add(vehicles)) {
                loadAllVehicles();
                new Alert(Alert.AlertType.CONFIRMATION, "Saved A Vehicle..", ButtonType.CLOSE).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Already Exists..", ButtonType.CLOSE).show();
        }
        setVNData();
    }

    /*Load vehicle details to table*/
    private void loadAllVehicles(){
        ObservableList<AddVehicleTMV> tmObservableList = FXCollections.observableArrayList();
        for (AddVehicle temp: addVehicleList) {
            Button btn= new Button("Delete");
            tmObservableList.add(new AddVehicleTMV(temp.getVehicleNumber(),temp.getVehicleType(),temp.getMaximumWeight(),temp.getPassengers(),btn));

            btn.setOnAction((e) -> {
                ButtonType yes= new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType no= new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure whether you want to delete this Vehicle?",yes,no);
                alert.setTitle("Confirmation Alert");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(no)==yes){
                    addVehicleList.remove(temp);
                    loadAllVehicles();
                }else{
                }
            });
        }
        tblVehicle.setItems(tmObservableList);
    }

    public boolean isExists(AddDriver drivers) {
        for (AddDriver t : addDriverList
        ) {
            if (t.getNic().equalsIgnoreCase(drivers.getNic())) {
                return false;
            }
        }
        return true;
    }

    /*Save driver details*/
    public void saveDriverDetailsOnAction(ActionEvent actionEvent) {
        AddDriver drivers = new AddDriver(txtDriverName.getText(), txtNIC.getText(), txtLicense.getText(), txtAddress.getText(),txtContact.getText());
        if (isExists(drivers)) {
            if (addDriverList.add(drivers)) {
                loadAllDrivers();
                new Alert(Alert.AlertType.CONFIRMATION, "Saved A Driver..", ButtonType.CLOSE).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..", ButtonType.CLOSE).show();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Already Exists..", ButtonType.CLOSE).show();
        }
       setDNData();
    }

    /*Load driver details to table*/
    private void loadAllDrivers(){
        ObservableList<AddDriverTMV> tmObservableList = FXCollections.observableArrayList();
        for (AddDriver temp: addDriverList) {
            Button btn= new Button("Delete");
            tmObservableList.add(new AddDriverTMV(temp.getDriverName(),temp.getNic(),temp.getDrivingLicense(),temp.getAddress(),temp.getContact(),btn));

            btn.setOnAction((e) -> {
                ButtonType yes= new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType no= new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure whether you want to delete this Driver?",yes,no);
                alert.setTitle("Confirmation Alert");
                Optional<ButtonType> result = alert.showAndWait();

                if (result.orElse(no)==yes){
                    addDriverList.remove(temp);
                    loadAllDrivers();
                }else{
                }
            });
        }
        tblDrivers.setItems(tmObservableList);
    }

    /*Clear textfields in vehicle details*/
    public void addNewVehicleOnAction(ActionEvent actionEvent) {
        btnAddNewVehicle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                txtVehicleNumber.clear();
                txtWeight.clear();
                txtPassenger.clear();
            }
        });
    }

    /*Clear textfields in driver details*/
    public void addNewDriverOnAction(ActionEvent actionEvent) {
        btnNewDriver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                txtDriverName.clear();
                txtNIC.clear();
                txtLicense.clear();
                txtAddress.clear();
                txtContact.clear();
            }
        });
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ParkingDeliveryDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) addVehicleContext.getScene().getWindow();
        window.setScene(new Scene(load));

    }

    public void backToSelectVehicleOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/SelectVehicleForm.fxml"));
        Parent parent = loader.load();
        SelectVehicleFormController controller = loader.<SelectVehicleFormController>getController();
        controller.setDataToVNComboBox(vehicleNumbers);
        controller.setDataToDNComboBox(driverNames);
        Stage window = (Stage) addVehicleContext.getScene().getWindow();
        window.setScene(new Scene(parent));
    }
}
