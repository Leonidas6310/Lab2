import java.io.PrintStream;
import java.util.Scanner;

public class Forth {
    public static PrintStream out = System.out;
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        if (n < 3)
            out.print("Error, n should be greater than or equal to 3");

        int k = in.nextInt();
        if (k < 3)
            out.print("Error, k should be greater than or equal to 3");

        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = in.nextInt();

        int ind1 = 0, ind2 = -1, ind3 = -1;
        for (int i = 0; i < n - 2; ++i) {
            //В качестве сравниваемого значения будем брать i-й элемент
            ind1 = i;

            boolean elementsFound = false;
            //Расстояние между первым и последним подходящим элементом должно быть не более k,
            //поэтому в условии цикла указано j < i+k
            for (int j = i+1; j < n && j < i+k; ++j) {
                if (arr[ind1] == arr[j]) {
                    if (ind2 == -1)
                        ind2 = j;
                    else {
                        ind3 = j;
                        elementsFound = true;
                        break;
                    }
                }
            }

            if (elementsFound)
                break;
            else
                ind2 = -1;
        }

        if (ind3 != -1)
            out.printf("Значение: %d\nИндексы элементов: %d %d %d", arr[ind1], ind1, ind2, ind3);
        else
            out.print("NO");
    }
}
