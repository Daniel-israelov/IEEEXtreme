package HackerRank;


import java.util.Scanner;

public class Pattern3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        String text;

        for (int i = 0; i < t; i++) {
            text = in.nextLine();
            KMP(text);
        }
    }

    private static void KMP(String text) {
        //longest prefix-suffix
        int[] lps = new int[text.length()];
        int j = 0;
        int i;

        for (i = 1; i < text.length(); i++) {
            //backtrack j to the beginning of the last pattern found
            while (j > 0 && text.charAt(i) != text.charAt(j))
                j = lps[j-1];

            //save the length of the longest pattern
            if (text.charAt(i) == text.charAt(j))
                j++;

            lps[i] = j;
        }
        //(i - j) --> gives us the smallest length of the repeating pattern
        //j is the longest pattern with repetition
        System.out.println(i - j);
    }
}
