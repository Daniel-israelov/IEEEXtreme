package Miscellaneous;

import java.util.Scanner;

/* --->>>>>  COMPLETED  100/100  <<<<<---- */
public class BeetleBag {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        int capacity, numOfGadgets, gadgetWeight, fightPower;

        for (int i = 0; i < t; i++) {
            capacity = in.nextInt(); // bag capacity
            numOfGadgets = in.nextInt(); // num of gadgets

            int[] weights = new int[numOfGadgets]; // gadget weights
            int[] powers = new int[numOfGadgets];  // gadget power

            for (int j = 0; j < numOfGadgets; j++) {
                gadgetWeight = in.nextInt();
                fightPower = in.nextInt();

                weights[j] = gadgetWeight;
                powers[j] = fightPower;
            }
            System.out.println(beetleBag(weights, powers, capacity));
        }
    }

    public static int beetleBag(int[] weights, int[] powers, int capacity){
        //Using Knapsack algorithm (dynamic programming)
        int[] dp = new int[capacity + 1];

        for (int i = 1; i < powers.length + 1; i++) {
            for (int j = capacity; j >= 0 ; j--) {
                if(weights[i - 1] <= j){
                    //getting the max value
                    dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + powers[i - 1]);
                }
            }
        }
        return dp[capacity];
    }
}
