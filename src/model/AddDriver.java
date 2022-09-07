package model;

public class AddDriver {
    private String driverName;
    private String nic;
    private String drivingLicense;
    private String address;
    private String contact;

    public AddDriver() {
    }

    public AddDriver(String driverName, String nic, String drivingLicense, String address, String contact) {
        this.setDriverName(driverName);
        this.setNic(nic);
        this.setDrivingLicense(drivingLicense);
        this.setAddress(address);
        this.setContact(contact);
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
}
