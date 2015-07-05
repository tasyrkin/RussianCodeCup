import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class RCCQ3B {

	public static class Pair{
		int i;
		int j;
		public Pair(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int h = -1,w=-1;
		String line = null;
		int cnt = 0;
		char[][]charray = null;
		while(null != (line =br.readLine())){
			if(h==-1){
				String[]parts = line.split("\\s+");
				w = Integer.parseInt(parts[0]);
				h = Integer.parseInt(parts[1]);
				charray = new char[h][w];
				continue;
			}
			char[]ch  = line.toCharArray();
			for(int i = 0; i < ch.length; i++){
				charray[cnt][i] = ch[i];
			}
			if(++cnt>=h)break;
		}
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(0,0));
//		array[0][0] = 1;
		HashSet<String> set = new HashSet<String>();
		HashSet<String> traversed = new HashSet<String>();
		int res = 0;
		while(!queue.isEmpty()){
			Pair p = queue.poll();
			if(p.i+1<h){
				int forw = (p.i+1);
				String key = (p.i + "," + p.j) + ":" + (forw + "," + p.j);
				if(!traversed.contains(forw + "," + p.j)){
					traversed.add(forw + "," + p.j);
					queue.add(new Pair(p.i+1,p.j));
				}
				if(!set.contains(key)&&charray[p.i+1][p.j]!=charray[p.i][p.j]){
//					System.out.println(key);
					set.add(key);
					res++;
				}			
			}
			if(p.j+1<w){
				int forw = p.j+1; 
				String key = (p.i + "," + p.j) + ":" + (p.i + "," + forw);
				if(!traversed.contains(p.i + "," + forw)){
					queue.add(new Pair(p.i,p.j+1));
					traversed.add(p.i + "," + forw);
				}
				if(!set.contains(key)&&charray[p.i][p.j+1]!=charray[p.i][p.j]){
//					System.out.println(key);
					set.add(key);
					res++;
				}				
			}
		}
		System.out.println(res);
	}
	
}
