import java.util.Random;
import java.util.Scanner;

public class LAB_1101_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		
		int k = 1600;
		int n = k * 1000;
		
		int[] arr = new int[n];
		
		//랜덤값
		for(int i = 0; i < n; i++) {
			arr[i] = r.nextInt(n / k / 10);
			
		}
		
		//직접 입력 (length 길이 변화 측정용)
		
//		for(int i = 0; i < n; i++) {
//			arr[i] = scan.nextInt();
//			System.out.print(arr[i] + " ");
//		}
//		
		//시간 측정 시작 - sort - 시간측정 종료
		long start = System.currentTimeMillis();
		sort(arr);
		long end = System.currentTimeMillis();
		System.out.println();
		System.out.println((double)(end - start) + "ms");
		
	}
	public static void sort(int[] a) {
		sort(a, 0, a.length);
	}

	public static void sort(int[] a, int fromIndex, int toIndex) {
		rangeCheck(a.length, fromIndex, toIndex);
		dualPivotQuicksort(a, fromIndex, toIndex - 1, 3);
	}

	private static void rangeCheck(int length, int fromIndex, int toIndex) {
		if (fromIndex > toIndex) {
			throw new IllegalArgumentException("fromIndex > toIndex");
		}
		if (fromIndex < 0) {
			throw new ArrayIndexOutOfBoundsException(fromIndex);
		}
		if (toIndex > length) {
			throw new ArrayIndexOutOfBoundsException(toIndex);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void dualPivotQuicksort(int[] a, int left, int right, int div) {
		int len = right - left;
		if (len < 17) {
			for (int i = left + 1; i <= right; i++) {

				for (int j = i; j > left && a[j] < a[j - 1]; j--) {
					swap(a, j, j - 1);
				}
			}
			return;
		}
		int third = len / div;
		
		int m1 = left + third;
		int m2 = right - third;
		if (m1 <= left) {
			m1 = left + 1;
		}
		if (m2 >= right) {
			m2 = right - 1;
		}
		if (a[m1] < a[m2]) {
			swap(a, m1, left);
			swap(a, m2, right);
		} else {
			swap(a, m1, right);
			swap(a, m2, left);
		}

		int pivot1 = a[left];
		int pivot2 = a[right];

		int less = left + 1;
		int great = right - 1;

		for (int k = less; k <= great; k++) {
			if (a[k] < pivot1) {
				swap(a, k, less++);
			} else if (a[k] > pivot2) {
				while (k < great && a[great] > pivot2) {
					great--;
				}
				swap(a, k, great--);
				if (a[k] < pivot1) {
					swap(a, k, less++);
				}
			}
		}

		int dist = great - less;
		if (dist < 17) {
			div++;
		}
		swap(a, less - 1, left);
		swap(a, great + 1, right);

		dualPivotQuicksort(a, left, less - 2, div);
		dualPivotQuicksort(a, great + 2, right, div);


		if (dist > len - 13 && pivot1 != pivot2) {
			for (int k = less; k <= great; k++) {
				if (a[k] == pivot1) {
					swap(a, k, less++);
				} else if (a[k] == pivot2) {
					swap(a, k, great--);
					if (a[k] == pivot1) {
						swap(a, k, less++);
					}
				}
			}
		}
	
		if (pivot1 < pivot2) {
			dualPivotQuicksort(a, less, great, div);
		}
	}
}
