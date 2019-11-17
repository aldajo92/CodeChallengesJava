import java.util.Scanner;
public final class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = 1;
        for (int i = 0; i < n; i++) result = result + 4 * i;
        System.out.println(result);
    }
}