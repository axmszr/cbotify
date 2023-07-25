package cbotify.struct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import cbotify.song.Artist;

class ArtistList {
    private static HashMap<Artist, List<Artist>> emptyMap = new HashMap<>();

    private HashMap<Artist, List<Artist>> artists;

    ArtistList(Map<Artist, List<Artist>> artists) {
        this.artists = new HashMap<>(artists);
    }

    public static ArtistList makeNew() {
        return new ArtistList(emptyMap);
    }

    public static ArtistList makeNewWith(List<Artist> artistList) {
        Map<Artist, List<Artist>> artistMap = artistList.stream()
                .collect(Collectors.toMap(Function.identity(), List::of));

        return new ArtistList(artistMap);
    }

    public static ArtistList makeCopy(ArtistList artistList) {
        return new ArtistList(artistList.artists);
    }
    
    public boolean hasArtist(Artist artist) {
        return this.artists.containsKey(artist);
    }
    
    public Artist makeArtist(String name) {
        Artist artist = new Artist(name);
        if (!hasArtist(artist)) {
            this.artists.put(artist, List.of(artist));
        }

        // it is ensured that the first index is the Artist
        return this.artists.get(artist).get(0);
    }

    public void makeAssoc(Artist first, Artist second) {
        if (!hasArtist(first)) {
            this.artists.put(first, List.of(first));
        }

        if (!hasArtist(second)) {
            this.artists.put(second, List.of(second));
        }

        this.artists.get(first).add(second);
        this.artists.get(second).add(first);
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
