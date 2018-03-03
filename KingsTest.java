package hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class KingsTest {
	KingsList kl;
	
	@Before
	public void setUp() {
		kl = new KingsList(6, 2);
	} 
	
	@Test
	public void testListQualities() {
		kl.circularize(6);
		assertEquals(6, kl.getList().size());
	}

}
