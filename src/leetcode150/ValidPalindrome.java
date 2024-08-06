package leetcode150;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new ValidPalindrome().isPalindrome(s));

    }

    /*    public boolean isPalindrome(String s) {
            String n1=s.replaceAll("[^a-bA-B0-9]","").toLowerCase();
            String n2=new StringBuilder(n1).reverse().toString();
            return n1.equals(n2);
        }*/
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch) || Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        String result = sb.toString();
        result = result.toLowerCase();
        return checkPalindrome(result);
    }

    private boolean checkPalindrome(String result) {
        int left = 0, right = result.length() - 1;
        while (left < right) {
            if (result.charAt(left) != result.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
