package view.tm;

import javafx.scene.control.Button;

public class AddVehicleTMV {
    private String vehicleNumber;
    private String vehicleType;
    private String maximumWeight;
    private String passengers;
    private Button btn;

    public AddVehicleTMV() {
    }

    public AddVehicleTMV(String vehicleNumber, String vehicleType, String maximumWeight, String passengers, Button btn) {
        this.setVehicleNumber(vehicleNumber);
        this.setVehicleType(vehicleType);
        this.setMaximumWeight(maximumWeight);
        this.setPassengers(passengers);
        this.setBtn(btn);
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(String maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
