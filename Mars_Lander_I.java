package codingame;

import java.util.Scanner;
import java.util.Vector;

/**
 * <h1>Mars Lander - Episode 1</h1>
 *
 * <h2>Setting:</h2>
 * The goal for your program is to safely land the "Mars Lander" shuttle, the landing ship which contains the
 * Opportunity rover. Mars Lander is guided by a program, and right now the failure rate for landing on the NASA
 * simulator is unacceptable.
 * <p>
 * <b>Note that it may look like a difficult problem, but in reality the problem is easy to solve.</b> This puzzle is
 * the first level among three, therefore, we need to present you some controls you won't need in order to complete this
 * first level.
 * 
 * <h2>Rules:</h2>
 * Built as a game, the simulator puts Mars Lander on a limited zone of Mars sky.
 * <p>
 * The zone is 7000m wide and 3000m high.
 * <b>For this level,</b> Mars Lander is above the landing zone, in vertical position, with no initial speed.<br>
 * There is a <b>unique area of flat ground</b> on the surface of Mars, which is at least 1000 meters wide.
 * <p>
 * <b>Every second</b>, depending on the current flight parameters (location, speed, fuel ...), the program must provide
 * the new desired tilt angle and thrust power of Mars Lander:
 * <p>
 * Angle goes from -90&deg; to 90&deg;. Thrust power goes from 0 to 4.
 * <b>For this level</b>, you only need to control the thrust power: the tilt angle should be 0.
 * <p>
 * The game simulates a free fall without atmosphere. Gravity on Mars is 3.711 m/s² . For a <b>thrust power of X</b>, a
 * push force equivalent to <b>X m/s&sup2;</b> is generated and <b>X liters of fuel</b> are consumed. As such, a thrust
 * power of 4 in an almost vertical position is needed to compensate for the gravity on Mars.
 * <p>
 * For a landing to be successful, the ship must:
 * <ul>
 * <li>land on flat ground
 * <li>land in a vertical position (tilt angle = 0&deg;)
 * <li>vertical speed must be limited ( &le; 40m/s in absolute value)
 * <li>horizontal speed must be limited ( &le; 20m/s in absolute value)
 * </ul>
 * 
 * <b>Remember that this puzzle was simplified:</b>
 * <ul>
 * <li>the landing zone is just below the shuttle. You can therefore ignore rotation and always output 0 as the target
 * angle.
 * <li>you don't need to store the coordinates of the surface of Mars to succeed.
 * <li>you only need your vertical landing speed to be between 0 and 40m/s – your horizontal speed being nil.
 * <li>As the shuttle falls, the vertical speed is negative. As the shuttle flies upward, the vertical speed is
 * positive.
 * </ul>
 * 
 * <h2>Note:</h2>
 * For this first level, Mars Lander will go through <b>a single test</b>.
 * <p>
 * Tests and validators are only slightly different. <b>A program that passes a given test will pass the corresponding
 * validator</b> without any problem.
 * 
 * <h2>Input:</h2>
 * The program must first read the initialization data from standard input. Then, within an infinite loop, the program
 * must read the data from the standard input related to Mars Lander's current state and provide to the standard output
 * the instructions to move Mars Lander.
 * 
 * <h2>Initialization input:</h2>
 * Line 1: the number <b>surfaceN</b> of points used to draw the surface of Mars.<br>
 * Next <b>surfaceN</b> lines: a couple of integers <b>landX</b> &amp; <b>landY</b> providing the coordinates of a
 * ground point.
 * <p>
 * By linking all the points together in a sequential fashion, you form the surface of Mars which is
 * composed of several segments. For the first point, <b>landX</b> = 0 and for the last point, <b>landX</b> = 6999
 * 
 * <h2>Input for one game turn:</h2>
 * A single line with 7 integers: <b>X Y hSpeed vSpeed fuel rotate power</b>
 * <ul>
 * <li><b>X</b>,<b>Y</b> are the coordinates of Mars Lander (in meters).
 * <li><b>hSpeed</b> and <b>vSpeed</b> are the horizontal and vertical speed of Mars Lander (in m/s). These can be
 * negative depending on the direction of Mars Lander.
 * <li><b>fuel</b> is the remaining quantity of fuel in liters. When there is no more fuel, the power of thrusters falls
 * to zero.
 * <li><b>rotate</b> is the angle of rotation of Mars Lander expressed in degrees.
 * <li><b>power</b> is the thrust power of the landing ship.
 * </ul>
 * 
 * <h2>Output for one game turn:</h2>
 * A single line with 2 integers: <b>rotate</b> <b>power</b>:
 * <ul>
 * <li><b>rotate</b> is the desired rotation angle for Mars Lander. Please note that for each turn the actual value of
 * the angle is limited to the value of the previous turn +/- 15&deg;.
 * <li><b>power</b> is the desired thrust power. 0 = off. 4 = maximum power. Please note that for each turn the value of
 * the actual power is limited to the value of the previous turn +/- 1.
 * </ul>
 * 
 * <h2>Constraints:</h2>
 * 0 &le; <b>surfaceN</b> &lt; 30<br>
 * 0 &le; <b>X</b> &lt; 7000<br>
 * 0 &le; <b>Y</b> &lt; 3000<br>
 * -500 &lt; <b>hSpeed</b>,<b>vSpeed</b> &lt; 500<br>
 * 0 &le; <b>fuel</b> &le; 2000<br>
 * -90 &le; <b>rotate</b> &le; 90<br>
 * 0 &le; <b>power</b> &le; 4<br>
 * Reponse time per turn &le; 100ms
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 14, 2018
 */

