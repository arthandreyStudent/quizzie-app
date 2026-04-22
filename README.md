# Quizzie - A Java-Based Quiz Application System

## 1. Purpose

`Quizzie` is a Java-based quiz application system where teachers can create quizzes, manage questions, and students can answer them and view their results. The application supports multiple question types, including multiple-choice, true/false, and identification questions.

This project is in its early stages of development, and the current implementation focuses on the core functionalities of quiz creation, question management, and result tracking. Future enhancements may include additional question types, course management features, advanced analytics and features such as timed quizzes, question randomization, leaderboard system, and integration with learning management systems (LMS). The application is designed to be user-friendly and scalable, allowing for easy expansion of features and functionalities as needed.

## 2. User Roles

### Teacher
- Can create and manage quizzes.
- Can add, edit, and delete questions. Questions can be of three types: multiple-choice, true/false, and identification.
- Can view quiz results and analytics.
- And many more features to be added in the future.

### Student
- Can view available quizzes.
- Can take quizzes.
- Can submit answers.
- Can view their quiz results and performance analytics / history.
- And also many more features to be added in the future.

## 3. Main Features/Flow

### Student Flow
1. Student logs in to the application.
2. Student views the list of available quizzes.
3. Student selects a quiz to take.
4. Student answers the questions in the quiz. The quiz can include multiple-choice, true/false, and identification questions.
5. Student submits the quiz.
6. Student views their quiz results and performance analytics/history.

### Teacher Flow
1. Teacher logs in to the application.
2. Teacher creates a new quiz by providing a title and description.
3. Teacher adds questions to the quiz. Each question can be of type multiple-choice, true/false, or identification.
4. Teacher can edit or delete existing questions in the quiz.
5. Teacher can view the students' attempt details, quiz results, and analytics for the quizzes they have created.

## 4. Data Needed (Database Schema)

The database schema for `Quizzie` includes the following tables:

### - users
- user_id
- first_name
- last_name
- username
- password
- user_type (1 or 2, where 1 = Teacher, 2 = Student)

### - quizzes
- quiz_id
- title
- description
- created_by (foreign key referencing Users.user_id)
- allow_retakes (boolean indicating if students can retake the quiz)
- max_attempts (integer indicating the maximum number of attempts allowed for retakes, if allow_retakes is true)

### - questions
- question_id
- quiz_id (foreign key referencing Quizzes.quiz_id)
- question_text
- question_type (1 for multiple-choice, 2 for true/false, 3 for identification)
- correct_answer_text (for true/false and identification questions, this field will store the correct answer; for multiple-choice questions, this field can be null or store the correct choice_id)

### - choices (for multiple-choice questions)
- choice_id
- question_id (foreign key referencing Questions.question_id)
- choice_text
- is_correct (boolean indicating if the choice is the correct answer)

### - quiz_attempts
- attempt_id
- quiz_id (foreign key referencing Quizzes.quiz_id)
- user_id (foreign key referencing Users.user_id)
- score
- total_items
- attempt_date

### - answers
- answer_id
- attempt_id (foreign key referencing Quiz Attempts.attempt_id)
- question_id (foreign key referencing Questions.question_id)
- answer_text
- is_correct (boolean indicating if the answer is correct)

## 5. Relationships

- A `User` can be a `Teacher` or a `Student`.
- A `Teacher` can create multiple `Quizzes`.
- A `Quiz` can have multiple `Questions`.
- A `Student` can attempt multiple `Quizzes`, and each attempt is recorded in the `Quiz Attempts` table.
- Each `Quiz Attempt` can have multiple `Answers`, which are linked to the corresponding `Questions`.
- The `correct_answer` field in the `Questions` table is used to determine if a student's answer is correct when they submit their quiz attempt.

## 6. Screens (JavaFX)

- `Login Screen`: Allows users to log in as either a teacher or a student.
- `Registration Screen`: Allows new users to register for an account. 
- `Role Selection Screen` (in Registration): User selects whether they want to register as a teacher or a student, in which they will be directed to the appropriate registration form.
- `Student Dashboard`: Displays available quizzes and allows students to take quizzes and view their results.
- `Teacher Dashboard`: Allows teachers to create and manage quizzes, add/edit/delete questions, and view quiz results and analytics.
- `Quiz Taking Screen (Student's Side)`: Displays the quiz questions for students to answer and submit.
- `Quiz Creation Screen (Teacher's Side)`: Allows teachers to create a new quiz and add questions to it.
- `Quiz Management Screen (Teacher's Side)`: Allows teachers to edit or delete existing quizzes and questions.
- `Quiz Results Screen`: Displays the results of a quiz attempt for students and analytics for teachers.

## 7. Logic Rules (Business Logic)

- Only teachers can create and manage quizzes and questions.
- Students can only view and take quizzes, and view their own results.
- When a student submits a quiz attempt, the system calculates the score based on the correct answers and stores the attempt details in the database.
- Teachers can view the results of all students who have attempted their quizzes, while students can only view their own results.
- The application should validate user input to ensure that all required fields are filled out and that the data is in the correct format (e.g., valid usernames, passwords, quiz titles, etc.).
- The application should handle edge cases, such as attempting to take a quiz that has no questions or trying to create a quiz without a title.
- A student cannot take the same quiz multiple times unless the teacher allows it. If a student attempts to take a quiz they have already attempted, they will receive a message indicating that they have already taken the quiz and cannot retake it unless permitted by the teacher.
- Teachers can choose to allow or disallow retakes for each quiz. If retakes are allowed, students can take the quiz multiple times, with a maximum attempts of 3, and only the highest score will be recorded in the database.
- Teachers can only edit or delete quizzes and questions that they have created, and cannot modify quizzes created by other teachers.
- Teachers can edit quizzes and questions at any time, but changes will not affect students who have already attempted the quiz. Students will only see the updated quiz when they attempt it after the changes have been made.

## 8. Tech Stack

- `Java (OOP)`: The primary programming language used for developing the application.
- `JavaFX (UI)`: Used for creating the graphical user interface of the application.
- `JDBC (Database Connectivity)`: Used for connecting the Java application to the MySQL database and performing database operations.
- `MySQL (Database)`: Used for storing user information, quizzes, questions, quiz attempts, and answers.
- `Serialization (Session Management)`: Used for managing user sessions and maintaining state across different screens in the application.

## 9. Architecture

The application follows a layered architecture, separating concerns into different layers:

- `Controller Layer (JavaFX UI)`: Handles user interactions and updates the view accordingly. It communicates with the service layer to perform business logic operations.
- `Service Layer (Business Logic)`: Contains the core business logic of the application, such as quiz creation, question management, and result calculation. It interacts with the data access layer to perform database operations.
- `Data Access Layer (DAO)`: Responsible for interacting with the database using JDBC. It contains methods for CRUD operations on users, quizzes, questions, quiz attempts, and answers.
- `Model Layer`: Contains the data models representing the entities in the application, such as User, Quiz, Question, QuizAttempt, and Answer. These models are used to transfer data between the different layers of the application.
- `Utility Layer`: Contains utility classes for common functionalities such as database connection management, input validation, and session management.