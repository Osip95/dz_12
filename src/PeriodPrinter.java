public class PeriodPrinter implements Runnable {
    private SessionTime sessionTime;
    private final long period;

    public PeriodPrinter(SessionTime sessionTime, long period) {
        this.sessionTime = sessionTime;
        this.period = period;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sessionTime) {
                try {
                    sessionTime.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (sessionTime.getSeconds() % period == 0) {
                    System.out.println("Message every " + period + " seconds ");
                }
            }
        }
    }
}
