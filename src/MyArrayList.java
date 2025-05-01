import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E> {
    private int size;

    private static final int DEFAULT_SIZE = 10;

    Object[] data;

    public MyArrayList() {
        this.data = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    public MyArrayList(int initialSize){
        this.data = new Object[Math.max(initialSize, DEFAULT_SIZE)];
        this.size = 0;
    }

    public boolean add(E e){
        if (size == data.length){
            data = Arrays.copyOf(data, (size/2)*3);
        }
        data[size] = e;
        size++;
        return true;
    }

    public void add(int index, E e){
        if(index>=0&&index<=size){
            if (size == data.length){
                data = Arrays.copyOf(data, (size/2)*3);
            }
            System.arraycopy(data, index, data, index + 1, size - index);
            data[index] = e;
            size++;
        }
    }

    public E get(int index){
        if(index>=0&&index<size){
            return (E) data[index];
        }
        return null;
    }

    public E remove(int index){
        if(index>=0&&index<=size){
            E indexValue = (E) data[index];
            int numMoved = size - index - 1;
            if (numMoved > 0)
                System.arraycopy(data, index + 1, data, index, numMoved);
            data[--size] = null;
            return indexValue;
        }
        return null;
    }

    public boolean remove(E e){
        if (e == null) {
            for (int index = 0; index < size; index++)
                if (data[index] == null) {
                    remove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (e.equals(data[index])) {
                    remove(index);
                    return true;
                }
        }
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        Object[] newData = c.toArray();
        int newDataSize = newData.length;
        if (newDataSize == 0){
            return false;
        }
        if (size + newDataSize > data.length) {
            int maybeNewLength = (size*3)/2;
            int newSize = Math.max(maybeNewLength, size + newDataSize);
            data = Arrays.copyOf(data, newSize);
        }
        System.arraycopy(newData, 0, data, size, newDataSize);
        size += newDataSize;
        return true;
    }

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("fgfd");
        list.add("fgfd");
        list.add("fgfd");
        list.add("fgfd");
        list.add("fgfd");
        list.add("fgfd");
        list.add("fgfd");
        list.add("fgfd");
        list.add("fgfd");
        list.add("fgfd");
        list.add("fgfd");
        list.add(0, "asjdjd");
    }
}