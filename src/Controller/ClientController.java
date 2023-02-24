package Controller;
import Infrastructure.Client;
import Service.PersistenceService;

import java.util.ArrayList;

public class ClientController {
    private ArrayList<Client> clients = new ArrayList<>();
    private PersistenceService persistenceServiceClient = new PersistenceService();

    public ClientController() {
        clients = (ArrayList<Client>) persistenceServiceClient.loadClients();
    }

    //Methode um einen Kunden hinzuzufügen mithilfe des Persistence Service
    public void addClient(Client client) {
        clients.add(client);
        persistenceServiceClient.saveClients(clients);
    }

    //Methode um einen Kunden zu aktualisieren mithilfe des Persistence Service
    public void updateClient(int index, Client client) {
        clients.set(index, client);
        persistenceServiceClient.saveClients(clients);
    }

    //Methode um einen Kunden zu löschen mithilfe des Persistence Service
    public void removeClient(int index) {
        clients.remove(index);
        persistenceServiceClient.saveClients(clients);
    }

    //Getter für den Kunden
    public Client getClient(int index) {
        return clients.get(index);
    }

    //Getter für die Arraylist
    public ArrayList<Client> getClients() {
        return clients;
    }

    //Setter für die Arraylist (nicht gebraucht)
    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

}
