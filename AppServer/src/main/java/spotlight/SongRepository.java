/*
 * SongRepository.java
 * Ankur Goswami, agoswam3@ucsc.edu
 * Song repository
 */


package spotlight;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository

public interface SongRepository extends JpaRepository<Song, Long>{}