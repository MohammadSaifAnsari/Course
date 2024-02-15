import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Module {
    private String title;
    private String courseId;
    private String moduleId;
    private long createdAt;
    private List<String> articleIds;
    private static final List<Module> MODULES = new ArrayList<>();

    public Module(String title, String courseId) {
        this.title = title;
        this.courseId = courseId;
        this.moduleId = UUID.randomUUID().toString();
        this.createdAt = System.currentTimeMillis();
        this.articleIds = new ArrayList<>();
        MODULES.add(this);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Article findArticle(String articleId) {
        for (String id : articleIds) {
            if (id.equals(articleId)) {
                for (Article article : Article.getArticles()) {
                    if (article.getArticleId().equals(articleId)) {
                        return article;
                    }
                }
                break;
            }
        }
        return null;
    }

    public void addArticle() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter article title: ");
            String title = scanner.nextLine();
            System.out.println("Enter article content: ");
            String content = scanner.nextLine();
            System.out.println("Enter duration in minutes: ");
            int duration = Integer.parseInt(scanner.nextLine());
            System.out.println("Is this article optional? (T/F): ");
            boolean isOptional = scanner.nextLine().equalsIgnoreCase("T");
            Article article = new Article(title, content, duration, this.moduleId, isOptional);
            this.articleIds.add(article.getArticleId());
            System.out.println("Article added successfully.");
        } catch (Exception e) {
            System.out.println("Article not added.");
        }
    }

    public void removeArticle(String articleId) {
        if (articleIds.remove(articleId)) {
            System.out.println("Article removed successfully.");
        } else {
            System.out.println("Article not found in this module.");
        }
    }

    // Getter methods for the private fields

    public static List<Module> getModules() {
        return MODULES;
    }

    public List<String> getArticleIds() {
        return articleIds;
    }

    public String getModuleId() {
        return moduleId;
    }

    public static void main(String[] args) {
        // Example usage
        Module module = new Module("Example Module", "Course1");
        module.addArticle();
    }
}

