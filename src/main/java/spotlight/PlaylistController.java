/*
 * PlaylistController.java
 * Ankur Goswami, agoswam3@ucsc.edu
 * Playlist resource controller
 */

package spotlight;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/playlist")
public class PlaylistController {

    private final PlaylistRepository playlistRepository;

    @Autowired
    PlaylistController(PlaylistRepository playlistRepository){
        this.playlistRepository = playlistRepository;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public Playlist playlist() {
        // Ask database for playlist object
        Playlist playlist = this.playlistRepository.findOne(new Long(1));
        if(playlist != null){
            return playlist;
        }

        // If playlist does not exist, fetch from spotify
        // CODE GOES HERE
        return null;
    }
}