package com.airport.circulararrayqueue;


/**
 * Code from https://www.codingninjas.com/codestudio/library/implementation-of-hashmap
 * Used to just understand hashing and derive a solution without collision detection
 * Hashing method Derived from Data Structures and Algorithm Analysis Text book
 */


import java.util.LinkedList;

public class Map<K, V> {

    private class Node{  // contains two parameters - key and value
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;  // initialising the key
            this.value = value;   // initialising the value
        }
    }

    private int size;
    private LinkedList<Node>[] buckets; // N = buckets.length

    public Map() {
        initializebuckets(4);
        size = 0;
    }

    public Map(int capacity) {
        initializebuckets(capacity);
        size = 0;
    }

    private void initializebuckets(int N) {
        buckets = new LinkedList[N];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value)
    {
        int bi = hashfn(key);   // getting the value of index of bucket
        int di = getIndexWithinBucket(key,bi);   // getting the value of index
        // inside the bucket
        if(di!=-1)
        {
            // if the key is already present
            Node node = buckets[bi].get(di);  // node at index di in the bucket bi
            node.value = value; // updating the value
        }
        else
        {
            // if the key is not already present
            Node node = new Node(key,value);  // make a new node with that key-value
            buckets[bi].add(node);  // add it on index bi
            size++;  // increase the size
        }
    }




    private int getIndexWithinBucket(K key, int bi)
    {
        int di = 0;
        for(Node node : buckets[bi])
        {
            if(node.key.equals(key))
            {
                // if key==key, return the index
                return di;
            }
            di++; // otherwise, keep moving to the next index
        }

        return -1;  // if we've searched the whole linked list and the key is not
        // present, return -1.
    }

    public V get(K key) {
        int bi = hashfn(key);    // index of the bucket
        int di = getIndexWithinBucket(key,bi); //index of the position in that
        //bucket
        if(di!=-1){ // if the key is present at di, return its value. Otherwise,
            // Return null
            Node node = buckets[bi].get(di);
            return node.value;
        }
        else{
            return null;
        }
    }

    public int size() {
        return size;  // return the value of size variable
    }

    public int hashfn(K k) {
        String kString = k.toString();
        char ch[];
        ch = kString.toCharArray();
        int i, sum;
        for (sum=0, i=0; i<kString.length(); i++)
            sum += ch[i];
        return sum % buckets.length;
    }







}
