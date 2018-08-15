package codingame;

/**
 * <h1>Chuck Norris</h1>
 *
 * <h2>Setting:</h2>
 * Binary with 0 and 1 is good, but binary with only 0, or almost, is even better! Originally, this is a concept
 * designed by Chuck Norris to send so called unary messages.<br>
 * Write a program that takes an incoming message as input and displays as output the message encoded using Chuck
 * Norris’ method.
 * 
 * <h3>Rules:</h3>
 * Here is the encoding principle:
 * <ul>
 * <li>The input message consists of ASCII characters (7-bit)
 * <li>The encoded output message consists of blocks of 0
 * <li>A block is separated from another block by a space
 * <li>Two consecutive blocks are used to produce a series of same value bits (only 1 or 0 values):
 * <ul>
 * <li>First block: it is always 0 or 00. If it is 0, then the series contains 1, if not, it contains 0
 * <li>Second block: the number of 0 in this block is the number of bits in the series
 * </ul>
 * </ul>
 * 
 * <h3>Example</h3>
 * Let’s take a simple example with a message which consists of only one character: Capital C. C in binary is
 * represented as 1000011, so with Chuck Norris’ technique this gives:
 * <ul>
 * <li>0 0 (the first series consists of only a single 1)
 * <li>00 0000 (the second series consists of four 0)
 * <li>0 00 (the third consists of two 1)
 * </ul>
 * So C is coded as: 0 0 00 0000 0 00
 * <p>
 * Second example, we want to encode the message CC (i.e. the 14 bits 10000111000011) :
 * <ul>
 * <li>0 0 (one single 1)
 * <li>00 0000 (four 0)
 * <li>0 000 (three 1)
 * <li>00 0000 (four 0)
 * <li>0 00 (two 1)
 * </ul>
 * So CC is coded as: 0 0 00 0000 0 000 00 0000 0 00
 * 
 * <h2>Input:</h2>
 * Line 1: the message consisting of <b>N</b> ASCII characters (without carriage return)
 * 
 * <h2>Output:</h2>
 * The encoded message
 * 
 * <h2>Constraints:</h2>
 * 0 &lt; <b>N</b> &lt; 100
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 14, 2018
 */
import java.util.Scanner;

class Chuck_Norris {
    static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        String MESSAGE = in.nextLine();
        System.err.println("Msg: " + MESSAGE);

        StringBuilder bits = makeBitstream(MESSAGE);
        String output = parseBitstream(bits);

        System.out.println(output);
    }

    public static StringBuilder makeBitstream(String msg) {
        StringBuilder bits = new StringBuilder(7 * msg.length());

        for (int i = 0; i < msg.length(); i++) {
            StringBuilder tmp = new StringBuilder(Integer.toBinaryString(msg.charAt(i)));
            while (tmp.length() < 7) {
                tmp.insert(0, '0');
            }
            bits.append(tmp);
            System.err.println("Char " + i + ": " + tmp);
        }
        return bits;
    }

    public static String parseBitstream(StringBuilder bits) {
        StringBuilder output = new StringBuilder();
        char current = '2';
        int count = 0;
        for (int i = 0; i < bits.length(); i++) {
            if (bits.charAt(i) == current) count++;
            else {
                current = bits.charAt(i);
                for (int j = 0; j < count; j++)
                    output.append('0');
                output.append(' ');
                if (current == '1') output.append("0 ");
                else output.append("00 ");
                count = 1;
            }
        }
        for (int j = 0; j < count; j++)
            output.append('0');
        output.deleteCharAt(0);
        return output.toString();
    }
}
