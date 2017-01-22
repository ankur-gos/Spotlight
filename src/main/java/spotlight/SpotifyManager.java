/*
 * SpotifyManager.java
 * Ankur Goswami, agoswam3@ucsc.edu
 * Spotify Manager
 */

import java.net.*;
import java.io.*;

class SpotifyManager {

    public String getAuthHeader(String token){
        String charset = "UTF-8";
        String query = String.format("grant_type=authorization_code&code=%s&redirect_ui=https%3A%2F%2Fspotlightweb.herokuapp.com%2Fauth&client_id=f4013c48969645179f4f32a94e4b69ae&client_secret=a7df0e5c4692491b94148a15bf324f96", 
            URLEncoder.encode(token, charset));
        URLConnection connection = new URL("https://accounts.spotify.com/api/token").openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Accept-Charset", charset);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);

        try (OutputStream output = connection.getOutputStream()) {
            output.write(query.getBytes(charset));
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                               connection.getInputStream()));
        while ((inputLine = in.readLine()) != null)
            sb.append(inputLine);
        in.close();
        JSONObject authObj = new JSONObject(sb.toString());
        return "Bearer " + authObj.getString("access_token");
    }

    public JSONObject getJsonFromURL(String url, String authHeader){
        URL spotify = new URL(url);
        URLConnection sc = spotify.openConnection();
        sc.setRequestProperty("Authorization", authHeader);
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                sc.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            sb.append(inputLine);

        in.close();
        return new JSONObject(sb.toString());
   }
    public void getData(String playlist, String token){
        String authHeader = getAuthHeader(token);
        JSONObject playlistObj = getJsonFromURL("https://api.spotify.com/v1/me/playlists", authHeader);
        JSONArray playlists = playlistObj.getJSONArray("items");
        for(int i = 0; i < playlists.length(); i++){
            JSONObject playlist = playlists.getJSONObject(i);
            String name = playlist.getString("name");
            if (name.equals(playlist)){

            }
        }
    }
}
