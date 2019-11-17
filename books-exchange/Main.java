import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(in.readLine());
        for (int i = 0; i < q; i++) {
            int size = Integer.parseInt(in.readLine());
            String[] arr = in.readLine().split(" ");
            solution(size, arr);
        }
    }

    public static void solution(int size, String[] arr){
        String[] books = new String[size];
        int[] days = new int[size];

        for (int i = 0; i < size; i++) {
            books[i] = Integer.toString(i + 1);
            days[i] = 1;
        }

        String[] trans = books.clone();

        for (int i = 0; i < size; i++) {
            trans[Integer.parseInt(arr[i]) - 1] = books[i];
        }

        String[] n_b;
        while (!Arrays.equals(books, trans)){
            n_b = trans.clone();
            for (int i = 0; i < size; i++) {
                if(!trans[i].equals(books[i])){
                    n_b[Integer.parseInt(arr[i]) - 1] = trans[i];
                    days[i] += 1;
                }
            }
            trans = n_b.clone();
        }
        System.out.println(fromIntArray(days));
    }

    private static String fromIntArray(int[] input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            sb.append(input[i]);
            if (i < input.length - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}