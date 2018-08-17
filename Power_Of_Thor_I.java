package codingame;

import java.util.Scanner;

/**
 * <h1>Power of Thor - Episode 1</h1>
 *
 * <h2>Setting:</h2>
 * Your program must allow Thor to reach the light of power.
 * 
 * <h2>Rules:</h2>
 * Thor moves on a map which is 40 wide by 18 high. Note that the coordinates (X and Y) start at the top left! This
 * means the most top left cell has the coordinates "X=0,Y=0" and the most bottom right one has the coordinates
 * "X=39,Y=17".
 * <p>
 * <b>Once the program starts</b> you are given:
 * <ul>
 * <li>the variable <b>lightX</b>: the X position of the light of power that Thor must reach.
 * <li>the variable <b>lightY</b>: the Y position of the light of power that Thor must reach.
 * <li>the variable <b>initialTX</b>: the starting X position of Thor.
 * <li>the variable <b>initialTY</b>: the starting Y position of Thor.
 * </ul>
 * <p>
 * <b>At the end of the game turn</b>, you must output the direction in which you want Thor to go among:
 * <ul>
 * <li><b>N</b> (North)<br>
 * <li><b>NE</b> (North-East)<br>
 * <li><b>E</b> (East)<br>
 * <li><b>SE</b> (South-East)<br>
 * <li><b>S</b> (South)<br>
 * <li><b>SW</b> (South-West)<br>
 * <li><b>W</b> (West)<br>
 * <li><b>NW</b> (North-West)
 * </ul>
 * Each movement makes Thor move by 1 cell in the chosen direction.
 * 
 * <h2>Note</h2>
 * Do not forget to execute the tests from the "Test cases" panel.
 * <b>Beware:</b> the tests given and the validators used to compute the score are slightly different in order to avoid
 * hard coded solutions.
 * 
 * <h2>Input:</h2>
 * The program must first read the initialization data from the standard input, then, in an infinite loop, provides on
 * the standard output the instructions to move Thor.
 * 
 * <h2>Initialization input</h2>
 * Line 1: 4 integers <b>lightX lightY initialTX initialTY</b>.<br>
 * (lightX, lightY) indicates the position of the light. (initialTX, initialTY) indicates the initial position of Thor.
 * 
 * <h2>Input for a game round</h2>
 * Line 1: the number of remaining moves for Thor to reach the light of power: <b>remainingTurns</b>.<br>
 * You can ignore this data but you must read it.
 * 
 * <h2>Output for a game round:</h2>
 * A single line providing the move to be made: <b>N NE E SE S SW W</b> or <b>NW</b>
 * 
 * <h2>Constraints:</h2>
 * 0 &le; <b>lightX</b> &lt; 40<br>
 * 0 &le; <b>lightY</b> &lt; 18<br>
 * 0 &le; <b>initialTX</b> &lt; 40<br>
 * 0 &le; <b>initialTY</b> &lt; 18<br>
 * Response time for a game round &le; 100ms
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 14, 2018
 */

class Power_Of_Thor_I {
    static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position

        while (in.nextInt() > 0) {
            String output = "";
            if (lightY - initialTY > 0) {
                output += 'S';
                initialTY += 1;
            } else if (lightY - initialTY < 0) {
                output += 'N';
                initialTY -= 1;
            }
            if (lightX - initialTX > 0) {
                output += 'E';
                initialTX += 1;
            } else if (lightX - initialTX < 0) {
                output += 'W';
                initialTX -= 1;
            }
            System.out.println(output);
        }
    }
}
