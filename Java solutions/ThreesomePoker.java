package HackerRank;

import java.util.*;

/* --->>>>>  COMPLETED  100/100  <<<<<---- */
public class ThreesomePoker {
    public static void main(String[] arg){
        Scanner in = new Scanner(System.in);
        int[] startMoney = new int[3]; // the initial array of money

        for (int i = 0; i < 3; i++)
            startMoney[i] = in.nextInt();

        threesomePoker(startMoney);
    }

    public static void threesomePoker(int[] startMoney){
        int firstWinRow = -1, row;
        int maxRows = 797161; //max row is (265720*3)+1=797161
        int[][] roundRes = new int[maxRows][3]; //holds the money amount after each round

        //initializing the 1st row of 'roundRes' to be the input values
        roundRes[0][0] = startMoney[0];
        roundRes[0][1] = startMoney[1];
        roundRes[0][2] = startMoney[2];

        //loop runs maximum 265720 times because each iteration creates 3^x rows.
        //1st iteration creates 3 rows and each one of these rows creates 3 more rows.
        //meaning --> 3^1 + 3^2 + ... + 3^12 + 1
        //exponents are from 1 to 12 because each round takes 5 minutes and 12*5=60 (1 hour).
        //3 is for 3 possibilities of each round (as written below).
        for (int i = 0; i < 265720; i++) {
            int p1Money = roundRes[i][0];
            int p2Money = roundRes[i][1];
            int p3Money = roundRes[i][2];

            if(validate(p1Money, p2Money, p3Money)){//if game ends in less than 1 hour
                firstWinRow = i; // the row index of the 1st win
                break;
            }
            row = i * 3;

            //the following simulates 3 possibilities for each round:
            //1. Player1 Vs. Player2
            //2. Player1 Vs. Player3
            //3. Player2 Vs. Player3
            //Each round fills a row in the 'roundRes' array which represent the
            //amount of money each player has after that round
            //-------------------------------------------------
            //Each following loop iteration will be in relative to the i/3-(1,2,3) row

            //player1 VS player2
            roundRes[row + 1][0] = simulate1(p1Money, p2Money);
            roundRes[row + 1][1] = simulate2(p1Money, p2Money);
            roundRes[row + 1][2] = p3Money; //player3 resting

            //player1 VS player3
            roundRes[row + 2][0] = simulate1(p1Money, p3Money);
            roundRes[row + 2][2] = simulate2(p1Money, p3Money);
            roundRes[row + 2][1] = p2Money; //player2 resting

            //player2 VS player3
            roundRes[row + 3][1] = simulate1(p2Money, p3Money);
            roundRes[row + 3][2] = simulate2(p2Money, p3Money);
            roundRes[row + 3][0] = p1Money; //player1 resting
        }
        if(firstWinRow < 0)
            System.out.println("Ok");
        else
            printShortestRounds(firstWinRow, roundRes);
    }

    private static void printShortestRounds(int row, int[][] res) {
        List<Integer> rows = new ArrayList<>();
        while(row > -1){
            rows.add(row);
            row = Math.floorDiv(row-1, 3);
        }

        //need to reverse the order of element in 'rows'
        //so we can print the valid rows in the correct order
        Collections.reverse(rows);

        for(int r : rows) //printing the best combinations for game less than 1hr
            System.out.println(res[r][0] + " " + res[r][1] + " " + res[r][2]);
    }

    private static boolean validate(int p1, int p2, int p3){
        //returns 'true' if at least 1 argument is 0
        //else false
        return p1 == 0 || p2 == 0 || p3 == 0;
    }

    private static int simulate1(int pX, int pY){
        return pX > pY? (pX - pY) : (pX * 2);
    }

    private static int simulate2(int pX, int pY) {
        return pX > pY? (pY * 2) : (pY - pX);
    }
}
