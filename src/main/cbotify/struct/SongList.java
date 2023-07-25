package cbotify.struct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import cbotify.song.Album;
import cbotify.song.Artist;
import cbotify.song.Song;

class SongList {
    private static HashMap<Song, Song> emptyMap = new HashMap<>();

    private HashMap<Song, Song> songs;

    SongList(Map<Song, Song> songs) {
        this.songs = new HashMap<>(songs);
    }

    public static SongList makeNew() {
        return new SongList(emptyMap);
    }

    public static SongList makeNewWith(List<Song> songList) {
        Map<Song, Song> songMap = songList.stream()
                .collect(Collectors.toMap(Function.identity(), Function.identity()));

        return new SongList(songMap);
    }

    public static SongList makeCopy(SongList songList) {
        return new SongList(songList.songs);
    }

    public boolean hasSong(Song song) {
        return this.songs.containsKey(song);
    }
    
    public Song makeSong(String songTitle, Album album, List<Artist> artists) {
        Song song = new Song(songTitle, album, artists);
        if (!hasSong(song)) {
            this.songs.put(song, song);
        }
        
        return this.songs.get(song);
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
