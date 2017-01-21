/*
 * Playlist.java
 * Ankur Goswami, agoswam3@ucsc.edu
 * Playlist object
 */

package spotlight;

public class Playlist{
    private final long id;
    private final Song currentSong;
    private final Song[] playlist;
    
    public Playlist(long id, Song currentSong, Song[] playlist){
        this.id = id;
        this.currentSong = currentSong;
        this.playlist = playlist;
    }

    public long getId{
        return id;
    }

    public Song getCurrentSong{
        return currentSong;
    }

    public Song[] getPlaylist{
        return playlist;
    }
}
