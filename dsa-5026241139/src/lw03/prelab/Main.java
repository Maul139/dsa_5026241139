package lw03.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        problem1();
        System.out.println();
        problem2();
        System.out.println();
        problem3();
    }

    static void problem1() throws FileNotFoundException {
        List<String> playlist = new ArrayList<>();
        Scanner scanner = new Scanner(new File("playlist.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            if (line.startsWith("ADD ")) {
                String song = line.substring(4).trim();
                playlist.add(song);
            } else if (line.startsWith("INSERT ")) {
                String rest = line.substring(7).trim();
                int space = rest.indexOf(' ');
                int index = Integer.parseInt(rest.substring(0, space));
                String song = rest.substring(space + 1).trim();
                playlist.add(index, song);
            } else if (line.startsWith("REMOVE ")) {
                String song = line.substring(7).trim();
                playlist.remove(song);
            }
        }
        scanner.close();

        System.out.println("===== Problem 1 : ===== ");
        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }
    }

    static void problem2() throws FileNotFoundException {
        Set<String> participants = new LinkedHashSet<>();
        int duplicates = 0;
        Scanner scanner = new Scanner(new File("participants.txt"));

        while (scanner.hasNextLine()) {
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                continue;
            }
            if (!participants.add(name)) {
                duplicates++;
            }
        }
        scanner.close();

        System.out.println("===== Problem 2 : =====");
        System.out.println("Unique participants: " + participants.size());
        int i = 1;
        for (String name : participants) {
            System.out.println(i + ". " + name);
            i++;
        }
        System.out.println("Duplicate registrations: " + duplicates);
    }

    static void problem3() throws FileNotFoundException {
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedSales = 0;
        Scanner scanner = new Scanner(new File("inventory.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");
            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if ("ADD".equals(type)) {
                if (inventory.containsKey(product)) {
                    inventory.put(product, inventory.get(product) + quantity);
                } else {
                    inventory.put(product, quantity);
                }
            } else if ("SELL".equals(type)) {
                if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
                    inventory.put(product, inventory.get(product) - quantity);
                } else {
                    failedSales++;
                }
            }
        }
        scanner.close();

        System.out.println("===== Problem 3 : =====");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Failed sales: " + failedSales);
    }
}