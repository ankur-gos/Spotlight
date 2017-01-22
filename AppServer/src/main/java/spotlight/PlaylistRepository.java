/*
 * PlaylistRepository.java
 * Ankur Goswami, agoswam3@ucsc.edu
 * Playlist repository
 */


package spotlight;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long>{}
