/*
 * SpotifyManager.java
 * Ankur Goswami, agoswam3@ucsc.edu
 * Spotify Manager
 */

package spotlight;

import java.net.*;
import java.io.*;
import org.json.*;

class SpotifyManager {

    SpotifyManager(){}

    public String getAuthHeader(String token){
        try{
        String charset = "UTF-8";
        String url = "https://spotlightweb.herokuapp.com/auth";
        String query = String.format("grant_type=authorization_code&code=%s&redirect_uri=%s&client_id=f4013c48969645179f4f32a94e4b69ae&client_secret=a7df0e5c4692491b94148a15bf324f96", 
            URLEncoder.encode(token, charset),
            URLEncoder.encode(url, charset));
        URLConnection connection = new URL("https://accounts.spotify.com/api/token").openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Accept-Charset", charset);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);

        try (OutputStream output = connection.getOutputStream()) {
            output.write(query.getBytes(charset));
        }
        // String urlParameters  = "grant_type=authorization_code&code=" + token + "&redirect_ui=c";
        // byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
        // int    postDataLength = postData.length;
        // String request        = "http://example.com/index.php";
        // URL    url            = new URL( request );
        // HttpURLConnection conn= (HttpURLConnection) url.openConnection();           
        // conn.setDoOutput( true );
        // conn.setInstanceFollowRedirects( false );
        // conn.setRequestMethod( "POST" );
        // conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
        // conn.setRequestProperty( "charset", "utf-8");
        // conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
        // conn.setUseCaches( false );
        // try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
        // wr.write( postData );
        // }
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                               connection.getInputStream()));
        String inputLine;
        StringBuilder sb = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            sb.append(inputLine);
        in.close();
        JSONObject authObj = new JSONObject(sb.toString());
        return "Bearer " + authObj.getString("access_token");}catch(Exception e){System.out.println(e);}
        return "";
    }

    public JSONObject getJsonFromURL(String url, String authHeader){
        try{
        URL spotify = new URL(url);
        URLConnection sc = spotify.openConnection();
        sc.setRequestProperty("Authorization", authHeader);
        System.out.println("Auth header: ");
        System.out.println(authHeader);
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                sc.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            sb.append(inputLine);

        in.close();
        return new JSONObject(sb.toString());}catch(Exception e){}
        return null;
   }
    public JSONArray getData(String playlist, String token){
        String authHeader = getAuthHeader(token);
        JSONObject playlistObj = getJsonFromURL("https://api.spotify.com/v1/me/playlists", authHeader);
        JSONArray playlists = playlistObj.getJSONArray("items");
        for(int i = 0; i < playlists.length(); i++){
            JSONObject list = playlists.getJSONObject(i);
            String name = list.getString("name");
            if (name.equals(playlist)){
                JSONObject tracksObj = new JSONObject(list.getString("tracks"));
                JSONObject tracks = getJsonFromURL(tracksObj.getString("href"), authHeader);
                return tracks.getJSONArray("items");
            }
        }
        return null;
    }
}
