package soword;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 字符串排列
 */
public class Solution27 {
    public static void main(String[] args) {
        Solution27 solution = new Solution27();
        String str = "abc";
        ArrayList<String> res = solution.Permutation(str);
        for (String e : res) {
            System.out.println(e);
        }
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0 , res);
            Collections.sort(res);
        }
        return res;
    }

    public void PermutationHelper(char[] str, int i, ArrayList<String> res) {
        if (!res.contains(String.valueOf(str))) {
            res.add(String.valueOf(str));
        }
        for (int j = i; j < str.length; j++) {
            char temp = str[j];
            str[j] = str[i];
            str[i] = temp;

            PermutationHelper(str, i+1, res);

            temp = str[j];
            str[j] = str[i];
            str[i] = temp;

        }
    }
}
