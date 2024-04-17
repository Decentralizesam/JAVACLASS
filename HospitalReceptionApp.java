import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HospitalReceptionApp extends JFrame {

    private ArrayList<String> patients;

    private JTextField nameField;
    private JTextArea displayArea;

    public HospitalReceptionApp() {
        patients = new ArrayList<>();

        setTitle("Hospital Patient Management");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Patient Name:");
        nameField = new JTextField(15);
        JButton addButton = new JButton("Add Patient");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPatient();
            }
        });

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(addButton);

        displayArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void addPatient() {
        String name = nameField.getText().trim();
        if (!name.isEmpty()) {
            patients.add(name);
            updateDisplay();
            nameField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a valid patient name.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateDisplay() {
        displayArea.setText("");
        for (String patient : patients) {
            displayArea.append(patient + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HospitalReceptionApp().setVisible(true);
            }
        });
    }
}


