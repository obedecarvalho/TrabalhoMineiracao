package music4U;

public class Music {
	public static Integer n = 0; 
	public String title;
	public String artist;
	public String letter;
	public Integer index;
	
	public Music(String title, String artist, String letter) {
		this.title = title;
		this.artist = artist;
		this.letter = letter;
		index = n;
		n++;
	}
	
	@Override
	public String toString() {
		return "Title:"+ title + ", Artist:" + artist + ", Letter:" + letter;
	}

}
