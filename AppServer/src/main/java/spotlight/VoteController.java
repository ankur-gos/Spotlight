/*
 * VoteController.java
 * Ankur Goswami, agoswam3@ucsc.edu
 * Vote requests
 */

 package spotlight;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

 @RestController
 @RequestMapping("/vote")
 class VoteController{

     private final PlaylistRepository playlistRepository;

     @Autowired
     VoteController(PlaylistRepository playlistRepository){
         this.playlistRepository = playlistRepository;
     }

     @RequestMapping(method = RequestMethod.POST)
     public Playlist vote(@PathVariable String songId){
         Playlist playlist = this.playlistRepository.findOne(new Long(1));
         List<Song> songList = playlist.getPlaylist();
         for (ListIterator<Song> iter = songList.listIterator(); iter.hasNext(); ) {
             Song nextSong = iter.next();
             if(nextSong.getId() == Long.parseLong(songId)){
                 nextSong.iterateVote();
                 iter.set(nextSong);
                 break;
             }
         }
         playlist.setPlaylist(songList);
         return playlistRepository.save(playlist);
     }
 }
