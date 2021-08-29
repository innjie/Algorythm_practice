
public class Delivery04_3 {

	public static void main(String[] args) {
		int U = 2;
		int L = 2;
		int[] C = {2, 0, 2, 0};

		int[][] matrix = new int[2][C.length];
		
		//C[i] == 2 -> U--, L-- 양쪽모두 1
		for(int i = 0; i < C.length; i++) {
			if(C[i] == 2) {
				matrix[0][i]++;
				matrix[1][i]++;
				U--; L--;
				
				C[i] = 0;
			}
		}
		
		for(int i = 0; i < C.length; i++) {
			if(C[i] == 1) {
				if(U > 0) { //0행에 채우기 가능
					matrix[0][i]++;
					U--;
				} else if(L > 0) {
					matrix[1][i]++;
					L--;
				}
			}
			C[i]--;
		}
		
		for(int i = 0; i < C.length; i++) {
			if(C[i] > 0) {
				System.out.println("IMPOSSIBLE");
			}
		}
		
		String answer = "";
		int temp = 0;
		for(int i = 0; i < matrix.length; i++) {
            int a = 1;
            temp = 0;
			for(int j = 0; j < matrix[0].length; j++) {
				temp *= 10;
				temp += matrix[i][j];
				
			}
			answer += String.valueOf(temp) + ", ";
		}
		answer = answer.substring(0, answer.length() - 2);
		System.out.println(answer);
		

	}

}
