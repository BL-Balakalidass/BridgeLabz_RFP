import java.util.Random;
import java.util.logging.Logger;

public class GamblingService {

    private static final Logger logger =
            Logger.getLogger(GamblingService.class.getName());

    private static final int STAKE = 100;
    private static final int BET_AMOUNT = 1;
    private static final int WIN_LIMIT = 150;
    private static final int LOSS_LIMIT = 50;
    private static final int TOTAL_DAYS = 20;

    public int playForDay() {

        int balance = STAKE;

        Random random = new Random();

        while (balance > LOSS_LIMIT && balance < WIN_LIMIT) {

            boolean isWon = random.nextBoolean();

            if (isWon) {
                balance += BET_AMOUNT;
            } else {
                balance -= BET_AMOUNT;
            }
        }

        return balance;
    }

    public MonthlyReport generateMonthlyReport() {

        MonthlyReport report = new MonthlyReport();

        int totalAmount = 0;
        int winningDays = 0;
        int losingDays = 0;

        int maxWin = Integer.MIN_VALUE;
        int maxLoss = Integer.MAX_VALUE;

        for (int day = 1; day <= TOTAL_DAYS; day++) {

            int endBalance = playForDay();

            int profit = endBalance - STAKE;

            totalAmount += profit;

            if (profit > 0) {
                winningDays++;
            } else {
                losingDays++;
            }

            if (profit > maxWin) {
                maxWin = profit;
                report.setLuckiestDay(day);
            }

            if (profit < maxLoss) {
                maxLoss = profit;
                report.setUnluckiestDay(day);
            }
        }

        report.setWinningDays(winningDays);
        report.setLosingDays(losingDays);
        report.setTotalAmount(totalAmount);

        logger.info("Winning Days: " + winningDays);
        logger.info("Losing Days: " + losingDays);
        logger.info("Total Amount: " + totalAmount);
        logger.info("Luckiest Day: " + report.getLuckiestDay());
        logger.info("Unluckiest Day: " + report.getUnluckiestDay());

        return report;
    }

    public void continueGambling() {

        int month = 1;

        while (true) {

            MonthlyReport report = generateMonthlyReport();

            logger.info("Month: " + month);
            logger.info("Monthly Result: " + report.getTotalAmount());

            if (report.getTotalAmount() <= 0) {

                logger.info("Gambler Stopped Gambling");

                break;
            }

            month++;
        }
    }
}