/*Song.java
for spotlight project
1/21/17
ucsc hackathon
*/

public class Song {
	//fields
	private long id;
	private String name;
	private String artist;
	private int voteCount;
	
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
