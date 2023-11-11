package nvb.dev;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private final List<Song> songList;

    public Album() {
        songList = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songList.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= songList.size())) {
            playlist.add(songList.get(index));
            return true;
        }
        System.out.println("This album does not have track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        Song song = findSong(title);
        if (song != null) {
            playlist.add(song);
            return true;
        }
        System.out.println("The song " + title + " is not in this album.");
        return false;
    }

    private Song findSong(String title) {
        for (Song song : songList) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

}
