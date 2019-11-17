import java.util.Scanner;
public final class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n > 81) System.out.println("NO");
        else {
            int result = -1;
            for (int i = 1; i < 10; i++) if (n % i == 0) if ((n / i) < 10) result = n / i;

            if (result > 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}