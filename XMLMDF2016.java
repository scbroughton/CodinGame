package codingame;

import java.util.Scanner;

/**
 * <h1>XML MDF-2016</h1>
 *
 * <h2>Setting:</h2>
 * In this challenge, a data format that is a simplified version of XML is used. Tags are identified by a lowercase
 * letter. A start tag is represented by that single letter, and the closing tag is represented by the &minus;
 * character, followed by that letter.
 * <br>
 * For example, the string "ab&minus;bcd&minus;d&minus;c&minus;ae&minus;e" is the equivalent of &lt;a&gt; &lt;b&gt;
 * &lt;/b&gt; &lt;c&gt; &lt;d&gt; &lt;/d&gt; &lt;/c&gt; &lt;/a&gt; &lt;e&gt; &lt;/e&gt; in XML. The supplied string will
 * always be properly formed.
 * <br>
 * Now we define the depth of a tag as 1 + the number of tags in which it is nested.
 * <br>
 * In the previous example:
 * <ul>
 * <li>a and e have a depth of 1
 * <li>b and c have a depth of 2
 * <li>d has a depth of 3
 * </ul>
 * The weight of a tag name is defined as the sum of the reciprocals of the depths of each of its occurrences.
 * <br>
 * For example, in the chain a&minus;abab&minus;b&minus;a&minus;b, there are:
 * <ul>
 * <li>Two tags a with depths of 1 and 2
 * <li>Two tags b with depths of 1 and 3.
 * </ul>
 * thus the weight of a is (1/1) + (1/2) = 1.5 and the weight of b is (1/1) + (1/3) = 1.33.
 * <br>
 * In this challenge you must determine the letter of the tag with the greatest weight in the string argument.
 * 
 * <h2>Input:</h2>
 * On a single line, a properly formed string of at most 1024 characters representing nested tags.
 * 
 * <h2>Output:</h2>
 * The letter corresponding to greatest weight tag name. If two tag names have the same weight, display the smallest in
 * alphabetical order.
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 14, 2018
 */

class XMLMDF2016 {
    static final Scanner in = new Scanner(System.in);
    static final String sequence = in.nextLine();

    public static void main(String args[]) {
        char tag = 'a';
        int depth = 0;
        double maxWeight = 0.0d;
        char maxTag = 'a';
        double[] tagWeight = new double[26];

        for (int i = 0; i < 26; i++)
            tagWeight[i] = 0.0d;

        for (int i = 0; i < sequence.length(); i++) {
            if ( (tag = sequence.charAt(i)) == '-') {
                i++;
                depth--;
                continue;
            }
            depth++;
            tagWeight[tag - 'a'] += 1.0d / depth;
        }

        for (int i = 0; i < 26; i++) {
            if (tagWeight[i] > maxWeight) {
                maxWeight = tagWeight[i];
                maxTag = (char) (i + 'a');
            }
        }
        System.out.println(maxTag);
    }
}