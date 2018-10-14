package codingame;

import java.util.Scanner;

/**
 * <h1>Brackets, Extreme Edition</h1>
 *
 * <p>
 *
 * You must determine whether a given expression has valid brackets. This means all the parentheses (), square brackets
 * [] and curly brackets {} must be correctly paired & nested.
 * <p>
 * The expression does not contain whitespace characters.
 * 
 * <h2>Input</h2>
 * A single line: <b>expression</b>.
 * 
 * <h2>Output</h2>
 * A single line: {@code true} if each kind of bracket (), [] and {} in <b>expression</b> are paired correctly,
 * {@code false} otherwise.
 * 
 * <h2>Constraints</h2>
 * <b>expression</b> contains less than 2048 characters.
 * 
 * <hr>
 *
 *
 * @author Stephen Broughton
 * @since Oct 14, 2018
 */
public class BracketsExtremeEdition {
    @SuppressWarnings("javadoc")
    public static void main(String args[]) {
        int[] b = {0, 0, 0};
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        String expression = in.next();

        for (int i = 0; i < expression.length(); i++) {
            char check = expression.charAt(i);
            switch (check) {
                case '(':
                    b[0]++;
                    break;
                case ')':
                    b[0]--;
                    break;
                case '{':
                    b[1]++;
                    break;
                case '}':
                    b[1]--;
                    break;
                case '[':
                    b[2]++;
                    break;
                case ']':
                    b[2]--;
                    break;
                default:
            }
            if (b[0] < 0 || b[1] < 0 || b[2] < 0) {
                System.out.println("false");
                System.exit(0);
            }
        }
        System.out.println(b[0] == 0 && b[1] == 0 && b[2] == 0);
    }
}
