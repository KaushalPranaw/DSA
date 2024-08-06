package leetcode150;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String one = strs[0];
        String two = strs[strs.length - 1];
        int idx = 0;
        while (idx < one.length() && idx < two.length()) {
            if (one.charAt(idx) == two.charAt(idx)) {
                idx++;
            } else break;
        }
        return one.substring(0, idx);
    }
}
