//LAB6_2
import java.util.Scanner;
public class LAB_1031 {
	public static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coin = new int[]{10, 50, 100, 500};
		Scanner scan = new Scanner(System.in);
		int money = scan.nextInt();
		
		int[] bucket = new int[money/10];
		change(coin, money, bucket, money / 10);
		System.out.println(count);
	}
	public static void change(int[] items, int money, int[] bucket, int k) {
		int total = 0;
		for(int i = 0; i < bucket.length; i++)
			total += bucket[i];
		
		if(total == money) {
			count++;
			return;
		}
		else if( total > money)
			return;
		
		int lastIndex = bucket.length - k - 1;
		
		for(int i = 0; i < items.length; i++) {
			if(bucket.length == k) {
				bucket[0] = items[i];
				change(items, money, bucket, k - 1);
			}
			else if (bucket[lastIndex] <= items[i]) {
				bucket[lastIndex + 1] = items[i];
				change(items, money, bucket, k - 1);
			}
		}
		
	}

}
