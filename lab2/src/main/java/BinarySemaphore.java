public class BinarySemaphore {
    /**
     * This variable can have one of two values: 0 or 1 (the default). Value 0
     * means that the semaphore is taken and any thread which wants to use it
     * must wait.
     */
    private int value;

    public BinarySemaphore() {
        value = 1;
    }

    /**
     * Decrements the value of the semaphore. Blocks if it is already 1.
     */
    public synchronized void P() {
        while (value == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        value = 0;
        notifyAll();
    }

    /**
     * Increments the value of the semaphore. Blocks if it is already 0.
     */
    public synchronized void V() {
        while (value == 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        value = 1;
        notifyAll();
    }
}
