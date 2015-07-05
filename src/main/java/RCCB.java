import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RCCB {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		int n = -1;
		int m = -1;
		int[][] tarifs = null;
		int[] msgs = null;
		int cnt = 0;
		String[] parts = null;
		while(null != (line = br.readLine())){
			if(n == -1){
				parts = line.split("\\s+");
				n = Integer.parseInt(parts[0]);
				m = Integer.parseInt(parts[1]);
				tarifs = new int[n][3];
				msgs = new int[m];
				continue;
			}
			parts = line.split("\\s+");
			if(cnt<n){
				tarifs[cnt][0] = Integer.parseInt(parts[0]);
				tarifs[cnt][1] = Integer.parseInt(parts[1]);
				tarifs[cnt][2] = Integer.parseInt(parts[2]);
				cnt++;
			}
			else{
				for(int i = 0; i < m; i++){
					msgs[i] = Integer.parseInt(parts[i]);
				}
				break;
			}
		}
		int min = Integer.MAX_VALUE;
		int num = -1;
		for(int i = 0; i < tarifs.length; i++){
			int currCost = tarifs[i][0]*100;
			for(int j = 0; j < msgs.length; j++){
				if(tarifs[i][1]<=msgs[j]){
					if(msgs[j]%tarifs[i][1]==0){
						currCost+=(msgs[j]/tarifs[i][1])*tarifs[i][2];
					}
					else{
						currCost+=(msgs[j]/tarifs[i][1]+1)*tarifs[i][2];
					}
				}
			}
			if(min>currCost){
				min = currCost;
				num = i;
			}
		}
		System.out.println(num+1);
	}
}
