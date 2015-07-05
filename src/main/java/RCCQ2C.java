import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Stack;


public class RCCQ2C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(--t>=0){
			String[]parts = br.readLine().split("\\s+");
			int L = Integer.parseInt(parts[0]);
			int m = Integer.parseInt(parts[1]);
			String s1 = br.readLine();
			int len1 = s1.length();
			String s2 = br.readLine();
			int len2 = s2.length();
			if(s2.equals(s1)&&L==len1){
				System.out.println(1);
				continue;
			}
			int rest = L-(len1+len2);
			if(rest<0){
				char[] s1char = s1.toCharArray();
				char[] s2char = s2.toCharArray();
				int res = 0;
				for(int i = 0; i < s1char.length; i++){
					int j = i;
					int k = 0;
					for(; j < s1char.length; j++){
						if(s1char[j]!=s2char[k++])break;
						if(k==s2char.length)break;
					}
					if(j==s1char.length){
						int common = j-i;
						if(L==len1+len2-common){
							res++;
							break;
						}
					}
				}
				for(int i = 0; i < s2char.length; i++){
					int j = i;
					int k = 0;
					for(; j < s2char.length; j++){
						if(s2char[j]!=s1char[k++])break;
						if(k==s1char.length)break;
					}
					if(j==s2char.length){
						int common = j-i;
						if(L==len1+len2-common){
							res++;
							break;
						}
					}
				}
				System.out.println(res%m);
			}
			else if(rest==0){
				System.out.println(2%m);
			}
			else{
				BigInteger num = new BigInteger(26+"");
				BigInteger pow = num.pow(rest);
				pow = pow.multiply(new BigInteger(""+2));
				BigInteger res = pow.mod(new BigInteger(""+m));
				System.out.println(res);
			}
		}
	}

}
