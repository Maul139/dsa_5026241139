

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void bubbleSort3Passes(int[] A) {
        int n = A.length;

        int passes = 3;
        for (int i = 0; i < passes && i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (A[j] < A[j + 1]) {
                    // Swap A[j] dan A[j+1]
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }

    public static int linearSearch(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        try {
            File file = new File("src/lw04/unguided/cards.txt");
            
            Scanner scanner = new Scanner(file);

            int N = scanner.nextInt();
            int[] branches = new int[N];
            for (int i = 0; i < N; i++) {
                branches[i] = scanner.nextInt();
            }

            int M = scanner.nextInt();
            int[] targets = new int[M];
            for (int i = 0; i < M; i++) {
                targets[i] = scanner.nextInt();
            }

            scanner.close();

            bubbleSort3Passes(branches);

            for (int i = 0; i < N; i++) {
                System.out.print(branches[i] + (i == N - 1 ? "" : " "));
            }
            System.out.println();

            for (int i = 0; i < M; i++) {
                int target = targets[i];
                int index = linearSearch(branches, target);
                if (index != -1) {
                    System.out.println(target + ": FOUND at index " + index);
                } else {
                    System.out.println(target + ": NOT FOUND");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File branches.txt tidak ditemukan.");
        }
    }
}