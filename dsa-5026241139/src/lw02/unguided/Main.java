package lw02.unguided;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
       
        final int MAX_BORROW = 2;

       
        LinkedList<String[]> requestsList = new LinkedList<>();

       
        LinkedList<String[]> books = new LinkedList<>();
        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Statistika", "2"});

       
        LinkedList<String[]> members = new LinkedList<>();

       
        try (Scanner sc = new Scanner(new File("borrowing.txt"))) {
            while (sc.hasNext()) {
                String name = sc.next();
                String bookTitle = sc.next(); // Bertipe String biasa

                requestsList.add(new String[]{name, bookTitle});

                // Cek dan tambahkan anggota jika belum terdaftar
                boolean isNewMember = true;
                for (String[] member : members) {
                    if (member[0].equals(name)) {
                        isNewMember = false;
                        break;
                    }
                }

                if (isNewMember) {
                    members.add(new String[]{name, "0"});
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File borrowing.txt tidak ditemukan!");
            return;
        }

       
        Queue<String[]> requestsQueue = new LinkedList<>();
        while (!requestsList.isEmpty()) {
            requestsQueue.add(requestsList.poll());
        }

       
        LinkedList<String[]> succesList = new LinkedList<>();
        Stack<String[]> failedStack = new Stack<>();

       
        while (!requestsQueue.isEmpty()) {
            String[] request = requestsQueue.poll();
            String name = request[0];
            String title = request[1];

            String[] targetBook = null;
            for (String[] b : books) {
                if (b[0].equalsIgnoreCase(title)) {
                    targetBook = b;
                    break;
                }
            }

            String[] targetMember = null;
            for (String[] m : members) {
                if (m[0].equals(name)) {
                    targetMember = m;
                    break;
                }
            }

            if (targetBook != null && targetMember != null) {
                int currentStock = Integer.parseInt(targetBook[1]);
                int currentBorrowed = Integer.parseInt(targetMember[1]);

                // Syarat berhasil: Stok > 0 DAN Buku dipinjam < MAX_BORROW
                if (currentStock > 0 && currentBorrowed < MAX_BORROW) {
                    targetBook[1] = String.valueOf(currentStock - 1);
                    targetMember[1] = String.valueOf(currentBorrowed + 1);
                    succesList.add(request);
                } else {
                    failedStack.push(request); // Masukkan ke Stack jika gagal
                }
            }
        }

       
        System.out.println("=== Successfully Processed Requests ===");
        for (String[] req : succesList) {
            System.out.println(req[0] + " " + req[1]);
        }

       
        System.out.println("=== Remaining Book Stock ===");
        for (String[] b : books) {
            System.out.println(b[0] + ": " + b[1]);
        }

       
        System.out.println("=== Failed Requests ===");
        while (!failedStack.isEmpty()) {
            String[] failedRequest = failedStack.pop();
            System.out.println(failedRequest[0] + " " + failedRequest[1]);
        }
    }
}