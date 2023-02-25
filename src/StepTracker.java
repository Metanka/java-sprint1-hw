import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData = new MonthData[12];
    Scanner scanner;
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        int month = getMonth(scanner);
        int day = getDay(scanner);
        int steps = getSteps(scanner);
        if (month == 0 || day == 0 || steps == 0) {
            System.out.println("Ошибка ввода данных");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
    }

    void changeStepGoal() {
        System.out.println("Введите целевое количество шагов в день:");
        int goalSteps = scanner.nextInt();
        if (goalSteps < 0) {
            System.out.println("Шаги будут считаться, даже при ходьбе назад.");
            return;
        } else if (goalSteps == 0) {
            System.out.println("Если вы не в коме, то шаги должны быть больше 0. Верьте в себя!.");
            return;
        }
        goalByStepsPerDay = goalSteps;
    }

    void printStatistic() {
        System.out.println("Введите номер месяца для получения статистики:");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Такого месяца не существует.");
            return;
        }
        monthToData[month - 1].printDaysAndStepsFromMonth();
        int sumSteps = monthToData[month - 1].sumStepsFromMonth();
        System.out.println("Общее число пройденных шагов: " + sumSteps);
        System.out.println("Максимальное число пройденных шагов: " + monthToData[month - 1].maxSteps());
        System.out.println("Среднее число пройденных шагов: " + (sumSteps / monthToData[month - 1].days.length));
        System.out.println("Вы прошли: " + converter.convertToKm(sumSteps) + " км");
        System.out.println("Вы сожгли: " + converter.convertStepsToKilocalories(sumSteps) + " ккал");
        System.out.println("Лучшая серия: " + monthToData[month - 1].bestSeries(goalByStepsPerDay) + " дней");
    }

    int getMonth(Scanner scanner) {
        System.out.println("Введите номер месяца от 1 до 12:");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Такого месяца не существует.");
            return 0;
        }
        return month;
    }

    int getDay(Scanner scanner) {
        System.out.println("Введите день:");
        int day = scanner.nextInt();
        if (day < 1 || day > 31) {
            System.out.println("Такого дня не существует.");
            return 0;
        }
        return day;
    }

    int getSteps(Scanner scanner) {
        System.out.println("Введите число шагов:");
        int steps = scanner.nextInt();
        if (steps < 1) {
            System.out.println("Нельзя ходить под себя.");
            return 0;
        }
        return steps;
    }
}
