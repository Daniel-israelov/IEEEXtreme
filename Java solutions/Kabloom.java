package HackerRank;

import java.util.HashMap;
import java.util.Scanner;

/* --->>>>>  COMPLETED  100/100  <<<<<---- */
public class Kabloom {
    static Scanner in = new Scanner(System.in);
    static HashMap<Character, Integer> cardsDeck = new HashMap<>();

    public static void main(String[] args) {
        initializeDeckMap();
        int cardsPerRow = in.nextInt();

        while(cardsPerRow != 0) { //test cases end with input 0
            char[] firstRow = setupRow(cardsPerRow);
            char[] secondRow = setupRow(cardsPerRow);
            kabloom(firstRow, secondRow);
            cardsPerRow = in.nextInt();
        }
    }

    private static void kabloom(char[] firstRow, char[] secondRow) {
        //1st row & 1st column will be 0
        int[][] lcsMat = new int[firstRow.length + 1][secondRow.length + 1];

        //Using the Longest Common Subsequence (LCS) approach.
        //Instead of storing the length of the LCS.
        //I store the sum of the LCS (of 1 row).
        //After I'm done creating the LCS matrix I multiply by 2 the result
        //at the bottom right of the matrix.
        for (int i = 1; i < firstRow.length + 1; i++) {
            for (int j = 1; j < secondRow.length + 1; j++) {
                lcsMat[i][j] = Math.max(lcsMat[i-1][j], lcsMat[i][j-1]);
                if(firstRow[i-1] == secondRow[j-1] || firstRow[i-1] == 'R' || secondRow[j-1] == 'R')
                    lcsMat[i][j] = Math.max(lcsMat[i][j], lcsMat[i-1][j-1] + getValue(firstRow[i-1], secondRow[j-1]));
            }
        }
        System.out.println(lcsMat[lcsMat.length-1][lcsMat.length-1]*2);
    }

    private static int getValue(char x, char y) {
        //If Joker is matched with another Joker
        //then the value of the joker is 50 (default value).
        if(x == 'R' && y == 'R')
            return cardsDeck.get('R');

        //If joker from the 1st row is matched with another card in the 2nd row
        //then the return value will be the value of that other card
        //and that value will be assigned to the joker
        if(x == 'R')
            return cardsDeck.get(y);

        //same as above but this time the 2nd row has the Joker
        return cardsDeck.get(x);
    }

    private static char[] setupRow(int rowLength){
        //setting up row with the given cards
        char[] row = new char[rowLength];
        for (int i = 0; i < rowLength; i++) {
            row[i] = in.next().charAt(0);
        }
        return row;
    }

    private static void initializeDeckMap(){
        //The keys are the card
        //The values are the value assigned to the card
        //Joker default value is 50
        cardsDeck.put('A', 20); //Ace
        cardsDeck.put('2', 2);
        cardsDeck.put('3', 3);
        cardsDeck.put('4', 4);
        cardsDeck.put('5', 5);
        cardsDeck.put('6', 6);
        cardsDeck.put('7', 7);
        cardsDeck.put('8', 8);
        cardsDeck.put('9', 9);
        cardsDeck.put('T', 10); //Ten
        cardsDeck.put('J', 15); //Jack
        cardsDeck.put('Q', 15); //Queen
        cardsDeck.put('K', 15); //King
        cardsDeck.put('R', 50); //Joker
        //If joker is matched to non-joker then its value will be the same as the other card
    }
}
