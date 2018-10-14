package codingame;

import java.util.Scanner;

/**
 * <h1>Balanced Ternary</h1>
 *
 * <p>
 *
 * Balanced ternary(3 base) is a non-standard positional numeral system. In the standard (unbalanced) ternary system,
 * digits have values 0, 1 and 2. The digits in the balanced ternary system have values -1, 0, and 1. We use letter T to
 * represent -1, so the digits are (T, 0, 1).
 * <p>
 * 
 * E.g.: 1T0 = 1 * (3**2) + (-1)*(3**1) + 0*(3**0) = 9 - 3 + 0 = 6
 * <p>
 * 
 * You must convert input integer (decimal) number to its balanced ternary representation.
 * 
 * <h2>Input</h2>
 * Line 1: An integer (decimal) number <b>N</b>
 * 
 * <h2>Output</h2>
 * Line 1: A balanced ternary number <b>BT</b> as string matching the input.
 * 
 * <h2>Constraints</h2>
 * -30 000 &lt; <b>N</b> &lt; 30 000
 * 
 * <hr>
 *
 *
 * @author Stephen Broughton
 * @since Oct 14, 2018
 */
public class BalancedTernary {
    @SuppressWarnings("javadoc")
    public static void main(String args[]) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        int DEC = in.nextInt();
        if (DEC == 0) {
            System.out.println('0');
            System.exit(0);
        }
        int length = 1 + (int) Math.ceil(Math.log(Math.abs((double) DEC)) / Math.log(3.0d));
        int num = Math.abs(DEC);
        int[] digits = new int[length];

        for (int i = length; i > 0; i--) {
            int rem = num % 3;
            if (rem == 2) rem = -1;
            digits[i - 1] = rem;
            num = (num - rem) / 3;
        }
        String output = parse(digits, length, Math.signum(DEC) >= 0);
        System.out.println(output);
    }

    static String parse(int[] digits, int length, boolean positive) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < length; i++)
            if (positive) if (digits[i] == -1) out.append('T');
            else out.append(digits[i]);
            else if (digits[i] == 1) out.append('T');
            else out.append(-1 * digits[i]);
        while (out.charAt(0) == '0')
            out.deleteCharAt(0);
        return out.toString();
    }
}
