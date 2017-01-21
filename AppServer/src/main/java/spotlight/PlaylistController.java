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

@RestController
public class PlaylistController {

    private final AtomicLong counter = new AtomicLong();
    private final AtomicLong songCounter = new AtomicLong();

    @RequestMapping("/playlist")
    public Playlist playlist() {
        Song song = new Song(songCounter.incrementAndGet(), "Wolf", "Sylvan Esso", 5);
        ArrayList<Song> songList = new ArrayList<>();
        songList.add(song);
        return new Playlist(counter.incrementAndGet(), song, songList);
    }
}