/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whowantstobemillionaire;

/**
 *
 * @author sai
 */
public class QuizController {
    //adding this controller class which controls the flow between the POJO, service, DAO classes
private QuizService quizService; // object for service class to use its methods

    public QuizController() { // no arg aonctructor
        this.quizService = new QuizService();
    }

    public Question getNextQuestion() { // calls a method from service class to retrieve questions
        return quizService.getNextQuestion();
    }

    public boolean checkAnswer(int userAnswer, Question question) { //calls a method from service class to validate the answer
        return quizService.validateUserAnswer(userAnswer, question); 
    }

    public int getScore() {//calls a method from service class to get the calculated score
        return quizService.getScore();
    }
}
