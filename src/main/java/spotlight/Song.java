/*Song.java
for spotlight project
1/21/17
ucsc hackathon
*/

package spotlight;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Song implements Serializable{
	//fields
	@Id
	private Long id;

	private String name;
	
	private String artist;

	private Integer voteCount;

	private String uri;

	private String imageURL;

	@ManyToOne
	private Playlist playlist;
	
	Song(){}

	//set
	Song(Long id, String name, String artist, Integer voteCount, String uri, String imageURL)
	{
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.voteCount = voteCount;
		this.uri = uri;
		this.imageURL = imageURL;
	}

	Song(String name, String artist, Integer voteCound, String uri){
		this.name = name;
		this.artist = artist;
		this.voteCount = voteCount;
		this.uri = uri;
	}
	//getters
	 public Long getId()
	 {
		 if(id == null){
			 id = new Long(20);
		 }
		 return id;
	 }
	 public String getURI(){
		 return uri;
	 }
	 public void setURI(String uri){
		 this.uri = uri;
	 }
	 public String getName()
	 {
		 return name;
	 }
	 public String getArtist()
	 {
		 return artist;
	 }
	 public Integer getVoteCnt()
	 {
		 return voteCount;
	 }

	 public String getImageURL(){
		 return imageURL;
	 }

	 public void setImageURL(String imageURL){
		 this.imageURL = imageURL;
	 }

	 public void iterateVote(){
		 if(this.voteCount != null)
		 	this.voteCount = this.voteCount + 1;
         else
		 	this.voteCount = 1;
	 }

}
