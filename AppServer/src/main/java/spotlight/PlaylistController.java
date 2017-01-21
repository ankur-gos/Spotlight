/*
 * PlaylistController.java
 * Ankur Goswami, agoswam3@ucsc.edu
 * Playlist resource controller
 */

package spotlight;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PlaylistController {

    private final AtomicLong counter = new AtomicLong();
    private final AtomicLong songCounter = new AtomicLong();

    @RequestMapping("/playlist")
    public Playlist playlist() {
        // Ask database for playlist object
        // CODE GOES HERE

        // If playlist does not exist, fetch from spotify
        // CODE GOES HERE

        Song song = new Song(songCounter.incrementAndGet(), "Wolf", "Sylvan Esso", 5);
        List<Song> songList = new ArrayList<>();
        songList.add(song);
        return new Playlist(counter.incrementAndGet(), song, songList);
    }

    @RequestMapping("/vote", method = RequestMethod.POST)
    public Playlist vote() {
        // Update and return playlist
        // CODE GOES HERE
    }
}