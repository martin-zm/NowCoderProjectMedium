package com.leetcode;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
public class FindSmallest {
    public static String findSmallest(String[] strs, int n) {
        quickSort(strs, 0, n-1);
        String result = "";
        for (int i = 0; i < n; i++) {
            result += strs[i];
        }
        return result;
    }

    public static void quickSort(String[] strs, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(strs, lo, hi);
        quickSort(strs, lo, j-1);
        quickSort(strs, j+1, hi);
    }

    public static int partition(String[] strs, int lo, int hi) {
        int i = lo;
        int j = hi+1;
        String point = strs[lo];
        String temp = "";
        while(true) {
            while(LT(strs[++i], point)) if (i == hi) break;
            while(!LT(strs[--j], point)) if (j == lo) break;

            if (i >= j) {
                break;
            }

            temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
        }

        temp = strs[j];
        strs[j] = strs[lo];
        strs[lo] = temp;

        return j;
    }

    public static boolean LT(String str1, String str2) {
        String temp1 = str1 + str2;
        String temp2 = str2 + str1;

        return temp1.compareTo(temp2) > 0 ? false : true;
    }

    public static void main(String[] args) {
       String strs[] = {"b", "ba"};

       String result = FindSmallest.findSmallest(strs, 2);

       System.out.println(result);
    }
}
