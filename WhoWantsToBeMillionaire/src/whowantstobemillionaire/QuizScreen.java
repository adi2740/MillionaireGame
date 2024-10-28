/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whowantstobemillionaire;
import whowantstobemillionaire.QuizController;
import whowantstobemillionaire.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sai
 */
public class QuizScreen extends JFrame{
    private QuizController quizController; //object fro controller class
    private JLabel questionLabel; // declaring componenets required
    private JRadioButton[] options;
    private JButton nextButton;
    private ButtonGroup optionsGroup;
    private Question currentQuestion;

    public QuizScreen() { // no arg constructor
        setTitle("Quiz");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        quizController = new QuizController();

        JPanel mainPanel = new JPanel(); // creating panel for rendering questions and options with button
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        questionLabel = new JLabel(); // creating label
        questionLabel.setFont(new Font("Arial", Font.BOLD, 14));
        mainPanel.add(questionLabel);

        options = new JRadioButton[4];
        optionsGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) { // creating 4 buttons. avoiding repeation bylooping them
            options[i] = new JRadioButton();
            optionsGroup.add(options[i]);
            mainPanel.add(options[i]);
        }

        nextButton = new JButton("Next"); // next button to render to next question
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleNextQuestion();
            }
        });

        mainPanel.add(nextButton); 
        add(mainPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null); // Center the window
        loadNextQuestion(); // calling method to load next question
        setVisible(true);
    }

    private void loadNextQuestion() { // this mthod helps in rending the questions
        currentQuestion = quizController.getNextQuestion();
        if (currentQuestion != null) {
            questionLabel.setText("<html><body style='width: 400px;'>" + currentQuestion.getQuestionText() + "</body></html>");
            options[0].setText(currentQuestion.getOption1());
            options[1].setText(currentQuestion.getOption2());
            options[2].setText(currentQuestion.getOption3());
            options[3].setText(currentQuestion.getOption4());
            optionsGroup.clearSelection(); // Clear any previously selected option
        } else {
            JOptionPane.showMessageDialog(this, "Thank you for playing! Your score: " + quizController.getScore() + "/10");   // once quiz is done, display the score
            dispose(); // Close the quiz window
        }
    }
   private void handleNextQuestion() {
        int selectedOption = -1;
        for (int i = 0; i < options.length; i++) {
            if (options[i].isSelected()) {
                selectedOption = i+1;
                break; // can exit loop when found the selected option
            }
        }

        if (selectedOption == -1) { // making sure the quetsion is answered before moving to next quetsion
            JOptionPane.showMessageDialog(this, "Please select an option before proceeding.");
            return;
        }

        quizController.checkAnswer(selectedOption, currentQuestion); // validate the choosen answer
        loadNextQuestion(); // navigate to next quetsion
    }

}
