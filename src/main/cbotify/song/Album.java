package cbotify.song;

class Album extends Attribute {
    private final String title;
    private final List<Artist> artists;     // doesn't include features
    
    Album(String title, List<Artist> artists) {
        this.title = title;
        this.artists = artists;
    }
    
    @Override
    String getValue() {
        return this.title;
    }
    
    @Override
    boolean contains(String substring) {
        if (!super.contains(substring)) {
            return false;
        }
        
        return this.artists.stream()
                .anyMatch(a -> a.contains(substring));
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof Album)) {
            return false;
        }
        
        Album other = (Album) obj;
        return getValue().equals(other.getValue())
                && this.artists.equals(other.artists);
    }
    
    @Override
    public int hashCode() {
        String artistsConcat = this.artists.stream().sorted()
                .map(a -> a.getValue())
                .collect(Collectors.joining());
                
        return Objects.hash(this.title, artistsConcat);
    }
}
