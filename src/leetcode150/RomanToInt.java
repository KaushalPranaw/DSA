package leetcode150;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new RomanToInt().romanToInt(s));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int i, j;
        //if i=0 and j=1 and now check
        //if i>=j then add s[i] into the result
        //if i<j then add minus of s[i] (-s[i]) into result

        int result = 0;
        for (i = 0, j = 1; j < s.length(); i++, j++) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(j))) {
                result += map.get(s.charAt(i));
            } else {
                result -= map.get(s.charAt(i));
            }
        }
        result += map.get(s.charAt(i));
        return result;

    }
}
