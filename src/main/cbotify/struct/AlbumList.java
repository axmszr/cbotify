package cbotify.struct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import cbotify.song.Album;
import cbotify.song.Artist;

class AlbumList {
    private static HashMap<Album, Album> emptyMap = new HashMap<>();

    private HashMap<Album, Album> albums;

    AlbumList(Map<Album, Album> albums) {
        this.albums = new HashMap<>(albums);
    }

    public static AlbumList makeNew() {
        return new AlbumList(emptyMap);
    }

    public static AlbumList makeNewWith(List<Album> albumList) {
        Map<Album, Album> albumMap = albumList.stream()
                .collect(Collectors.toMap(Function.identity(), Function.identity()));

        return new AlbumList(albumMap);
    }

    public static AlbumList makeCopy(AlbumList albumList) {
        return new AlbumList(albumList.albums);
    }
    
    public boolean hasAlbum(Album album) {
        return this.albums.containsKey(album);
    }
    
    public Album makeAlbum(String albumTitle, List<Artist> artists) {
        Album album = new Album(albumTitle, artists);
        if (!hasAlbum(album)) {
            this.albums.put(album, album);
        }
        
        return this.albums.get(album);
    }
    
    public void mergeAlbums(Album root, Album branch) {
        // root = original; branch = redirect
        if (!hasAlbum(root)) {
            this.albums.put(root, root);
        }
        
        this.albums.put(branch, root);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof AlbumList)) {
            return false;
        }
        
        AlbumList other = (AlbumList) obj;
        return this.albums.equals(other.albums);
    }
}
