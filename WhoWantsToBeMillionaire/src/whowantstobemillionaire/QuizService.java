/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whowantstobemillionaire;
import java.util.List;
/**
 *
 * @author sai
 */
public class QuizService {
    // this class is the code for having all the logic behind conducting the quiz
    private QuestionDAO questionDAO; // creating DAO class object just to utilize its mthods
    private int currentQuestionIndex;// tracking current question
    private List<Question> questions; // attribute for list of questions
    private int totalWinnings;
    private int score; // attribute for storing score which is initially 0

    public QuizService() { // no arg constructor for vreating oject
        this.questionDAO = new QuestionDAO();
        this.questions = questionDAO.getAllQuestions();
        this.totalWinnings = 0;
        this.score = 0;
    }

    public Question getNextQuestion() { //method for rensing next question
       if (currentQuestionIndex < questions.size()) // check the index of curren question
        {
            return questions.get(currentQuestionIndex++);// retrived the next question my incrementing the current question index
        }
        return null;
    }

    public boolean validateUserAnswer(int optedAnswer, Question question) { //validate the user answer
        if (optedAnswer == question.getCorrectOption()) { // compare the user opted answer against the actual answer and inreate the value of score its the right answer
            score++;
            totalWinnings += 100000; //$100,000 for each correct answer
            return true;
        }
        return false; // return false if the answer is wrong
    }

    public int getScore() {
        return score; // returns the score
    }
    public int getTotalWinnings(){
        return totalWinnings;
    }
}
