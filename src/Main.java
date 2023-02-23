import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            // приткнула для закрытия цикла. Если выносить все в метод processingCommand, то return останавливает метод, а не цикл
            int command = 0;
            printMenu();
            try {
                command = processingCommand(scanner, stepTracker);
                if (command == 4) {
                    return;
                }
            } catch (Exception e) {
                System.out.println("Можно вводить только числа.");
                System.out.println(e.getMessage());
            }
        }
    }

    static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Изменить цель по количеству шагов в день");
        System.out.println("3 - Напечатать статистику за определённый месяц");
        System.out.println("4 - Выход");
    }

    static int processingCommand(Scanner scanner, StepTracker stepTracker) {
        int command = scanner.nextInt();

        if (command == 1) {
            stepTracker.addNewNumberStepsPerDay();
            return command;
        } else if (command == 2) {
            stepTracker.changeStepGoal();
            return command;
        } else if (command == 3) {
            stepTracker.printStatistic();
            return command;
        } else if (command == 4) {
            scanner.close();
            System.out.println("Выход");
            return command;
        } else {
            System.out.println("Такой команды не существует.");
            return command;
        }
    }
}
