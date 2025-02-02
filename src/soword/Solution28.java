package soword;
import java.util.*;
/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数
 * 组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输
 * 出0。
 */



public class Solution28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (Integer e : array) {
            if (numsMap.containsKey(e)) {
                int count = numsMap.get(e);
                numsMap.put(e, ++count);
                if (count * 2 > array.length)
                    return e;
            } else {
                numsMap.put(e, 1);
            }
        }

        return 0;
    }

    public int MoreThanHalfNum_Solution_2(int [] array) {
        if (array == null || array.length == 0) return 0;

        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
            } else {
                if (result == array[i])
                    times++;
                else {
                    times--;
                }
            }
        }

        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (result == array[i])
                times++;
        }

        if (times * 2 > array.length) return result;

        return 0;
    }
}
