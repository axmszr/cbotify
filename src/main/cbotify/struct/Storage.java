package cbotify.struct;

public class Storage {
    private final AlbumList albumList;
    private final ArtistList artistList;
    private final SongList songList;

    Storage(AlbumList albumList, ArtistList artistList, SongList songList) {
        this.albumList = albumList;
        this.artistList = artistList;
        this.songList = songList;
    }

    public Storage makeNew() {
        AlbumList emptyAlbumList = AlbumList.makeNew();
        ArtistList emptyArtistList = ArtistList.makeNew();
        SongList emptySongList = SongList.makeNew();

        return new Storage(emptyAlbumList, emptyArtistList, emptySongList);
    }

    public Storage makeNewWith(AlbumList newAlbumList, ArtistList newArtistList, SongList newSongList) {
        return new Storage(newAlbumList, newArtistList, newSongList);
    }

    // public void addArtist
    // public void addAlbum
    // public void addSong
}