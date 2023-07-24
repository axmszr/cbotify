package cbotify.song;

abstract class Attribute implements Comparable<Attribute> {
    abstract String getValue();
    
    boolean contains(String substring) {
        return getValue().contains(substring);
    }
    
    @Override
    public int compareTo(Attribute other) {
        return getValue().toLowerCase().compareTo(other.getValue().toLowerCase());
    }
}
