package Exercise.week7;

public class Vehicle {
    private String vehicleType;
    private String brand;
    private String model;
    private int year;

    public Vehicle(String vehicleType, String brand, String model, int year) {
        this.vehicleType = vehicleType;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void start() {
        System.out.println("The " + vehicleType + " is starting");
    }

    public void stop() {
        System.out.println("The " + vehicleType + " is stopping");
    }

    public void accelerate() {
        System.out.println("The " + vehicleType + " is accelerating");
    }

    public void brake() {
        System.out.println("The " + vehicleType + " is braking");
    }

    public void displayInfo() {
        System.out.println("Type: " + vehicleType + ", Brand: " + brand + ", Model: " + model + ", Year: " + year);
    }

    // Getter & Setter
    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}