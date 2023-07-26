package cbotify.song;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Song {
    private static final Album dummyAlbum = Album.makeDummy();

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
        // how to ensure non-empty?
        this.tier = Tier.BLANK;
        this.comments = new ArrayList<>();
        this.tags = new ArrayList<>();
        this.isFlagged = false;
    }

    public static Song makeDummy(String songTitle, List<Artist> artists) {
        return new Song(songTitle, dummyAlbum, artists);
    }

    String printArtists() {
        int numArtists = artists.size();

        if (numArtists == 1) {
            return artists.get(0).getValue();
        } else if (numArtists == 2) {
            return String.format("%s & %s",
                    artists.get(0), artists.get(1));
        } else if (numArtists > 2) {
            String exceptLast = artists.subList(0, numArtists - 1).stream()
                    .map(Artist::getValue)
                    .collect(Collectors.joining(", "));
            return String.format("%s & %s",
                    exceptLast, artists.get(numArtists - 1));
        } else {
            return "";
            // throw exception
        }
    }
    
    public String rate(String rating) {
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
            // throw new exception?
        }

        return String.format("Rated '%s': %s",
                this.tier, this);
    }
    
    public void addComment(String commentString) {
        Comment comment = new Comment(commentString);
        this.comments.add(comment);
    }
    
    public void setComment(int index, String commentString) {
        Comment comment = new Comment(commentString);
        this.comments.set(index, comment);
    }
    
    public String delComment(int index) {
        return this.comments.remove(index).getValue();
    }

    public String printComments() {
        // ooh maybe index them?
        return this.comments.stream()
                .map(Comment::toString)
                .collect(Collectors.joining("\n"));
    }
    
    public void addTag(String tagString) {
        Tag tag = new Tag(tagString);
        this.tags.add(tag);
    }
    
    public String delTag(int index) {
        return this.tags.remove(index).toString();
    }

    public String printTags() {
        return this.tags.stream()
                .map(Tag::toString)
                .collect(Collectors.joining(" | "));
    }

    public void flag() {
        this.isFlagged = true;
    }

    public void unflag() {
        this.isFlagged = false;
    }

    public String print() {
        return String.format("%s", this);
        // TODO
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
        // note that the same song can be in different albums
        return this.title.equals(other.title)
                //&& this.album.equals(other.album)
                && this.artists.equals(other.artists);
                //&& this.tier.equals(other.tier)
                //&& this.comments.equals(other.comments)
                //&& this.tags.equals(other.tags)
                //&& this.isFlagged == other.isFlagged;
    }

    @Override
    public int hashCode() {
        String artistsConcat = this.artists.stream().sorted()
                .map(Artist::getValue)
                .collect(Collectors.joining());

        return Objects.hash(this.title, artistsConcat);
    }

    @Override
    public String toString() {
        return String.format("%s - %s",
                this.title, printArtists());
    }
}
