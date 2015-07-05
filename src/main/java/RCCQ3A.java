import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RCCQ3A {

	public static class Triple{
		int x;
		int y;
		int t;
		public Triple(int x, int y, int t){
			this.x = x;
			this.y = y;
			this.t = t;
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = -1,ncnt=-1,d=-1;
		Triple[] array = null;
		String line = null;
		while(null != (line =br.readLine())){
			if(n==-1){
				String[]parts = line.split("\\s+");
				n = Integer.parseInt(parts[0]);
				d = Integer.parseInt(parts[1]);
				array = new Triple[n];
				ncnt = n;
				continue;
			}			
			String[]parts = line.split("\\s+");
			array[n-ncnt] = new Triple(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])); 
			if(--ncnt<0)break;
		}
		String res = "No";
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array.length; j++){
				if(i==j)continue;
				int dist = (array[j].x-array[i].x)*(array[j].x-array[i].x) + (array[j].y-array[i].y)*(array[j].y-array[i].y);
				if(dist==d*d&&array[j].t!=array[i].t){
					res = "Yes";
				}
			}
		}
		System.out.println(res);
	}
}
