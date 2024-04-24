import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

interface Displayable {
    String display();
}


class Student implements Displayable {
    String name;
    String className;
    int age;

    public Student(String name, String className, int age) {
        this.name = name;
        this.className = className;
        this.age = age;
    }

    @Override
    public String display() {
        return "Name: " + name + ", Class: " + className + ", Age: " + age;
    }
}

// Student Register class
class StudentRegister {
    List<Student> students;

    public StudentRegister() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, String className, int age) {
        Student student = new Student(name, className, age);
        this.students.add(student);
    }

    public List<String> displayStudents() {
        List<String> studentList = new ArrayList<>();
        for (Student student : this.students) {
            studentList.add(student.display());
        }
        return studentList;
    }

    public void writeToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Student student : this.students) {
            writer.write(student.name + "," + student.className + "," + student.age + "\n");
        }
        writer.close();
    }
}

// GUI class
class RegisterGUI extends JFrame {
    private final StudentRegister studentRegister;

    private final JTextField nameField;
    private final JTextField classField;
    private final JTextField ageField;
    private final JTextArea textArea;

    public RegisterGUI() {
        super("Student Registration System");
        this.studentRegister = new StudentRegister();

        JLabel nameLabel = new JLabel("Enter student name:");
        JLabel classLabel = new JLabel("Enter student class:");
        JLabel ageLabel = new JLabel("Enter student age:");

        nameField = new JTextField(20);
        classField = new JTextField(20);
        ageField = new JTextField(20);

        JButton addButton = new JButton("Add Student");
        JButton displayButton = new JButton("Display Students");
        JButton saveButton = new JButton("Save to File");

        textArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);

        setLayout(new FlowLayout());

        add(nameLabel);
        add(nameField);
        add(classLabel);
        add(classField);
        add(ageLabel);
        add(ageField);
        add(addButton);
        add(displayButton);
        add(saveButton);
        add(scrollPane);

        // Add Student button action listener
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String className = classField.getText();
                String ageText = ageField.getText();
                if (!name.isEmpty() && !className.isEmpty() && !ageText.isEmpty()) {
                    try {
                        int age = Integer.parseInt(ageText);
                        studentRegister.addStudent(name, className, age);
                        JOptionPane.showMessageDialog(RegisterGUI.this, name + " added successfully!");
                        nameField.setText("");
                        classField.setText("");
                        ageField.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(RegisterGUI.this, "Please enter a valid age!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Display Students button action listener
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<String> students = studentRegister.displayStudents();
                if (!students.isEmpty()) {
                    textArea.setText(String.join("\n", students));
                } else {
                    textArea.setText("No students added yet!");
                }
            }
        });

        // Save to File button action listener
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filename = "student_list.txt";
                try {
                    studentRegister.writeToFile(filename);
                    JOptionPane.showMessageDialog(RegisterGUI.this, "Student list saved to " + filename + " successfully!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(RegisterGUI.this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
    }
}

public class StudentRegistrationSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RegisterGUI();
            }
        });
    }
}