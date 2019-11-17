import java.util.Scanner;
import java.util.Arrays;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int j = 0; j < t; j++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
    
            int[] array = new int[N];
            int start = (D % N);
    
            for (int i = 0; i < N; i++) {
                // array[(start + i) % N] = scanner.nextInt();
                array[((N-start) + i) % N] = scanner.nextInt();
            }
    
            System.out.println(Arrays.toString(array));
        }
    }
}