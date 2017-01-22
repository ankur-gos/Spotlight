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

@RestController
@RequestMapping("/nextSong")
public class NextSongController {

    private final PlaylistRepository playlistRepository;

    @Autowired
    NextSongController(PlaylistRepository playlistRepository){
        this.playlistRepository = playlistRepository;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public Song nextSong() {
        // Ask database for playlist object
        Playlist playlist = this.playlistRepository.findOne(new Long(1));
        if(playlist != null){
            Integer max = 0;
            Song currentSong;
            int index = 0;
            for (ListIterator<Song> iter = playlist.getSonglist().listIterator(); iter.hasNext(); ) {
                Song nextSong = iter.next();
                Integer voteCount = nextSong.getVoteCnt();
                if(voteCount >= max){
                    max = voteCount;
                    currentSong = nextSong;
                    index = iter.previousIndex();
                }
            }
            playlist.setPlaylist(playlist.getSonglist().remove(index));
            return currentSong;
        }

        // If playlist does not exist, fetch from spotify
        // CODE GOES HERE
        return new Song(new Long(1), "Wolf", "Sylvan Esso", 5, "spotify:track:4j4OfqOvPCnOoePywhtrc6");
    }
}
