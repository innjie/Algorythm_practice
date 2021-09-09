
public class Samsung04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] matrix = {"01000", "00110", "10001", "01001"};
		int min = 0;
		int col = 5;
		int row = 4;
		
		
        int[] count = new int[col];
        for(int j = 0; j < row; j++) {
            int total = 0;
            //j번째 맞추기
            for(int m = 0; m < col; m++) {
                min = col > row ? col : row;
                for(int n = 0; n < row; n++) {
                    int curr = matrix[n].charAt(m) - '0';
                    if(curr == 1) {
                        int t1 = n - j;
                        int t2 = row - t1;
                        
                        if(t1 < 0) {
                        	int a = 0 - t1;
                        	int b = row + t1;
                        	
                        	t1 = a < b ? a : b;
                        }
                        if(t2 <0) {
                        	int a = 0 - t2;
                        	int b = row + t2;
                        	t2 = a < b ? a : b;
                        }
                        int tmin = t1 < t2 ? t1 : t2;
                        
                        min = min < tmin ? min : tmin;
                    }
                }
                count[j] += min;
                System.out.println(m + " : " + min);
                
            }
            
        }
        int result = count[0];
        for(int j = 1; j < row; j++) {
        	if(result > count[j]) {
        		result = j;
        	}
        }
        

	}

}

