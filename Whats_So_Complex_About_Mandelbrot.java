package codingame;

import java.util.Scanner;

/**
 * <h1>What's So Complex About Mandelbrot?</h1>
 *
 * <h2>Setting:</h2>
 * The Mandelbrot Set is the most well known set of complex numbers with fractal properties.<br>
 * Members of the set are the complex numbers <b>c</b> such that the absolute value of the equation f(n) &equals;
 * f(n&minus;1)&sup2; &plus; c does not diverge as n approaches infinity, with f(0) &equals; 0.<br>
 * One property of this equation is that if its absolute value ever becomes larger than 2, we can be confident that it
 * will diverge and therefore conclude that c is not in the set. However, an absolute value less than 2 does not
 * guarantee that it will not diverge. Only additional iterations of the equation can help determine that.<br>
 * Since the equation will never diverge for numbers in the set, we would run an infinite number of iterations if we
 * only stopped based on the absolute value. Therefore, we select another number, <b>m</b>, and give up after running
 * <b>m</b> iterations of the equation. Higher values of <b>m</B> could have given us greater confidence that our number
 * is in the set, but we don't have infinite time so we have to draw a line somewhere.<br>
 * For this puzzle, you will need to determine how many iterations are necessary to decide if a given complex number
 * <b>c</b> is in the Mandelbrot set, using the absolute value heuristic described above, and given a maximum number of
 * iterations <b>m</b>.
 * 
 * <h2>Input:</h2>
 * Line 1: The complex number to evaluate <b>c</b> represented as (<b>x</b>&plus;<b>y</b><i>i</i>) where <b>x</b> and
 * <b>y</b> are floating point values. If <b>y</b> is negative, the &plus; will become a &minus;.<br>
 * Line 2: An integer <b>m</b> indicating the maximum number of iterations to evaluate.
 * 
 * <h2>Output:</h2>
 * Line 1 : An integer <b>i</b> indicating how many times you need to iterate to determine if the complex number
 * <b>c</b> is in the Mandelbrot set or not.
 * 
 * <h2>Constraints:</h2>
 * length(<b>c</b>) &lt; 30<br>
 * &minus;5 &lt; <b>x</b>, <b>y</b> &lt; 5<br>
 * 0 &lt; <b>m</b> &lt; 1000<br>
 * 0 &lt; <b>i</b> &le; <b>m</b>
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 14, 2018
 */

class Whats_So_Complex_About_Mandelbrot {
    static class Complex {
        public double r;
        public double i;

        Complex(double r, double i) {
            this.r = r;
            this.i = i;
        }

        Complex(String s) {
            if (s.contains("+")) {
                this.r = Double.parseDouble(s.substring(0, s.indexOf('+')));
                this.i = Double.parseDouble(s.substring(s.indexOf('+') + 1, s.length() - 1));
            } else {
                this.r = Double.parseDouble(s.substring(0, s.indexOf('-', 1)));
                this.i = Double.parseDouble(s.substring(s.indexOf('-', 1), s.length() - 1));
            }
        }

        public static Complex add(Complex a, Complex b) {
            return new Complex(a.r + b.r, a.i + b.i);
        }

        public static Complex multiply(Complex a, Complex b) {
            return new Complex(a.r * b.r - a.i * b.i, a.r * b.i + a.i * b.r);
        }

        public static Complex conjugate(Complex a) {
            return new Complex(a.r, -1d * a.i);
        }

        public double squareMagnitude() {
            return multiply(this, conjugate(this)).r;
        }
    }

    static final Scanner in = new Scanner(System.in);
    static final Complex c = new Complex(in.nextLine());
    static final int m = in.nextInt();
    static Complex z = new Complex(0d, 0d);

    public static void main(String args[]) {
        int i = 1;
        for (; i < m; i++) {
            z = Complex.add(Complex.multiply(z, z), c);
            if (z.squareMagnitude() > 4d) break;
        }
        System.out.println(i);
    }
}