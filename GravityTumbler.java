package codingame;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <h1>Gravity Tumbler</h1>
 *
 * <p>
 *
 * The program must output the result of tumbling a landscape a certain number of times.<br>
 * Tumbling entails:
 * <ul>
 * <li>rotating the landscape counterclockwise by 90&deg;
 * <li>letting the hash bits # fall down
 * </ul>
 * The map is composed of . and #.<br>
 * (This puzzle is a twist (hah!) on classic community puzzle “Gravity”. You may want to solve that one first.)
 * 
 * <h2>Input</h2>
 * 
 * Line 1: two space-separated integers: the map <b>width</b> and <b>height</b>.<br>
 * Line 2: the number <b>count</b> of tumbling actions to perform.<br>
 * Next <b>height</b> lines: <b>width</b> characters (empty bits . and heavy bits #).
 * 
 * <h2>Output</h2>
 * 
 * If <b>count</b> is odd: <b>width</b> lines of <b>height</b> characters.<br>
 * If <b>count</b> is even: <b>height</b> lines of <b>width</b> characters.
 * <p>
 * Obviously, in both cases, the # are at the bottom.
 * 
 * <h2>Constraints</h2>
 * 
 * 0 &lt; <b>width</b> &lt; 100<br>
 * 0 &lt; <b>height</b> &lt; 10<br>
 * 0 &lt; <b>count</b> &lt; 100
 * <p>
 * The input map is in a “stable” configuration, i.e. the heavy bits are already at the bottom.
 * 
 * <hr>
 *
 * @author Stephen Broughton
 * @since Oct 14, 2018
 */
public class GravityTumbler {
    @SuppressWarnings("javadoc")
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        char[][] field = new char[height][width];
        int count = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < height; i++) {
            field[i] = in.nextLine().toCharArray();
        }
        char[][] output = shift(field, height, width, count);
        if (count % 2 == 1) height = width;
        for (int i = 0; i < height; i++)
            System.out.println(output[i]);
        in.close();
    }

    static char[][] shift(char[][] field, int height, int width, int shiftsRemaining) {
        if (shiftsRemaining == 0) return field;
        char[][] newField = new char[width][height];
        for (int i = 0; i < height; i++) {
            Arrays.sort(field[i]);
            for (int j = 1; j <= width; j++)
                newField[width - j][i] = field[i][j - 1];
        }
        return shift(newField, width, height, shiftsRemaining - 1);
    }
}
