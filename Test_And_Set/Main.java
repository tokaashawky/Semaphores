package Test_And_Set;

public class Main {
    public static void main(String[] args) {
        Process[] processes = new Process[5];

        // Create and start 5 processes
        for (int i = 0; i < processes.length; i++) {
            processes[i] = new Process();
            processes[i].start();
        }
        
    }
}
