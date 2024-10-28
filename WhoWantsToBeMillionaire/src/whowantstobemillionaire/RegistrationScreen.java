/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whowantstobemillionaire;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sai
 */
public class RegistrationScreen extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField ageField;
    private JTextField userIdField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;
    
     private UserDAO userService = new UserDAO();

    public RegistrationScreen() {
        setTitle("Register for the Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2, 10, 10));

        firstNameField = new JTextField(); // initializing the components by declaring all diff type of required compoenents
        lastNameField = new JTextField();
        ageField = new JTextField();
        userIdField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        registerButton = new JButton("Register");
        
        // adding all the components to  the frame
        add(new JLabel("First Name:")); // label
        add(firstNameField); //text field
        add(new JLabel("Last Name:"));
        add(lastNameField);
        add(new JLabel("Age:"));
        add(ageField);
        add(new JLabel("User Id:"));
        add(userIdField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(new JLabel("Confirm Password:"));
        add(confirmPasswordField);
        add(new JLabel()); // cosmetic change - empty space
        add(registerButton);

        registerButton.addActionListener(new ActionListener() { //functionality of register button
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();  // call the registration method
            }
        });

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    // Method to validate inputs and register the user
    private void registerUser() {
        String firstName = firstNameField.getText().trim();  //captureing the user values
        String lastName = lastNameField.getText().trim();
        String ageText = ageField.getText().trim();
        String userId = userIdField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String confirmPassword = new String(confirmPasswordField.getPassword()).trim();

        if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || userId.isEmpty() // adding basic validations like none of the filed should be empty
                || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
            if (age <= 17) {
                JOptionPane.showMessageDialog(this, "Age should be greater than or equal to 18", "Error", JOptionPane.ERROR_MESSAGE); // popping error in error tone if age is less than 18
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age should be a number", "Error", JOptionPane.ERROR_MESSAGE);// popping error if age is not a number
            return;
        }

        if (password.length() < 3) {
            JOptionPane.showMessageDialog(this, "Passwords length should be atleast 3", "Error", JOptionPane.ERROR_MESSAGE); //popping error length of password is less than 3
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE); // passowrd and confirm password values should be same
            return;
        }

        if (userService.saveUser(firstName, lastName, age, userId, password)) { // saving user by sending in values
            JOptionPane.showMessageDialog(this, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE); // notifying user that registeration is done
            dispose(); 
            new LoginScreen(); // redirect user to login screen by closing the current screen
        }
    }
}
