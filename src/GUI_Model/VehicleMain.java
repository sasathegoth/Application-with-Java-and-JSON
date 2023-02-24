package GUI_Model;

import Controller.VehicleController;
import Infrastructure.Car;
import Infrastructure.Transporter;
import Infrastructure.Vehicle;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class VehicleMain extends JFrame{

    //Attribute der Java Swing Form
    private JPanel mainPanel;
    private JList vehicleList;
    private JTextField brandTextField;
    private JTextField modelTextField;
    private JTextField engineCapacityTextField;
    private JTextField fuelTypeTextField;
    private JTextField kilometreStatusTextField;
    private JTextField performanceTextField;
    private JTextField registrationTextField;
    private JTextField colorTextField;
    private JTextField weightTextField;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton newButton;
    private JRadioButton carRadioButton;
    private JRadioButton transporterRadioButton;
    private JTextField constructionTextField;
    private JTextField navigationTextField;
    private JTextField capacityTextField;
    private JButton backVButton;
    private JTextField modelSearchTextField;
    private JButton suchButton;
    private JLabel constructionLabel;
    private JLabel navLabel;
    private JLabel capacityLabel;
    private JTextField brandSearchTextField;
    private JScrollPane scrollPaneVehicle;

    //Erstellen des Controllers und des ListModels
    private VehicleController vehicleModel;
    private DefaultListModel vehicleListModel = new DefaultListModel(); // benötigt für die JList


    public VehicleMain() {
        super("My Vehicle Manager");

        vehicleList.setModel(vehicleListModel);

        saveButton.setEnabled(false);
        deleteButton.setEnabled(false);

        vehicleModel = new VehicleController();

        updateVehicleList();

        scrollPaneVehicle.setViewportView(vehicleList);
        vehicleList.setLayoutOrientation(JList.VERTICAL);

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        //Button, um zurück zum Hauptmenü zu gelangen
        backVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuMain mainFormM = new menuMain();
                mainFormM.setVisible(true);
                setVisible(false);
            }
        });

        //Button um ein Fahrzeug zu löschen
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = vehicleList.getSelectedIndex();

                if (selectedIndex >= 0) {
                    vehicleModel.removeVehicle(selectedIndex);
                    updateVehicleList();
                    vehicleList.setSelectedIndex(selectedIndex - 1);
                }
            }
        });

        //Button um ein neues Fahrzeug hinzuzufügen
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carRadioButton.isSelected()){
                    Car vehicleCar = new Car(
                            brandTextField.getText(), modelTextField.getText(), Double.parseDouble(engineCapacityTextField.getText()),
                            fuelTypeTextField.getText(), Double.parseDouble(kilometreStatusTextField.getText()), Double.parseDouble(performanceTextField.getText()),
                            registrationTextField.getText(), colorTextField.getText(), Double.parseDouble(weightTextField.getText()),
                            constructionTextField.getText(), navigationTextField.getText()
                    );
                    vehicleModel.addVehicle(vehicleCar);
                    updateVehicleList();
                } else if(transporterRadioButton.isSelected()) {
                    Transporter vehicleTransporter = new Transporter(
                            brandTextField.getText(), modelTextField.getText(), Double.parseDouble(engineCapacityTextField.getText()),
                            fuelTypeTextField.getText(), Double.parseDouble(kilometreStatusTextField.getText()), Double.parseDouble(performanceTextField.getText()),
                            registrationTextField.getText(), colorTextField.getText(), Double.parseDouble(weightTextField.getText()),
                            capacityTextField.getText()
                    );
                    vehicleModel.addVehicle(vehicleTransporter);
                    updateVehicleList();
                } else {
                    Vehicle vehicle = new Vehicle(
                            brandTextField.getText(), modelTextField.getText(), Double.parseDouble(engineCapacityTextField.getText()),
                            fuelTypeTextField.getText(), Double.parseDouble(kilometreStatusTextField.getText()), Double.parseDouble(performanceTextField.getText()),
                            registrationTextField.getText(), colorTextField.getText(), Double.parseDouble(weightTextField.getText())
                    );

                    vehicleModel.addVehicle(vehicle);
                    updateVehicleList();
                }
            }
        });

        //Button um ein aktualisiertes Fahrzeug zu speichern
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = vehicleList.getSelectedIndex();

                if(selectedIndex >= 0) {
                    Vehicle vehicle = vehicleModel.getVehicle(selectedIndex);
                    vehicle.setBrand(brandTextField.getText());
                    vehicle.setModel(modelTextField.getText());
                    vehicle.setEngineCapacity(Double.parseDouble(engineCapacityTextField.getText()));
                    vehicle.setFuelType(fuelTypeTextField.getText());
                    vehicle.setCurrentKilometreStatus(Double.parseDouble(kilometreStatusTextField.getText()));
                    vehicle.setPerformance(Double.parseDouble(performanceTextField.getText()));
                    vehicle.setFirstRegistrationAsString(registrationTextField.getText());
                    vehicle.setColor(colorTextField.getText());
                    vehicle.setEmptyWeight(Double.parseDouble(weightTextField.getText()));
                    vehicle.setConstruction(constructionTextField.getText());
                    vehicle.setNavigationSystem(navigationTextField.getText());
                    vehicle.setMaximumLoadCapacity(capacityTextField.getText());

                    vehicleModel.updateVehicle(selectedIndex, vehicle);
                    updateVehicleList();
                }
            }
        });

        //Button um ein Fahrzeug zu suchen
        suchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchVehicle();
            }
        });

        //lädt bei Klick auf ein Fahrzeug die Attribute in die Textfelder
        vehicleList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e){
                int selectedIndex = vehicleList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    Vehicle vehicle = vehicleModel.getVehicle(selectedIndex);
                    brandTextField.setText(vehicle.getBrand());
                    modelTextField.setText(vehicle.getModel());
                    engineCapacityTextField.setText(Integer.toString((int) vehicle.getEngineCapacity()));
                    fuelTypeTextField.setText(vehicle.getFuelType());
                    kilometreStatusTextField.setText(Integer.toString((int) vehicle.getCurrentKilometreStatus()));
                    performanceTextField.setText(Integer.toString((int) vehicle.getPerformance()));
                    registrationTextField.setText(vehicle.getFirstRegistrationAsString());
                    colorTextField.setText(vehicle.getColor());
                    weightTextField.setText(Integer.toString((int) vehicle.getEmptyWeight()));
                    constructionTextField.setText(vehicle.getConstruction());
                    navigationTextField.setText(vehicle.getNavigationSystem());
                    capacityTextField.setText(vehicle.getMaximumLoadCapacity());
                    saveButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                }
                else {
                    saveButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                }
            }
        });

        //Definiert was passiert, wenn der Transporter Radio Button ausgewählt wird
        transporterRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ButtonGroup carTransporter;
                carTransporter = new ButtonGroup();
                carTransporter.add(carRadioButton);
                carTransporter.add(transporterRadioButton);

                if (carRadioButton.isSelected()) {
                    capacityTextField.setEnabled(false);
                    transporterRadioButton.setForeground(Color.lightGray);
                    capacityLabel.setForeground(Color.lightGray);
                }
                else {
                    navigationTextField.setEnabled(false);
                    constructionTextField.setEnabled(false);
                    carRadioButton.setForeground(Color.lightGray);
                    navLabel.setForeground(Color.lightGray);
                    constructionLabel.setForeground(Color.lightGray);
                }
            }
        });

        //Definiert was passiert, wenn der Car Radio Button ausgewählt wird
        carRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ButtonGroup carTransporter;
                carTransporter = new ButtonGroup();
                carTransporter.add(carRadioButton);
                carTransporter.add(transporterRadioButton);

                if (carRadioButton.isSelected()) {
                    capacityTextField.setEnabled(false);
                    transporterRadioButton.setForeground(Color.lightGray);
                    capacityLabel.setForeground(Color.lightGray);
                }
                else {
                    navigationTextField.setEnabled(false);
                    constructionTextField.setEnabled(false);
                    carRadioButton.setForeground(Color.lightGray);
                    navLabel.setForeground(Color.lightGray);
                    constructionLabel.setForeground(Color.lightGray);
                }
            }
        });
    }

    //Zeigt beim Öffnen des Fahrzeugmanagers die Liste der Fahrzeuge mit Marke und Modell
    private void updateVehicleList() {
        vehicleListModel.removeAllElements();

        for(Vehicle vehicle: vehicleModel.getVehicles()) {
            vehicleListModel.addElement(vehicle.getBrand() + " " + vehicle.getModel());
        }
    }

    //Methode für die Suche eines Fahrzeuges anhand der Marke und des Modells
    public void SearchVehicle(){
        String searchBrand = brandSearchTextField.getText();
        String searchModel = modelSearchTextField.getText();
        int id = 0;
        int countOfVehicles = vehicleListModel.getSize();
        while (id < countOfVehicles){
            Vehicle SearchVehicle = vehicleModel.getVehicle(id);
            String VehicleOptionBrand = SearchVehicle.getBrand();
            String VehicleOptionModel = SearchVehicle.getModel();
            if(VehicleOptionBrand.equals(searchBrand) && VehicleOptionModel.equals(searchModel)){
                vehicleList.setSelectedIndex(id);
            }
            id++;
        }
    }
}
