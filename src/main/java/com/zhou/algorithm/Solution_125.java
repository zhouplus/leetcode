package com.zhou.algorithm;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_125 {
    public boolean isPalindrome(String s) {
        // 0. corner case
        if(s == null || "".equals(s)){
            return true;
        }

        // 1. filter out number  & char
        String filteredS = _filterNonNumberAndChar(s);

        // 2. reverse string & conpare string
        return filteredS.equalsIgnoreCase(_reverseString(filteredS));
    }

    private String _reverseString(String s) {
        return  new StringBuilder(s).reverse().toString();
    }

    private String _filterNonNumberAndChar(String s) {
        return s.replaceAll("[^a-zA-Z0-9]","");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
