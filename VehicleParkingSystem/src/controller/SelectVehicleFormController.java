package controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.tm.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SelectVehicleFormController {

    public ComboBox<String> cmbVehicleNumbers;
    public ComboBox<String> cmbDriverNames;
    public AnchorPane selectVehicleContext;
    public TextField txtVehicle;
    public Label txtDateTime;
    public JFXButton btnDelivery;
    public JFXButton btnPark;
    public JFXButton btnSlot1;
    public JFXButton btnSlot2;
    public JFXButton btnSlot3;
    public JFXButton btnSlot4;
    public JFXButton btnSlot5;
    public JFXButton btnSlot6;
    public JFXButton btnSlot7;
    public JFXButton btnSlot8;
    public JFXButton btnSlot9;
    public JFXButton btnSlot10;
    public JFXButton btnSlot11;
    public JFXButton btnSlot12;
    public JFXButton btnSlot13;
    public JFXButton btnSlot14;
    public TextField txtAvailable;
    public TextField txtSlotNumbers;

    String[] vehicleNumber = new String[14];
    String[] driverName = new String[16];

    static ArrayList<ParkedDetails> parkingArrayList=new ArrayList();
    static ArrayList<DeliveryDetails> deliveryArrayList=new ArrayList();

    static ArrayList<ArrayList<String>> vehicleNumbers=new ArrayList();
    static ArrayList<ArrayList<String>> driverNames=new ArrayList();

    AddVehicleDriverFormController addVehicleDriverFormController=new AddVehicleDriverFormController();

    /*Set passed vehicle numbers to comboBox*/
    public void setDataToVNComboBox(ArrayList<String> passedArrayData) {
        vehicleNumbers.add(passedArrayData);

        ObservableList<String> obVNList = FXCollections.observableArrayList();
        for (String temp : addVehicleDriverFormController.vehicleNumbers
        ) {
            obVNList.add(String.valueOf(temp));
        }

        cmbVehicleNumbers.setItems(obVNList);
    }

    /*Set passed driver names to comboBox*/
    public  void  setDataToDNComboBox(ArrayList<String> passedArrayData){
        driverNames.add(passedArrayData);

        ObservableList<String> obDNList = FXCollections.observableArrayList();
        for (String temp : addVehicleDriverFormController.driverNames
        ) {
            obDNList.add(String.valueOf(temp));
        }

        cmbDriverNames.setItems(obDNList);

    }

    static ArrayList<Parking> vanPark = new ArrayList<>();
    static ArrayList<Parking> lorryPark = new ArrayList<>();
    static ArrayList<Parking> busPark = new ArrayList<>();

    static ArrayList<Parking> vanParkedSlot = new ArrayList<>();
    static ArrayList<Parking> lorryParkedSlot = new ArrayList<>();
    static ArrayList<Parking> busParkedSlot = new ArrayList<>();

    Parking parking1=new Parking(1,"Van","Yes");
    Parking parking2=new Parking(2,"Van","Yes");
    Parking parking3=new Parking(3,"Van","Yes");
    Parking parking4=new Parking(4,"Van","Yes");
    Parking parking5=new Parking(5,"Cargo Lorry","Yes");
    Parking parking6=new Parking(6,"Cargo Lorry","Yes");
    Parking parking7=new Parking(7,"Cargo Lorry","Yes");
    Parking parking8=new Parking(8,"Cargo Lorry","Yes");
    Parking parking9=new Parking(9,"Cargo Lorry","Yes");
    Parking parking10=new Parking(10,"Cargo Lorry","Yes");
    Parking parking11=new Parking(11,"Cargo Lorry","Yes");
    Parking parking12=new Parking(12,"Van","Yes");
    Parking parking13=new Parking(13,"Van","Yes");
    Parking parking14=new Parking(14,"Bus","Yes");

    public void initialize() {

        initClock();

        /*Insert suitable vehicle to textfield*/
        cmbVehicleNumbers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("KA-4563") || newValue.equals("58-3567") || newValue.equals("GF-4358") || newValue.equals("CCB-3568") || newValue.equals("LM-6679") || newValue.equals("QA-3369")) {
                txtVehicle.setText("VAN");
            } else if (newValue.equals("KB-3668") || newValue.equals("JJ-9878") || newValue.equals("GH-5772") || newValue.equals("XY-4456") || newValue.equals("YQ-3536") || newValue.equals("CBB-3566") || newValue.equals("QH-3444")) {
                txtVehicle.setText("CARGO LORRY");
            } else {
                txtVehicle.setText("BUS");
            }
        });

        /*Disable slot buttons in parking*/
        if (vanPark.size()>0 && vanParkedSlot.size()>0){
            for (Parking parking:vanParkedSlot){
                if (parking.getSlotId()==1){
                    btnSlot1.setDisable(true);
                }else if (parking.getSlotId()==2){
                    btnSlot2.setDisable(true);
                }else if (parking.getSlotId()==3){
                    btnSlot3.setDisable(true);
                }else if (parking.getSlotId()==4){
                    btnSlot4.setDisable(true);
                }else if (parking.getSlotId()==12){
                    btnSlot12.setDisable(true);
                }else if (parking.getSlotId()==13){
                    btnSlot13.setDisable(true);
                }
            }
        }else if (busPark.size()>0 && busParkedSlot.size()>0){
            for (Parking parking:busParkedSlot) {
                if (parking.getSlotId() == 14) {
                    btnSlot14.setDisable(true);
                }
            }
        }else if(lorryPark.size()>0 && lorryPark.size()>0){
            for (Parking parking:lorryParkedSlot){
                if (parking.getSlotId()==5){
                    btnSlot5.setDisable(true);
                }else if (parking.getSlotId()==6){
                    btnSlot6.setDisable(true);
                }else if (parking.getSlotId()==7){
                    btnSlot7.setDisable(true);
                }else if (parking.getSlotId()==8){
                    btnSlot8.setDisable(true);
                }else if (parking.getSlotId()==9){
                    btnSlot9.setDisable(true);
                }else if (parking.getSlotId()==10){
                    btnSlot10.setDisable(true);
                }else if (parking.getSlotId()==11){
                    btnSlot11.setDisable(true);
                }
            }
        }

        if (vanPark.size()==0){
            vanPark.add(parking1);
            vanPark.add(parking2);
            vanPark.add(parking3);
            vanPark.add(parking4);
            vanPark.add(parking12);
            vanPark.add(parking13);
        }

        if (busPark.size()==0){
            busPark.add(parking14);
        }

        if (lorryPark.size()==0){
            lorryPark.add(parking5);
            lorryPark.add(parking6);
            lorryPark.add(parking7);
            lorryPark.add(parking8);
            lorryPark.add(parking9);
            lorryPark.add(parking10);
            lorryPark.add(parking11);
        }
    }

    /*Generate real date and time*/
    private void initClock() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("\tyyyy-MM-dd\n\t   HH:mm:ss");
            txtDateTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) selectVehicleContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void openLoginForm(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/LoginPopupForm.fxml"));
        Parent parent = loader.load();
        LoginPopupFormController controller = loader.<LoginPopupFormController>getController();
        Scene scene= new Scene(parent);
        Stage window = (Stage) selectVehicleContext.getScene().getWindow();
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        window.close();
    }

    public void sendParkingDetailsOnAction(ActionEvent actionEvent) {

        /*Park button disable when click*/
        btnPark.setDisable(true);
        btnDelivery.setDisable(false);

        /*Parking vehicles by generating slot numbers to relevant vehicles*/
        if(txtVehicle.getText().equals("VAN")){
            Parking parking=vanPark.get(0);
            vanParkedSlot.add(parking);
            vanPark.get(0).setPark("No");

            if (vanPark.get(0).getSlotId()==1){
                btnSlot1.setDisable(true);
                txtSlotNumbers.setText("1");
                txtSlotNumbers.setStyle("-fx-text-fill:  #74b9ff;");
            }else if (vanPark.get(0).getSlotId()==2){
                btnSlot2.setDisable(true);
                txtSlotNumbers.setText("2");
                txtSlotNumbers.setStyle("-fx-text-fill:  #74b9ff;");
            }else if (vanPark.get(0).getSlotId()==3){
                btnSlot3.setDisable(true);
                txtSlotNumbers.setText("3");
                txtSlotNumbers.setStyle("-fx-text-fill:  #74b9ff;");
            }else if (vanPark.get(0).getSlotId()==4){
                btnSlot4.setDisable(true);
                txtSlotNumbers.setText("4");
                txtSlotNumbers.setStyle("-fx-text-fill:  #74b9ff;");
            }else if (vanPark.get(0).getSlotId()==12){
                btnSlot12.setDisable(true);
                txtSlotNumbers.setText("12");
                txtSlotNumbers.setStyle("-fx-text-fill:  #74b9ff;");
            }else if (vanPark.get(0).getSlotId()==13){
                btnSlot13.setDisable(true);
                txtSlotNumbers.setText("13");
                txtSlotNumbers.setStyle("-fx-text-fill:  #74b9ff;");
            }
            vanPark.remove(vanPark.get(0));

        }else if(txtVehicle.getText().equals("BUS")){
            Parking parking = busPark.get(0);
            busParkedSlot.add(parking);
            busPark.get(0).setPark("No");

            if (busPark.get(0).getSlotId()==14){
                btnSlot14.setDisable(true);
                txtSlotNumbers.setText("14");
                txtSlotNumbers.setStyle("-fx-text-fill:    #f8a5c2;");
            }
            busPark.remove(busPark.get(0));

        }else if (txtVehicle.getText().equals("CARGO LORRY")){
            Parking parking = lorryPark.get(0);
            lorryParkedSlot.add(parking);
            lorryPark.get(0).setPark("No");

            if (lorryPark.get(0).getSlotId()==5){
                btnSlot5.setDisable(true);
                txtSlotNumbers.setText("5");
                txtSlotNumbers.setStyle("-fx-text-fill:   #b8e994;");
            }else if (lorryPark.get(0).getSlotId()==6){
                btnSlot6.setDisable(true);
                txtSlotNumbers.setText("6");
                txtSlotNumbers.setStyle("-fx-text-fill:   #b8e994;");
            }else if (lorryPark.get(0).getSlotId()==7){
                btnSlot7.setDisable(true);
                txtSlotNumbers.setText("7");
                txtSlotNumbers.setStyle("-fx-text-fill:   #b8e994;");
            }else if (lorryPark.get(0).getSlotId()==8){
                btnSlot8.setDisable(true);
                txtSlotNumbers.setText("8");
                txtSlotNumbers.setStyle("-fx-text-fill:   #b8e994;");
            }else if (lorryPark.get(0).getSlotId()==9){
                btnSlot9.setDisable(true);
                txtSlotNumbers.setText("9");
                txtSlotNumbers.setStyle("-fx-text-fill:   #b8e994;");
            }else if (lorryPark.get(0).getSlotId()==10){
                btnSlot10.setDisable(true);
                txtSlotNumbers.setText("10");
                txtSlotNumbers.setStyle("-fx-text-fill:   #b8e994;");
            }else if (lorryPark.get(0).getSlotId()==11){
                btnSlot11.setDisable(true);
                txtSlotNumbers.setText("11");
                txtSlotNumbers.setStyle("-fx-text-fill:   #b8e994;");
            }
            lorryPark.remove(lorryPark.get(0));
        }

        /*Insert text in textfield about parking*/
        if (btnPark.isDisable()){
            if (txtVehicle.getText().equals("VAN")) {
                txtAvailable.setText("  VAN PARK");
                txtAvailable.setStyle("-fx-text-fill:  #74b9ff;");
            }else if (txtVehicle.getText().equals("BUS")) {
                txtAvailable.setText("  BUS PARK");
                txtAvailable.setStyle("-fx-text-fill:    #f8a5c2;");
            }else if (txtVehicle.getText().equals("CARGO LORRY")) {
                txtAvailable.setText(" CARGO LORRY PARK");
                txtAvailable.setStyle("-fx-text-fill:   #b8e994;");
            }
        }

        /*Pass parking details to table*/
        ParkedDetails parkedDetails=new ParkedDetails(cmbVehicleNumbers.getValue(), txtVehicle.getText(), txtSlotNumbers.getText(), txtDateTime.getText());
        parkingArrayList.add(parkedDetails);
    }

    public void sendLeavingDetailsOnAction(ActionEvent actionEvent) {

        /*Deliver button disable when click*/
        btnDelivery.setDisable(true);
        btnPark.setDisable(false);

        /*Pass leaving details to table*/
        DeliveryDetails deliveryDetails=new DeliveryDetails(cmbVehicleNumbers.getValue(), txtVehicle.getText(), cmbDriverNames.getValue(), txtDateTime.getText());
        deliveryArrayList.add(deliveryDetails);

        /*Get previous slot number and disable slot button*/
        if (btnSlot1.isDisable()){
            btnSlot1.setDisable(false);
            txtSlotNumbers.setText("");
            vanPark.get(0).setSlotId(1);
        }else if (btnSlot2.isDisable()){
            btnSlot2.setDisable(false);
            txtSlotNumbers.setText("");
            vanPark.get(0).setSlotId(2);
        }else if (btnSlot3.isDisable()){
            btnSlot3.setDisable(false);
            txtSlotNumbers.setText("");
            vanPark.get(0).setSlotId(3);
        }else if (btnSlot4.isDisable()){
            btnSlot4.setDisable(false);
            txtSlotNumbers.setText("");
            vanPark.get(0).setSlotId(4);
        }else if (btnSlot5.isDisable()){
            btnSlot5.setDisable(false);
            txtSlotNumbers.setText("");
            lorryPark.get(0).setSlotId(5);
        }else if (btnSlot6.isDisable()){
            btnSlot6.setDisable(false);
            txtSlotNumbers.setText("");
            lorryPark.get(0).setSlotId(6);
        }else if (btnSlot7.isDisable()){
            btnSlot7.setDisable(false);
            txtSlotNumbers.setText("");
            lorryPark.get(0).setSlotId(7);
        }else if (btnSlot8.isDisable()){
            btnSlot8.setDisable(false);
            txtSlotNumbers.setText("");
            lorryPark.get(0).setSlotId(8);
        }else if (btnSlot9.isDisable()){
            btnSlot9.setDisable(false);
            txtSlotNumbers.setText("");
            lorryPark.get(0).setSlotId(9);
        }else if (btnSlot10.isDisable()){
            btnSlot10.setDisable(false);
            txtSlotNumbers.setText("");
            lorryPark.get(0).setSlotId(10);
        }else if (btnSlot11.isDisable()){
            btnSlot11.setDisable(false);
            txtSlotNumbers.setText("");
            lorryPark.get(0).setSlotId(11);
        }else if (btnSlot12.isDisable()){
            btnSlot12.setDisable(false);
            txtSlotNumbers.setText("");
            vanPark.get(0).setSlotId(12);
        }else if (btnSlot13.isDisable()){
            btnSlot14.setDisable(false);
            txtSlotNumbers.setText("");
            vanPark.get(0).setSlotId(13);
        }else if (btnSlot14.isDisable()){
            btnSlot14.setDisable(false);
            txtSlotNumbers.setText("");
            busPark.get(0).setSlotId(14);
        }

        /*Insert text in textfield about leaving*/
        if (btnDelivery.isDisable()){
            if (txtVehicle.getText().equals("VAN")) {
                txtAvailable.setText("  VAN LEAVE");
                txtAvailable.setStyle("-fx-text-fill:  #74b9ff;");
            }else if (txtVehicle.getText().equals("BUS")) {
                txtAvailable.setText("  BUS LEAVE");
                txtAvailable.setStyle("-fx-text-fill:    #f8a5c2;");
            }else if (txtVehicle.getText().equals("CARGO LORRY")) {
                txtAvailable.setText(" CARGO LORRY LEAVE");
                txtAvailable.setStyle("-fx-text-fill:   #b8e994;");
            }
        }
    }
}
