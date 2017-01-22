/*
 * Playlist.java
 * Ankur Goswami, agoswam3@ucsc.edu
 * Playlist object
 */

package spotlight;

import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Playlist implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Song currentSong;

    @OneToMany
    private List<Song> playlist = new ArrayList<>();

    Playlist(){}
    
    public Playlist(Long id, Song currentSong, List<Song> playlist){
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

    public List<Song> getPlaylist(){
        return playlist;
    }

    public void setPlaylist(List<Song> playlist){
        this.playlist = playlist;
    }
}
