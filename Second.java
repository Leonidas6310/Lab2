import java.io.PrintStream;
import java.util.Scanner;

public class Second {
    public static PrintStream out = System.out;
    public static Scanner in = new Scanner(System.in);

    static int max(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];

        return max;
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        // n должно быть натуральным
        if (n < 1)
            out.print("Error, n should be greater than 0");

        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = in.nextInt();

        int[] modTally = {0, 0, 0};
        for (int i = 0; i < n; ++i)
            ++modTally[arr[i]%3];

        //Если максимальное количество чисел от чисел определённого остатка меньше или равно
        //половине (округлённой до верха), то такая перестановка возможна
        if (max(modTally) <= (n+1)/2)
            out.print("YES");
        else
            out.print("NO");
    }
}
