public class Chronometer implements Runnable {

    private SessionTime sessionTime;
    private final long startTime;

    public Chronometer(SessionTime sessionTime, long startTime) {
        this.startTime = startTime;
        this.sessionTime = sessionTime;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long timeSec =  (System.currentTimeMillis() - startTime) / 1000;
            synchronized (sessionTime) {
                sessionTime.setSeconds(timeSec);
                sessionTime.notifyAll();
            }
        }
    }
}
