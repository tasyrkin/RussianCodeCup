import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;


public class RCCQ2B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = -1,m=-1,k=-1;
		String line = null;
		while(null != (line =br.readLine())){
			if(n==-1){
				String[]parts = line.split("\\s+");
				n = Integer.parseInt(parts[0]);
				m = Integer.parseInt(parts[1]);
				k = Integer.parseInt(parts[2]);
				break;
			}			
		}
//		p = Integer.parseInt(br.readLine());
		int pcnt=Integer.parseInt(br.readLine());
		HashMap<Integer, HashSet<Integer>> tort_nachinka = new HashMap<Integer, HashSet<Integer>>();
		while(--pcnt>=0){
			String[] parts = br.readLine().split("\\s+");
			HashSet<Integer> set = tort_nachinka.get(Integer.parseInt(parts[0])); 
			if(set==null){
				set = new HashSet<Integer>();				
			}
			set.add(Integer.parseInt(parts[1]));
			tort_nachinka.put(Integer.parseInt(parts[0]), set);
		}
		//int q = Integer.parseInt(br.readLine());
		int qcnt=Integer.parseInt(br.readLine());
		HashMap<Integer, HashSet<Integer>> nachinka_morojenoe = new HashMap<Integer, HashSet<Integer>>();
		while(--qcnt>=0){
			String[] parts = br.readLine().split("\\s+");
			HashSet<Integer> set = nachinka_morojenoe.get(Integer.parseInt(parts[0]));
			if(set==null){
				set = new HashSet<Integer>();
			}
			set.add(Integer.parseInt(parts[1]));
			nachinka_morojenoe.put(Integer.parseInt(parts[0]), set);			
		}
//		int r = Integer.parseInt(br.readLine());
		int rcnt=Integer.parseInt(br.readLine());
		HashMap<Integer, HashSet<Integer>> morojenoe_tort = new HashMap<Integer, HashSet<Integer>>();
		while(--rcnt>=0){
			String[] parts = br.readLine().split("\\s+");
			HashSet<Integer> set = morojenoe_tort.get(Integer.parseInt(parts[0]));
			if(set==null){
				set = new HashSet<Integer>();
			}
			set.add(Integer.parseInt(parts[1]));
			morojenoe_tort.put(Integer.parseInt(parts[0]), set);
		}
		int cnt = 0;
		for(int ncnt = 1; ncnt <= n; ncnt++){
			for(int mcnt = 1; mcnt <= m; mcnt++){
				for(int kcnt = 1; kcnt <= k; kcnt++){					
					if((tort_nachinka.get(ncnt)==null||!tort_nachinka.get(ncnt).contains(mcnt))&&
					   (nachinka_morojenoe.get(mcnt)==null||!nachinka_morojenoe.get(mcnt).contains(kcnt))&&
					   (morojenoe_tort.get(kcnt)==null||!morojenoe_tort.get(kcnt).contains(ncnt))){
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
