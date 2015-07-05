import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RCCA {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] string = br.readLine().toCharArray();
		
		int i = 0;
		while(i < string.length){
			if(string[i]=='('){
				for(int j = i; j < string.length; j++){
					if(string[j]==')'){
						int k = j-1;
						while(k>i){
							System.out.print(string[k--]);
						}
						i=j+1;
						break;
					}
				}
			}
			else{
				System.out.print(string[i++]);
			}
		}
		System.out.println();
	}
}
