import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.Song;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * A class representing a song, with properties for title, artist, year, and album.
 * Implements the Comparable interface to allow for sorting by title.
 */
public class MySong implements Comparable<MySong> {
    private String title;
    private String artist;
    private int year;
    private String album;

    /**
     * Constructs a new MySong object with the given properties.
     * @param title the title of the song
     * @param artist the artist who performed the song
     * @param year the year the song was released
     * @param album the album the song appears on
     */
    public MySong(String title, String artist, int year, String album) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.album = album;
    }

    /**
     * Returns the title of the song.
     * @return the title of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the artist who performed the song.
     * @return the artist who performed the song
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Returns the year the song was released.
     * @return the year the song was released
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the album the song appears on.
     * @return the album the song appears on
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Checks if this MySong object is equal to another object.
     * Two MySong objects are considered equal if they have the same title, artist, year, and album.
     * @param o the object to compare to
     * @return true if the objects are equal, false otherwise
     */
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

    /**
     * Computes a hash code for this MySong object based on its title, artist, year, and album.
     * @return the hash code for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(title, artist, year, album);
    }

    /**
     * Compares this MySong object to another MySong object based on their titles.
     * @param other the MySong object to compare to
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(MySong other) {
        return this.title.compareTo(other.title);
    }
}
