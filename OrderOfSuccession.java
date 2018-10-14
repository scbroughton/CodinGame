package codingame;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Vector;

class SiblingSorter implements Comparator<Node> {
    @Override
    public int compare(Node n1, Node n2) {
        if (n1.gender.equals(n2.gender)) return n1.birth - n2.birth;
        return (n1.gender.equals("M")) ? -1 : 1;
    }

    public static boolean equals(Node n1, Node n2) {
        return (n1.gender.equals(n2.gender) && n1.birth == n2.birth);
    }
}

class Node {
    public String name;
    public int birth;
    public boolean isAlive;
    public boolean isNotCatholic;
    public String gender;
    public Node leftChild = null;
    public Node rightSibling = null;

    Node(String name, int birth, String death, String religion, String gender) {
        this.name = name;
        this.birth = birth;
        this.isAlive = death.equals("-");
        this.isNotCatholic = !religion.equals("Catholic");
        this.gender = gender;
    }

    public String walk() {
        StringBuilder out = new StringBuilder();
        if (this.isAlive && this.isNotCatholic) out.append(this.name + "\n");
        if (this.leftChild != null) out.append(this.leftChild.walk());
        if (this.rightSibling != null) out.append(this.rightSibling.walk());
        return out.toString();
    }
}

/**
 * <h1>Class Name</h1>
 *
 * <p>
 *
 * You have to output the order of succession to the British throne of a list of given people. The order is simple:<br>
 * From a descendant A, the next in the order is A’s first child B.<br>
 * Then, the next one is B’s first child C if any and so on.<br>
 * If C has no child, then the next one is B’s second child D.<br>
 * Then D’s children if any. Then B’s third child E… then A’s second child F…
 * <p>
 * Let’s draw it with a tree:
 * 
 * <pre>
 *      A1
 *    ┌─┴─┐
 *    B2  F6
 * ┌──┼──┐
 * C3 D4 E5
 * </pre>
 * 
 * 
 * You see the order of succession: begin on the left of the tree, walk to the next level whenever possible otherwise
 * continue to the right. Repeat until the whole tree is covered. Thus, the order is A-B-C-D-E-F.
 * <p>
 * 
 * In fact, in siblings of the same person, the male descendants are ordered before the female descendants. For example,
 * if the order of birth of the children (M for male, F for female) is Fa Ma Me Fe then the order of succession in these
 * siblings is Ma Me Fa Fe.
 * <p>
 * 
 * <b>Ordering rules</b>
 * <ol type="a">
 * <li>in order of generation
 * <li>in order of gender
 * <li>in order of age (year of birth)
 * </ol>
 * 
 * <b>Outputting rules</b>
 * <ol type="a">
 * <li>exclude dead people
 * <li>exclude people who are catholic (but include siblings of catholic people)
 * </ol>
 * 
 * Note that this puzzle has been written in June, 2017 (some people might have died since this date).
 * 
 * <h2>Input</h2>
 * Line 1: The number of people <b>n</b><br>
 * Next <b>n</b> lines: <i>Name Parent Year of birth Year of death Religion Gender</i>
 * <p>
 * If the <i>people</i> is not dead then the year of death is replaced by the hyphen -.
 * 
 * <h2>Output</h2>
 * One name per line, in the order of succession to the throne: first the Queen, then all her descendants.
 * 
 * <h2>Constraints</h2>
 * Exactly one <i>people</i> does not have a parent (the parent’s name is replaced by the hyphen -).<br>
 * No two siblings of the same gender of a person have the same year of birth.<br>
 * 1 &le; <b>n</b> &le; 100
 * 
 * <hr>
 *
 *
 * @author Stephen Broughton
 * @since Oct 14, 2018
 */
public class OrderOfSuccession {
    @SuppressWarnings("javadoc")
    public static void main(String args[]) {
        Hashtable<String,Node> nodesByName = new Hashtable<>();
        Hashtable<String,Vector<Node>> childrenOf = new Hashtable<>();
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            String name = in.next();
            String parentName = in.next();
            int birth = in.nextInt();
            String death = in.next();
            String religion = in.next();
            String gender = in.next();
            if (!childrenOf.containsKey(parentName)) childrenOf.put(parentName, new Vector<Node>());
            nodesByName.put(name, new Node(name, birth, death, religion, gender));
            childrenOf.get(parentName).add(nodesByName.get(name));
        }
        for (String parent : childrenOf.keySet()) {
            if (parent.equals("-")) continue;
            childrenOf.get(parent).sort(new SiblingSorter());
            nodesByName.get(parent).leftChild = childrenOf.get(parent).get(0);
            for (int i = 1; i < childrenOf.get(parent).size(); i++) {
                childrenOf.get(parent).get(i - 1).rightSibling = childrenOf.get(parent).get(i);
            }
        }
        System.out.print(childrenOf.get("-").get(0).walk());

    }
}
