/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whowantstobemillionaire;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author ashwinkasoju
 */

public class LoginScreen extends JFrame {
    private final JTextField uidField;
    private final JPasswordField passwordField;
    private final JButton loginButton;
    private final UserDAO userService = new UserDAO();

    public LoginScreen() {
        setTitle("Login to the Game");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close the app when user hits on X
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.TRUETYPE_FONT, 20));
        gbc.gridwidth = 2; // adding css like setting width, alignment
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(new JLabel("User ID:"), gbc); // positioning and add the user ID label

        uidField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(uidField, gbc); //adding a text box for user entry

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Password:"), gbc); // positioning and adding the password label

        passwordField = new JPasswordField(25);
        //
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc); //adding login button with respecyive stylings

        add(panel, BorderLayout.CENTER);


        loginButton.addActionListener((ActionEvent e) -> {
            authenticateUser();
        });

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private void authenticateUser() { //when the functionality comes into play
        String uid = uidField.getText();
        String password = new String(passwordField.getPassword());

        if (userService.authenticate(uid, password)) {
            JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE); // popping up a dialog saying successfull login in info tone
            dispose();
            new RulesScreen();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials. Try again", "Error", JOptionPane.ERROR_MESSAGE); // popping up a dialog saying invalid creds  in error tone
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginScreen());
    }
}
