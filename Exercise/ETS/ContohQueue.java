package Exercise.ETS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

public class ContohQueue {
    public static void main(String[] args) {
        // A. Queue Standar (LinkedList)
        Queue<String> antrean = new LinkedList<>();
        antrean.add("Budi");
        antrean.add("Siti");
        antrean.add("Andi");

        System.out.println("Depan antrean (peek): " + antrean.peek()); // Budi
        System.out.println("Diproses (poll): " + antrean.poll());       // Budi keluar

        // B. PriorityQueue (Otomatis terurut dari angka terkecil)
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(40); 
        pq.add(10);
        pq.add(25);

        System.out.print("Urutan keluar PriorityQueue: ");
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " "); // Mencetak: 10 25 40
        }
    }
}