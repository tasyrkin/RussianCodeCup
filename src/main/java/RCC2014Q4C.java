import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;

public class RCC2014Q4C {

    private static class Node {
        int id;
        LinkedList<Integer> presents = new LinkedList<Integer>();

        public Node(final int id) {
            this.id = id;
        }

        public Integer getPresent() {
            if (presents.isEmpty()) {
                return id;
            } else {
                return presents.removeFirst();
            }
        }

        public void takePresent(final int present) {
            presents.add(present);
        }
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] parts = br.readLine().split("\\s+");
            int n = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            Node[] nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(i);
            }

            for (int i = 0; i < m; i++) {
                parts = br.readLine().split("\\s+");

                int from = Integer.parseInt(parts[0]) - 1;
                int to = Integer.parseInt(parts[1]) - 1;
                int present = nodes[from].getPresent();
                if (present == to) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }

                nodes[to].takePresent(present);
            }
        }

    }
}
