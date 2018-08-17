package codingame;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

/**
 * <h1>ASCII Art</h1>
 *
 * <h2>Setting:</h2>
 * In stations and airports you often see this type of screen:
 * <p>
 * Have you ever asked yourself how it might be possible to simulate this display on a good old terminal? We have: with
 * ASCII art!
 * 
 * <h3>Rules:</h3>
 * ASCII art allows you to represent forms by using characters. To be precise, in our case, these forms are words. For
 * example, the word "MANHATTAN" could be displayed as follows in ASCII art:
 * 
 * <pre>
 * # #  #  ### # #  #  ### ###  #  ###
 * ### # # # # # # # #  #   #  # # # #
 * ### ### # # ### ###  #   #  ### # #
 * # # # # # # # # # #  #   #  # # # #
 * # # # # # # # # # #  #   #  # # # #
 * </pre>
 * 
 * Your mission is to write a program that can display a line of text in ASCII art in a style you are given as input.
 * 
 * <h2>Input:</h2>
 * Line 1: the width <b>L</b> of a letter represented in ASCII art. All letters are the same width.<br>
 * Line 2: the height <b>H</b> of a letter represented in ASCII art. All letters are the same height.<br>
 * Line 3: The line of text <b>T</b>, composed of <b>N</b> ASCII characters.<br>
 * Following lines: the string of characters <i>ABCDEFGHIJKLMNOPQRSTUVWXYZ?</i> Represented in ASCII art.<br>
 * 
 * <h2>Output:</h2>
 * The text <b>T</b> in ASCII art.<br>
 * The characters a to z are shown in ASCII art by their equivalent in upper case.<br>
 * The characters that are not in the intervals [a&minus;z] or [A&minus;Z] will be shown as a question mark in ASCII
 * art.
 * 
 * <h2>Constraints:</h2>
 * 0 &lt; <b>L</b> &lt; 30<br>
 * 0 &lt; <b>H</b> &lt; 30<br>
 * 0 &lt; <b>N</b> &lt; 200<br>
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 14, 2018
 */

class ASCII_Art {
    static final String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?";
    static Scanner in = new Scanner(System.in);
    static String l;
    static Character c;
    static Vector<HashMap<Character,String>> bigAlpha = new Vector<>();

    public static void main(String args[]) {
        int W = in.nextInt();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine().toUpperCase().replaceAll("[^A-Z]", "?");

        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            System.err.println(ROW);
            HashMap<Character,String> line = new HashMap<>();
            for (int j = 0; j < 27; j++)
                line.put(new Character(alpha.charAt(j)), ROW.substring(W * j, W * (j + 1)));
            bigAlpha.add(line);
        }

        for (int i = 0; i < H; i++) {
            l = "";
            for (int j = 0; j < T.length(); j++)
                l += bigAlpha.get(i).get(new Character(T.charAt(j)));
            System.out.println(l);
        }
    }
}
