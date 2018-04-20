package by.bsuir.convertor.action;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainTest extends Application{
	
	private boolean expected = true;
	private StringBuilder res;
	
	public MainTest() {
	}
	
	@Before
	public void init() {
		res = new StringBuilder();
	}
	
	@Test
	public void resNotNull() {
		boolean real = true;
		if(res== null)
			real = false;
		assertEquals(expected, real);
		
	}
	@Test
	public void resToStringNotNull() {
		boolean real = true;
		if(res.toString()== null)
			real = false;
		assertEquals(expected, real);
	}
	
	@Test
	public void TestExpected() {
		boolean real = false;
		Convertor convertor = new Convertor();
		if(convertor.convert(2).equals("10"))
			real = true;
		assertEquals(expected, real);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		
	}

}
