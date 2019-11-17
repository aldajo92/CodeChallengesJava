import java.util.Scanner;

public final class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int minimun = 0;
        int[] visited = new int[n];

        for (int i = 0; i < k; i++) {
            visited[i] = scanner.nextInt();
            minimun += visited[i];
        }

        int result = minimun;
        int resultIndex = 1;

        for (int i = k; i < n; i++) {
            visited[i] = scanner.nextInt();
            result = result - visited[i-k] + visited[i];
            if(result < minimun){
                minimun = result;
                resultIndex = i - k + 2;
            }
        }

        System.out.println(resultIndex);
    }
}