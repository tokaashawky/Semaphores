package Test_And_Set;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Process extends Thread {
    //ReentrantLock(): thread that already holds a lock can acquire the lock again without blocking itself.
    static Lock resourceLock = new ReentrantLock();
    //static boolean resourcesOpen = true;

    public void run() {
        try {
            // make all processes work in the same time 
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " Trying to enter the critical section ");
            boolean acquired = false;
            
            while (!acquired) {
                
            /*tryLock() : Acquires the lock only if it is free at the time of invocation.
            Acquires the lock if it is available and returns immediately with the value true.
            If the lock is not available then this method will return immediately with the value false.*/

                if (resourceLock.tryLock()) {
                    acquired = true;
                    System.out.println(Thread.currentThread().getName() + " Entered the critical section ");
                    // the process time to work 
                    System.out.println(Thread.currentThread().getName() + " is performing operation on shared resources... ");
                    Thread.sleep(2000);
                    //After finishing the process will release the lock 
                    System.out.println(Thread.currentThread().getName() + " Exited the critical section");
                    resourceLock.unlock();
                } else {

                    System.out.println(Thread.currentThread().getName() + " couldn't Entere the critical section. Busy waiting.");
                    // busy waiting
                    Thread.sleep(1000); 
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

