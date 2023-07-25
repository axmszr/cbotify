package cbotify.song;

import java.util.ArrayList;
import java.util.List;

public class Song {
    private final Title title;
    private final Album album;
    private final List<Artist> artists;

    private Tier tier;
    private List<Comment> comments;
    private List<Tag> tags;
    private boolean isFlagged;
    
    
    public Song(String songTitle, Album album, List<Artist> artists) {
        this.title = new Title(songTitle);
        this.album = album;
        this.artists = artists;
        this.tier = Tier.BLANK;
        this.comments = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.isFlagged = false;
    }
    
    boolean isSameAs(Song other) {
        // note that the same song can be in different albums
        return this.title.equals(other.title)
                && this.artists.equals(other.artists);
    }
    
    void rate(String rating) {
        boolean matchFound = false;
        
        for (Tier t : Tier.values()) {
            if (t.matches(rating)) {
                this.tier = t;
                matchFound = true;
                break;
            }
        }
        
        if (!matchFound) {
            this.tier = this.tier;
            // throw new 
        }
    }
    
    void flag() {
        this.isFlagged = true;
    }
    
    void unflag() {
        this.isFlagged = false;
    }
    
    void addComment(Comment comment) {
        this.comments.add(comment);
    }
    
    void setComment(int index, Comment comment) {
        this.comments.set(index, comment);
    }
    
    void delComment(int index) {
        this.comments.remove(index);
    }
    
    void addTag(Tag tag) {
        this.tags.add(tag);
    }
    
    void delTag(int index) {
        this.tags.remove(index);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        
        if (!(obj instanceof Song)) {
            return false;
        }
        
        Song other = (Song) obj;
        return this.title.equals(other.title)
                && this.album.equals(other.album)
                && this.artists.equals(other.artists)
                && this.tier.equals(other.tier)
                && this.comments.equals(other.comments)
                && this.tags.equals(other.tags)
                && this.isFlagged == other.isFlagged;
    }
}
