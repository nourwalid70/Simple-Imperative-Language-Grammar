package labP;

import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;


public class tester {

	public static void main(String[] args) throws NumberFormatException, ParseException, UnsupportedEncodingException {
		
		try {
			/*String string = "if tt then a := 6 else a := 7";
	        InputStream in = new ByteArrayInputStream(string.getBytes("UTF-8"));
			new labP.language(in).Start();
			System.out.println("Accepted");*/
			
			String n= new labP.language(System.in).Start();
		      System.out.println(n);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
/*StringReader in=new StringReader("count 10");
      Hello hello=new Hello(in);
      int val = Hello.Start();
      System.out.println(val);*/