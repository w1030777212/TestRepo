package com.dxl;

public class leettest {
    public String minWindow(String s, String t) {
        int[] pattern = new int[128];
        int[] window = new int[128];
        int distance = 0;

        for (int i=0;i<t.length();i++){
            char c = t.charAt(i);
            pattern[c-'A'] ++;
        }
        //统计字串不同字符个数
        for (int i=0;i<pattern.length;i++){
            if (pattern[i] > 0){
                distance ++ ;
            }
        }
        //查找字串
        int right = 0;
        int left = 0;
        int minlen = s.length()+1;
        int start = 0;
        int match = 0;
        int slength = s.length();

        while (right<slength){
            char c = s.charAt(right);
            if (pattern[c-'A']>0){
                window[c-'A']++;

                if (window[c-'A'] == pattern[c-'A']){
                    match++;
                }
            }
            right++;
            //移动左指针
            while (match == distance){
                if (right - left<minlen){
                    start = left;
                    minlen = right-left;
                }
                char leftC = s.charAt(left);
                if (window[leftC-'A']>0){
                    window[leftC-'A']--;
                    if (window[leftC-'A'] < pattern[leftC-'A'])
                        match--;
                }
                left ++;
            }
        }
        return minlen == slength+1?"" : s.substring(start, start+minlen);
    }


    public static void main(String[] args) {
        leettest l = new leettest();
        System.out.println(l.minWindow("a", "a"));;

    }
}
