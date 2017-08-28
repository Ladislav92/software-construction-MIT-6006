package warmup;

import java.util.HashSet;
import java.util.Set;

public class Quadratic {

    /**
     * Find the integer roots of a quadratic equation, ax^2 + bx + c = 0.
     *
     * @param a coefficient of x^2
     * @param b coefficient of x
     * @param c constant term.  Requires that a, b, and c are not ALL zero.
     * @return all integers x such that ax^2 + bx + c = 0.
     */
    public static Set<Integer> roots(int a, int b, int c) {

        if (a == 0 && b == 0 && c == 0) {
            throw new IllegalArgumentException();
        }

        Set<Integer> rootSet = new HashSet<>();

        int discriminant = (b * b - 4 * a * c);   // b^2 - 4ac
        int solution1;
        int solution2;

        if (b == 0) {

            if (c / a < 0) {   // Fix for finding root if a or c are negative
                c = -c;
            }
            int solution = (int) Math.sqrt(c / a);
            solution1 = solution;
            solution2 = -solution;

        } else if (c == 0) {
            solution1 = 0;
            solution2 = -b / a;

        } else {
            int discriminantRoot = (int) Math.sqrt(discriminant);
            solution1 = (-b - discriminantRoot) / (2 * a);
            solution2 = (-b + discriminantRoot) / (2 * a);
        }

        if (discriminant == 0) {
            rootSet.add(solution1);
        } else {
            rootSet.add(solution1);
            rootSet.add(solution2);
        }

        return rootSet;
    }

    /**
     * Main function of program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        int r1 = 45_000; // a root ~45,000 means c is ~2,000,000,000, which is close to the maximum integer 2^31 - 1
        int r2 = -45_000;

        Set<Integer> result = Quadratic.roots(1, -r1 - r2, r1 * r2);
        System.out.println(result);
    }

    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     * Don't post any of this code on the web or to a public Github repository.
     */
}
