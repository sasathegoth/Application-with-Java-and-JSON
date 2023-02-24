package Controller;
import Service.PersistenceService;
import Infrastructure.Vehicle;

import java.util.ArrayList;

public class VehicleController {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private PersistenceService persistenceServiceVehicle = new PersistenceService();

    public VehicleController() {
        vehicles = (ArrayList<Vehicle>) persistenceServiceVehicle.loadVehicles();
    }

    //Methode um ein Fahrzeug hinzuzufügen mithilfe des Persistence Service
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        persistenceServiceVehicle.saveVehicles(vehicles);
    }

    //Methode um ein Fahrzeug zu aktualisieren mithilfe des Persistence Service
    public void updateVehicle(int index, Vehicle vehicle) {
        vehicles.set(index, vehicle);
        persistenceServiceVehicle.saveVehicles(vehicles);
    }

    //Methode um ein Fahrzeug zu löschen mithilfe des Persistence Service
    public void removeVehicle(int index) {
        vehicles.remove(index);
        persistenceServiceVehicle.saveVehicles(vehicles);
    }

    //Getter für das Fahrzeug
    public Vehicle getVehicle(int index) {
        return vehicles.get(index);
    }

    //Getter für die Arraylist
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    //Setter für die Arraylist (nicht gebraucht)
    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}
