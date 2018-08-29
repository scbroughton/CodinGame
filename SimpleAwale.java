package codingame;

import java.util.Scanner;

/**
 * <h1>Simple Awal&eacute;</h1>
 *
 * <h2>Setting:</h2>
 * Awal&eacute; is an African 2&dash;player game consisting of moving grains in some bowls. Each player has 7 bowls
 * indexed from 0 to 6. The last bowl is the reserve.
 * <br>
 * At each turn a player chooses one of his own bowls except the reserve, picks up all grains there and redistributes
 * them one by one to bowls beginning just after the chosen one. If the number of grains in hand is sufficient, after
 * adding one to his reserve the player continues the distribution in the opponent's bowls excluding his reserve and
 * then back in his own bowls, until his hand is empty.
 * <br>
 * If the final grain is distributed to the player's reserve, he is allowed to play again.
 * 
 * <h3>Examples</h3>
 * 
 * <pre>
 * bowls num : 0 1 2 3 4 5  6
 * --------------------------
 * opp bowls : 5 1 0 6 2 2 [3]
 *  my bowls : 3 4 0 3 3 2 [2]
 * </pre>
 * 
 * I play bowl 0: distribute 3 grains in bowl 1, 2 and 3
 * <br>
 * <br>
 * 
 * <pre>
 * bowls num : 0 1 2 3 4 5  6
 * --------------------------
 * opp bowls : 5 1 0 6 2 2 [3]
 *  my bowls : 0 5 1 4 3 2 [2]
 * </pre>
 * 
 * I play bowl 5: distribute 2 grains (1 in my reserve and 1 in the first opponent bowl)
 * <br>
 * <br>
 * 
 * <pre>
 * bowls num : 0 1 2 3 4 5  6
 * --------------------------
 * opp bowls : 6 1 0 6 2 2 [3]
 *  my bowls : 3 4 0 3 3 0 [3]
 * </pre>
 * 
 * If I end in my reserve I can replay:
 * <br>
 * I play bowl 3:
 * <br>
 * <br>
 * 
 * <pre>
 * bowls num : 0 1 2 3 4 5  6
 * --------------------------
 * opp bowls : 5 1 0 6 2 2 [3]
 *  my bowls : 3 4 0 0 4 3 [3]
 *  
 * REPLAY
 * </pre>
 * 
 * Your goal is to simulate your turn of game. Given the numbers of grains in each bowl and the <b>num</b> of the chosen
 * bowl your program has to display the new situation and the string <i>REPLAY</i> if the player has a chance to play
 * again. Print the numbers of grains of opponent bowls separated by space, then yours. Put reserve counts between
 * brackets.
 * <br>
 * Remember that the player always skips the opponent's reserve when distributing!
 * 
 * <h2>Input:</h2>
 * Line 1: <b>opBowls</b> a string of numbers of grains in each opponent bowls separated by spaces<br>
 * Line 2: <b>myBowls</b> a string of numbers of grains in each of my bowls separated by spaces<br>
 * Line 3: <b>num</b> the index of chosen bowl
 * 
 * <h2>Output:</h2>
 * Line 1: a string of numbers of grains in each opponent bowls separated by spaces<br>
 * Line 2: a string of numbers of grains in each of my bowls separated by spaces<br>
 * <br>
 * If the same player gets to play again:<br>
 * Line 3: <i>REPLAY</i>
 * 
 * <h2>Constraints:</h2>
 * 0 &le; <b>num</b> &lt; 6
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 14, 2018
 */

class SimpleAwale {
    static final Scanner in = new Scanner(System.in);
    static final String[] opStrings = in.nextLine().split(" ");
    static final String[] myStrings = in.nextLine().split(" ");
    static final int bLength = opStrings.length;
    static final int length = 2 * bLength;

    public static void main(String args[]) {
        int[] bowls = new int[length];
        for (int i = 0; i < bLength; i++) {
            bowls[i] = Integer.parseInt(opStrings[i]);
            bowls[bLength + i] = Integer.parseInt(myStrings[i]);
        }

        int num = in.nextInt() + bLength;
        int grains = bowls[num];
        bowls[num++] = 0;

        for (int i = 0; i < grains; i++)
            if ( (num + i) % length == bLength - 1) grains++;
            else bowls[ (num + i) % length]++;
        for (int i = 0; i < length; i++)
            if (i % bLength == bLength - 1) System.out.print("[" + bowls[i] + "]\n");
            else System.out.print(bowls[i] + " ");
        if ( (num + grains) % length == 0) System.out.println("REPLAY");
    }
}