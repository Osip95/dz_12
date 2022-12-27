public class Main {
    static long startTime = System.currentTimeMillis();

    public static void main(String[] args) {

        SessionTime sessionTime = new SessionTime();

        Chronometer chronometer = new Chronometer(sessionTime,startTime);
        new Thread(chronometer).start();

        SecondsPrinter secondsPrinter = new SecondsPrinter(sessionTime);
        new Thread(secondsPrinter).start();

        PeriodPrinter periodFivePrinter = new PeriodPrinter(sessionTime, 5);
        new Thread(periodFivePrinter).start();

        PeriodPrinter periodSevenPrinter = new PeriodPrinter(sessionTime, 7);
        new Thread(periodSevenPrinter).start();

    }
}



