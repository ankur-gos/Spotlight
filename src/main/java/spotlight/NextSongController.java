/*
 * NextSongController.java
 * Ankur Goswami, agoswam3@ucsc.edu
 * Next song controller
 */

package spotlight;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@RestController
@RequestMapping("/nextSong")
public class NextSongController {

    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;

    @Autowired
    NextSongController(PlaylistRepository playlistRepository, SongRepository songRepository){
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public Song nextSong() {
        // Ask database for playlist object
        Playlist playlist = this.playlistRepository.findOne(new Long(1));
        if(playlist != null){
            Integer max = 0;
            Song currentSong = new Song(new Long(1), "Wolf", "Sylvan Esso", 0, "spotify:track:4j4OfqOvPCnOoePywhtrc6");
            int index = 0;
            for (ListIterator<Song> iter = playlist.getPlaylist().listIterator(); iter.hasNext(); ) {
                Song nextSong = iter.next();
                Integer voteCount = nextSong.getVoteCnt();
                if(voteCount >= max){
                    max = voteCount;
                    currentSong = nextSong;
                    index = iter.previousIndex();
                    System.out.println(max);
                }
            }
            List<Song> songlist = playlist.getPlaylist();
            songlist.remove(index);
            Song songCopy = new Song(currentSong.getId(), currentSong.getName(), currentSong.getArtist(), currentSong.getVoteCnt(), currentSong.getURI());
            Song newSong = songRepository.save(new Song(currentSong.getId(), currentSong.getName(), currentSong.getArtist(), 0, currentSong.getURI()));
            songlist.add(newSong);
            
            playlist.setPlaylist(songlist);
            for (ListIterator<Song> iter = playlist.getPlaylist().listIterator(); iter.hasNext(); ) {
                Song nextSong = iter.next();
                // System.out.println(nextSong.getVoteCnt());
            }
            playlistRepository.save(playlist);
            System.out.println(songCopy.getVoteCnt());
            return songCopy;
        }

        // If playlist does not exist, fetch from spotify
        // CODE GOES HERE
        return new Song(new Long(1), "Wolf", "Sylvan Esso", 3, "spotify:track:4j4OfqOvPCnOoePywhtrc6");
    }
}
