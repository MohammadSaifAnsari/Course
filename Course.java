import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Course {
    private String title;
    private String description;
    private String instructorId;
    private String courseId;
    private long createdAt;
    private List<String> moduleIds;

    public Course(String title, String description, String instructorId) {
        this.title = title;
        this.description = description;
        this.instructorId = instructorId;
        this.courseId = UUID.randomUUID().toString();
        this.createdAt = System.currentTimeMillis();
        this.moduleIds = new ArrayList<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Module findModule(String moduleId) {
        for (String id : moduleIds) {
            if (id.equals(moduleId)) {
                for (Module module : Module.getModules()) {
                    if (module.getModuleId().equals(moduleId)) {
                        return module;
                    }
                }
                break;
            }
        }
        return null;
    }

    public void addModule() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter module title: ");
        String title = scanner.nextLine();
        Module module = new Module(title, this.courseId);
        this.moduleIds.add(module.getModuleId());
        System.out.println("Module added successfully.");
    }

    public void removeModule(String moduleId) {
        if (moduleIds.remove(moduleId)) {
            System.out.println("Module removed successfully.");
        } else {
            System.out.println("Module not found in this course.");
        }
    }

    // Getter methods for the private fields

    public List<String> getModuleIds() {
        return moduleIds;
    }

    public String getCourseId() {
        return courseId;
    }

    public static void main(String[] args) {
        // Example usage
        Course course = new Course("Example Course", "Description", "Instructor1");
        course.addModule();
    }
}
