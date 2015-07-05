import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA. User: tasyrkin Date: 5/11/13 Time: 10:53 AM To change this template use File | Settings |
 * File Templates.
 */
public class RCC2013Q2A {
    public static void main(final String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            char[] line = reader.readLine().toCharArray();
            int cnt = 0;
            for (int j = 0; j < line.length;) {
                if (line[j] == 'b') {
                    ++cnt;
                    while (j < line.length && line[j] == 'b') {
                        j++;
                    }
                } else {
                    j++;
                }
            }

            if (cnt > 0) {
                --cnt;
            }

            if (line[0] == 'b' && line[line.length - 1] == 'b') {
                if (cnt > 0) {
                    --cnt;
                }
            }

            System.out.println(cnt);
        }

    }
}
