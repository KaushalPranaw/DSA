package leetcode150.day7;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(new IsomorphicStrings().isIsomorphic(s, t));
    }

    public boolean isIsomorphic(String s, String t) {
        return helper(s).equals(helper(t));

    }

    private String helper(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, i);
            }
            sb.append(map.get(ch));
            sb.append("-");
        }
        return sb.toString();
    }
}
