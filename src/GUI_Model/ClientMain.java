package GUI_Model;

import Controller.ClientController;
import Infrastructure.Client;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientMain extends JFrame {

    //Attribute der Java Swing Form
    private JPanel mainPanel;
    private JList clientList;
    private JTextField lastnameTextField;
    private JTextField firstnameTextField;
    private JTextField streetTextField;
    private JTextField postalcodeTextField;
    private JTextField cityTextField;
    private JTextField phonePrivateTextField;
    private JTextField phoneMobileTextField;
    private JTextField emailTextField;
    private JTextField dateOfBirthTextField;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton newButton;
    private JButton backCButton;
    private JScrollPane scrollPaneClient;

    //Erstellen des Controllers und des ListModels
    private ClientController clientModel = new ClientController();
    private DefaultListModel clientListModel = new DefaultListModel(); // benötigt für die JList

    public ClientMain() {
        super("My Client Manager");

        clientList.setModel(clientListModel);

        saveButton.setEnabled(false);
        deleteButton.setEnabled(false);

        updateClientList();

        scrollPaneClient.setViewportView(clientList);
        clientList.setLayoutOrientation(JList.VERTICAL);

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        //Button, um zurück zum Hauptmenü zu gelangen
        backCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuMain mainFormM = new menuMain();
                mainFormM.setVisible(true);
                setVisible(false);
            }
        });

        //Button um einen Kunden zu löschen
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = clientList.getSelectedIndex();

                if (selectedIndex >= 0) {
                    clientModel.removeClient(selectedIndex);
                    updateClientList();
                    clientList.setSelectedIndex(selectedIndex - 1);
                }
            }
        });

        //Button um einen neuen Kunden hinzuzufügen
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client client = new Client(
                        lastnameTextField.getText(), firstnameTextField.getText(),
                        streetTextField.getText(), postalcodeTextField.getText(), cityTextField.getText(),
                        phonePrivateTextField.getText(), phoneMobileTextField.getText(), emailTextField.getText(),
                        dateOfBirthTextField.getText()
                );

                clientModel.addClient(client);
                updateClientList();
            }
        });

        //Button um einen aktualisierten Kunden zu speichern
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = clientList.getSelectedIndex();

                if(selectedIndex >= 0) {
                    Client client = clientModel.getClient(selectedIndex);
                    client.setLastname(lastnameTextField.getText());
                    client.setFirstname(firstnameTextField.getText());
                    client.setStreet(streetTextField.getText());
                    client.setPostalCode(postalcodeTextField.getText());
                    client.setCity(cityTextField.getText());
                    client.setPhonePrivate(phonePrivateTextField.getText());
                    client.setPhoneMobile(phoneMobileTextField.getText());
                    client.setEmail(emailTextField.getText());
                    client.setDateOfBirthAsString(dateOfBirthTextField.getText());


                    clientModel.updateClient(selectedIndex, client);
                    updateClientList();
                }
            }
        });

        //lädt bei Klick auf einen Kunden die Attribute in die Textfelder
        clientList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e){
                int selectedIndex = clientList.getSelectedIndex();

                if (selectedIndex >= 0) {
                    Client client = clientModel.getClient(selectedIndex);
                    lastnameTextField.setText(client.getLastname());
                    firstnameTextField.setText(client.getFirstname());
                    streetTextField.setText(client.getStreet());
                    postalcodeTextField.setText(client.getPostalCode());
                    cityTextField.setText(client.getCity());
                    phonePrivateTextField.setText(client.getPhonePrivate());
                    phoneMobileTextField.setText(client.getPhoneMobile());
                    emailTextField.setText(client.getEmail());
                    dateOfBirthTextField.setText(client.getDateOfBirthAsString());
                    saveButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                } else {
                    saveButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                }
            }
        });
    }

    //Zeigt beim Öffnen des Kundenmanagers die Liste der Kunden mit Nachname und Vorname
    private void updateClientList() {
        clientListModel.removeAllElements();

        for(Client client: clientModel.getClients()) {
            clientListModel.addElement(client.getLastname() + " " + client.getFirstname());
        }
    }
}

