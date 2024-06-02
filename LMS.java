import java.util.ArrayList;
import java.util.List;

// Main class for the LMS
public class LMS {
    public static void main(String[] args) {
        // Create some sample users
        User student1 = new Student("John Doe", "john.doe@flinders.edu.au", "password123");
        User staff1 = new AcademicStaff("Dr. Smith", "smith@flinders.edu.au", "securepass");

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
    public Student(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public void accessCourseMaterial() {
        System.out.println("Accessing course materials for students...");
        // Code to access course materials for students
    }
}

// Class for Academic Staff
class AcademicStaff extends User {
    public AcademicStaff(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public void accessCourseMaterial() {
        System.out.println("Accessing course materials for academic staff...");
        // Code to access course materials for academic staff
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
