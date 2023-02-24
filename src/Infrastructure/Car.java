package Infrastructure;

public class Car extends Vehicle {
    private String construction;
    private String navigationSystem;

    //Konstruktor zur Erstellung eines Autos
    public Car(String brand, String model, double engineCapacity, String fuelType, double currentKilometreStatus,
                   double performance, String firstRegistration, String color, double emptyWeight, String construction, String navigationSystem) {
        this.setBrand(brand);
        this.setModel(model);
        this.setEngineCapacity(engineCapacity);
        this.setFuelType(fuelType);
        this.setCurrentKilometreStatus(currentKilometreStatus);
        this.setPerformance(performance);
        setFirstRegistrationAsString(firstRegistration);
        this.setColor(color);
        this.setEmptyWeight(emptyWeight);
        this.construction = construction;
        this.navigationSystem = navigationSystem;
    }

    //Getter und Setter
    public String getConstruction() {
        return construction;
    }
    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public String getNavigationSystem() {
        return navigationSystem;
    }
    public void setNavigationSystem(String navigationSystem) {
        this.navigationSystem = navigationSystem;
    }
}
