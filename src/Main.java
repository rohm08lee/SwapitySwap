import java.util.*;
import java.io.*;
public class Main {
    // Swap once and see how many more times a swap is necessary
    // while removing duplicate swaps (swaps that result in the same outcome).
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("swap.in"));
        PrintWriter pw = new PrintWriter("swap.out");

        int N = sc.nextInt();
        int K = sc.nextInt();

        int a1 = sc.nextInt()-1;
        int a2 = sc.nextInt()-1;
        int b1 = sc.nextInt()-1;
        int b2 = sc.nextInt()-1;

        int[] cows = new int[N];
        for (int i = 0; i < N; i++) {
            cows[i] = i+1;
        }
        int cycle = 0;
        boolean sorted = false;
        while (!sorted) {
            cycle++;
            reverse(cows, a1, a2);
            reverse(cows, b1, b2);
            sorted = true;
            for(int i = 0; sorted && i < N; i++) sorted = cows[i] == i + 1;
        }

        K %= cycle;
        for (int i = 0; i < N; i++) { cows[i] = i+1;}
        for (int j = 0; j < K; j++) {
            reverse(cows, a1, a2);
            reverse(cows, b1, b2);
        }
        for (int i : cows) { pw.println(i);}
        pw.close();
    }

    static void reverse(int[] cows, int A, int B) {
        while (A < B) {
            int x = cows[A];
            cows[A] = cows[B];
            cows[B] = x;
            A++;
            B--;
        }
    }
}