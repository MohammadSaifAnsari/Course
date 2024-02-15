import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Article {
    private String title;
    private String content;
    private int duration;
    private String moduleId;
    private boolean isOptional;
    private String articleId;
    private long createdAt;
    private static final List<Article> ARTICLES = new ArrayList<>();

    public Article(String title, String content, int duration, String moduleId, boolean isOptional) {
        this.title = title;
        this.content = content;
        this.duration = duration;
        this.moduleId = moduleId;
        this.isOptional = isOptional;
        this.articleId = UUID.randomUUID().toString();
        this.createdAt = System.currentTimeMillis();
        ARTICLES.add(this);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setOptional() {
        this.isOptional = true;
    }

    public void setCompulsory() {
        this.isOptional = false;
    }

    // Getter methods for the private fields if needed

    public static void main(String[] args) {
        // Example usage
        Article article = new Article("Example Title", "Example Content", 60, "Module1", false);
        article.setOptional();
        System.out.println("Article ID: " + article.articleId);
    }
}
