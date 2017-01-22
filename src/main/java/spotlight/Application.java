package spotlight;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
	CommandLineRunner init(PlaylistRepository playlistRepository, SongRepository songRepository) {
		return (evt) -> Arrays.asList(
				"myplaylist")
				.forEach(
						a -> {
                            Song song = songRepository.save(new Song("Wolf", "Sylvan Esso", 0, "spotify:track:4j4OfqOvPCnOoePywhtrc6"));
                            List<Song> songList = new ArrayList<>();
                            songList.add(song);
                            playlistRepository.save(new Playlist(new Long(1), song, songList));
						});
	}
}