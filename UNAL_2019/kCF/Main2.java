import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // int a = scanner.nextInt();
        int a, b, c;

        while (c >= a + b) { // if c becomes less than a+b, than there's no sollution
            c -= b;
            if (c % a == 0) {
                printf("YES");
                return 0;
            }
        }
        printf("NO");

        System.out.println("Possible");

        if (isPossible(7, 3, a))
            System.out.println("Possible");
        else
            System.out.println("Not Possible");
    }

    static int gcd(int a, int b) {
        return (a % b == 0) ? b : gcd(b, a % b);
    }

    private static boolean isPossible(int a, int b, int c) {
        return (c % gcd(a, b) == 0);
    }
}