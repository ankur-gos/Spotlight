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
	CommandLineRunner init(PlaylistRepository playlistRepository) {
		return (evt) -> Arrays.asList(
				"myplaylist")
				.forEach(
						a -> {
                            // Song song = new Song(new Long(1), "Wolf", "Sylvan Esso", 5);
                            // List<Song> songList = new ArrayList<>();
                            // songList.add(song);
                            // playlistRepository.save(new Playlist(new Long(1), song, songList));
						});
	}
}