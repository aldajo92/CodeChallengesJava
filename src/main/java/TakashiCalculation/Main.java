import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int result = (a <= 9 && b <= 9) ? a * b : -1;
        System.out.println(result);
    }
}