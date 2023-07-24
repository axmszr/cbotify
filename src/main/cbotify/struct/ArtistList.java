package cbotify.struct;

import cbotify.song.Artist;

class ArtistList {
    private HashSet<Artist> artists;
    
    ArtistList() {
        this.artists = new HashSet<>();
    }
    
    public boolean hasArtist(Artist artist) {
        return this.artists.contains(artist);
    }
    
    public Artist makeArtist(String name) {
        Artist artist = new Artist(name);
        if (!hasArtist(artist)) {
            this.artists.add(artist);
        }
        
        return artist;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof ArtistList)) {
            return false;
        }
        
        ArtistList other = (ArtistList) obj;
        return this.artists.equals(other.artists);
    }
}
