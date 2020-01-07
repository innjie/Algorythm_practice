import java.util.Scanner;

//move clock
public class LAB_1105 {
	static int[] clock = new int[16];
	static int mnum = 31;
	static int[][] switchA = new int[10][16];
	static int[] copyClock = new int[16];

	static boolean checkClock() {
		int i;

		for (i = 0; i < 16; i++)
			if (copyClock[i] % 12 != 0)
				return false;
		return true;
	}

	static void moveClock(int n, int count) {
		copyClock[n] += (3 * count);

		return;
	}

	static void selectClock(int[] item, int size, int[] bucket, int bSize) {
		int i;
		int j;

		for (i = 0; i < bSize; i++)
			for (j = 0; j < 16; j++)
				if (switchA[i][j] != 0)
					moveClock(j, bucket[i]);

	}

	static void combination(int item[], int size, int bucket[], int b_size, int k) {
		int i, lastIndex, min = 0;
		int check;
		int total = 0;

		if (k == 0) {
			selectClock(item, size, bucket, b_size);

			if (checkClock()) {
				for (i = 0; i < 10; i++)
					total += bucket[i];

				mnum = mnum > total ? total : mnum;
				return;
			}

			for (i = 0; i < 16; i++)
				copyClock[i] = clock[i];

			return;
		}

		lastIndex = b_size - k - 1;

		min = 0;

		for (i = min; i < size; i++) {
			bucket[lastIndex + 1] = i;
			combination(item, size, bucket, b_size, k - 1);
		}
	}

	public static void main(String[] args) {
		int[] item = { 0, 1, 2, 3 };
		int[] bucket = new int[10];
		int i, j;

		Scanner scan = new Scanner(System.in);

		for (i = 0; i < 10; i++) {
			int n = scan.nextInt();
			int m = scan.nextInt();

			for (j = 0; j < m; j++) {
				int k = scan.nextInt();
				switchA[n][k]++;
			}
		}
		for (i = 0; i < 16; i++)
			clock[i] = scan.nextInt();

		for (i = 0; i < 16; i++)
			copyClock[i] = clock[i];

		combination(item, 4, bucket, 10, 10);
		System.out.println(mnum);
	}
}
