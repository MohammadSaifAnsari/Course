import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class User {
    private String username;
    private String password;
    private String userId;
    private long createdAt;
    private List<String> enrolledCourseIds;
    private static final List<User> USERS = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.userId = UUID.randomUUID().toString();
        this.createdAt = System.currentTimeMillis();
        this.enrolledCourseIds = new ArrayList<>();
        USERS.add(this);
        System.out.println("\nSignUp successful.\n\n");
    }

    public void browseCourses() {
        System.out.println("Available courses:-");
        for (Course course : Course.getCourses()) {
            System.out.println("Course Title: " + course.getTitle() + ", Course ID: " + course.getCourseId());
        }
        System.out.println("Browsing courses completed.");
    }

    public void enrollCourse(String courseId) {
        if (enrolledCourseIds.contains(courseId)) {
            System.out.println("Course already enrolled.");
            return;
        }

        for (Course course : Course.getCourses()) {
            if (course.getCourseId().equals(courseId)) {
                enrolledCourseIds.add(courseId);
                System.out.println("\nCourse enrolled successfully.\n\n");
                return;
            }
        }

        System.out.println("\nCourse not found.\n\n");
    }

    public void unenrollCourse(String courseId) {
        if (enrolledCourseIds.contains(courseId)) {
            enrolledCourseIds.remove(courseId);
            System.out.println("\nCourse unenrolled successfully.\n\n");
        } else {
            System.out.println("\nCourse not enrolled.\n\n");
        }
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
        for (User user : USERS) {
            if (user.getUsername().equals(newUsername)) {
                System.out.println("User with same username already exists.");
                return;
            }
        }
        this.username = newUsername;
        System.out.println("Username changed successfully.");
    }

    public void viewEnrolledCourses() {
        System.out.println("Enrolled courses:-");
        for (String courseId : enrolledCourseIds) {
            for (Course course : Course.getCourses()) {
                if (course.getCourseId().equals(courseId)) {
                    System.out.println("Title: " + course.getTitle() + ", ID: " + course.getCourseId());
                }
            }
        }

        if (enrolledCourseIds.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            System.out.println("Viewing enrolled courses completed.");
        }
    }

    // Getter methods for the private fields

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getEnrolledCourseIds() {
        return enrolledCourseIds;
    }

    public static List<User> getUsers() {
        return USERS;
    }

    public static void main(String[] args) {
        // Example usage
        User user = new User("example_user", "example_password");
        user.browseCourses();
    }
}
