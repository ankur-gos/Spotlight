/*
 * PlaylistRepository.java
 * Ankur Goswami, agoswam3@ucsc.edu
 * Playlist repository
 */


package spotlight;

import org.springframework.data.domain.*;
import org.springframework.data.repository.*;

public interface PlaylistRepository extends CrudRepository<Playlist, Long>{}
