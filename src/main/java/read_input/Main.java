import java.util.Scanner;

class Main {

    private static String return_operator(int value1, int value2) {
        if (value1 > value2) return ">";
        else if (value1 < value2) return "<";
        else return "=";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.println(return_operator(scanner.nextInt(), scanner.nextInt()));
        }
    }
}