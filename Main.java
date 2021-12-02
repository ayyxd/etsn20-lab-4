import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // This try-resource block automatically closes the scanner when the program exits.
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("> ");
                CommandHandler.execute(scanner.nextLine());
            }
        }
    }

}