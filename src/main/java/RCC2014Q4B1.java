import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RCC2014Q4B1 {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        main:
        while (n-- > 0) {
            String[] parts = br.readLine().split("\\s+");
            int k = Integer.parseInt(parts[0]);
            char[] num = parts[1].toCharArray();
            int cnt = 0;
            for (int i = num.length - 1; i >= 0; i--) {
                if (num[i] == '0' && cnt < 2) {
                    cnt++;
                    continue;
                }

                if (k == 0) {
                    if (cnt == 2) {
                        System.out.println(new String(num, 0, i + 1) + "00");
                    } else {
                        System.out.println(-1);
                    }

                    continue main;
                } else {
                    k--;
                }
            }

            if (k == 0) {
                if (cnt == 1) {
                    System.out.println(0);
                } else {
                    System.out.println(-1);
                }
            } else {
                System.out.println(-1);
            }
        }
    }
}
