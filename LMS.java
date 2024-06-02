import java.util.ArrayList;
import java.util.List;

// Main class for the LMS
public class LMS {
    public static void main(String[] args) {
        // Create some sample users
        Student student1 = new Student("John Doe", "john.doe@flinders.edu.au", "password123");
        AcademicStaff staff1 = new AcademicStaff("Dr. Smith", "smith@flinders.edu.au", "securepass");

        // Authenticate users
        if (authenticate(student1, "john.doe@flinders.edu.au", "password123")) {
            System.out.println("Student authenticated successfully.");
        } else {
            System.out.println("Student authentication failed.");
        }

        if (authenticate(staff1, "smith@flinders.edu.au", "securepass")) {
            System.out.println("Academic staff authenticated successfully.");
        } else {
            System.out.println("Academic staff authentication failed.");
        }

        // Access course material
        student1.accessCourseMaterial();
        staff1.accessCourseMaterial();

        // Create academic calendar
        AcademicCalendar calendar = new AcademicCalendar();
        calendar.addEvent(new Event("Assignment 1 Due", "2024-06-15"));
        calendar.addEvent(new Event("Midterm Exam", "2024-07-10"));
        calendar.addEvent(new Event("Assignment 2 Due", "2024-08-01"));
        calendar.addEvent(new Event("Final Exam", "2024-09-25"));

        // Display academic calendar
        calendar.displaySchedule();

        // Student uploads an assignment
        student1.uploadAssignment("Assignment 1", "Assignment1_Submission.pdf");

        // Student takes an online exam
        student1.takeExam("Midterm Exam");

        // Academic staff grades an assignment
        staff1.gradeAssignment(student1, "Assignment 1", 85);

        // Student checks their grades
        student1.checkGrades();

        // Academic staff uploads content
        staff1.uploadContent("Lecture 1", "Lecture1_Slides.pdf");

        // Discussion forum interaction
        DiscussionForum forum = new DiscussionForum();
        forum.postMessage(staff1, "Welcome to the course! Feel free to ask any questions.");
        forum.postMessage(student1, "Thank you, Dr. Smith! I have a question about the first lecture.");

        // Display forum messages
        forum.displayMessages();
    }

    // Method to authenticate users
    public static boolean authenticate(User user, String email, String password) {
        return user.getEmail().equals(email) && user.getPassword().equals(password);
    }
}

// Abstract class for a User
abstract class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public abstract void accessCourseMaterial();
}

// Class for a Student
class Student extends User {
    private List<Assignment> assignments;
    private List<Exam> exams;
    private List<Grade> grades;

    public Student(String name, String email, String password) {
        super(name, email, password);
        this.assignments = new ArrayList<>();
        this.exams = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    @Override
    public void accessCourseMaterial() {
        System.out.println("Accessing course materials for students...");
        // Code to access course materials for students
    }

    public void uploadAssignment(String title, String fileName) {
        Assignment assignment = new Assignment(title, fileName);
        assignments.add(assignment);
        System.out.println("Uploaded " + fileName + " for " + title);
    }

    public void takeExam(String title) {
        Exam exam = new Exam(title);
        exams.add(exam);
        System.out.println("Taking " + title + " exam...");
        // Code to take the exam
    }

    public void checkGrades() {
        System.out.println("Checking grades...");
        for (Grade grade : grades) {
            System.out.println(grade.getTitle() + ": " + grade.getScore());
        }
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }
}

// Class for Academic Staff
class AcademicStaff extends User {
    private List<Content> contents;

    public AcademicStaff(String name, String email, String password) {
        super(name, email, password);
        this.contents = new ArrayList<>();
    }

    @Override
    public void accessCourseMaterial() {
        System.out.println("Accessing course materials for academic staff...");
        // Code to access course materials for academic staff
    }

    public void uploadContent(String title, String fileName) {
        Content content = new Content(title, fileName);
        contents.add(content);
        System.out.println("Uploaded " + fileName + " as " + title);
    }

    public void gradeAssignment(Student student, String title, int score) {
        Grade grade = new Grade(title, score);
        student.addGrade(grade);
        System.out.println("Graded " + title + " with score " + score);
    }
}

// Class to represent an Assignment
class Assignment {
    private String title;
    private String fileName;

    public Assignment(String title, String fileName) {
        this.title = title;
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public String getFileName() {
        return fileName;
    }
}

// Class to represent an Exam
class Exam {
    private String title;

    public Exam(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// Class to represent a Grade
class Grade {
    private String title;
    private int score;

    public Grade(String title, int score) {
        this.title = title;
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public int getScore() {
        return score;
    }
}

// Class to represent Content uploaded by Academic Staff
class Content {
    private String title;
    private String fileName;

    public Content(String title, String fileName) {
        this.title = title;
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public String getFileName() {
        return fileName;
    }
}

// Class to represent an Event in the academic calendar
class Event {
    private String title;
    private String date; // Simplified as a String for this example

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }
}

// Class to represent the Academic Calendar
class AcademicCalendar {
    private List<Event> events;

    public AcademicCalendar() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void displaySchedule() {
        System.out.println("Academic Calendar:");
        for (Event event : events) {
            System.out.println(event.getDate() + " - " + event.getTitle());
        }
    }
}

// Class to represent a Message in the discussion forum
class Message {
    private User user;
    private String content;

    public Message(User user, String content) {
        this.user = user;
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }
}

// Class to represent the Discussion Forum
class DiscussionForum {
    private List<Message> messages;

    public DiscussionForum() {
        this.messages = new ArrayList<>();
    }

    public void postMessage(User user, String content) {
        Message message = new Message(user, content);
        messages.add(message);
        System.out.println(user.getName() + " posted: " + content);
    }

    public void displayMessages() {
        System.out.println("Discussion Forum Messages:");
        for (Message message : messages) {
            System.out.println(message.getUser().getName() + ": " + message.getContent());
        }
    }
}
