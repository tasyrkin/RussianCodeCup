import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;


public class RCCQ3C {
	
	public static class Time{
		int hh;
		int mm;
		public Time(String time){
			String[]parts = time.split(":");
			this.hh = Integer.parseInt(parts[0]);
			this.mm = Integer.parseInt(parts[1]);
		}		
		public Time(int hh, int mm){
			this.hh = hh;
			this.mm = mm;
		}
		public Time add(int durationMin){
			int hours = durationMin/60;
			int minutes = durationMin%60;			
			if(mm+minutes>=60){
				hours++;
				minutes = mm+minutes-60;
			}
			else{
				minutes = mm + minutes;
			}
			hours = hh + hours;
			return new Time(hours,minutes);			
		}
		public String toString(){
			return format(hh)+":"+format(mm);
		}
		public static String format(int d){
			if(d<10){
				return "0"+d;
			}
			return ""+d;
		}
		public int compareTo(Time t){
			if(hh < t.hh)return -1;
			else if(hh>t.hh)return 1;
			if(mm < t.mm)return -1;
			else if(mm>t.mm)return 1;
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = -1;
		String line = null;
		Time currTime = null;
		boolean res = true;
		while(null != (line =br.readLine())){
			if(n==-1){
				currTime = new Time(line);
				n = Integer.parseInt(br.readLine());
				continue;
			}
			String[]parts = line.split("\\s+");
			Time s = new Time(parts[0]);
			Time f = new Time(parts[1]);
			int dur = Integer.parseInt(parts[2]);
			s = s.compareTo(currTime)>=0?s:currTime;
			Time fin = s.add(dur);
			if(fin.compareTo(f)>0){
				res = false;
				break;
			}
			else{
				currTime = fin;
			}
			
			if(--n<0)break;
		}
		if(res){
			System.out.println("Yes");
			System.out.println(currTime);
		}
		else{
			System.out.println("No");
		}
	}
}