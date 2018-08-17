package codingame;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * <h1>How Time Flies</h1>
 *
 * <h2>Setting:</h2>
 * Your program must print formatted string with the number of full years and full months (if there are any greater than
 * 0) and the total number of days between BEGIN and END dates in dd.mm.yyyy format.
 * <h3>Example 1:</h3>
 * <b>Input:</b><br>
 * 01.01.2000<br>
 * 01.01.2016<br>
 * <b>Output:</b><br>
 * 16 years, total 5844 days
 * <h3>Example 2:</h3>
 * <b>Input:</b><br>
 * 15.12.2014<br>
 * 14.02.2016<br>
 * <b>Output:</b><br>
 * 1 year, 1 month, total 426 days
 * <h3>Example 3:</h3>
 * <b>Input:</b><br>
 * 01.01.2016<br>
 * 18.08.2016<br>
 * <b>Output:</b><br>
 * 7 months, total 230 days
 * 
 * <h2>Input:</h2>
 * Line 1: A date <b>BEGIN</b> in dd.mm.yyyy format.
 * Line 2: A date <b>END</b> in dd.mm.yyyy format.
 * 
 * <h2>Output:</h2>
 * Line 1 : Formatted string presenting date difference.
 * 
 * <h2>Constraints:</h2>
 * <b>BEGIN</b> &le; <b>END</b>
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 14, 2018
 */

class How_Time_Flies {
    static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    static final String[] unit = {" year", " month"};
    static final Scanner in = new Scanner(System.in);

    public static void main(String args[]) {
        String BEGIN = in.next();
        String END = in.next();

        LocalDate begin = LocalDate.parse(BEGIN, format);
        LocalDate end = LocalDate.parse(END, format);
        Period diff = Period.between(begin, end).normalized();

        long[] num = {diff.getYears(), diff.getMonths(), ChronoUnit.DAYS.between(begin, end)};

        for (int i = 0; i < 2; i++)
            if (num[i] > 0) System.out.print(num[i] + unit[i] + ( (num[i] > 1) ? "s, " : ", "));
        System.out.print("total " + num[2] + " days");
    }
}