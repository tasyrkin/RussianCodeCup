import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;


public class RCCQ3D {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = -1,P=-1;
		String line = null;
		int[] mass = null;
		while(null != (line =br.readLine())){
			if(n==-1){
				String[]parts = line.split("\\s+");
				n = Integer.parseInt(parts[0]);
				P = Integer.parseInt(parts[1]);
				mass = new int[n];
				parts = br.readLine().split("\\s+");
				for(int i = 0; i < n; i++){
					mass[i] = Integer.parseInt(parts[i]);
				}
				break;
			}			
		}
		int ans = 0;
		if(P>=1000){
			for(int i = 0; i < n; i++){
				ans += mass[i];
			}			
		}
		else{
			
		}
		System.out.println(ans);
	}
}