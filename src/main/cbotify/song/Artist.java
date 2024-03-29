package cbotify.song;

import java.util.Objects;

public class Artist extends Attribute {
    private static final String dummyName = "DUMMY";

    private final String name;
    
    public Artist(String name) {
        this.name = name;
    }

    public static Artist makeDummy() {
        return new Artist(dummyName);
    }

    @Override
    String getValue() {
        return this.name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof Artist)) {
            return false;
        }
        
        Artist other = (Artist) obj;
        return getValue().equals(other.getValue());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
