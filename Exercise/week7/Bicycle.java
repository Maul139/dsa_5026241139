package Exercise.week7;

public class Bicycle extends Vehicle {
    private int numGears;

    public Bicycle(String brand, String model, int year, int numGears) {
        super("Bicycle", brand, model, year);
        this.numGears = numGears;
    }

    public void ringBell() {
        System.out.println("The " + getVehicleType() + " is ringing its bell");
    }

    // Overloading method ringBell
    public void ringBell(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println("The " + getVehicleType() + " is ringing its bell");
        }
    }

    // Overriding method displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Gears: " + numGears);
    }
}
