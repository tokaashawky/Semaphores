package Producer_Consumer;

public class Producer extends Thread {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.produce(i);
                Thread.sleep((int)(Math.random() * 200)); // Simulate production time
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
