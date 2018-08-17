package codingame;

import java.util.Scanner;

/**
 * <h1>Temperature</h1>
 *
 * <h2>Setting:</h2>
 * In this exercise, you have to analyze records of temperature to find the closest to zero.
 * 
 * <h2>Rules:</h2>
 * Write a program that prints the temperature closest to 0 among input data. <b>If two numbers are equally close to
 * zero, positive integer has to be considered closest to zero</b> (for instance, if the temperatures are -5 and 5, then
 * display 5).
 * 
 * <h2>Input:</h2>
 * Line 1: <b>N</b>, the number of temperatures to analyze<br>
 * Line 2: A string with the <b>N</b> temperatures expressed as integers ranging from -273 to 5526
 * 
 * <h2>Output:</h2>
 * Display 0 (zero) if no temperatures are provided. Otherwise, display the temperature closest to 0.
 * 
 * <h2>Constraints:</h2>
 * 0 &le; <b>N</b> &lt; 10000
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 14, 2018
 */

class Temperatures {
    static int near;
    static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        int n = in.nextInt(); // the number of temperatures to analyze
        if (n > 0) {
            near = 5526;
        } else {
            near = 0;
        }
        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            if (Math.abs(t) < Math.abs(near) || (Math.abs(t) == Math.abs(near) && t > near)) {
                near = t;
            }
        }
        System.out.println(near);
    }
}
