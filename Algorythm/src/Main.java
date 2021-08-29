
import java.util.*;

public class Main {
	public static void main(String[] args) {
		int i = 0;
		while(i < 7) {
			i++;
			if(i == 3) {
				continue;
			}
			if(i == 5) {
				break;
			}
			System.out.println(i);
		}
		
	}
}
