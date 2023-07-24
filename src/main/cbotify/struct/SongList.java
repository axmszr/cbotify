package cbotify.struct;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cbotify.song.Album;
import cbotify.song.Artist;
import cbotify.song.Song;
import cbotify.song.Title;

class SongList {
    private static HashSet<Song> emptySet = new HashSet<>();

    private HashSet<Song> songs;

    SongList(Set<Song> songs) {
        this.songs = new HashSet<>(songs);
    }

    public static SongList makeNew() {
        return new SongList(emptySet);
    }

    public static SongList makeWith(List<Song> songList) {
        HashSet<Song> songSet = new HashSet<>(songList);
        return new SongList(songSet);
    }

    public static SongList makeCopy(SongList songList) {
        return new SongList(songList.songs);
    }

    public boolean hasSong(Song song) {
        return this.songs.contains(song);
    }
    
    public Song makeSong(String songTitle, Album album, List<Artist> artists) {
        // maybe do String processing here?
        Title title = new Title(songTitle);
        Song song = new Song(title, album, artists);
        if (!hasSong(song)) {
            this.songs.add(song);
        }
        
        return song;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof SongList)) {
            return false;
        }
        
        SongList other = (SongList) obj;
        return this.songs.equals(other.songs);
    }
}
