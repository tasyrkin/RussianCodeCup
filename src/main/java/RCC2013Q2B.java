import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with longelliJ IDEA. User: tasyrkin Date: 5/11/13 Time: 10:53 AM To change this template use File | Settings
 * | File Templates.
 */
public class RCC2013Q2B {

    private static class Pair {
        public Pair(final long ix, final long iy) {
            x = ix;
            y = iy;
        }

        long x;
        long y;

        public boolean contains(final Pair p) {
            return (x >= p.x && y >= p.y) || (x >= p.y && y >= p.x);
        }

        public List<List<Pair>> minus(final Pair p) {
            List<List<Pair>> result = new ArrayList<List<Pair>>();

            List<Pair> var1 = new ArrayList<Pair>();
            if (x - p.x > 0) {
                var1.add(new Pair(x - p.x, y));
            }

            if (y - p.y > 0) {
                var1.add(new Pair(x, y - p.y));
            }

            if (!var1.isEmpty()) {
                result.add(var1);
            }

            List<Pair> var2 = new ArrayList<Pair>();

            if (x - p.y > 0) {
                var2.add(new Pair(x - p.y, y));
            }

            if (y - p.x > 0) {
                var2.add(new Pair(x, y - p.x));
            }

            if (!var2.isEmpty()) {
                result.add(var2);
            }

            return result;
        }

        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(reader.readLine());

        label:
        for (long i = 0; i < n; i++) {

            String[] parts = reader.readLine().split("\\s+");
            long fx = Long.parseLong(parts[0]);
            long fy = Long.parseLong(parts[1]);
            Pair mp = new Pair(fx, fy);

            // System.out.print(mp);

            List<Pair> curr = new ArrayList<Pair>();
            curr.add(mp);

            boolean res = true;
            for (long j = 0; j < 3; j++) {

                parts = reader.readLine().split("\\s+");

                long cx = Long.parseLong(parts[0]);
                long cy = Long.parseLong(parts[1]);

                Pair ship = new Pair(cx, cy);

                // System.out.print(", " + ship);

                List<Pair> result = new ArrayList<Pair>();
                boolean atLeastInOne = false;
                for (Pair v : curr) {
                    if (v.contains(ship)) {
                        atLeastInOne = true;

                        List<List<Pair>> r = v.minus(ship);

                        for (List<Pair> r1 : r) {
                            result.addAll(r1);
                        }
                    }
                }

                curr = result;

                res &= atLeastInOne;
            }

            if (res) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }

    }

}
