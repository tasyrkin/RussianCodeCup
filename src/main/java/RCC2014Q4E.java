import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RCC2014Q4E {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] parts = br.readLine().split("\\s+");
            int n = Integer.parseInt(parts[0]);
            int can = Integer.parseInt(parts[1]);
            int dont = Integer.parseInt(parts[2]);

            int min = Math.max(can - dont, 0);
            int diff = Math.max(dont - (n - can), 0);
            int max = can - diff;
            System.out.println(min + " " + max);
        }

    }
}
