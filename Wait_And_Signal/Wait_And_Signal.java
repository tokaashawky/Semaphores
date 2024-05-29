package Wait_And_Signal;

class Resource {
    private boolean available = true;

    public synchronized void acquire() {
        while (!available) {
            try {
                wait(); // Wait until the resource is available
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        
        available = false; // Mark the resource as unavailable
        

    }

    public synchronized void release() {
        available = true; // Mark the resource as available
        notifyAll(); // Notify waiting threads that the resource is available
    }
}

class Process extends Thread {
    private Resource resource;

    public Process(Resource resource) {
        this.resource = resource;
    }

    public void run() {
        
        resource.acquire(); // Acquire the resource
        System.out.println(Thread.currentThread().getName() + " Entered the critical section");
        // the process time to work
        try {
            System.out.println(Thread.currentThread().getName() + " is performing operation on shared resources... ");

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Exited the critical section");

        resource.release(); // Release the resource
    }
}