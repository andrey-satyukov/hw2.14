package com.example.demo;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {
    private final String[] data;
    private int size;

    public StringListImpl() {
        this.data = new String[10];
    }

    public StringListImpl(int initSize) {
        this.data = new String[initSize];
    }

    @Override
    public String add(String item) {
        checkSize();
        checkItem(item);
        data[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkSize();
        checkItem(item);
        checkIndex(index);

        if (index == size) {
            data[size++] = item;
            return item;
        }

        System.arraycopy(data, index, data, index + 1, size - index);
        size++;
        data[index] = item;

        return item;
    }

    @Override
    public String set(int index, String item) {
        checkIndex(index);
        checkItem(item);
        data[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        checkItem(item);

        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public String remove(int index) {
        checkIndex(index);

        String item = data[index];

        if (index == size) {
            data[size--] = null;
            return item;
        }
        System.arraycopy(data, index + 1, data, index, size - index );

        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1
                ;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            String s = data[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            String s = data[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);

        return data[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (size != otherList.size()) {
            return false
            ;
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(this.get(i), otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(data, size);
    }

    private void checkItem(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item не может быть null");
        }
    }

    private void checkSize() {
        if (size == data.length) {
            throw new IllegalArgumentException("Массив полный");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
    }
}
