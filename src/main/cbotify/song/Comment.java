package cbotify.song;

public class Comment extends Attribute {
    private final String comment;
    
    Comment(String comment) {
        this.comment = comment;
    }
    
    @Override
    String getValue() {
        return this.comment;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof Comment)) {
            return false;
        }
        
        Comment other = (Comment) obj;
        return getValue().equals(other.getValue());
    }
}
