import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;


public class RCCQ3E {

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
	}
}