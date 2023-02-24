package Infrastructure;

public class Transporter extends Vehicle {
    private String maximumLoadCapacity;

    //Konstruktor zur Erstellung eines Transporters
    public Transporter(String brand, String model, double engineCapacity, String fuelType, double currentKilometreStatus,
                   double performance, String firstRegistration,String color, double emptyWeight, String maximumLoadCapacity) {
        this.setBrand(brand);
        this.setModel(model);
        this.setEngineCapacity(engineCapacity);
        this.setFuelType(fuelType);
        this.setCurrentKilometreStatus(currentKilometreStatus);
        this.setPerformance(performance);
        setFirstRegistrationAsString(firstRegistration);
        this.setColor(color);
        this.setEmptyWeight(emptyWeight);
        this.setMaximumLoadCapacity(maximumLoadCapacity);
    }

    //Getter und Setter
    public String getMaximumLoadCapacity() {
        return maximumLoadCapacity;
    }
    public void setMaximumLoadCapacity(String maximumLoadCapacity) {
        this.maximumLoadCapacity = maximumLoadCapacity;
    }
}
