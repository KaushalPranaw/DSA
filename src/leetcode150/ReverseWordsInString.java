package leetcode150;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(new ReverseWordsInString().reverseWords(s));

    }

 /*   public String reverseWords(String s) {
        // Trim leading and trailing spaces
        s = s.trim();
        // Split the words by spaces
        String[] words = s.split("\\s+");
        // Use StringBuilder to reverse the words
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }*/

    //using two pointer
    public String reverseWords(String s) {

        String[] words = s.trim().split("\\s+");
        int i = 0, j = words.length - 1;
        while (i < j) {
            String t = words[i];
            words[i] = words[j];
            words[j] = t;
            i++;
            j--;
        }
        return String.join(" ", words);
    }
}
