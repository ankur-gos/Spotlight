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

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String artist;

	@Column(nullable = false)
	private Integer voteCount;

	@ManyToOne
	@JoinColumn(name = "playlist", referencedColumnName="id")
	private Playlist playlist;
	
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

}
