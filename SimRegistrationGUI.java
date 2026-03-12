import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.net.InetAddress;

public class SimRegistrationGUI extends JFrame implements ActionListener {

    JTextField nameField, surnameField, phoneField;
    JTextArea outputArea;
    JButton registerBtn, deviceBtn;

    public SimRegistrationGUI() {

        setTitle("SIM Registration System");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Name:"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("Surname:"));
        surnameField = new JTextField(20);
        add(surnameField);

        add(new JLabel("Phone Number:"));
        phoneField = new JTextField(20);
        add(phoneField);

        registerBtn = new JButton("Register SIM");
        deviceBtn = new JButton("Show Device Info");

        add(registerBtn);
        add(deviceBtn);

        outputArea = new JTextArea(10, 35);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));

        registerBtn.addActionListener(this);
        deviceBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == registerBtn) {

            String name = nameField.getText();
            String surname = surnameField.getText();
            String phone = phoneField.getText();

            if (!phone.matches("\\d{10}")) {
                outputArea.setText("❌ Invalid phone number (must be 10 digits)");
                return;
            }

            String network = detectNetwork(phone);

            saveUser(name, surname, phone, network);

            outputArea.setText(
                    "✅ SIM Registered\n\n" +
                    "Name: " + name + " " + surname +
                    "\nPhone: " + phone +
                    "\nNetwork: " + network
            );
        }

        if (e.getSource() == deviceBtn) {

            outputArea.setText(getDeviceInfo());

        }
    }

    public String detectNetwork(String phone) {

        if (phone.startsWith("082") || phone.startsWith("083")) {
            return "Vodacom";
        }

        if (phone.startsWith("081") || phone.startsWith("078")) {
            return "MTN";
        }

        if (phone.startsWith("060") || phone.startsWith("061")) {
            return "Telkom";
        }

        if (phone.startsWith("084") || phone.startsWith("074")) {
            return "Cell C";
        }

        return "Unknown Network";
    }

    public void saveUser(String name, String surname, String phone, String network) {

        try {

            FileWriter writer = new FileWriter("users.txt", true);

            writer.write(name + " " + surname + " | " + phone + " | " + network + "\n");

            writer.close();

        } catch (Exception e) {

            outputArea.setText("Error saving user.");

        }
    }

    public String getDeviceInfo() {

        try {

            InetAddress ip = InetAddress.getLocalHost();

            return "🖥 DEVICE INFO\n\n" +
                    "Computer: " + ip.getHostName() +
                    "\nIP Address: " + ip.getHostAddress() +
                    "\nUser: " + System.getProperty("user.name") +
                    "\nOS: " + System.getProperty("os.name");

        } catch (Exception e) {

            return "Unable to retrieve device info.";

        }
    }

    public static void main(String[] args) {

        new SimRegistrationGUI();

    }
}