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
	@GeneratedValue
	private Long id;

	private String name;
	
	private String artist;

	private Integer voteCount;

	private String uri;

	@ManyToOne
	private Playlist playlist;
	
	Song(){}

	//set
	Song(Long id, String name, String artist, Integer voteCount, String uri)
	{
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.voteCount = voteCount;
		this.uri = uri;
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

	 public void iterateVote(){
		 if(this.voteCount != null)
		 	this.voteCount = this.voteCount + 1;
         else
		 	this.voteCount = 1;
	 }

}
