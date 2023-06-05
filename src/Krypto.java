import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.toBinaryString;

public class Krypto {
    private final Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private String a;
    private String b;

    public Krypto() {}

    public Krypto(String a, String b) {
        this.a = a;
        this.b = b;
    }

    void compare() {
        if(a.equals(b)){
            System.out.println("Są sobie równe.");
        } else {
            System.out.println("\nSą różne od siebie.");
        }
    }

    void textLength() {
        if (a.length() == b.length()){
            System.out.println("Podane ciągi znaków mają taką samą długość, która wynosi: " + a.length());
        } else {
            System.out.println("Podane ciągi znaków mają różne długości i wynoszą one kolejno:");
            System.out.println("długość pierwszego ciągu wynosi: " + a.length());
            System.out.println("długość drugiego ciągu wynosi: " + b.length());
            System.out.println(b.length());
        }
    }

    void ascii(char c){
        int temp = c;
        int binary = Integer.parseInt(toBinaryString(temp));
        String format = String.format("%8s", binary).replaceAll(" ", "0");  // 8-bit Binary
        System.out.println("Wybrany znak: " + c + " | " + "zapis decymalny: " + temp + " | " + "zapis binarny: " + format);
    }

    void textToAscii(){
        System.out.println("Podaj ciąg znaków:");
        String text = scanner.next();
        for (int i = 0; i < text.length(); i++) {
            ascii(text.charAt(i));
        }
    }

    void convertBinary(){
        System.out.println("Wprowadź znak: ");
        char a = scanner.next().charAt(0);
        int b = Integer.parseInt(toBinaryString(a));
        String ascii = String.format("%8s", b).replaceAll(" ", "0");
        System.out.println("Wprowadź ile bitów chcesz zmienić: ");
        int iter = scanner.nextInt()-1;
        for (int i = 0; i < iter; i++) {
            ascii = randomize(ascii);
        }
        int decimal = Integer.parseInt(randomize(ascii),2);
        char c = (char) decimal;
        System.out.println("Twój znak przed zmianą: " + a);
        System.out.println("Twój znak po zmianie: " + c);
        ascii(a);
        ascii(c);
    }

    private String randomize(String ascii){
        Random random = new Random();
        StringBuilder s = new StringBuilder();
            int index = random.nextInt(ascii.length());
            for (int i = 0; i < ascii.length(); i++) {
                if (i == index) {
                    if (ascii.charAt(index) == '1'){
                        s.append('0');
                    } else {
                        s.append('1');
                    }
                } else {
                    s.append(ascii.charAt(i));
                }
            }
        return String.valueOf(s);
    }
}
