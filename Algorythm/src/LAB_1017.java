// Salary

public class LAB_1017 {
	static String organization[] = {
			"NYNNN", 
			"NNNNN",
			"NNNYY", 
			"NYNNN", 
			"NNNNN"
	}; 
	static int [] count = new int[organization.length];

	public static void main(String[] args) {
		int total = 0;
		for(int i = 0; i < count.length; i++) {
			count[i] = 0;
		}
		for(int i = 0; i < organization.length; i++)
			total += salary(i, count);
		System.out.println(total);
		
	}
	public static int salary(int id, int memo[]) {
		if(count[id] != 0)
			return count[id];
		
		int salary = 0;
		
		char staff[] = organization[id].toCharArray();
		
		for(int i = 0; i < staff.length; i++)
			if(staff[i] == 'Y')
				salary += salary(i, count);
		
		count[id] = salary == 0 ? 1 : salary;
		
		return count[id];
	}

}
