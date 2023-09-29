package com.airport.circulararrayqueue;

/** Array-based queue implementation
 * Derived From Data Structures and Algorithm Analysis
 * By Clifford A. Shaffer
 */



public class ArrayQueue<E> {


    private static final int defaultSize = 10;
    private int maxSize; // Maximum size of queue
    private int front; // Index of front element
    private int rear; // Index of rear element
    private E[] listArray; // Array holding queue elements

    /** Constructors */
    ArrayQueue() { this(defaultSize); }
    @SuppressWarnings("unchecked") // For generic array
    ArrayQueue(int size) {
        maxSize = size+1; // One extra space is allocated
        rear = 0; front = 1;
        listArray = (E[])new Object[maxSize]; // Create listArray
    }
    /** Reinitialize */
    public void clear() { rear = 0; front = 1; }
    /** Put "it" in queue */
    public void enqueue(E it) {
        if (((rear+2) % maxSize) != front){
            rear = (rear+1) % maxSize; // Circular increment
            listArray[rear] = it;
        }else {
            System.out.println ("Queue is full, cant add: " + it.toString());
        }

    }
    /** Remove and return front value */
    public E dequeue() {
        if (length() == 0){
            return (E) "Queue Empty";
        }
        E it = listArray[front];
        front = (front+1) % maxSize; // Circular increment
        return it;
    }
    /** @return Front value */
    public E frontValue() {
        if (length() == 0){
            return (E) "Queue Empty";
        }
        return listArray[front];
    }

    public E rearValue(){
        if (length() == 0){
            return (E) "Queue Empty";
        }
        return listArray[rear];
    }

    /** @return Queue size */
    public int length()
    { return ((rear+maxSize) - front + 1) % maxSize; }

    public boolean isEmpty(){
        if (length() == 0){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        if (length() == 0){
            return "Queue Empty";
        }

        String STACK_STRING = "";

        for(int n = front; n != rear; n = (n+1)%maxSize){
            if (n == front){
                STACK_STRING += listArray[n].toString() + "\n";
            }else {
                STACK_STRING += listArray[n].toString() + "\n";
            }

        }




        return STACK_STRING + listArray[rear];
    }

}
