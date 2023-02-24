package Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import Infrastructure.Client;
import Infrastructure.Vehicle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersistenceService {

    //Definiert den JSON Dateinamen und Objectmapper
    private String filenameVehicle = "vehicles.json";
    private ObjectMapper mapperVehicle;

    private String filenameClient = "clients.json";
    private ObjectMapper mapperClient;

    //Instanziiert einen neuen Persistence Service
    public PersistenceService() {
        mapperVehicle = new ObjectMapper();
        mapperClient = new ObjectMapper();
    }

    //Methode um die Fahrzeuge zu laden
    public List<Vehicle> loadVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try {
            File jsonFile = new File(filenameVehicle);
            if (jsonFile.exists()) {
                Vehicle[] vehicleArray = mapperVehicle.readValue(jsonFile, Vehicle[].class);

                for (Vehicle vehic: vehicleArray) {
                    vehicles.add(vehic);
                }
            }
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        return vehicles;
    }

    //Methode um die Fahrzeuge zu speichern
    public void saveVehicles(List<Vehicle> vehicles) {
        try {
            File jsonFile = new File(filenameVehicle);
            mapperVehicle.writerWithDefaultPrettyPrinter().writeValue(jsonFile, vehicles);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }


    //Methode um die Kunden zu laden
    public List<Client> loadClients() {
        List<Client> clients = new ArrayList<>();
        try {
            File jsonFile = new File(filenameClient);
            if (jsonFile.exists()) {
                Client[] clientArray = mapperClient.readValue(jsonFile, Client[].class);

                for (Client cli: clientArray) {
                    clients.add(cli);
                }
            }
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
        return clients;
    }

    //Methode um die Kunden zu speichern
    public void saveClients(List<Client> clients) {
        try {
            File jsonFile = new File(filenameClient);
            mapperClient.writerWithDefaultPrettyPrinter().writeValue(jsonFile, clients);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
