/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whowantstobemillionaire;

/**
 *
 * @author ashwinkasoju
 */
public class Question {
    //this is just a POJO class for questio 
    private final int id; // unique identifier to identify each question
    private final String questionText; // attribute for storing the question value
    private final String option1; // attibutes for 4 different options for each question
    private final String option2;
    private final String option3;
    private final String option4;
    private final int answer; // attribute for storing right answer

    public Question(int id, String questionText, String option1, String option2, String option3, String option4, int correctOption) {
        //all arg consturctor to create a question object
        this.id = id;
        this.questionText = questionText;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = correctOption;
    }
    
    //adding just getter methos as setters are not required for this app. We are directly writing the questions inside Db using insert query 
    public int getId() { return id; } // returns id
    public String getQuestionText() { return questionText; } //return question value
    public String getOption1() { return option1; } //returns option 1
    public String getOption2() { return option2; } //returns option 2
    public String getOption3() { return option3; } //returns option 3
    public String getOption4() { return option4; } //returns option 4
    public int getCorrectOption() { return answer; } //returns right answer

}

