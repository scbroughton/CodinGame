package codingame;

/**
 * <h1>Defibrillators</h1>
 *
 * <h2>Setting:</h2>
 * The city of Montpellier has equipped its streets with defibrillators to help save victims of cardiac arrests. The
 * data corresponding to the position of all defibrillators is available online. Based on the data we provide in the
 * tests, write a program that will allow users to find the defibrillator nearest to their location using their mobile
 * phone.
 * 
 * <h3>Rules:</h3>
 * The input data you require for your program is provided in text format.<br>
 * This data is comprised of lines, each of which represents a defibrillator. Each defibrillator is represented by the
 * following fields:
 * <ol>
 * <li>A number identifying the defibrillator
 * <li>Name
 * <li>Address
 * <li>Contact Phone number
 * <li>Longitude (degrees)
 * <li>Latitude (degrees)
 * </ol>
 * These fields are separated by a semicolon (;).<br>
 * <i>Beware:</i> the decimal numbers use the comma (,) as decimal separator. Remember to turn the comma (,) into dot
 * (.) if necessary in order to use the data in your program.
 * 
 * <h3>DISTANCE</h3>
 * The distance <b>d</b> between two points A and B will be calculated using the following formula:<br>
 * <ul>
 * <li>x = (B<sub>long</sub>&minus;A<sub>long</sub>)&times;cos((A<sub>lat</sub>&plus;B<sub>lat</sub>)&divide;2)
 * <li>y =
 * <li>d = &radic;(x&sup2;&plus;y&sup2;)&times;6371
 * </ul>
 * <i>Note:</i> In this formula, the latitudes and longitudes are expressed in radians. 6371 corresponds to the radius
 * of the earth in km.<br>
 * The program will display the name of the defibrillator located the closest to the user’s position. This position is
 * given as input to the program.
 * 
 * <h2>Input:</h2>
 * Line 1: User's longitude (in degrees)
 * Line 2: User's latitude (in degrees)
 * Line 3: The number <b>N</b> of defibrillators located in the streets of Montpellier
 * <b>N</b> next lines: a description of each defibrillator
 * 
 * <h2>Output:</h2>
 * The name of the defibrillator located the closest to the user’s position.
 * 
 * <h2>Constraints:</h2>
 * 0 &lt; <b>N</b> &lt; 10000
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 14, 2018
 */
import java.util.Scanner;

class Defibrillators {
    static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        double bestDist = Double.MAX_VALUE;
        String bestName = "None";
        Double LON = new Double(in.next().replace(',', '.'));
        Double LAT = new Double(in.next().replace(',', '.'));
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine().replace(',', '.');
            int i1 = DEFIB.lastIndexOf(";");
            int i2 = DEFIB.lastIndexOf(";", i1 - 1) + 1;
            Double lat = new Double(DEFIB.substring(i1 + 1));
            Double lon = new Double(DEFIB.substring(i2, i1));
            double x = (LON.doubleValue() - lon.doubleValue()) * Math.cos( (LAT.doubleValue() + lat.doubleValue()) / 2);
            double y = LAT.doubleValue() - lat.doubleValue();
            double dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            if (dist < bestDist) {
                bestDist = dist;
                i1 = DEFIB.indexOf(";") + 1;
                i2 = DEFIB.indexOf(";", i1);
                bestName = DEFIB.substring(i1, i2);
            }
        }

        System.out.println(bestName);
    }
}
