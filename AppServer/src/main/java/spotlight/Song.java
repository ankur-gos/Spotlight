/*Song.java
for spotlight project
1/21/17
ucsc hackathon
*/

package spotlight;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Song {
	//fields
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String artist;

	@Column(nullable = false)
	private int voteCount;

	@ManyToOne
	@JoinColumn(referencedColumnName="id")
	private Playlist playlist;
	
	//set
	Song(int id, String name, String artist, int voteCount)
	{
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.voteCount = voteCount;
		
	}
	//getters
	 public int getId()
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
	 public int getVoteCnt()
	 {
		 return voteCount;
	 }

}
