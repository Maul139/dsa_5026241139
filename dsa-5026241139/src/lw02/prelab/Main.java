package lw02.prelab;


import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {

        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failedStack = new Stack<>();
        
        Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));
            
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] transaction = line.split(" ");
                transactions.add(transaction);
            }
        sc.close();
        
        while (!transactions.isEmpty()) {
            queue.add(transactions.removeFirst());
        }
        for(String[] t : queue){
            String name = t[0];
            boolean found = false;
            for(String[] c : customers){
                if(c[0].equals(name)){
                    found = true;
                    break;
                }
            }
            if(!found){
                customers.add(new String[]{name, "0"});
            }

            
        }
        
        

        while(!queue.isEmpty()){
            String[] t = queue.poll();
            String name = t[0];
            String type = t[1];
            int amount = Integer.parseInt(t[2]);
            for(String[] c : customers){
                if(c[0].equals(name)){
                    int balance = Integer.parseInt(c[1]);
                    if(type.equals("DEPOSIT")){
                        balance += amount;
                        c[1] = String.valueOf(balance);
                    } else if(type.equals("WITHDRAW")){
                        if(balance >= amount){
                            balance -= amount;
                            c[1] = String.valueOf(balance);
                        } else {
                            failedStack.push(t);
                        }
                    }
                    break;
                }
            }
        }
        System.out.println("=== Final Balances ===");
        for (String[] c : customers) {
            System.out.println(c[0] + " : " + c[1]);
        }

        System.out.println("\n=== Failed Transactions ===");
        while (!failedStack.isEmpty()) {
            String[] f = failedStack.pop();
            System.out.println(f[0] + " " + f[1] + " " + f[2]);
        }
    }
}