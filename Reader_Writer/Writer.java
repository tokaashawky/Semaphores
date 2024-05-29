package Reader_Writer;

public class Writer extends Thread {
    private ReaderWriter rw;

    public Writer(ReaderWriter rw) {
        this.rw = rw;
    }

    public void run() {
        try {
            rw.startWrite();
            System.out.println(Thread.currentThread().getName() + " is writing.");
            Thread.sleep((int)(Math.random() * 500));
            rw.endWrite();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
