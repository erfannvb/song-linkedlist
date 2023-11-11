package nvb.dev;

import java.util.*;

public class Main {

    private static final Scanner input = new Scanner(System.in);
    private static final List<Album> albumList = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Reputation", "Taylor Swift");
        album.addSong("End Game", 4.4);
        album.addSong("Ready for it?", 3.28);
        album.addSong("Gorgeous", 3.29);
        album.addSong("Delicate", 3.52);
        albumList.add(album);

        album = new Album("Take Me Home", "One Direction");
        album.addSong("Stole My Heart", 3.25);
        album.addSong("Up All Night", 3.13);
        album.addSong("I Wish", 3.35);
        album.addSong("One Thing", 3.17);
        albumList.add(album);

        LinkedList<Song> playlist = new LinkedList<>();

        albumList.get(0).addToPlaylist("End Game", playlist);
        albumList.get(0).addToPlaylist("Hello", playlist);
        albumList.get(0).addToPlaylist("Delicate", playlist);
        albumList.get(0).addToPlaylist("Gorgeous", playlist);

        albumList.get(1).addToPlaylist(1, playlist);
        albumList.get(1).addToPlaylist(3, playlist);
        albumList.get(1).addToPlaylist(10, playlist);

        play(playlist);

    }

    private static void play(LinkedList<Song> playlist) {
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> songListIterator = playlist.listIterator();

        if (playlist.isEmpty()) {
            System.out.println("No songs in the playlist.");
        } else {
            System.out.println("Now playing " + songListIterator.next().toString());
            printMenu();
        }

        while (!quit) {

            System.out.print("Choose your action : ");
            int action = input.nextInt();

            switch (action) {

                case 0:
                    System.out.println("Playlist Complete.");
                    quit = true;
                    break;

                case 1:
                    if (!forward) {
                        if (songListIterator.hasNext()) {
                            songListIterator.next();
                        }
                        forward = false;
                    }
                    if (songListIterator.hasNext()) {
                        System.out.println("Now playing " + songListIterator.next());
                    } else {
                        System.out.println("We have reached the end of the list.");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward) {
                        if (songListIterator.hasPrevious()) {
                            songListIterator.previous();
                        }
                        forward = false;
                    }
                    if (songListIterator.hasPrevious()) {
                        System.out.println("Now playing " + songListIterator.previous());
                    } else {
                        System.out.println("We are at the start of the playlist.");
                        forward = true;
                    }
                    break;

                case 3:
                    if (forward) {
                        if (songListIterator.hasPrevious()) {
                            System.out.println("Replaying " + songListIterator.previous());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the playlist.");
                        }
                    } else {
                        if (songListIterator.hasNext()) {
                            System.out.println("Replaying " + songListIterator.next());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the playlist.");
                        }
                    }
                    break;

                case 4:
                    printList(playlist);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if (!playlist.isEmpty()) {
                        songListIterator.remove();
                        if (songListIterator.hasNext()) {
                            System.out.println("Now playing " + songListIterator.next());
                        } else if (songListIterator.hasPrevious()) {
                            System.out.println("Now playing " + songListIterator.previous());
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid Action!");
                    break;

            }

        }

    }

    private static void printList(LinkedList<Song> playlist) {
        Iterator<Song> songIterator = playlist.iterator();
        System.out.println("==================");
        if (songIterator.hasNext())
            System.out.println(songIterator.next());
        System.out.println("==================");
    }

    private static void printMenu() {
        System.out.println("Available Actions");
        System.out.println("0 - to quit");
        System.out.println("1 - to play the next song");
        System.out.println("2 - to play the previous song");
        System.out.println("3 - to replay the current song");
        System.out.println("4 - list songs in the playlist");
        System.out.println("5 - print available actions");
        System.out.println("6 - remove the current song from the playlist");
    }

}
