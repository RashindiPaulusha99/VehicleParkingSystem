package view.tm;

public class Parking {
    private int slotId;
    private String vehicleType;
    private String isPark;

    public Parking() {
    }

    public Parking(int slotId, String vehicleType, String isPark) {
        this.setSlotId(slotId);
        this.setVehicleType(vehicleType);
        this.setPark(isPark);
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String isPark() {
        return isPark;
    }

    public void setPark(String park) {
        isPark = park;
    }
}
