import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RCC2014Q1C {

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] ps = br.readLine().split("\\s+");
            Map<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(ps[i]);
                LinkedList<Integer> l = map.get(num);
                if (l == null) {
                    l = new LinkedList<Integer>();
                }

                l.addFirst(i);
                map.put(num, l);
            }

            int[] arr = new int[n];
            int cnt = 0;
            Integer[] keys = map.keySet().toArray(new Integer[0]);
            Arrays.sort(keys);
            for (Integer k : keys) {
                List<Integer> l = map.get(k);
                for (Integer idx : l) {
                    arr[idx] = ++cnt;
                }
            }

            System.out.println(Arrays.toString(arr).replace(",", "").replace("[", "").replace("]", ""));
        }
    }
}
