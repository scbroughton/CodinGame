package codingame;

import java.util.Scanner;

/**
 * <h1>Organic Compounds</h1>
 *
 * <h2>Setting:</h2>
 * Write a program to input the condensed formula of an alicylic hydrocarbon, and decide whether it is valid or not.
 * 
 * <h3>Condensed Formula:</h3>
 * The condensed formula includes units of carbon linked to one another by one or more bonds.<br>
 * 1 unit of carbon is represented as CH<i>n</i>.<br>
 * The bonds are adjacent to the carbon units, either horizontally or vertically. Bonds are represented as
 * (<i>m</i>).<br>
 * The inputs given will have a valid representation, but the bonds might not be matching. For example, a carbon unit
 * with n=1 should have 3 adjacent bonds, one with n=2 should have 2 adjacent bonds, etc.
 * 
 * <h3>Note:</h3>
 * To get a better understanding of organic compounds and condensed formulae, look it up on the web
 * 
 * <h2>Input:</h2>
 * Line 1: An integer <b>N</b>, denoting the number of lines<br>
 * Next <b>N</b> Lines: String <i>compound</i> representing the hydrocarbon
 * 
 * <h2>Output:</h2>
 * If the hydrocarbon is valid, a single line <b>VALID</b>.<br>
 * If it is not valid, a single line <b>INVALID</b>.
 * 
 * <h2>Constraints:</h2>
 * 1 &le; <b>N</b> &lt; 20<br>
 * In carbon units, 0 &le; <b>n</b> &le; 4<br>
 * In bonds, 0 &lt; <b>m</b> &le; 4
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 14, 2018
 */

class OrganicCompounds {
    static final Scanner in = new Scanner(System.in);
    static final int N = in.nextInt();
    static final int M = 11;
    static String response = "VALID";
    static int sum = 0;

    public static void main(String args[]) {
        int[][] array = new int[N][M];

        if (in.hasNextLine()) in.nextLine();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                array[i][j] = 0;

        for (int i = 0; i < N; i++) {
            String compound = in.nextLine();
            compound = compound.replaceAll("CH|\\(|\\)", "");
            compound = compound.replaceAll("   ", " ");
            for (int j = 0; j < compound.length(); j++) {
                if (compound.charAt(j) == ' ') array[i][j] = 0;
                else array[i][j] = compound.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i += 2) {
            for (int j = 0; j < M; j += 2) {
                if ( (sum = array[i][j]) == 0) continue;
                if (i > 0) sum += array[i - 1][j];
                if (i < N - 1) sum += array[i + 1][j];
                if (j > 0) sum += array[i][j - 1];
                if (j < M - 1) sum += array[i][j + 1];
                if (sum != 4) response = "INVALID";
            }
        }
        System.out.println(response);
    }
}