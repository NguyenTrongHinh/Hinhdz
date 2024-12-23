package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Media implements Playable {
    // Nguyễn Trọng Hinh - 20225842 - Thuộc tính
    private String artist;
    private ArrayList<Track> tracks;

    // Nguyễn Trọng Hinh - 20225842 - Constructor
    public CompactDisc(int id, String title, String category, float cost, String artist, ArrayList<Track> tracks) {
        super(id, title, category, cost);
        this.tracks = tracks;
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    // Nguyễn Trọng Hinh - 20225842 - Getter
    public String getArtist() {
        return artist;
    }

    // Nguyễn Trọng Hinh - 20225842 - Thuộc tính
    public void addTrack(Track song) {
        if (tracks.contains(song)) {
            System.out.println(song.getTitle() + " is already in the CD");
        } else {
            tracks.add(song);
        }
    }

    public void removeTrack(Track song) {
        if (tracks.contains(song)) {
            tracks.remove(song);
        } else {
            System.out.println(song.getTitle() + " is not in the CD");
        }
    }

    @Override
    public float getLength() {
        float sum = 0;
        for (Track song : tracks) {
            sum += song.getLength();
        }
        return sum;
    }
    @Override
    public void play() {
        System.out.println("\nTitle: " + getTitle() + '\n' + "Artist: " + getArtist() + "\n\n");
        for (Track song : tracks) {
            song.play();
        }
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder("CD: " +
                " {id = "  + getId() +
                ", artist: " + artist +
                ", title = '" + getTitle() + '\'' +
                ", category = '" + getCategory() + '\'' +
                ", length : " + getLength() + " min" +
                ", cost= " + getCost() + "$}" + '\n' + "Tracks: \n"
                + "===================" + '\n');
        for (Track track : tracks) {
            print.append(track.getTitle());
            print.append('\t');
            print.append(track.getLength());
            print.append(" min");
            print.append('\n');
        }
        return print.toString();
    }
}