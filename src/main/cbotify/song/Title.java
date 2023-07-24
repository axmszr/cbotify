package cbotify.song;

class Title extends Attribute {
    private final String title;
    
    Title(String title) {
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
