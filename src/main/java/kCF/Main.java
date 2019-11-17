import java.util.Scanner;

public final class Main {

    static String solution(int a, int b, int n) {
        for (int i = 0; i * a <= n; i++) if ((n - (i * a)) % b == 0) return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) System.out.println(solution(7, 3, scanner.nextInt()));
    }

}