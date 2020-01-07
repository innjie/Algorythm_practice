//10/4 제출
import java.util.Scanner;
public class October04Q1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//분수를 입력받음 (분모, 분자)
		double a = scan.nextInt();
		double b = scan.nextInt();
		
		printPath(b, a);
	}
	public static void printPath(double a, double b) {
		double lm = 1, ln = 1; //왼쪽 분모, 분자
		double rm = 1, rn = 1; //오른쪽 분모, 분자
		double km = 1, kn = 1; //현재위치
		
		//결과까지 도달하는 동안
		while(true) {
			//종료조건
			if((a == km) && (b == kn)) {
				break;
			}
			if((b / a) < (kn / km)){ //찾는 값이 더 작은경우
				System.out.print("L"); //L 출력
				
				if(kn == 1) { //맨 끝 특수한 경우
					rm = lm;
					lm += 1;
					km = lm; kn = ln;
				}
				else {
					rm = km; rn = kn;
					km = rm + lm; kn = rn + ln;
				}
				
			}
			else { //찾는 값이 더 큰경우
				System.out.print("R");
				
				if(km == 1) { //맨 끝 특수한 경우
					ln = rn;
					rn += 1;
					km = rm; kn = rn;
				}
				else {
					lm = km; ln = kn;
					km = lm + rm; kn = ln + rn;
				}	
			}
		}
	}
}

