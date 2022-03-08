public class Post {

 
    private Long id;
    
    private String title;
    
    private String description;
    
    private String content;
    
    private Set<Comment> comments = new HashSet<>();
}