import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Instructor {
    private String username;
    private String password;
    private String instructorId;
    private long createdAt;
    private List<String> createdCourseIds;
    private static final List<Instructor> INSTRUCTORS = new ArrayList<>();

    public Instructor(String username, String password) {
        this.username = username;
        this.password = password;
        this.instructorId = UUID.randomUUID().toString();
        this.createdAt = System.currentTimeMillis();
        this.createdCourseIds = new ArrayList<>();
        INSTRUCTORS.add(this);
        System.out.println("\nSignUp successful.\n\n");
    }

    public void createCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter course title: ");
        String title = scanner.nextLine();
        System.out.println("Enter course description: ");
        String description = scanner.nextLine();
        Course course = new Course(title, description, this.instructorId);
        Course.getCourses().add(course);
        this.createdCourseIds.add(course.getCourseId());
        System.out.println("Course created successfully.");
    }

    public void removeCourse(String courseId) {
        if (this.createdCourseIds.contains(courseId)) {
            this.createdCourseIds.remove(courseId);
            Course.getCourses().removeIf(course -> course.getCourseId().equals(courseId));
            System.out.println("Course removed successfully.");
        } else {
            System.out.println("Course not found in this instructor.");
        }
    }

    public void viewCreatedCourses() {
        System.out.println("Created courses:-");
        for (Course course : Course.getCourses()) {
            if (course.getInstructorId().equals(this.instructorId)) {
                System.out.println("Course: " + course.getTitle());
            }
        }
        System.out.println("Viewing created courses completed.");
    }

    public void changePassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new password: ");
        String newPassword = scanner.nextLine();
        this.password = newPassword;
        System.out.println("Password changed successfully.");
    }

    public void changeUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new username: ");
        String newUsername = scanner.nextLine();
        for (Instructor instructor : INSTRUCTORS) {
            if (instructor.username.equals(newUsername)) {
                System.out.println("Instructor with same username already exists.");
                return;
            }
        }
        this.username = newUsername;
        System.out.println("Username changed successfully.");
    }

    // Getter methods for the private fields

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public List<String> getCreatedCourseIds() {
        return createdCourseIds;
    }

    public static List<Instructor> getInstructors() {
        return INSTRUCTORS;
    }

    public static void main(String[] args) {
        // Example usage
        Instructor instructor = new Instructor("example_user", "example_password");
        instructor.createCourse();
    }
}

