package cbotify.song;

public class Title extends Attribute {
    private final String title;
    
    public Title(String title) {
        this.title = title;
    }
    
    @Override
    String getValue() {
        return this.title;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof Title)) {
            return false;
        }
        
        Title other = (Title) obj;
        return getValue().equals(other.getValue());
    }
}
