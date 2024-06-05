package proje;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import proje.connection.musteriConnect;
import proje.connection.personelConnect;

class test2 {

	musteriConnect musteritest = new musteriConnect();	
	@Test
	void test1() {
		assertEquals(true,musteritest.musteriMi(5));
	}
	@Test
	void test2() {
		assertEquals(true,musteritest.musteriMi(8));
	}
	@Test
	void test3() {
		assertEquals(false,musteritest.musteriMi(47));
	}
	@Test
	void test4() {
		assertEquals(false,musteritest.musteriMi(42));
	}
}
