package view.tm;

import javafx.scene.control.Button;

public class AddDriverTMV {
    private String driverName;
    private String nic;
    private String drivingLicense;
    private String address;
    private String contact;
    private Button btn;

    public AddDriverTMV() {
    }

    public AddDriverTMV(String driverName, String nic, String drivingLicense, String address, String contact, Button btn) {
        this.setDriverName(driverName);
        this.setNic(nic);
        this.setDrivingLicense(drivingLicense);
        this.setAddress(address);
        this.setContact(contact);
        this.setBtn(btn);
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
