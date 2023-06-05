import java.util.ArrayList;

public class Asymetryczne {
    private final ArrayList<Integer> liczbyWzledniePierwsze = new ArrayList<>();
    private final int n;
    private int q;

    public Asymetryczne(int n) {
        this.n = n;
    }

    public Asymetryczne(int n, int q) {
        this.n = n;
        this.q = q;
    }

    public void wygenerujKlucze(){
        znajdzLiczby();
        int kluczPubliczny = kluczPubliczny();
        System.out.println("Klucz publiczny: " + kluczPubliczny);
        int kluczPrywatny = kluczPrywatny(kluczPubliczny);
        System.out.println("Klucz prywatny: " + kluczPrywatny);
    }

    public void printList(){
        znajdzLiczby();
        System.out.println("Liczby wzglednie pierwsze dla " + n + ":");
        for (Integer integer : liczbyWzledniePierwsze) {
            System.out.println(integer);
        }
    }

    public int kluczPrywatny(int kluczPubliczny){
        int temp = 0;
        while ((kluczPubliczny * temp) % n != 1){
            temp++;
        }
        return temp;
    }

    private void znajdzLiczby() {
        for(int i = 2; i<n; i++) {
            if(NWD(n, i)) liczbyWzledniePierwsze.add(i);
        }
    }

    private int kluczPubliczny() {
        int klucz = 0;
        for (Integer integer : liczbyWzledniePierwsze) {
            if (integer > q) {
                klucz = integer;
                break;
            }
        }
            return klucz;
    }


    private boolean NWD(int a, int b){
        int c;
        while (a % b != 0){
            c = b;
            b = a % b;
            a = c;
        }
        return b==1;
    }


}
