package hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ShuffTest {

	Shuffler shuff;
	
	
	@Before
	public void setUp() {
		String[] in = {"a", "b", "c", "d","e", "f"};
		shuff = new Shuffler(in);
	}
	
	@Test
	public void shuffledTest() {
		assertFalse(shuff.getList().equals(shuff.getShuffledList()));
		assertTrue(shuff.getDiffBetweenLists() > 2);
	}
	
	@Test
	public void basicsTest() {
		String[] in = {"a","b", "c","d","e","f"};
		assertEquals(shuff.getList(), in);
		int index = (shuff.getRandomIndex());
		shuff.randomizeIndex();
		assertFalse(index == shuff.getRandomIndex());
	}
}
