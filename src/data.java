import java.util.ArrayList;
import java.util.List;


public class data {
	public static String fname;
	public static String lname;
	public static String mail;
	public static String num;
	public static String roomtyp;
	public static String strdate;
	public static String enddate;
	public static String price;
	public static float res;
	public static float total;
	
	static List<String> namelist = new ArrayList<String>();
	public static void addnamelist() {
		namelist.add(" Mx. "+fname+" - "+price+" Bath");
	}
	
	public String getList() {
		String delim = ("<br/>");
		String tes = String.join(delim, namelist);
		System.out.print(tes);
		String res = ("<html>"+tes+"</html>");
		return res;
	}
	
	
	public static void saveinfo(String finame,String laname, String email, String pnum) {
		
		fname = finame;
		lname = laname;
		mail = email;
		num = pnum;
		
	}
	
	public static void saveSR(String room,String sdate, String edate, String pri, float res) {
		
		roomtyp = room;
		strdate = sdate;
		enddate = edate;
		price = pri;
		total += res;
		
	}
	
	public String getFname() {
		return fname;
		
	}
	public String getLname() {
		return lname;
		
	}
	public String getMail() {
		return mail;
		
	}
	public String getPhon() {
		return num;
		
	}
	public String getRoom() {
		return roomtyp;
		
	}
	public String getSdate() {
		return strdate;
		
	}
	public String getEdate() {
		return enddate;
		
	}
	public String getPrice() {
		return price;
		
	}
	public float getTotal() {
		return total;
		
	}
	
}
