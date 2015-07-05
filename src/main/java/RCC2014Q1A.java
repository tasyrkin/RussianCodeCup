import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RCC2014Q1A {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.parseInt(br.readLine().trim());
        int init = t;
        while (t-- > 0) {

            boolean isGood = false;
            int n = Integer.parseInt(br.readLine().trim());
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] ps = br.readLine().split("\\s+");
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(ps[j]);
                    if (a[i][j] == 0) {
                        isGood = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j - 1 > 0) {
                        if (a[i][j] == a[i][j - 1]) {
                            isGood = true;
                        }
                    }

                    if (i - 1 > 0) {
                        if (a[i][j] == a[i - 1][j]) {
                            isGood = true;
                        }
                    }

                }

            }

            System.out.println(isGood ? "YES" : "NO");
        }
    }
}
