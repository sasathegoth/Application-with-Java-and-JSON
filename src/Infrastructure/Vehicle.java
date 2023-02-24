package Infrastructure;

import Service.LocalDateDeserializer;
import Service.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vehicle {
    private String brand;
    private String model;
    private double engineCapacity;
    private String fuelType;
    private double currentKilometreStatus;
    private double performance;

    //Definiert den Gebrauch des Serializer und Deserializer für das Registrierungsdatum
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate firstRegistration;
    private String color;
    private double emptyWeight;

    //Car Attribute
    private String construction;
    private String navigationSystem;

    //Transporter Attribut
    private String maximumLoadCapacity;


    //Konstruktor zur Erstellung eines Fahrzeuges
    public Vehicle(String brand, String model, double engineCapacity, String fuelType, double currentKilometreStatus,
                   double performance, String firstRegistration,String color, double emptyWeight) {
        this.brand = brand;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.fuelType = fuelType;
        this.currentKilometreStatus = currentKilometreStatus;
        this.performance = performance;
        setFirstRegistrationAsString(firstRegistration);
        this.color = color;
        this.emptyWeight = emptyWeight;
    }

    public Vehicle() {

    }

    //Getter und Setter
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }
    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getCurrentKilometreStatus() {
        return currentKilometreStatus;
    }
    public void setCurrentKilometreStatus(double currentKilometreStatus) {
        this.currentKilometreStatus = currentKilometreStatus;
    }

    public double getPerformance() {
        return performance;
    }
    public void setPerformance(double performance) {
        this.performance = performance;
    }

    //Ersetzt durch FirstRegistrationAsString
    public LocalDate getFirstRegistration() {
        return firstRegistration;
    }
    public void setFirstRegistration(LocalDate firstRegistration) {
        this.firstRegistration = firstRegistration;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public double getEmptyWeight() {
        return emptyWeight;
    }
    public void setEmptyWeight(double emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

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

    public String getFirstRegistrationAsString() {
        return this.firstRegistration.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    public void setFirstRegistrationAsString(String firstRegistration) {
        this.firstRegistration = LocalDate.parse(firstRegistration, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public String getMaximumLoadCapacity() {
        return maximumLoadCapacity;
    }
    public void setMaximumLoadCapacity(String maximumLoadCapacity) {
        this.maximumLoadCapacity = maximumLoadCapacity;
    }
}
