import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Courshell {
    private static User CURRENT_LOGIN_USER;
    private static Instructor CURRENT_LOGIN_INSTRUCTOR;
    private static final List<User> USERS = new ArrayList<>();
    private static final List<Instructor> INSTRUCTORS = new ArrayList<>();
    private static final List<Course> COURSES = new ArrayList<>();

    public static void signUpUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        for (User user : USERS) {
            if (user.getUsername().equals(username)) {
                System.out.println("User with same username already exists.");
                return;
            }
        }
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        User user = new User(username, password);
        USERS.add(user);
        CURRENT_LOGIN_USER = user;
    }

    public static void signUpInstructor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        for (Instructor instructor : INSTRUCTORS) {
            if (instructor.getUsername().equals(username)) {
                System.out.println("Instructor with same username already exists.");
                return;
            }
        }
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        Instructor instructor = new Instructor(username, password);
        INSTRUCTORS.add(instructor);
        CURRENT_LOGIN_INSTRUCTOR = instructor;
    }

    public static void loginUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        for (User user : USERS) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                CURRENT_LOGIN_USER = user;
                System.out.println("\nLogin successful.\n\n");
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }

    public static void loginInstructor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        for (Instructor instructor : INSTRUCTORS) {
            if (instructor.getUsername().equals(username) && instructor.getPassword().equals(password)) {
                CURRENT_LOGIN_INSTRUCTOR = instructor;
                System.out.println("\nLogin successful.\n\n");
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }

    public static void logout() {
        CURRENT_LOGIN_USER = null;
        CURRENT_LOGIN_INSTRUCTOR = null;
        System.out.println("\nLogout successful.\n\n");
    }

    public static Course findCourse(String courseId) {
        for (Course course : COURSES) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nr_dashes = (80 - "Welcome to Courshell".length()) / 2;
        System.out.println("\n" + "-".repeat(nr_dashes) + "Welcome to Courshell" + "-".repeat(nr_dashes) + "\n\n");

        while (true) {
            System.out.println("1. Sign Up as User");
            System.out.println("2. Sign Up as Instructor");
            System.out.println("3. Login as User");
            System.out.println("4. Login as Instructor");
            System.out.println("5. Exit Program");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    signUpUser();
                    break;
                case 2:
                    signUpInstructor();
                    break;
                case 3:
                    loginUser();
                    break;
                case 4:
                    loginInstructor();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice. Please try again.\n\n");
            }

            if (CURRENT_LOGIN_USER != null) {
                while (true) {
                    System.out.println("User Menu:");
                    // Handle user actions
                }
            }

            if (CURRENT_LOGIN_INSTRUCTOR != null) {
                while (true) {
                    System.out.println("Instructor Menu:");
                    // Handle instructor actions
                }
            }
        }
    }
}

