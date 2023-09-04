import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	private	GradeBook t1;
	private	GradeBook t2;

	@BeforeEach
	void setUp() throws Exception {
		t1=new GradeBook(5);		
		t2=new GradeBook(5);
		t1.addScore(.2);
		t1.addScore(.3);
		t2.addScore(1);
		t2.addScore(2);
	}

	@AfterEach
	void tearDown() throws Exception {
		t1=null;
		t2=null;
	}

	@Test
	void testaddScore() {
		assertTrue(t1.toString().equals("0.2 0.3 "));
		assertTrue(t2.toString().equals("1.0 2.0 "));
		assertEquals(t1.getScoreSize(),2);
		assertEquals(t2.getScoreSize(),2);

	}
	@Test
	void testsum() {
		assertEquals(t1.sum(),.5);
		assertEquals(t2.sum(),3);
	}
	@Test
	void testminimum() {
		assertEquals(t1.minimum(),.2);
		assertEquals(t2.minimum(),1);
	}
	@Test
	void testfinalScore() {
		assertEquals(t1.finalScore(),.3);
		assertEquals(t2.finalScore(),2);

	}

}
