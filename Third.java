import java.io.PrintStream;
import java.util.Scanner;

public class Third {
    public static PrintStream out = System.out;
    public static Scanner in = new Scanner(System.in);

    static long power(int n, int k) {
        long res = 1;
        for (int i = 0; i < k; ++i)
            res *= n;

        return res;
    }

    public static void main(String[] args) {
        long M = in.nextLong();
        if (M < 1 || M > power(10, 15))
            out.print("Error, M should be between 1 and 10^15");

        //Заметим, что все числа на числовой оси упорядочены, значит,
        //можно воспользоваться методом бинарного поиска
        long left = 0, right = M;
        long middle;
        long k = -1;
        while (left <= right) {
            middle = (left + right) / 2;
            //Так как, если число M слишком большое, а операция middle*middle
            //может выйти за границы long, то условие можно переписать так:
            if (middle == M / middle) {
                k = middle;
                break;
            }
            else {
                if (middle > M / middle)
                    right = middle - 1;
                else {
                    left = middle + 1;
                    k = middle;
                }
            }
        }

        // Если M - квадрат числа k, то k надо уменьшить на 1
        if (k * k == M)
            --k;

        out.print(k);
    }
}
