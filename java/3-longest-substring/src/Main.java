/**
 * Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * ---
 *
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * ---
 *
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note: The answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * ---
 *
 * Example 4:
 *
 * Input: s = ""
 * Output: 0
 *
 * ---
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class Main {

  /**
   * Works via a brute force approach. For every character in the string, every subsequent character
   * is tallied until a duplicate is found. When a tally is greater than the longest, the longest
   * is updated with the tally. A duplicate is found by checking a character set, when a unique
   * character is found, the character map is updated.
   */
  public static int lengthOfLongestSubstring(String s) {
    int longest = 0;
    int tally = 0;
    int[] charset = new int[128];

    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      for (int j = i; j < chars.length; j++) {
        char current = s.charAt(j);

        // Duplicate is found.
        if (charset[current] > 1) {
          if (tally > longest) longest = tally;

          // Reset tally and the character map for the next substring.
          tally = 0;
          charset = new int[128];

          // No need to check the rest of the substring, as a duplicate is already found.
          break;
        }

        tally++;
        charset[current] = current;
      }
    }

    // In some cases, where a duplicate hasn't been found, the tally hasn't had a chance to check
    // if it's the longest.
    if (tally > longest) longest = tally;

    return longest;
  }

  public static void main(String[] args) {
    int t1 = Main.lengthOfLongestSubstring("abcabcbb");
    if (t1 != 3) throw new Error("Soz bro.");

    int t2 = Main.lengthOfLongestSubstring("bbbbb");
    if (t2 != 1) throw new Error("Soz bro.");

    int t3 = Main.lengthOfLongestSubstring("pwwkew");
    if (t3 != 3) throw new Error("Soz bro.");

    int t4 = Main.lengthOfLongestSubstring("");
    if (t4 != 0) throw new Error("Soz bro.");

    System.out.println("Nice.");
  }

}
