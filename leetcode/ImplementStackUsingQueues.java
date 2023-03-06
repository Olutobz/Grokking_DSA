import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ImplementStackUsingQueues {

    static class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        // Pushes element x to the top of the stack
        public void push(int x) {
            while (!q1.isEmpty()) {
                q2.offer(q1.remove());
            }
            q1.offer(x);
            while (!q2.isEmpty()) {
                q1.offer(q2.remove());
            }
        }

        // Removes the element on the top of the stack and returns it
        public int pop() {
            return q1.remove();
        }

        // Returns the element on the top of the stack
        public int top() {
            return q1.peek();
        }

        // Returns whether the stack is empty
        public boolean empty() {
            return q1.isEmpty();
        }
    }

    static class MyStackII {
        Queue<Integer> queue;

        public MyStackII() {
            queue = new LinkedList<>();
        }

        // Pushes element x to the top of the stack
        public void push(int x) {
            queue.add(x);
            for (int i = 1; i < queue.size(); i++) {
                queue.offer(queue.remove());
            }
        }

        // Removes the element on the top of the stack and returns it
        public int pop() {
            return queue.remove();
        }

        // Returns the element on the top of the stack
        public int top() {
            return queue.peek();
        }

        // Returns whether the stack is empty
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
