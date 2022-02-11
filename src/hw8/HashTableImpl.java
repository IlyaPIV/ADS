package hw8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private final Set<Item<K, V>>[] data;
    private int size;


    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }
    }

    public HashTableImpl(int initialCapacity) {
        data = new HashSet[initialCapacity * 2];
    }

    public HashTableImpl() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {

        int index = hashFunc(key);

        if (data[index]==null) {
            data[index] = new HashSet<>();
            size++;
        }
        data[index].add(new Item<>(key, value));

        return true;
    }

     private boolean isKeysEquals(Item<K, V> item, K key) {
        return (item.getKey() == null) ? (key == null) : item.getKey().equals(key);
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (data[index]==null) return null;

        for (Item<K,V> value:
             data[index]) {
            if (isKeysEquals(value,key)) {
                return value.value;
            }
        }

        return null;
    }

    private int indexOf(K key) {
        return hashFunc(key);
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }

        for (Item<K, V> value : data[index]) {
            if (isKeysEquals(value, key)) {
                data[index].remove(value);
                return value.getValue();
            }
        }

        return null;
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
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%s = [%s]%n", i, data[i]));
        }
        return sb.toString();
    }
}
