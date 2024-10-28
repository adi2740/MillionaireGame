/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package whowantstobemillionaire;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ashwinkasoju
 */
public class QuestionDAO {
     //this class handles all by question related DB connections 
    
    //need connection string, Id, password to connect to our DB
  private static final String CONNECTION_URL = "jdbc:derby://localhost:1527/millionaire;create=true";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        String query = "select * from questions"; // sql querty to retrieve questions frm question table

        try (Connection connection = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD);
             Statement stmt = connection.createStatement(); //hitting DB
             ResultSet questionData = stmt.executeQuery(query)) { // capturing the result set of the query and parsing it

            while (questionData.next()) {
                int id = questionData.getInt("id");
                String questionText = questionData.getString("question_text");
                String option1 = questionData.getString("option1");
                String option2 = questionData.getString("option2");
                String option3 = questionData.getString("option3");
                String option4 = questionData.getString("option4");
                int correctOption = questionData.getInt("correct_option");

                questions.add(new Question(id, questionText, option1, option2, option3, option4, correctOption)); // calling questions constructor to create the question pbject by passing in the values captured from result set
            }

        } catch (SQLException e) {
            e.printStackTrace(); // using catch just in case it throws an error
        }

        return questions; // returning the list of questions
    }
}