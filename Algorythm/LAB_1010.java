import java.util.Scanner;

//컴퓨터학과 20170966 이인지
public class LAB_1010 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		int i = scan.nextInt();
		int[] array = new int[i];
		long [] memo = new long[i];
		array[0] = 1;
		
		
		long k = handShake(i, array, memo);
		System.out.print(k);
	}
	public static long handShake(int i, int[] array, long[] memo) {
		int k = i / 2;
		long count = 0;

		if(i == 0 || i ==2)
			return memo[k] = 1;
		
		if(memo[k] > 0)
			return memo[k];
		
		
		for(i = 0; i < k; i++)
			count += handShake(2 * i, array, memo) * handShake(2 * (k - 1 - i), array, memo);
		return memo[k] = count;
	}
	
}
