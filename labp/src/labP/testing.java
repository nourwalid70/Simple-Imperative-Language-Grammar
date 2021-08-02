package labP;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;

class testing {

	@Test
	void test1() throws UnsupportedEncodingException {
		String string = "tt | tt";
        InputStream in = new ByteArrayInputStream(string.getBytes("UTF-8"));
		assertThrows(ParseException.class, () -> new labP.language(in).Start());
	}
	

	@Test
	void test2() throws UnsupportedEncodingException {
		String string = "z:=5";
        InputStream in = new ByteArrayInputStream(string.getBytes("UTF-8"));
		assertThrows(TokenMgrError.class, () -> new labP.language(in).Start());
	}
	
	
	@Test
	void test3() throws UnsupportedEncodingException {
		String string = "if (tt) then a := 6 else a := 7";
        InputStream in = new ByteArrayInputStream(string.getBytes("UTF-8"));
		assertThrows(ParseException.class, () -> new labP.language(in).Start());
	}
	
	@Test
	void test4() throws UnsupportedEncodingException, NumberFormatException, ParseException {
		String string = "if tt then a := 6 else a := 7";
        InputStream in = new ByteArrayInputStream(string.getBytes("UTF-8"));
        
        String stat =new labP.language(in).Start();
		assertEquals("accepted",stat);
	}
	
	@Test
	void test5() throws UnsupportedEncodingException, NumberFormatException, ParseException {
		String string = "abc:=5";
        InputStream in = new ByteArrayInputStream(string.getBytes("UTF-8"));
        String stat =new labP.language(in).Start();
		assertEquals("accepted",stat);
	}
	
	@Test
	void test6() throws UnsupportedEncodingException, NumberFormatException, ParseException {
		String string = "if ff then a := 6 else a := 7";
        InputStream in = new ByteArrayInputStream(string.getBytes("UTF-8"));
        
        String stat =new labP.language(in).Start();
		assertEquals("accepted",stat);
	}
	
	@Test
	void test7() throws UnsupportedEncodingException, NumberFormatException, ParseException {
		String string = "while (a==4) do skip";
        InputStream in = new ByteArrayInputStream(string.getBytes("UTF-8"));
        
        String stat =new labP.language(in).Start();
		assertEquals("accepted",stat);
	}
	
	@Test
	void test8() throws UnsupportedEncodingException, NumberFormatException, ParseException {
		String string = "a := 4;\r\n" + 
				"if (a == 4) then a := 5 else a := 6;\r\n" + 
				"b := ( a + 11)";
        InputStream in = new ByteArrayInputStream(string.getBytes("UTF-8"));
        
        String stat =new labP.language(in).Start();
		assertEquals("accepted",stat);
	}
	@Test
	void test9() throws UnsupportedEncodingException, NumberFormatException, ParseException {
			String string = "while b==6 do skip";
        InputStream in = new ByteArrayInputStream(string.getBytes("UTF-8"));
		assertThrows(ParseException.class, () -> new labP.language(in).Start());
	}
	
	@Test
	void test10() throws UnsupportedEncodingException, NumberFormatException, ParseException {
		String string = "if !(a==99) then a := (a+a); else a := (a+7);if((a == 3)^(b == 7))then c := 6; else skip; while !(c==4) do c := (c-1);";
        InputStream in = new ByteArrayInputStream(string.getBytes("UTF-8"));

		assertThrows(ParseException.class, () -> new labP.language(in).Start());
	}
	
	@Test
	void test11() throws UnsupportedEncodingException, NumberFormatException, ParseException {
		String string = "a:=5 b:=6";
        InputStream in = new ByteArrayInputStream(string.getBytes("UTF-8"));
        assertThrows(ParseException.class, () -> new labP.language(in).Start());
	}
	@Test
	void test12() throws UnsupportedEncodingException, NumberFormatException, ParseException {
		String string = "if !(ab==99) then if (ab==20) then ab := (ab-a) else ab := (a+10) else ab := (a+7) ";
        InputStream in = new ByteArrayInputStream(string.getBytes("UTF-8"));
        
        String stat =new labP.language(in).Start();
		assertEquals("accepted",stat);;
	}
	
	@Test
	void test13() throws UnsupportedEncodingException {
		String string = "20 / 4";
        InputStream in = new ByteArrayInputStream(string.getBytes("UTF-8"));
		assertThrows(ParseException.class, () -> new labP.language(in).Start());
	}
	@Test
	void test15() throws UnsupportedEncodingException, NumberFormatException, ParseException {
		String string = "while((a == b) ^ (bb == bcd)) do if ff then ab:=6; bc:=7 else skip ";
        InputStream in = new ByteArrayInputStream(string.getBytes("UTF-8"));
        
        String stat =new labP.language(in).Start();
		assertEquals("accepted",stat);;
	}
	
}
