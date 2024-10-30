PLEASE CHECK THE src > assets FILE FOR THE DB COMMANDS USED. 




This project is a Java-based implementation of the popular quiz game "Who Wants to Be a Millionaire." The game is developed using a combination of Java Swing for the graphical user interface (GUI) and JDBC for database management. It follows Object-Oriented Programming (OOP) principles, ensuring a clean and modular design.


Main Features:
User Registration and Login: Users can register by providing details such as name, age, user ID, and password. They can then log in using their credentials.
Quiz Gameplay: The game consists of 10 questions, each with four options. The user must answer each question correctly to win $100,000 per correct answer.
Graphical Interface: The game has a GUI built with Java Swing, making it intuitive and user-friendly.
Database Integration: User details and quiz questions are stored in a database (Java DB/Derby), and the application interacts with the database using JDBC.
Class Breakdown:
LoginScreen: Handles user authentication by capturing User ID and password and checking them against stored records.
MainMenuScreen: Displays the main menu, allowing users to navigate to registration or login.
RegistrationScreen: Allows new users to register by providing their details. Includes input validation and age restrictions.
RulesScreen: Presents the rules of the quiz game to the user before starting the quiz.
QuizScreen: Manages the display of questions, user options, and tracks user answers during the quiz.
QuizController: Acts as the intermediary between the quiz screens and the service class, managing the flow of questions and answers.
QuizService: Contains the core logic of the quiz game, including loading questions, validating user answers, and calculating scores and winnings.
QuestionDAO: Manages database interactions for retrieving and storing quiz questions.
Question: A Plain Old Java Object (POJO) representing a question with its text, options, and correct answer.
UserDAO: Manages database interactions for user registration and authentication.
Key Functionalities:
User Management: Allows users to register and log in, ensuring their details are stored securely in the database.
Quiz Management: Loads questions from the database and dynamically presents them to the user in the GUI.
Scoring and Winnings: Calculates and displays the total winnings based on the number of correct answers.
Validation and Error Handling: Includes validation for user inputs such as age and password matching, and handles database connection errors gracefully.
OOP Principles Applied:
Encapsulation: Each class hides its internal state and only exposes necessary methods for interaction.
Abstraction: Complex logic, like database interactions and question validations, is abstracted into DAO and service classes.
Modularity: The project is divided into logical units like LoginScreen, QuizService, and QuestionDAO to separate concerns and reduce complexity.
Inheritance and Polymorphism: Although not extensively used, these principles can be applied to extend or override classes if additional features or modifications are needed in the future.
Technologies and Tools Used:
Java: For developing the entire application.
Java Swing: For creating the graphical user interface.
JDBC (Java Database Connectivity): For connecting and interacting with the Java DB (Derby) database.
NetBeans: Used as the integrated development environment (IDE) for coding, testing, and debugging.
Conclusion:
The "Who Wants to Be a Millionaire" quiz game project is an excellent demonstration of OOP principles in Java. It effectively combines database management, user interaction, and GUI design to create an engaging application. The modular and extensible design makes it easy to maintain and upgrade in the future
