package test2.servlet;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTest {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd"); 
		String result = df.format(cal.getTime());
		System.out.println(result);
		
	}
}
