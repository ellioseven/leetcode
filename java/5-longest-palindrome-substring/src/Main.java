/**
 * Longest Palindromic Substring.
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 * ---
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * ---
 *
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * ---
 *
 * Example 3:
 *
 * Input: s = "a"
 * Output: "a"
 *
 * ---
 *
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 *
 * ---
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters (lower-case and/or upper-case),
 */
public class Main {

  /**
   * Get palindrome substring.
   */
  public static String longestPalindrome(String s) {
    int[] slice = longestPalindromeSlice(s);
    int start = slice[1];
    int end = slice[2];
    return s.substring(start, end + 1);
  }

  /**
   * Builds longest palindrome substring.
   *
   * t[0] = count;
   * t[1] = start;
   * t[2] = end;
   */
  public static int[] longestPalindromeSlice(String s) {
    char[] chars = s.toCharArray();
    int[] longest = new int[3];
    int count = 0;
    int remaining = 0;

    // Loop each character in string.
    for (int i = 0; i < chars.length; i++) {

      // Exit early if it's not possible to create a longer substring.
      remaining = chars.length - i - 1;
      if (remaining < longest[0]) return longest;

      // Loop through substrings.
      for (int j = i; j < chars.length; j++) {
        count = j - i;

        // Check substring for longest palindrome.
        if (isPalindrome(chars, i, j) && count > longest[0]) {
          longest[0] = count;
          longest[1] = i;
          longest[2] = j;
        }
      }
    }


    return longest;
  }

  /**
   * Check string for palindrome.
   *
   * Checks each character to ensure it's counterpart matches.
   */
  public static boolean isPalindrome(char[] chars, int start, int end) {
    int j;
    int k = 0;

    // Substrings below 2 chars fail.
    if (end - start < 1) return false;

    // Loop through each character.
    // @todo Can stop half way through string check.
    for (int i = start; i < end; i++) {
      j = end - k;
      if (chars[i] != chars[j]) return false;
      k++;
    }

    return true;
  }

  public static void main(String[] args) {
    String t1 = longestPalindrome("tebabac");
    if (!t1.equals("bab")) throw new Error("Soz bro.");

    String t2 = longestPalindrome("racecar");
    if (!t2.equals("racecar")) throw new Error("Soz bro.");

    String t3 = longestPalindrome("cbbd");
    if (!t3.equals("bb")) throw new Error("Soz bro.");

    System.out.println("Nice.");
  }

}
