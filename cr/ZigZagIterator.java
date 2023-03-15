import java.util.*;

public class ZigZagIterator {

    /**
     * Question: Given two 1D vectors, implement an Iterator to return their elements alternatively
     * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
     * <p>
     * Example: Input1:
     * v1 = [1, 2]
     * v2 = [3, 4, 5, 6]
     * Output: [1, 3, 2, 4, 5, 6]
     * Explanation: By calling next repeatedly until hasNext returns false, the order of the elements
     * returned by next should be [1, 3, 2, 4, 5, 6]
     */

    public static void main(String[] args) {
        List<Integer> v1 = Arrays.asList(1, 2);
        List<Integer> v2 = Arrays.asList(3, 4, 5, 6);
        ZigzagIterator z1 = new ZigzagIterator(v1, v2);
        while (z1.hasNext()) {
            System.out.print(z1.next());
        }
        System.out.println();


        List<Integer> v3 = Arrays.asList(1, 2, 3);
        List<Integer> v4 = Arrays.asList(4, 5, 6, 7);
        List<Integer> v5 = Arrays.asList(8, 9);

        List<List<Integer>> vectors = Arrays.asList(v3, v4, v5);

        ZigzagIteratorK z2 = new ZigzagIteratorK(vectors);
        while (z2.hasNext()) {
            System.out.print(z2.next());
        }
    }

    public static class ZigzagIterator {
        List<Integer> result = new ArrayList<>();
        int index = 0;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {

            for (int i = 0; i < Math.max(v1.size(), v2.size()); i++) {
                if (i < v1.size()) {
                    result.add(v1.get(i));
                }
                if (i < v2.size()) {
                    result.add(v2.get(i));
                }
            }
        }

        public int next() {
            int value = result.get(index);
            index++;

            return value;
        }

        public boolean hasNext() {
            return index < result.size();
        }
    }

    public static class ZigzagIteratorK {

        // int[0] is index of vector of vectors list,
        // int[1] is start of a vector, int[2] is end of a vector
        Queue<int[]> q = new LinkedList<>();
        List<List<Integer>> vectors;

        public ZigzagIteratorK(List<List<Integer>> vectors) {
            this.vectors = vectors;
            for (int i = 0; i < vectors.size(); i++) {
                q.offer(new int[]{i, 0, vectors.get(i).size()});
            }
        }

        public int next() {
            int[] current = q.poll();
            int i = current[0];
            int start = current[1];
            int end = current[2];

            if (start + 1 < end) {
                q.offer(new int[]{i, start + 1, end});
            }
            return vectors.get(i).get(start);
        }

        public boolean hasNext() {
            return !q.isEmpty();
        }
    }

}