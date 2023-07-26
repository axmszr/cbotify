package cbotify.struct;

import java.util.ArrayList;
import java.util.List;

import cbotify.song.Album;
import cbotify.song.Artist;
import cbotify.song.Song;

public class Storage {
    private final ArtistList artistList;
    private final AlbumList albumList;
    private final SongList songList;

    Storage(AlbumList albumList, ArtistList artistList, SongList songList) {
        this.artistList = artistList;
        this.albumList = albumList;
        this.songList = songList;
    }

    public Storage makeNew() {
        AlbumList emptyAlbumList = AlbumList.makeNew();
        ArtistList emptyArtistList = ArtistList.makeNew();
        SongList emptySongList = SongList.makeNew();

        return new Storage(emptyAlbumList, emptyArtistList, emptySongList);
    }

    public Storage load(AlbumList newAlbumList, ArtistList newArtistList, SongList newSongList) {
        return new Storage(newAlbumList, newArtistList, newSongList);
    }

    public Artist addArtist(String name) {
        return this.artistList.makeArtist(name);
    }

    public Album addAlbum(String albumTitle, List<String> artistNames) {
        List<Artist> artists = new ArrayList<>();
        artistNames.stream()
                .map(this::addArtist)
                .forEachOrdered(artists::add);

        return this.albumList.makeAlbum(albumTitle, artists);
    }

    public Song addSong(String songTitle, String albumTitle, List<String> albumArtists, List<String> artistNames) {
        Album album = addAlbum(albumTitle, albumArtists);

        List<Artist> artists = new ArrayList<>();
        artistNames.stream()
                .map(this::addArtist)
                .forEachOrdered(artists::add);

        return this.songList.makeSong(songTitle, album, artists);
    }
}