package GUI_Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuMain extends JFrame {

    //Attribute der Java Swing Form
    private JPanel mainPanel;
    private JButton clientManagerButton;
    private JButton vehicleManagerButton;

    public menuMain() {
        super("Main Menu");

        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        ClientMain mainFormC = new ClientMain();
        VehicleMain mainFormV = new VehicleMain();

        //öffnet den Client Manager
        clientManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFormC.setVisible(true);
                mainFormV.setVisible(false);
                setVisible(false);
            }
        });

        //öffnet den Vehicle Manager
        vehicleManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFormV.setVisible(true);
                mainFormC.setVisible(false);
                setVisible(false);
            }
        });
    }

    //Main-Methode zur Ausführung des Programms
    public static void main(String[] args) {
        menuMain mainFormM = new menuMain();
        mainFormM.setVisible(true);
    }
}
