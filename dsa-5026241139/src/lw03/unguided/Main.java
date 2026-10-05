package lw03.unguided;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
       
        Map<String, Integer> enrollmentMap = new LinkedHashMap<>();

       
        List<String> checkResults = new ArrayList<>();

       
        int rejectedOperations = 0;

       
        Scanner scanner = new Scanner(new File("enrollment.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");
            String operation = parts[0];
            String courseCode = parts[1];

            if ("REGISTER".equalsIgnoreCase(operation)) {
                int count = Integer.parseInt(parts[2]);

       
                if (count <= 0) {
                    rejectedOperations++;
                } else {
       
                    if (enrollmentMap.containsKey(courseCode)) {
                        int currentCount = enrollmentMap.get(courseCode);
                        enrollmentMap.put(courseCode, currentCount + count);
                    } else {
                        enrollmentMap.put(courseCode, count);
                    }
                }

            } else if ("WITHDRAW".equalsIgnoreCase(operation)) {
                int count = Integer.parseInt(parts[2]);

       
                if (count <= 0) {
                    rejectedOperations++;
                } else {
       
                    if (enrollmentMap.containsKey(courseCode) && enrollmentMap.get(courseCode) >= count) {
                        int currentCount = enrollmentMap.get(courseCode);
                        enrollmentMap.put(courseCode, currentCount - count);
                    } else {
                        rejectedOperations++;
                    }
                }

            } else if ("CHECK".equalsIgnoreCase(operation)) {
       
                if (enrollmentMap.containsKey(courseCode)) {
                    checkResults.add(courseCode + ": " + enrollmentMap.get(courseCode) + " students");
                } else {
                    checkResults.add(courseCode + ": Not found");
                }
            }
        }
        scanner.close();

       
        System.out.println("===== Enrollment Checks =====");
        for (int i = 0; i < checkResults.size(); i++) {
            System.out.println(checkResults.get(i));
        }

       
        System.out.println("===== Final Enrollment =====");
        for (Map.Entry<String, Integer> entry : enrollmentMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " students");
        }

       
        System.out.println("Rejected operations: " + rejectedOperations);
    }
}