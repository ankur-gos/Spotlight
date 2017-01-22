// /*
//  * SpotifyManager.java
//  * Ankur Goswami, agoswam3@ucsc.edu
//  * Spotify Manager
//  */

// import java.net.*;
// import java.io.*;

// class SpotifyManager {

//     public JSONObject getJsonFromURL(String url){
//         URL spotify = new URL(url);
//         URLConnection sc = spotify.openConnection();
//         BufferedReader in = new BufferedReader(
//                                 new InputStreamReader(
//                                 sc.getInputStream()));
//         StringBuilder sb = new StringBuilder();
//         String inputLine;

//         while ((inputLine = in.readLine()) != null) 
//             sb.append(inputLine);

//         in.close();
//         return new JSONObject(sb.toString());
//    }
//    public void getData(String playlist){
//         JSONObject playlistObj = getJsonFromURL("https://api.spotify.com/v1/me/playlists");
//         JSONArray playlists = playlistObj.getJSONArray("items");
//         for(int i = 0; i < playlists.length(); i++){
//             JSONObject playlist = playlists.getJSONObject(i);
//             String name = playlist.getString("name");
//             if (name.equals(playlist)){

//             }
//         }
//    }
// }