class Tuple {
    public int X;
    public int Y;

    Tuple(int x, int y) {
        this.X = x;
        this.Y = y;
    }
}

class Line {
    private Tuple left, right;
    private float slope, intercept;

    Line(Tuple l, Tuple r) {
        this.left = l;
        this.right = r;
        this.slope = ((float) this.left.Y - (float) this.right.Y) / ((float) this.left.X - (float) this.right.X);
        this.intercept = this.left.Y - this.slope * this.left.X;
    }

    public int getAltitude(int X, int Y) {
        return Math.round(Y - (this.slope * X + this.intercept));
    }

    public boolean isBelow(int X) {
        if (X > this.right.X || X < this.left.X) return false;
        return true;
    }

    public boolean isFlat() {
        return this.slope == 0f;
    }
}

class Lander {
    private final float G = 3.711f;
    private final float safeDropSpeed = -40f;
    public int X; // Current X position of lander
    public int Y; // Current Y position of lander
    public int dx; // the horizontal speed (in m/s), can be negative.
    public int dy; // the vertical speed (in m/s), can be negative.
    public int fuel; // the quantity of remaining fuel in liters.
    public int angle; // the rotation angle in degrees (-90 to 90).
    public int thrust; // the thrust power (0 to 4).

    Lander(Scanner in) {
        this.X = in.nextInt();
        this.Y = in.nextInt();
        this.dx = in.nextInt();
        this.dy = in.nextInt();
        this.fuel = in.nextInt();
        this.angle = in.nextInt();
        this.thrust = in.nextInt();
    }

    public String getSafeSpeed() {
        float fdy = this.dy;
        float effectiveG = this.thrust - this.G;

        if (fdy + effectiveG > 0) return "0";
        if (fdy < this.safeDropSpeed + 3) return "4";
        return "0";
    }
}

class Mars_Lander_I {
    static int x, y, surfaceN, lastX, lastY, flat = 0;
    static Scanner in = new Scanner(System.in);
    static Vector<Line> surface = new Vector<>();

    public static void main(String args[]) {
        surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
        surfaceN--; // The number of lines that make up the surface.

        x = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
        y = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential
                          // fashion, you form the surface of Mars.

        Tuple left = new Tuple(x, y);
        for (int i = 0; i < surfaceN; i++) {
            x = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            y = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential
                              // fashion, you form the surface of Mars.
            Tuple right = new Tuple(x, y);
            surface.add(new Line(left, right));
            left = right;
            if (surface.get(i).isFlat()) flat = i;
        }

        Lander l = new Lander(in);
        System.out.println("0 0");
        lastX = l.X;
        lastY = l.Y;
        while (true) {
            Lander lander = new Lander(in);
            lander.dx = lander.X - lastX;
            lander.dy = lander.Y - lastY;
            System.out.println("0 " + lander.getSafeSpeed());
            lastX = lander.X;
            lastY = lander.Y;
        }
    }
}
