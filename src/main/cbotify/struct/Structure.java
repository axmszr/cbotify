package cbotify.struct;

import java.util.ArrayList;
import java.util.List;

import cbotify.song.Album;
import cbotify.song.Artist;
import cbotify.song.Song;

public class Structure {
    private final ArtistList artistList;
    private final AlbumList albumList;
    private final SongList songList;

    Structure(AlbumList albumList, ArtistList artistList, SongList songList) {
        this.artistList = artistList;
        this.albumList = albumList;
        this.songList = songList;
    }

    public Structure makeNew() {
        AlbumList emptyAlbumList = AlbumList.makeNew();
        ArtistList emptyArtistList = ArtistList.makeNew();
        SongList emptySongList = SongList.makeNew();

        return new Structure(emptyAlbumList, emptyArtistList, emptySongList);
    }

    public Structure load(AlbumList newAlbumList, ArtistList newArtistList, SongList newSongList) {
        return new Structure(newAlbumList, newArtistList, newSongList);
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
