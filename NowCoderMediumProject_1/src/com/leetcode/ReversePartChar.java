package com.leetcode;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
public class ReversePartChar {

    public static String reversePartChar(String s, int index) {
        char[] chars = s.toCharArray();
        reverseString(chars, 0, index);
        reverseString(chars, index+1, s.length() - 1);
        reverseString(chars, 0, s.length() - 1);

        return String.valueOf(chars);
    }

    public static void reverseString(char[] chars, int first, int last) {
        char temp = ' ';
        for (int i = first, j = last; i <= j; i++, j--) {
           temp = chars[i];
           chars[i] = chars[j];
           chars[j] = temp;
        }
    }

    public static void main(String[] args) {
        String s = "abcde";

        System.out.println(ReversePartChar.reversePartChar(s, 2));
    }
}
