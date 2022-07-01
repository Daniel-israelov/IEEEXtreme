import java.util.Scanner;

public class Fibonacci {
    /**
     * This method returns a list of the first 60 numbers of fibonacci modulo 10.
     * This sequence occurs every 60 numbers from fibonacci sequance.
     * 
     * @return array of integers.
     */
    static int[] generateSequence() {
        return new int[] { 1, 1, 2, 3, 5, 8, 3, 1, 4, 5, 9, 4, 3, 7, 0, 7, 7, 4, 1, 5, 6, 1, 7, 8, 5, 3, 8, 1, 9, 0, 9,
                9, 8, 7, 5, 2, 7, 9, 6, 5, 1, 6, 7, 3, 0, 3, 3, 6, 9, 5, 4, 9, 3, 2, 5, 7, 2, 9, 1, 0 };
    }

    public static void main(String[] args) {
        int[] modTenSequence = generateSequence();
        Scanner in = new Scanner(System.in);

        int numOfTestCases = in.nextInt();

        while (numOfTestCases-- > 0) {
            System.out.println(modTenSequence[in.nextInt() % 60]);
        }
        in.close();
    }
}