package Exercise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Try {

        public static void mirror(Queue<String> q) {
            if (q == null || q.isEmpty()) {
                return;
            }

            Stack<String> s = new Stack<>();
            int originalSize = q.size();

            for (int i = 0; i < originalSize; i++) {
                String val = q.poll();
                q.offer(val);
                s.push(val);
            }

            while (!s.isEmpty()) {
                q.offer(s.pop());
            }
        }
    

    public static void main(String[] args) {
        
        Queue<String> q = new LinkedList<>();
        
       
        q.offer("a");
        q.offer("b");
        q.offer("c");

        System.out.println("Queue sebelum diproses : " + q);

        
        mirror(q);

        System.out.println("Queue setelah di-mirror: " + q);
    }
}
