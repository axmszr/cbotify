package cbotify.struct;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cbotify.song.Artist;

class ArtistList {
    private static HashSet<Artist> emptySet = new HashSet<>();

    private HashSet<Artist> artists;

    ArtistList(Set<Artist> artists) {
        this.artists = new HashSet<>(artists);
    }

    public static ArtistList makeNew() {
        return new ArtistList(emptySet);
    }

    public static ArtistList makeWith(List<Artist> artistList) {
        HashSet<Artist> artistSet = new HashSet<>(artistList);
        return new ArtistList(artistSet);
    }

    public static ArtistList makeCopy(ArtistList artistList) {
        return new ArtistList(artistList.artists);
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
