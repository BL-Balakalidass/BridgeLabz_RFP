import java.util.Random;
import java.util.logging.Logger;

public class GamblingSimulator {

    private static final Logger logger = Logger.getLogger(GamblingSimulator.class.getName());

    private static final int STAKE = 100;
    private static final int BET = 1;
    private static final int WIN_LIMIT = 150;
    private static final int LOSS_LIMIT = 50;
    private static final int TOTAL_DAYS = 20;

    private int totalAmount = 0;
    private int maxWin = Integer.MIN_VALUE;
    private int maxLoss = Integer.MAX_VALUE;
    private int luckiestDay = 0;
    private int unluckiestDay = 0;

    public static void main(String[] args) {
        GamblingSimulator simulator = new GamblingSimulator();
        simulator.startMonthlyGambling();
    }

    private void startMonthlyGambling() {
        int[] dailyResults = playForMonth();

        displayMonthlyReport(dailyResults);

        if (totalAmount > 0) {
            logger.info("Gambler won this month and will continue playing next month.");
        } else {
            logger.info("Gambler lost this month and will stop gambling.");
        }
    }

    private int[] playForMonth() {
        int[] dailyResults = new int[TOTAL_DAYS];

        for (int day = 1; day <= TOTAL_DAYS; day++) {
            int dayResult = playForDay();
            dailyResults[day - 1] = dayResult;

            totalAmount += dayResult;

            updateLuckiestAndUnluckiestDay(day, dayResult);
        }

        return dailyResults;
    }

    private int playForDay() {
        int currentStake = STAKE;
        Random random = new Random();

        while (currentStake > LOSS_LIMIT && currentStake < WIN_LIMIT) {

            boolean isWin = random.nextBoolean();

            if (isWin) {
                currentStake += BET;
            } else {
                currentStake -= BET;
            }
        }

        return currentStake - STAKE;
    }

    private void updateLuckiestAndUnluckiestDay(int day, int dayResult) {

        if (dayResult > maxWin) {
            maxWin = dayResult;
            luckiestDay = day;
        }

        if (dayResult < maxLoss) {
            maxLoss = dayResult;
            unluckiestDay = day;
        }
    }

    private void displayMonthlyReport(int[] dailyResults) {

        int wonDays = 0;
        int lostDays = 0;

        logger.info("----- Monthly Gambling Report -----");

        for (int day = 1; day <= TOTAL_DAYS; day++) {

            int result = dailyResults[day - 1];

            if (result > 0) {


                wonDays++;
                logger.info("Day " + day + " Won Amount: $" + result);
            } else {
                lostDays++;
                logger.info("Day " + day + " Lost Amount: $" + result);
            }
        }

        logger.info("-----------------------------------");
        logger.info("Total Amount Won/Lost: $" + totalAmount);
        logger.info("Total Winning Days: " + wonDays);
        logger.info("Total Losing Days: " + lostDays);
        logger.info("Luckiest Day: Day " + luckiestDay + " Amount Won: $" + maxWin);
        logger.info("Unluckiest Day: Day " + unluckiestDay + " Amount Lost: $" + maxLoss);
    }
}