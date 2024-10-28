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
 * @author ashwinkasoju
 */
public class MainMenuScreen extends JFrame{
    private final JButton registerButton;
    private final JButton loginButton;

    public MainMenuScreen() {
        setTitle("Welcome to the Quiz Game");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cose the app when cliedk on X
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(); //setting up th epanel and its position
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel titleLabel = new JLabel("Who Wants To Be A Millionaire"); //adding a title
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_START;

        registerButton = new JButton("Register"); //adding register button and its position
        gbc.gridx = 0;
        panel.add(registerButton, gbc);

        loginButton = new JButton("Login"); //adding login button and its position
        gbc.gridx = 1;
        panel.add(loginButton, gbc);

        add(panel, BorderLayout.CENTER);

        registerButton.addActionListener((ActionEvent e) -> { //when clicked on regster, navigate the user to registration screen
            dispose();
            new RegistrationScreen();
        });

        loginButton.addActionListener((ActionEvent e) -> { //when clicked on login, navigate the user to registration screen
            dispose();
            new LoginScreen(); 
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

}
