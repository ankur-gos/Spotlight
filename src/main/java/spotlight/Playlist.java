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
    private List<Song> songlist = new ArrayList<>();

    Playlist(){}
    
    public Playlist(Long id, Song currentSong, List<Song> songlist){
        this.id = id;
        this.currentSong = currentSong;
        this.songlist = songlist;
    }

    public Playlist(Song currentSong, List<Song> songlist){
        this.currentSong = currentSong;
        this.songlist = songlist;
    }

    public long getId(){
        return id;
    }

    public Song getCurrentSong(){
        return currentSong;
    }

    public void setCurrentSong(Song song){
        this.currentSong = song;
    }

    public List<Song> getPlaylist(){
        return songlist;
    }

    public void setPlaylist(List<Song> playlist){
        this.songlist = playlist;
    }
}
