public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
        int max = 0;
        for (int i = 0; i < days.length; i++) {
            if (max < days[i]) {
                max = days[i];
            }
        }
        return max;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int bestSeriesNumber = 0;
        for (int i = 0; i < days.length; i++) {
            if (goalByStepsPerDay < days[i]) {
                currentSeries = currentSeries + 1;
                if (bestSeriesNumber < currentSeries) {
                    bestSeriesNumber = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return bestSeriesNumber;
    }
}
