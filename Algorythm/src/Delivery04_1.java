import java.util.*;
import java.util.Map.Entry;
public class Delivery04_1 {

	public static void main(String[] args) {
		String S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
		String C = "Example";
		
		String answer = "";
		
		HashMap<String, Integer> email = new HashMap<String, Integer>();
		
		Iterator<Entry<String, Integer>> entries = email.entrySet().iterator();
		
		//String -> arr split
		String[] sArr = S.split(", ");
		answer += "\"";
		for(int i = 0; i < sArr.length; i++) {
			//make emailName
			String[] name = sArr[i].split(" ");
			String emailName = "";
			String[] last;
			String lastString = "";
			
			//name length 2
			if(name.length == 2) { //no middle name
				//pick First
				emailName += name[0].charAt(0);

				//pick Last
				//check hyphen and length
				last = name[1].split("-");
				for(int j = 0; j < last.length; j++) {
					lastString += last[j];
				}
				
				if(lastString.length() > 8) {
					lastString = lastString.substring(0, 8);
				}
				emailName += lastString;
				
				
				
				
			} else if(name.length == 3) { //exist middle name
				//pick First
				emailName += name[0].charAt(0);
				//pick Middle
				emailName += name[1].charAt(0);
				//pick Last
				
				last = name[2].split("-");
				for(int j = 0; j < last.length; j++) {
					lastString += last[j];
				}
				
				if(lastString.length() > 8) {
					lastString = lastString.substring(0, 8);
				}
				emailName += lastString;
				
			}
			
			emailName = emailName.toLowerCase();
			//check exist
			if(email.containsKey(emailName)) {
				email.put(emailName, email.get(emailName) + 1);
				String duplicate = String.valueOf(email.get(emailName));
				
				emailName += duplicate;
			} else {
				email.put(emailName, 1);
			}
			answer += (sArr[i] + " <" + emailName + "@" + C + ".com>, ");
			
		}
		
		answer = answer.substring(0, answer.length() - 2);
		answer.toLowerCase();
		answer += "\"";
		System.out.println(answer);
		
		

	}

}
