package lw04.unguided;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    
    public static void sortCards(int[] arr, int passes) {
        int n = arr.length;
    
        for (int i = 0; i < passes && i < n - 1; i++) {

            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public static int findCard(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
                }
        }
        return -1;
    }

    public static void main(String[] args) {
        try {

        Scanner scanner = new Scanner(new File("dsa-5026241139/src/lw04/unguided/cards.txt"));

        int N = scanner.nextInt();
            int[] cards = new int[N];
            for (int i = 0; i < N; i++) {
                cards[i] = scanner.nextInt();
            }

        int M = scanner.nextInt();
            int[] targets = new int[M];
            for (int i = 0; i < M; i++) {
                targets[i] = scanner.nextInt();
            }

            scanner.close();

            sortCards(cards, 2);

            for (int i = 0; i < N; i++) {
                System.out.print(cards[i] + (i == N - 1 ? "" : " "));
            }
            System.out.println();

            for (int i = 0; i < M; i++) {
                int target = targets[i];
                int index = findCard(cards, target);
                if (index != -1) {
                    System.out.println(target + ": FOUND at index " + index);
                } else {
                    System.out.println(target + ": NOT FOUND");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File cards.txt tidak ditemukan.");
            
        }
    }
}
