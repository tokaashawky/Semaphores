package Producer_Consumer;

public class Consumer extends Thread {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.consume();
                Thread.sleep((int)(Math.random() * 500)); // Simulate consumption time
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
