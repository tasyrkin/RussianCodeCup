import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.Set;

public class RCC2014Q2B {

    public static int K = 0;
    public static Pos[] dest = null;

    private static class Pos {
        int x, y;

        public Pos(final int ix, final int iy) {
            x = ix;
            y = iy;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pos pos = (Pos) o;

            if (x != pos.x) {
                return false;
            }

            if (y != pos.y) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] parts = br.readLine().split("\\s+");
            int n = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            K = Integer.parseInt(parts[2]);
            dest = null;

            Pos[] poss = new Pos[3];
            // poss[0] = new Pos(0, 0);

            solve2(0, poss, n, m);

            // solve(1, n - 1 + m - 1, poss, n, m);
            if (dest != null) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < dest.length; j++) {
                    if (sb.length() > 0) {
                        sb.append(" ");
                    }

                    sb.append(dest[j].x + " " + dest[j].y);
                }

                System.out.println(sb.toString());
            } else {
                System.out.println("IMPOSSIBLE");
            }

        }
    }

    private static void solve2(final int pos, final Pos[] poss, final int n, final int m) {

        if (pos == 3) {
            Set<Integer> xs = new HashSet<Integer>();
            Set<Integer> ys = new HashSet<Integer>();
            for (int i = 0; i < poss.length; i++) {
                xs.add(poss[i].x);
                xs.add(poss[i].y);
            }

        }

    }

    private static void solve(final int pos, final long count, final Pos[] poss, final int n, final int m) {
        if (pos == 3) {
            if (count == K) {
                dest = new Pos[3];
                for (int i = 0; i < poss.length; i++) {
                    dest[i] = new Pos(poss[i].x, poss[i].y);
                }
            }

            return;
        }

        if (pos == 1) {
            if (m > 1) {
                Pos p = new Pos(0, 1);
                poss[pos] = p;
                solve(pos + 1, count + m - 1, poss, n, m);
            }

            if (m > 1 && n > 1) {
                Pos p = new Pos(1, 1);
                poss[pos] = p;
                solve(pos + 1, count + m - 2 + n - 2, poss, n, m);
            }

            if (n > 1) {
                Pos p = new Pos(1, 0);
                poss[pos] = p;
                solve(pos + 1, count + n - 1, poss, n, m);
            }
        } else if (pos == 2) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i < n && j < m) {
                        boolean free = true;
                        for (int k = 0; k < pos; k++) {
                            if (poss[k].x == i && poss[k].y == j) {
                                free = false;
                                break;
                            }
                        }

                        if (free) {
                            int cx = 0;
                            int cy = 0;

                            for (int k = 0; k < pos; k++) {
                                if (poss[k].x == i) {
                                    cx++;
                                }

                                if (poss[k].y == j) {
                                    cy++;
                                }
                            }

                            Pos p = new Pos(i, j);
                            poss[pos] = p;

                            int cntm = 0;
                            if (cx == 0) {
                                if (poss[0].x == poss[1].x) {
                                    cntm = m - 2;
                                } else {
                                    cntm = m - 3;
                                }
                            }

                            int cntn = 0;
                            if (cy == 0) {
                                if (poss[0].y == poss[1].y) {
                                    cntn = n - 2;
                                } else {
                                    cntn = n - 3;
                                }
                            }

                            solve(pos + 1, count + cntm + cntn, poss, n, m);
                        }
                    }
                }
            }
        }

    }
}
