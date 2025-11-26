import java.io.PrintStream;
import java.util.Scanner;

public class First {
    public static PrintStream out = System.out;
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int a0 = in.nextInt();
        int n = in.nextInt();

        if (n < 1) {
            out.print("Error, n should be greater than 0");
            return;
        }

        int[] arr = new int[n];
        for (int i = 1; i < n+1; ++i) {
            if (i % 2 != 0)
                a0 -= 3;
            else
                a0 *= 4;

            arr[i-1] = a0;
        }

        for (int i = 0; i < n; ++i)
            out.print(arr[i] + " ");
    }
}
