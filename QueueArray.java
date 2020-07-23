//tzvi tornek
package queuearray;

import java.util.EmptyStackException;

public class QueueArray {

    String[] backingArray;
    int rear = 0, front = 0, numOfElements = 0;

    public QueueArray() {
        this(10);
    }

    public QueueArray(int initialCapacity) {
        backingArray = new String[initialCapacity];
    }

    public boolean enqueue(String s) {
        if (numOfElements == backingArray.length) {
            resize();
        }
        backingArray[rear] = s;
        rear++;
        if (rear == backingArray.length - 1) {
            rear = 0;
        }
        numOfElements++;
        return true;
    }

    public String dequeue() {
        checkUnderflowException();
        String s = backingArray[front];
        front++;
        if (front == backingArray.length - 1) {
            front = 0;
        }
        numOfElements--;
        return s;
    }

    public boolean isEmpty() {
        return numOfElements == 0;
    }

    public void checkUnderflowException() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }

    private void resize() {
        String[] temp = new String[backingArray.length * 2 + 1];
        System.arraycopy(backingArray, front, temp, 0, backingArray.length - front);
        System.arraycopy(backingArray, 0, temp, backingArray.length - front, front);
        backingArray = temp;
        rear = numOfElements;
        front = 0;
    }
}

