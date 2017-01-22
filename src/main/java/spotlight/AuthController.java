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
import org.json.*;

 @RestController
 @CrossOrigin()
 @RequestMapping("/auth")
 class AuthController{

     private final PlaylistRepository playlistRepository;
     private final SongRepository songRepository;

     @Autowired
     AuthController(PlaylistRepository playlistRepository, SongRepository songRepository){
         this.playlistRepository = playlistRepository;
         this.songRepository = songRepository;
     }

     @RequestMapping(method = RequestMethod.GET)
     public Playlist auth(@RequestParam("code") String code){
         SpotifyManager smanager = new SpotifyManager();
         JSONArray tracks = smanager.getData("Life is good", code);
         Playlist playlist = new Playlist();
         List<Song> songs = new ArrayList<>();
         for(int i = 0; i < tracks.length(); i++){
             JSONObject trackObj = tracks.getJSONObject(i);
             JSONObject track = trackObj.getJSONObject("track");
             System.out.println(track.toString());
             String name = track.getString("name");
             JSONArray artists = track.getJSONArray("artists");
             JSONObject artistObj = artists.getJSONObject(0);
             String artist = artistObj.getString("name");
             String uri = track.getString("uri");
             Song addSong = songRepository.save(new Song(new Long(i), name, artist, 0, uri));
             songs.add(addSong);
         }
         playlist.setPlaylist(songs);
         playlist.setCurrentSong(songs.get(0));
         playlistRepository.save(playlist);
         return playlist;
     }
 }
