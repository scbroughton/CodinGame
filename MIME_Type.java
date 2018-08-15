package codingame;

/**
 * <h1>MIME Type</h1>
 *
 * <h2>Setting:</h2>
 * MIME types are used in numerous internet protocols to associate a media type (html, image, video ...) with the
 * content sent. The MIME type is generally inferred from the extension of the file to be sent.<br>
 * You have to write a program that makes it possible to detect the MIME type of a file based on its name.
 * 
 * <h3>Rules:</h3>
 * You are provided with a table which associates MIME types to file extensions. You are also given a list of names of
 * files to be transferred and for each one of these files, you must find the MIME type to be used.
 * <p>
 * The extension of a file is defined as the substring which follows the last occurrence, if any, of the dot character
 * within the file name.<br>
 * If the extension for a given file can be found in the association table (case insensitive, e.g. TXT is treated the
 * same way as txt), then print the corresponding MIME type. If it is not possible to find the MIME type corresponding
 * to a file, or if the file doesn’t have an extension, print <i>UNKNOWN</i>.
 * 
 * <h2>Input:</h2>
 * Line 1: Number <b>N</b> of elements which make up the association table.<br>
 * Line 2: Number <b>Q</b> of file names to be analyzed.<br>
 * <b>N</b> following lines: One file extension per line and the corresponding MIME type (separated by a blank
 * space).<br>
 * <b>Q</b> following lines: One file name per line.
 * 
 * <h2>Output:</h2>
 * For each of the <b>Q</b> filenames, display on a line the corresponding MIME type. If there is no corresponding type,
 * then display <i>UNKNOWN</i>.
 * 
 * <h2>Constraints:</h2>
 * 0 &lt; <b>N</b> &lt; 10000
 * 0 &lt; <b>Q</b> &lt; 10000
 * 
 * <ul>
 * <li>File extensions are composed of a maximum of 10 alphanumerical ASCII characters.
 * <li>MIME types are composed of a maximum 50 alphanumerical and punctuation ASCII characters.
 * <li>File names are composed of a maximum of 256 alphanumerical ASCII characters and dots (full stops).
 * <li>There are no spaces in the file names, extensions or MIME types.
 * </ul>
 * 
 * <p>
 *
 * @author Stephen Broughton
 * @since Aug 14, 2018
 */
import java.util.Hashtable;
import java.util.Scanner;

class MIME_Type {
    static Scanner in = new Scanner(System.in);
    static Hashtable<String,String> mime = new Hashtable<String,String>();

    public static void main(String args[]) {
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            mime.put(EXT.toLowerCase(), MT);
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            System.err.println(FNAME);
            String ext = FNAME.substring(FNAME.lastIndexOf(".") + 1).toLowerCase();
            if (mime.containsKey(ext) && FNAME.contains(".")) System.out.println(mime.get(ext));
            else System.out.println("UNKNOWN");
        }

    }
}
