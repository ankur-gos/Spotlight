//pseudo code
//propsl
package spotlight;

class SpotifyManager implements Serializable{
   
    @GET users/{user_id}/playlists/{playlist_id}
    public Playlist getPlaylist(){
        // STUB
       ArrayList<Playlist> find = new ArrayList<Playlist>;
       //no curr user
       if(user == NULL)
       {
          return null;
       }
       try{
          for(Playlist playlist : )
          {
            Long id = playlist.getId();
            Song currSong =  playlist.getCurrentSong();
            List<Song>playlistt = playlist.getPlaylist();
            find.searh(new Playlist(id, currSong, playlistt);
             
          }
                       }
           catch(Exception e){
              System.err.println("Cannot load user specified playlist");
              e.printStackTrace();
           }      
          
    }
}
