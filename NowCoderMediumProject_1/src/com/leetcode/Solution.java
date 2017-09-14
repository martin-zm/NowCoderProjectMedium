package com.leetcode;

/**
 * Created by Administrator on 2017/9/10 0010.
 */
public class Solution {

    public static String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        if (s.equals("")) {
            return "";
        }

        String rs = reverseString(s);
        String[] stringArray = rs.split(" " );

        //字符串中全部是空格
        if (stringArray.length == 0) {
            return "";
        }

        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = reverseString(stringArray[i]);
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stringArray.length - 1; i++) {
            if (stringArray[0].equals("")) {
                continue;
            }
            result.append(stringArray[i] + " ");
        }

        result.append(stringArray[stringArray.length - 1]);

        return result.toString();
    }

    public static String reverseString(String s) {
        if (s == null) {
            return null;
        }

        char[] charArray = s.toCharArray();
        char temp = ' ';
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String s = "   a   b ";

        System.out.println(Solution.reverseWords(s));
        System.out.println(Solution.reverseWords(s).length());
    }

}
