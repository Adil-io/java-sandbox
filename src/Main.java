import solutions.Solution;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        String str = "abcabcdd";
//        int length = Solution.lengthOfLongestNonRepeatingSubstring(str);
//        System.out.println(length);

//        String str = "abcbbcadd";
//        String longestSubstring = Solution.longestNonRepeatingSubstring(str);
//        System.out.println(longestSubstring);

//        String str = "3(ab)4(cd)7(d)";
//        String expandedStr = Solution.getExpandedString(str);
//        System.out.println(expandedStr);

//        String s = "jar";
//        String t = "jam";
//        System.out.println(Solution.isAnagram(s,t));

//        int[] nums = new int[]{1,3,4,2};
//        int target = 6;
//        int[] twoSum = Solution.twoSum(nums, target);
//        System.out.println(twoSum[0] + "," + twoSum[1]);

//        String[] strs = new String[]{"act", "pots", "tops", "cat", "stop", "hat"};
//        System.out.println(Solution.optimized_groupAnagrams(strs));

        int[] nums = new int[]{7,7};
        int k = 1;
        System.out.println(Arrays.toString(Solution.topKFrequent(nums, k)));

    }

}