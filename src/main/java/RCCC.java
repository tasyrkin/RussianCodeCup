import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class RCCC {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] parts = br.readLine().split("\\s+");
		Integer[] array = new Integer[n];		
		for(int i = 0; i < array.length; i++){
			array[i] = Integer.parseInt(parts[i]);
		}
		int k = Integer.parseInt(br.readLine());
		if(k==1){
			int count = getMinimalNumberOfStepsToOrder(array);
			System.out.println(count);
		}
		else
		{
			int num = 0;
			for(int i=0; i<=k-1;i++){
				ArrayList<Integer> list = new ArrayList<Integer>();
				for(int j=i;j<array.length;j+=k){
					list.add(array[j]);
				}
				Integer[]tmp = list.toArray(new Integer[list.size()]);
				num += getMinimalNumberOfStepsToOrder(tmp);
				Arrays.sort(tmp);
				int idx = 0;
				for(int j=i;j<array.length;j+=k){
					array[j] = tmp[idx++];
				}			
			}
			boolean isSorted = true;
			for(int i = 1; i < array.length-1; i++){
				if(array[i]>array[i+1]){
					isSorted = false;
					break;
				}
			}
			if(!isSorted){
				System.out.println(-1);
			}
			else{
				System.out.println(num);
			}
		}
	}
	public static int getMinimalNumberOfStepsToOrder(Integer[]array){
		Integer[]tmp = array.clone();
		int[]perm = new int[tmp.length];
		int cnt = 0;
		int min = Integer.MAX_VALUE;
		while(cnt<perm.length){
			int minIdx = -1;
			for(int idx = 0; idx < tmp.length; idx++){
				if(min<tmp[idx]){
					min = tmp[idx];
					minIdx = idx;
				}
			}
			perm[minIdx] = cnt++;
			tmp[minIdx] = Integer.MAX_VALUE;
			min = Integer.MAX_VALUE;
		}
		HashSet<Integer> notOrdered = new HashSet<Integer>();
		for(int idx = 0; idx < perm.length; idx++){
			if(perm[idx]!=idx)notOrdered.add(perm[idx]);
		}
		int count = 0;
		while(!notOrdered.isEmpty()){
			count++;
			int idx = notOrdered.iterator().next();
			if(idx == perm[perm[idx]]){
				notOrdered.remove(perm[idx]);
				notOrdered.remove(idx);
				int val = perm[idx];
				perm[idx] = idx;
				perm[val] = val;
			}
			else{
				notOrdered.remove(perm[idx]);
				int val = perm[perm[idx]];
				perm[perm[idx]] = idx;
				perm[idx] = val; 						
			}					
		}
		return count;		
	}
}
