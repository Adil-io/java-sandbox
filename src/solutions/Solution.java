package solutions;

import utils.Utils;

import java.util.*;

public class Solution {
    private Solution() {
    }

    public static int lengthOfLongestNonRepeatingSubstring(String s) {
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String str = s.substring(l, i + 1);
            int j = 0;
            while (charSet.contains(ch)) {
                char tempChar = str.charAt(j);
                charSet.remove(tempChar);
                j++;
                l++;
            }
            charSet.add(ch);
            maxLength = Math.max(maxLength, charSet.size());
        }
        return maxLength;
    }

    public static String longestNonRepeatingSubstring(String s) {
        String longestSubstring = "";
        Set<Character> charSet = new HashSet<>();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (charSet.contains(ch)) {
                charSet.remove(ch);
                l++;
            }
            charSet.add(ch);
            String currentSubstring = s.substring(l, r);
            if (currentSubstring.length() > longestSubstring.length()) {
                longestSubstring = currentSubstring;
            }
        }
        return longestSubstring;
    }

    public static String getExpandedString(String s) {
        String expanded = "";
        for (int i = 0; i < s.length(); i++) {
            int num = Integer.parseInt(s.charAt(i) + "");

            int j = i + 1;
            String subString = "";
            while (s.charAt(j) != ')') {
                if (Character.isAlphabetic(s.charAt(j))) {
                    subString += s.charAt(j);
                }
                j++;
            }

            for (int k = 0; k < num; k++) {
                expanded += subString;
            }
            if (j < s.length()) {
                i = j;
            }
        }
        return expanded;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> hm = new HashMap<>();
        for (char ch : t.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for (char ch : s.toCharArray()) {
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) - 1);
            }
        }
        for (char ch : t.toCharArray()) {
            if (hm.containsKey(ch) && hm.get(ch) <= 0) {
                hm.remove(ch);
            }
        }
        return hm.isEmpty();
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }

        int p1 = -1, p2 = -1;
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (hm.containsKey(comp) && hm.get(comp) != i) {
                p1 = i;
                p2 = hm.get(comp);
                break;
            }
        }
        return new int[]{p1, p2};
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramsGroup = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("0")) {
                continue;
            }
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    strs[j] = "0";
                }
            }
            anagramsGroup.add(group);
        }
        return anagramsGroup;
    }

    public static List<List<String>> optimized_groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();
        for (String str : strs) {
            String sortedStr = Utils.getSortedString(str);
            anagramsMap.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagramsMap.values());
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int[] topKArr = new int[k];
        int i = 0;
        while (k > 0) {
            int maxValue = 0, maxKey = 0;
            for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                    topKArr[i] = entry.getKey();
                }
            }
            i++;
            k--;
            hm.remove(maxKey);
        }
        return topKArr;
    }

    public static String shortestPalindrome(String s) {
        String shortestPalindrome = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            shortestPalindrome += ch;
        }
        if (s.equals(shortestPalindrome)) {
            return shortestPalindrome;
        }

        // aaabcd -> dcbaaabcd
        shortestPalindrome = "";
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i > 0; i--) {
            char ch = s.charAt(i);
            if (ch == s.charAt(i - 1)) {
                stack.add(ch);
                continue;
            }

            while (!stack.isEmpty()) {
                shortestPalindrome += stack.pop();
            }
            shortestPalindrome += ch + "";
        }

        return shortestPalindrome + s;
    }

}
