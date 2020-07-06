package soword;
import java.util.*;

public class Solution29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k == 0 || k > input.length) return result;

        Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i = 0; i < input.length; i++) {
            if (queue.size() < k) {
                queue.add(input[i]);
            } else {
                if (queue.peek() > input[i]) {
                    queue.remove();
                    queue.add(input[i]);
                }
            }
        }

        while (!queue.isEmpty()) {
            result.add(queue.remove());
        }

        return result;
    }
}
