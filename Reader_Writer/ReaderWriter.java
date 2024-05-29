package Reader_Writer;
import java.util.concurrent.Semaphore;

class ReaderWriter {
    private int readersCount;
    private Semaphore mutex;
    private Semaphore readerSem;
    private Semaphore writerSem;

    public ReaderWriter() {
        readersCount = 0;
        mutex = new Semaphore(1); // Semaphore for mutual exclusion
        readerSem = new Semaphore(1); // Semaphore for reader access control
        writerSem = new Semaphore(1); // Semaphore for writer access control
    }

    public void startRead() throws InterruptedException {
        readerSem.acquire(); // Wait for reader access
        mutex.acquire(); // Enter critical section
        readersCount++;
        if (readersCount == 1) {
            writerSem.acquire(); // Prevent writers from entering
        }
        mutex.release(); // Exit critical section
        readerSem.release(); // Allow other readers to access
    }

    public void endRead() throws InterruptedException {
        mutex.acquire(); // Enter critical section
        readersCount--;
        if (readersCount == 0) {
            writerSem.release(); // Allow writers to enter
        }
        mutex.release(); // Exit critical section
    }

    public void startWrite() throws InterruptedException {
        writerSem.acquire(); // Wait for writer access
    }

    public void endWrite() {
        writerSem.release(); // Release writer access
    }
}

    

