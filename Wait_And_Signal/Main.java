package Wait_And_Signal;

public class Main {
    public static void main(String[] args) {
        Resource resource = new Resource();

        // Start multiple processes
        for (int i = 0; i < 5; i++) {
            new Process(resource).start();
        }
    }
}