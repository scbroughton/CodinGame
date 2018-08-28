package codingame;

import java.util.Scanner;

/**
 * <h1>Rugby Score</h1>
 *
 * <h2>Setting:</h2>
 * Given a rugby score, your program must compute the different scoring combinations that lead to that particular
 * score.<br>
 * As a reminder:
 * <ul>
 * <li>a try is worth 5 points
 * <li>after a try, a transformation kick is played and is worth 2 extra points if successful
 * <li>penalty kicks and drops are worth 3 points
 * </ul>
 * 
 * <h2>Input:</h2>
 * Line 1: the <b>score</b>
 * 
 * <h2>Output:</h2>
 * <b>N</b> lines: number of <b>tries</b>, number of <b>transformations</b>, number of <b>penalties/drops</b>, separated
 * by spaces<br>
 * The combinations must be ordered by increasing order of tries, then transformations, then penalties/drops
 * 
 * <h2>Constraints:</h2>
 * No impossible scores are given, there is always at least one valid combination.
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 14, 2018
 */

class RugbyScore {
    static final Scanner in = new Scanner(System.in);
    static final int N = in.nextInt();

    public static void main(String args[]) {
        for (int i = 0; i <= N; i++)
            for (int j = 0; j <= i; j++)
                for (int k = 0; k <= N; k++)
                    if (5 * i + 2 * j + 3 * k == N) System.out.println(i + " " + j + " " + k);
    }
}