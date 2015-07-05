import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RCCQ2A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = -1,r=-1;
		String line = null;
		while(null != (line =br.readLine())){
			if(n==-1){
				String[]parts = line.split("\\s+");
				n = Integer.parseInt(parts[0]);
				r = Integer.parseInt(parts[1]);
				continue;
			}
			String[]parts = line.split("\\s+");
			int a = 0;
			for(int i = 0; i < parts.length;i++){
				a += Integer.parseInt(parts[i]);
			}
			for(int i = 0; i < parts.length;i++){
				double res = (double)(Math.PI*r*r)/(double)a*Integer.parseInt(parts[i]);
				System.out.println((double)Math.round(res * 100000000) / 100000000);
			}
			
		}
	}

}
