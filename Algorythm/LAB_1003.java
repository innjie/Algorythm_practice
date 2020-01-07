
import java.util.Scanner;
public class LAB_1003 {
	public static void main(String[] args) {
		char[] items = {'-', '+'};
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		int k = 1;
		while(sum(k) < n)
			k++;
		
		while(true) {
			char[] bucket = new char[k];
			if(select(items, bucket, k, n))
				break;
		}
		
	}
	public static int sum(int n) {
		return n * (n + 1) / 2;
	}
	public static boolean select(char[] items, char[] bucket, int k, int n) {
		if(k == 0) { //종료조건
			calc(bucket, n);
			return true;
		}
		
		int lastIndex = bucket.length - k - 1;
		
		for(int i = 0; i < items.length; i++) {
			bucket[lastIndex + 1] = items[i];
			select(items, bucket, k -1, n);
		}
		return false;
	}
	public static int calc(char[] bucket, int n) {
		int result = 0;
		String str = "";
		for(int i = 1; i <= bucket.length; i++) {
			if(bucket[i - 1] == '+') {
				result += i;
			}
			else {
				result -= i;
			}
			str += bucket[i - 1] + " " + i + " ";
		}
		if (result == n) {
			System.out.println(str);
			return 1;
		}
		return 0;
	}
}