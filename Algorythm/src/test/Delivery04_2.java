
public class Delivery04_2 {

	public static void main(String[] args) {
		String S = "admin  -wx 29 Sep 1983        833 source.h\r\n" + 
				"admin  r-x 23 Jun 2003     854016 blockbuster.mpeg\r\n" + 
				"admin  --x 02 Jul 1997        821 delete-this.py\r\n" + 
				"admin  -w- 15 Feb 1971      23552 library.dll\r\n" + 
				"admin  --x 15 May 1979  645922816 logs.zip\r\n" + 
				"jane   --x 04 Dec 2010      93184 old-photos.rar\r\n" + 
				"jane   -w- 08 Feb 1982  681574400 important.java\r\n" + 
				"admin  rwx 26 Dec 1952   14680064 to-do-list.txt";
		
		String[] sArr = S.split("\r\n");
		
		int[] checkFilter = new int[sArr.length];
		
		
		long limit = 14;
		for(int i = 0; i < 20; i++) {
			limit *= 2;
		}
		for(int i = 0; i < sArr.length; i++) {
			String[] line = sArr[i].split(" ");
			//check secondFilter (Admin)
			if(line[0].equals("admin")) {
				checkFilter[i]++;
				//check firstFilter (x)
				if(line[2].contains("x")) {
					checkFilter[i]++;
					for(int j = 6; j < line.length; j++) {
						if(!line[j].equals("")) {
							int b = Integer.parseInt(line[j]);
							if(b < limit) {
								System.out.println(line[3] + " " + line[4] + " " + line[5]);
							}
							break;
							
						}
					}
				}
			}
		}
		for(int i = 0; i < checkFilter.length; i++) {
			System.out.println(checkFilter[i] + " " );
		}

	}

}
