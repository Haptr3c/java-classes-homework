import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.Song;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MySong implements Comparable<MySong> {
    private String title;
    private String artist;
    private int year;
    private String album;

    public MySong(String title, String artist, int year, String album) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public String getAlbum() {
        return album;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MySong mySong = (MySong) o;
        return year == mySong.year &&
                Objects.equals(title, mySong.title) &&
                Objects.equals(artist, mySong.artist) &&
                Objects.equals(album, mySong.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, year, album);
    }

    @Override
    public int compareTo(MySong other) {
        return this.title.compareTo(other.title);
    }
}
