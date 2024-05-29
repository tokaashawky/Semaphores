package Producer_Consumer;
import java.util.concurrent.Semaphore;
public class Buffer {
    private static final int BUFFER_SIZE = 5;
    private int[] data;
    private int in, out;
    private Semaphore mutex, empty, full;

    public Buffer() {
        data = new int[BUFFER_SIZE];
        in = 0;
        out = 0;
        mutex = new Semaphore(1); // Semaphore for mutual exclusion
        empty = new Semaphore(BUFFER_SIZE); // Semaphore for empty slots in buffer
        full = new Semaphore(0); // Semaphore for filled slots in buffer
    }

    public void produce(int item) throws InterruptedException {
        empty.acquire(); // Wait for an empty slot
        mutex.acquire(); // Enter critical section
        data[in] = item;
        in = (in + 1) % BUFFER_SIZE;
        System.out.println("Produced: " + item);
        mutex.release(); // Exit critical section
        full.release(); // Signal that a slot has been filled
    }

    public int consume() throws InterruptedException {
        full.acquire(); // Wait for a filled slot
        mutex.acquire(); // Enter critical section
        int item = data[out];
        out = (out + 1) % BUFFER_SIZE;
        System.out.println("Consumed: " + item);
        mutex.release(); // Exit critical section
        empty.release(); // Signal that a slot has been emptied
        return item;
    }
    
}
