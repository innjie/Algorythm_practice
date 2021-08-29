import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		String s = "one4seveneight";
		int answer = 0;
		
		s = s.replace("one", "1");
		s = s.replace("two",  "2");
		s = s.replace("three",  "3");
		s = s.replace("four",  "4");
		s = s.replace("five",  "5");
		s = s.replace("six", "6");
		s = s.replace("seven",  "7");
		s = s.replace("eight",  "8");
		s = s.replace("nine",  "9");
		s = s.replace("zero",  "zero");
		
		int multiple = 1;
		for(int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			answer += (ch - '0') * multiple;
			multiple *= 10;
		}
		
		System.out.println(answer);
	}
	public static int numbering(String s) {
		switch(s) {
		case "zero":
			return 0;
		case "one":
			return 1;
		case "two":
			return 2;
		case "three":
			return 3;
		case "four":
			return 4;
		case "five":
			return 5;
		case "six":
			return 6;
		case "seven":
			return 7;
		case "eight":
			return 8;
		case "nine":
			return 9;
		}
		return 0;
	}
}


//public static void main(String[] args) {
//	int n = 3;
//	int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
//
//	dfs(computers, 0, 1);
//	System.out.println(answer);
//
//}
//
//static int answer = 0;
//
//public static void dfs(int[][] computers, int row, int col) {
//	if (col == computers.length - 1) {
//		answer++;
//		return;
//	}
//	if (computers[row][col] == 1) {
//		dfs(computers, col, col + 1);
//	}
//	if (row < computers.length - 1) {
//		dfs(computers, row, col + 1);
//	} else {
//		dfs(computers, row + 1, row + 2);
//	}
//
//}