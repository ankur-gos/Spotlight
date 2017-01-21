/*Song.java
for spotlight project
1/21/17
ucsc hackathon
*/
public class Song {
	int id;
	String name;
	String artist;
	int voteCount;
	
	Song(int id, String name, String artist, int voteCount)
	{
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.voteCount = voteCount;
		
	}
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
