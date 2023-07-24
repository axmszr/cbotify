package cbotify.struct;

import cbotify.song.Album;

class AlbumList {
    private HashMap<Album, Album> albums;
    
    AlbumList() {
        this.albums = new HashMap<>();
    }
    
    public boolean hasAlbum(Album album) {
        return this.albums.containsKey(album);
    }
    
    public Album makeAlbum(String albumTitle, List<Artist> artists) {
        Album album = new Album(albumTitle, artists);
        if (!hasAlbum(album)) {
            albums.set(album, album);
        }
        
        return albums.get(album);
    }
    
    public void mergeAlbums(Album root, Album branch) {
        if (!hasAlbum(root)) {
            albums.set(root, root);
        }
        
        albums.set(branch, root);
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
