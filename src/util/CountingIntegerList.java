package util;

import java.util.AbstractList;

public class CountingIntegerList extends AbstractList<Integer> {
    private int size;
    public CountingIntegerList(int size) {
        this.size = Math.max(size, 0);
    }
    @Override
    public Integer get(int index) {
        return index;
    }
    @Override
    public int size() { return size; }

    public static void main(String[] args) {
        System.out.println(new CountingIntegerList(30));
    }
}
