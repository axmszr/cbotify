package cbotify.song;

class Tag extends Attribute {
    private final String tag;
    
    Tag(String tag) {
        this.tag = tag;
    }
    
    @Override
    String getValue() {
        return this.tag;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof Tag)) {
            return false;
        }
        
        Tag other = (Tag) obj;
        return getValue().equals(other.getValue());
    }

    @Override
    public String toString() {
        return String.format("[%s]", getValue());
    }
}
