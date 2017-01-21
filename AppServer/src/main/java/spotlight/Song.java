
public class Song {
	int id;
	String name;
	String artist;
	int voteCount;
	
	Song(int id1, String name1, String artist1, int voteCount1)
	{
		id = id1;
		name = name1;
		artist = artist1;
		voteCount = voteCount1;
		
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
