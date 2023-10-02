package BoksOyunu;

public class Main {
    public static void main(String[] args) {
        Boxer b1 = new Boxer("A", 10, 100, 100, 65);
        Boxer b2 = new Boxer("B", 20, 100, 85, 35);

        Match match = new Match(b1, b2, 85, 100);
        match.run();
    }
}
