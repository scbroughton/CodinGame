package codingame;

import java.util.Scanner;

/**
 * <h1>1&times;1&times;1 Rubik's Cube Movements</h1>
 *
 * <h2>Setting:</h2>
 * A 2&times;2&times;2 Rubik's cube is quite complicated. In this puzzle, we will focus on the mono-cube, the
 * 1&times;1&times;1 Rubik's cube!<br>
 * You are given a set of <b>rotations</b> and two <b>faces</b>. Apply the <b>rotations</b> to the cube and locate the
 * two <b>faces</b> after the rotations.
 * <h3>Face notation</h3>
 * <ul>
 * <li><i>F</i> (Front): the side currently facing the observer
 * <li><i>B</i> (Back): the side opposite the front
 * <li><i>U</i> (Up): the side above or on top of the front side
 * <li><i>D</i> (Down): the side opposite the top, underneath the cube
 * <li><i>L</i> (Left): the side directly to the left of the front
 * <li><i>R</i> (Right): the side directly to the right of the front
 * </ul>
 * 
 * <h3>Rotation notation</h3>
 * <ul>
 * <li>A rotation without the prime symbol <i>'</i> is a quarter turn clockwise.
 * <li>A rotation with the prime symbol <i>'</i> is a quarter turn counter-clockwise.
 * <li><i>x</i>, <i>x'</i>: rotate cube on <i>R</i> (<i>R</i> and <i>L</i> still face the same directions after
 * rotation)
 * <li><i>y</i>, <i>y'</i>: rotate cube on <i>U</i> (<i>U</i> and <i>D</i> still face the same directions after
 * rotation)
 * <li><i>z</i>, <i>z'</i>: rotate cube on <i>F</i> (<i>F</i> and <i>B</i> still face the same directions after
 * rotation)
 * </ul>
 * 
 * <h3>Example 1</h3>
 * <i>z</i><br>
 * <i>D</i><br>
 * <i>L</i><br>
 * Means: rotate cube clockwise on <i>F</i> and identify the new directions of <i>D</i> and <i>L</i>.<br>
 * Answer: Output <i>L</i> in line 1 because the initial down face now faces left. Output <i>U</i> in line 2 because the
 * initial left face now faces up.
 * 
 * <h3>Example 2</h3>
 * <i>z z'</i><br>
 * <i>U</i><br>
 * <i>R</i><br>
 * Means: rotate cube clockwise on <i>F</i> then counter-clockwise on <i>F</i>, and identify the new directions of
 * <i>U</i> and <i>R</i>.<br>
 * Answer: Output <i>U</i> in line 1 and <i>R</i> in line 2 because both faces do not change directions after the
 * rotations.
 * 
 * <h2>Input:</h2>
 * Line 1: Space-separated <b>rotations</b> in <i>xyz</i> notation.<br>
 * Line 2: Initial direction of <b>face1</b> the first queried face.<br>
 * Line 3: Initial direction of <b>face2</b> the second queried face.
 * 
 * <h2>Output:</h2>
 * Line 1: Direction of <b>face1</b> after the <b>rotations</b>.
 * Line 2: Direction of <b>face2</b> after the <b>rotations</b>.
 * 
 * <h2>Constraints:</h2>
 * 1 &le; length of <b>rotations</b> &le; 100
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 14, 2018
 */

class OneByOneByOneRubiksCubeMovements {
    static final int[] x = {2, 3, 1, 0, 4, 5};
    static final int[] xc = {3, 2, 0, 1, 4, 5};
    static final int[] y = {4, 5, 2, 3, 1, 0};
    static final int[] yc = {5, 4, 2, 3, 0, 1};
    static final int[] z = {0, 1, 5, 4, 2, 3};
    static final int[] zc = {0, 1, 4, 5, 3, 2};
    static final Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        final String[] rotations = in.nextLine().split(" ");
        final int face1 = faceToIndex(in.nextLine().charAt(0));
        final int face2 = faceToIndex(in.nextLine().charAt(0));
        System.out.println(rotate(rotations, face1));
        System.out.println(rotate(rotations, face2));
    }

    static char rotate(String[] rotations, int face) {
        String rotation = rotations[0];
        String[] newRotations = new String[rotations.length - 1];
        if (rotations.length > 1) for (int i = 1; i < rotations.length; i++)
            newRotations[i - 1] = rotations[i];
        boolean reverse = (rotation.contains("'"));
        switch (rotation.charAt(0)) {
            case 'x':
                if (reverse) face = xc[face];
                else face = x[face];
                break;
            case 'y':
                if (reverse) face = yc[face];
                else face = y[face];
                break;
            case 'z':
                if (reverse) face = zc[face];
                else face = z[face];
            default:
        }
        if (rotations.length == 1) return indexToFace(face);
        return rotate(newRotations, face);
    }

    static int faceToIndex(char c) {
        int i = 0;
        switch (c) {
            case 'B':
                i = 1;
                break;
            case 'U':
                i = 2;
                break;
            case 'D':
                i = 3;
                break;
            case 'L':
                i = 4;
                break;
            case 'R':
                i = 5;
            default:
        }
        return i;
    }

    static char indexToFace(int i) {
        char c = 'F';
        switch (i) {
            case 1:
                c = 'B';
                break;
            case 2:
                c = 'U';
                break;
            case 3:
                c = 'D';
                break;
            case 4:
                c = 'L';
                break;
            case 5:
                c = 'R';
            default:
        }
        return c;
    }
}