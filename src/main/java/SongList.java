import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import Bridges.base.SLelement;

public class SongList implements List<MySong> {
    private SLelement<MySong> head;
    private int size;
    private String name;

    public SongList(String name) {
        this.name = name;
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

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

    @Override
    public Iterator<MySong> iterator() {
        return new Iterator<MySong>();
    }

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

    @Override
    public boolean add(MySong song) {
        SLelement<MySong> newElem = new SLelement<>(song, head);
        head = newElem;
        size++;
        return true;
    }
}