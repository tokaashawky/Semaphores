package Reader_Writer;

public class Main {
    public static void main(String[] args) {
        ReaderWriter rw = new ReaderWriter();
        for (int i = 0; i < 5; i++) {
            new Reader(rw).start();
            new Writer(rw).start();
        }
    }
    
}
