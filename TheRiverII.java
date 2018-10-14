package codingame;

import java.util.Scanner;

/**
 * <h1>The River II</h1>
 *
 * <p>
 *
 * A digital river is a sequence of numbers where every number is followed by the same number plus the sum of its
 * digits. In such a sequence 123 is followed by 129 (since 1 + 2 + 3 = 6), which again is followed by 141.
 * <p>
 * We call a digital river river K, if it starts with the value K.
 * <p>
 * For example, river 7 is the sequence beginning with {7, 14, 19, 29, 40, 44, 52, ... } and river 471 is the sequence
 * beginning with {471, 483, 498, 519, ... }.
 * <p>
 * Digital rivers can meet. This happens when two digital rivers share the same values. River 32 meets river 47 at 47,
 * while river 471 meets river 480 at 519.
 * <p>
 * Given a number decide, whether it can be a meeting point of two or more digital rivers. For example, it is easy to
 * check that only river 20 contains the number 20 in its sequence (as a starting point).
 * <p>
 * (Idea : BIO'99)
 * 
 * <h2>Input</h2>
 * Line 1: An integer <b>r1</b>.
 * 
 * <h2>Output</h2>
 * Line 1: YES if <b>r1</b> can be a meeting points of two digital rivers, NO otherwise.
 * 
 * <h2>Constraints</h2>
 * 1 &le; <b>r1</b> &lt; 100000
 * 
 * <hr>
 *
 *
 * @author Stephen Broughton
 * @since Oct 14, 2018
 */
public class TheRiverII {
    @SuppressWarnings("javadoc")
    public static void main(String args[]) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        int r1 = in.nextInt();
        boolean[] memo = new boolean[r1 + 1];
        for (int i = 0; i < r1 + 1; i++)
            memo[i] = true;

        for (int i = 1; i < r1; i++) {
            int r2 = i;
            while (r2 <= r1 && memo[r2]) {
                if (r2 == r1) {
                    System.out.println("YES");
                    System.exit(0);
                }
                memo[r2] = false;
                r2 = next(r2);
            }
        }
        System.out.println("NO");
    }

    static int next(int r) {
        String str = String.valueOf(r);
        String[] digits = str.split("");
        for (int i = 0; i < str.length(); i++) {
            r += Integer.valueOf(digits[i]).intValue();
        }
        return r;
    }
}
