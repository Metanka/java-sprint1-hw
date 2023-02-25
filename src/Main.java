import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        while (true) {
            printMenu();
            int command = scanUserInputSafely(scanner);
            if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                stepTracker.changeStepGoal();
            } else if (command == 3) {
                stepTracker.printStatistic();
            } else if (command == 4) {
                scanner.close();
                System.out.println("Выход");
                return;
            } else {
                System.out.println("Такой команды не существует.");
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

    public static int scanUserInputSafely(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println("Недопустимые данные!");
            return -1;
        }
    }
}
