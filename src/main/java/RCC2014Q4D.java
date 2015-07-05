import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RCC2014Q4D {

    private static int[] rank;
    private static int[] parent;

    private static class TmpNode {
        Node node;
        int deep;

        public TmpNode(final Node inode, final int ideep) {
            node = inode;
            deep = ideep;
        }
    }

    private static class Node {
        int id;
        HashSet<Node> nodes = new HashSet<Node>();

        public Node(final int iid) {
            id = iid;
        }

        public void addNode(final Node n) {
            nodes.add(n);
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Node node = (Node) o;

            if (id != node.id) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split("\\s+");
        int[] ps = new int[n];
        Node[] ns = new Node[n];
        rank = new int[n];
        parent = new int[n];

        Set<Integer> roots = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            ps[i] = Integer.parseInt(parts[i]) - 1;
            ns[i] = new Node(i);
            if (i == ps[i]) {
                roots.add(i);
            }

            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            if (roots.contains(i)) {
                continue;
            }

            Node parent = ns[ps[i]];
            Node curr = ns[i];
            parent.addNode(curr);
        }

        if (roots.isEmpty()) {
            System.out.println(-1);
            return;
        }

        int childrenNum = 0;
        for (Integer root : roots) {
            Queue<TmpNode> q = new LinkedList<TmpNode>();
            q.add(new TmpNode(ns[root], 0));

            Set<Integer> visited = new HashSet<Integer>();
            while (!q.isEmpty()) {
                TmpNode curr = q.poll();
                if (visited.contains(curr.node.id)) {
                    System.out.println(-1);
                    return;
                }

                visited.add(curr.node.id);

                for (Node child : curr.node.nodes) {
                    childrenNum++;
                    if (visited.contains(child.id)) {
                        System.out.println(-1);
                        return;
                    }

                    q.add(new TmpNode(child, curr.deep + 1));
                }
            }
        }

        for (Integer root : roots) {
            Queue<TmpNode> q = new LinkedList<TmpNode>();
            q.add(new TmpNode(ns[root], 0));

            while (!q.isEmpty()) {
                TmpNode curr = q.poll();

                for (Node child : curr.node.nodes) {
                    childrenNum++;

                    // System.out.println((curr.node.id + 1) + " " + (child.id + 1));
                    union(curr.node.id, child.id);
                    q.add(new TmpNode(child, curr.deep + 1));

                }
            }
        }

        System.out.println(childrenNum);
        for (int i = 0; i < n; i++) {
            if (parent[i] != ps[i]) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(Arrays.toString(parent));

        for (Integer root : roots) {
            Queue<TmpNode> q = new LinkedList<TmpNode>();
            q.add(new TmpNode(ns[root], 0));

            while (!q.isEmpty()) {
                TmpNode curr = q.poll();

                for (Node child : curr.node.nodes) {
                    childrenNum++;

                    System.out.println((curr.node.id + 1) + " " + (child.id + 1));
                    q.add(new TmpNode(child, curr.deep + 1));
                }
            }
        }

    }

    private static void union(final int a, final int b) {
        if (rank[a] == rank[b]) {
            rank[a] = rank[a] + 1;
        }

        if (rank[a] > rank[b]) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
