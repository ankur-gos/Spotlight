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

	@ManyToOne
	private Playlist playlist;
	
	Song(){}

	//set
	Song(Long id, String name, String artist, Integer voteCount)
	{
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.voteCount = voteCount;
		
	}
	//getters
	 public Long getId()
	 {
		 return id;
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
		 this.voteCount = this.voteCount + 1;
	 }

}
