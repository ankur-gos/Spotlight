/*
 * Playlist.java
 * Ankur Goswami, agoswam3@ucsc.edu
 * Playlist object
 */

package spotlight;

import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Playlist implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @JoinColumn(nullable = false)
    private Song currentSong;

    @OneToMany(orphanRemoval = true, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private ArrayList<Song> playlist = new ArrayList<>();
    
    public Playlist(long id, Song currentSong, ArrayList<Song> playlist){
        this.id = id;
        this.currentSong = currentSong;
        this.playlist = playlist;
    }

    public long getId(){
        return id;
    }

    public Song getCurrentSong(){
        return currentSong;
    }

    public ArrayList<Song> getPlaylist(){
        return playlist;
    }
}
