package utilities;

import java.util.Date;

public class DateUtil {
	
	public static String timeStamp(){
		Date date = new Date();
		
		return date.toString().replace(" ","_").replace(":","_");
	}

}