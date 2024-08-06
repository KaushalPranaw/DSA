package leetcode150.day2;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(new RansomNote().canConstruct(ransomNote, magazine));

    }
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;
        int[] alphabets_counter = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            alphabets_counter[c-'a']++;
        }
        int count=0;
        for(int i=0;i<ransomNote.length();i++){
            int c=ransomNote.charAt(i);
            if (alphabets_counter[c-'a'] == 0)
                return false;
            alphabets_counter[c-'a']--;
        }
        return true;
    }

    /*1. Create a Hashmat<char, int>
      2. Iterate through the “ransonNote” String
         —for the char in  each iteration, check if it is present inside map and check ig its frequency is greater than 0
         —if yes increment a variable “count” and decrement char’s frequency by 1
         —if no, then break the loop
      3. Return true if count==length of ransomNote String
         Else return false
    */
    /*public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count=0;
        for(int i=0;i<ransomNote.length();i++){
            char ch=ransomNote.charAt(i);
            if(map.containsKey(ch) && map.get(ch)>0){
                count++;
                map.put(ch, map.get(ch)-1);
            }else{
                break;
            }
        }
        if(count==ransomNote.length())
            return true;
        return false;

    }*/
}
