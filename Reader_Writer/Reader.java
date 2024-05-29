package Reader_Writer;

public class Reader extends Thread {
    private ReaderWriter rw;

    public Reader(ReaderWriter rw) {
        this.rw = rw;
    }

    public void run() {
        try {
            rw.startRead();
            System.out.println(Thread.currentThread().getName() + " is reading.");
            Thread.sleep((int)(Math.random() * 200));
            rw.endRead();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
