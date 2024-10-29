/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whowantstobemillionaire;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author sai
 */
public class RulesScreen extends JFrame {
    
    
      private JTextField nameField;
    public RulesScreen() {
        setTitle("Quiz App"); //title of the app
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);


        // few rules for the player
        JTextArea rulesText = new JTextArea("This quiz has 10 questions.$100,000 for each\n" +
                "Answering all questions is mandatory.\n" +
                "You cant go to next question without answering the current question.\n" +
                "Results will be displayed at the end of all 10 questions.");
        rulesText.setBounds(50, 80, 400, 100);
        rulesText.setEditable(false);
        panel.add(rulesText);

        JButton startButton = new JButton("Start"); // button to get into quiz
        startButton.setBounds(200, 200, 100, 30);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {              
                  dispose(); // close the current screen
                  new QuizScreen();    // navigate user to the quiz screen
            }
        });
        panel.add(startButton);

        add(panel);
        setVisible(true);
    }
 
}
