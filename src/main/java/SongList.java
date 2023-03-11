import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import Bridges.base.SLelement;

/**
 * A class representing a list of songs. Implements the List interface to allow for manipulation of the list.
 */
public class SongList implements List<MySong> {
    private SLelement<MySong> head;
    private int size;
    private String name;

    /**
     * Constructs a new SongList object with the given name.
     * @param name the name of the playlist
     */
    public SongList(String name) {
        this.name = name;
        head = null;
        size = 0;
    }

    /**
     * Returns the number of songs in the playlist.
     * @return the number of songs in the playlist
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the playlist is empty.
     * @return true if the playlist is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the playlist contains a specific song.
     * @param o the song to check for
     * @return true if the playlist contains the song, false otherwise
     */
    @Override
    public boolean contains(Object o) {
        if (!(o instanceof MySong)) {
            return false;
        }
        MySong song = (MySong) o;
        SLelement<MySong> curr = head;
        while (curr != null) {
            if (curr.getValue().equals(song)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    /**
     * Returns an iterator over the songs in the playlist.
     * @return an iterator over the songs in the playlist
     */
    @Override
    public Iterator<MySong> iterator() {
        return new Iterator<MySong>();
    }

    /**
     * Returns an array containing all of the songs in the playlist.
     * @return an array containing all of the songs in the playlist
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        SLelement<MySong> curr = head;
        int index = 0;
        while (curr != null) {
            array[index] = curr.getValue();
            curr = curr.getNext();
            index++;
        }
        return array;
    }

    /**
     * Returns an array containing all of the songs in the playlist.
     * If the array is larger than the playlist, the extra elements are set to null.
     * @param a the array to fill with the songs
     * @return an array containing all of the songs in the playlist
     */
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) new Object[size];
        }
        SLelement<MySong> curr = head;
        int index = 0;
        while (curr != null) {
            a[index] = (T) curr.getValue();
            curr = curr.getNext();
            index++;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    /**
     * Adds a song to the playlist.
     * @param song the song to add
     * @return true if the song was added successfully, false otherwise
     */
    @Override
    public boolean add(MySong song) {
        SLelement<MySong> newElem = new SLelement<>(song, head);
        head = newElem;
        size++;
        return true;
    }
}
