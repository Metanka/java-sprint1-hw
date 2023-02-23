public class Converter {
    int LENGTH_OF_STEP = 75;
    int CENTIMETERS_PER_KILOMETER = 100000;
    int CALORIES_PER_STEP = 50;
    int CALORIES_PER_KILOCALORIES = 1000;

    int convertToKm(int steps) {
        return (steps * LENGTH_OF_STEP) / CENTIMETERS_PER_KILOMETER;
    }

    int convertStepsToKilocalories(int steps) {
        return steps * CALORIES_PER_STEP / CALORIES_PER_KILOCALORIES;
    }
}
