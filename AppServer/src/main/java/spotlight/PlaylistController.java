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

@RestController
public class PlaylistController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/playlist")
    public Playlist playlist() {
        return new Playlist(counter.incrementAndGet(),
                            String.format(template, name));
    }
}