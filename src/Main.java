import java.util.Scanner;
public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean exit;
        do {
            menuText();
            exit = menuChoice();
        } while (!exit);
    }
    private static void menuText(){
        System.out.println("Wybierz funkcję: ");
        System.out.println("1. Zapis z tablicy ASCII dla wybranego znaku.");
        System.out.println("2. Zapis z tablicy ASCII dla wybranego ciągu znaków.");
        System.out.println("3. Porównanie czy podane ciągi znaków są takie same.");
        System.out.println("4. Porównanie długości podanych ciągów znaków.");
        System.out.println("5. Zamiana bitowa litery");
        System.out.println("0. Zamknij program.");
    }

    private static boolean menuChoice(){
        switch (scanner.next()) {
            case "1" -> {
                System.out.println("Wprowadź symbol: ");
                Krypto krypto = new Krypto();
                krypto.ascii(scanner.next().charAt(0));
            }
            case "2" -> {
                Krypto krypto = new Krypto();
                krypto.textToAscii();
            }
            case "3" -> {
                System.out.println("Podaj pierwszy ciąg znaków:");
                String a = scanner.next();
                System.out.println("Podaj drugi ciąg znaków:");
                String b = scanner.next();
                Krypto krypto = new Krypto(a, b);
                krypto.compare();
            }
            case "4" -> {
                System.out.println("Podaj pierwszy ciąg znaków:");
                String a = scanner.next();
                System.out.println("Podaj drugi ciąg znaków:");
                String b = scanner.next();
                Krypto krypto = new Krypto(a, b);
                krypto.textLength();
            }
            case "5" -> {
                Krypto krypto = new Krypto();
                krypto.convertBinary();
            }
            case "0" -> {
                System.out.println("Dowidzenia!");
                return true;}
            default -> System.out.println("Wybierz poprawną opcję.\n");
        }
        return false;
    }
}