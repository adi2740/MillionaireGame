/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  ashwinkasoju
 * Created: Oct 29, 2024
 */

/* DB details
Database Name: millionaire
User ID: root
Password: root
Connection URL: "jdbc:derby://localhost:1527/millionaire;create=true"
*/

-- queries to create tables:

CREATE TABLE QUESTIONS (
    ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    QUESTION_TEXT VARCHAR(255) NOT NULL,
    OPTION1 VARCHAR(100) NOT NULL,
    OPTION2 VARCHAR(100) NOT NULL,
    OPTION3 VARCHAR(100) NOT NULL,
    OPTION4 VARCHAR(100) NOT NULL,
    CORRECT_OPTION INT NOT NULL
);


CREATE TABLE USERS (
    ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    FIRST_NAME VARCHAR(50) NOT NULL,
    LAST_NAME VARCHAR(50) NOT NULL,
    AGE INT,
    USER_ID VARCHAR(100) NOT NULL UNIQUE,
    PASSWORD VARCHAR(100) NOT NULL
);

-- query to insert values into questions table
INSERT INTO QUESTIONS (QUESTION_TEXT, OPTION1, OPTION2, OPTION3, OPTION4, CORRECT_OPTION) 
VALUES ('What is the capital of France?', 'Berlin', 'Madrid', 'Paris', 'Rome', 3);

INSERT INTO QUESTIONS (QUESTION_TEXT, OPTION1, OPTION2, OPTION3, OPTION4, CORRECT_OPTION) 
VALUES ('Which planet is known as the Red Planet?', 'Earth', 'Mars', 'Jupiter', 'Venus', 2);

INSERT INTO QUESTIONS (QUESTION_TEXT, OPTION1, OPTION2, OPTION3, OPTION4, CORRECT_OPTION) 
VALUES ('Who wrote the play "Romeo and Juliet"?', 'William Shakespeare', 'Charles Dickens', 'Mark Twain', 'Jane Austen', 1);

INSERT INTO QUESTIONS (QUESTION_TEXT, OPTION1, OPTION2, OPTION3, OPTION4, CORRECT_OPTION) 
VALUES ('Which element has the chemical symbol "O"?', 'Gold', 'Oxygen', 'Silver', 'Osmium', 2);

INSERT INTO QUESTIONS (QUESTION_TEXT, OPTION1, OPTION2, OPTION3, OPTION4, CORRECT_OPTION) 
VALUES ('How many continents are there?', 'Five', 'Six', 'Seven', 'Eight', 3);

INSERT INTO QUESTIONS (QUESTION_TEXT, OPTION1, OPTION2, OPTION3, OPTION4, CORRECT_OPTION) 
VALUES ('What is the largest ocean on Earth?', 'Atlantic Ocean', 'Indian Ocean', 'Southern Ocean', 'Pacific Ocean', 4);

INSERT INTO QUESTIONS (QUESTION_TEXT, OPTION1, OPTION2, OPTION3, OPTION4, CORRECT_OPTION) 
VALUES ('Who was the first President of the United States?', 'Abraham Lincoln', 'George Washington', 'Thomas Jefferson', 'John Adams', 2);

INSERT INTO QUESTIONS (QUESTION_TEXT, OPTION1, OPTION2, OPTION3, OPTION4, CORRECT_OPTION) 
VALUES ('Which is the smallest planet in our solar system?', 'Venus', 'Mars', 'Mercury', 'Earth', 3);

INSERT INTO QUESTIONS (QUESTION_TEXT, OPTION1, OPTION2, OPTION3, OPTION4, CORRECT_OPTION) 
VALUES ('What is the square root of 64?', '6', '8', '7', '9', 2);

INSERT INTO QUESTIONS (QUESTION_TEXT, OPTION1, OPTION2, OPTION3, OPTION4, CORRECT_OPTION) 
VALUES ('Which country is known as the Land of the Rising Sun?', 'China', 'South Korea', 'Japan', 'Vietnam', 3);
