package codingame;

/**
 * <h1>Horse Racing Duals</h1>
 *
 * <h2>Setting:</h2>
 * Casablanca's hippodrome is organizing a new type of horse racing: duals. During a dual, only two horses will
 * participate in the race. In order for the race to be interesting, it is necessary to try to select two horses with
 * similar strength. Write a program which, using a given number of strengths, identifies the two closest strengths and
 * shows their difference with an integer (&ge; 0).
 * 
 * <h2>Input:</h2>
 * Line 1: Number <b>N</b> of horses<br>
 * The <b>N</b> following lines: the strength <b>P<sub>i</b> of each horse. <b>P<sub>i</b> is an integer.
 * 
 * <h2>Output:</h2>
 * The difference <b>D</b> between the two closest strengths. <b>D</b> is an integer greater than or equal to 0.
 * 
 * <h2>Constraints:</h2>
 * 1 &lt; <b>N</b> &lt; 100000<br>
 * 0 &lt; <b>P<sub>i</b> &le; 10000000
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 14, 2018
 */

import java.util.Arrays;
import java.util.Scanner;

class Horse_Racing_Duals {
    static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        int best = Integer.MAX_VALUE;
        int N = in.nextInt();
        int[] horses = new int[N];
        for (int i = 0; i < N; i++) {
            horses[i] = in.nextInt();
        }
        Arrays.sort(horses);
        for (int i = 1; i < N; i++)
            if (horses[i] - horses[i - 1] < best) best = horses[i] - horses[i - 1];
        System.out.println(best);
    }
}
