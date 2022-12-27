public class SecondsPrinter implements Runnable {

    private SessionTime sessionTime;

    public SecondsPrinter(SessionTime sessionTime) {
        this.sessionTime = sessionTime;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sessionTime) {
                try {
                    sessionTime.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Passed " + sessionTime.getSeconds() + " seconds");
            }
        }
    }
}
