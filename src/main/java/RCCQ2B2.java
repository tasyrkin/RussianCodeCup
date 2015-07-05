import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;


public class RCCQ2B2 {

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
		boolean[][]tort_nachinka = new boolean[n+1][m+1];
//		p = Integer.parseInt(br.readLine());
		int pcnt=Integer.parseInt(br.readLine());
		while(--pcnt>=0){
			String[] parts = br.readLine().split("\\s+");
			tort_nachinka[Integer.parseInt(parts[0])][Integer.parseInt(parts[1])] = true;
		}
		//int q = Integer.parseInt(br.readLine());
		int qcnt=Integer.parseInt(br.readLine());
		boolean[][]nachinka_morojenoe = new boolean[m+1][k+1];
		while(--qcnt>=0){
			String[] parts = br.readLine().split("\\s+");
			nachinka_morojenoe[Integer.parseInt(parts[0])][Integer.parseInt(parts[1])] = true;
		}
//		int r = Integer.parseInt(br.readLine());
		int rcnt=Integer.parseInt(br.readLine());
		boolean[][]tort_morojenoe = new boolean[n+1][k+1];
		while(--rcnt>=0){
			String[] parts = br.readLine().split("\\s+");
			tort_morojenoe[Integer.parseInt(parts[0])][Integer.parseInt(parts[1])] = true;
		}
		int cnt = 0;
		for(int ncnt = 1; ncnt <= n; ncnt++){
			for(int mcnt = 1; mcnt <= m; mcnt++){
				for(int kcnt = 1; kcnt <= k; kcnt++){					
					if(!tort_nachinka[ncnt][mcnt]&&
					   !nachinka_morojenoe[mcnt][kcnt]&&
					   !tort_morojenoe[ncnt][kcnt]){
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
