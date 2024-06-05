package proje;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import proje.connection.personelConnect;

class test3 {

	personelConnect personeltest = new personelConnect();	
	@Test
	void test1() {
		assertEquals(true,personeltest.personelMi(14));
	}
	@Test
	void test2() {
		assertEquals(true,personeltest.personelMi(11));
	}
	@Test
	void test3() {
		assertEquals(true,personeltest.personelMi(5));
	}
	@Test
	void test4() {
		assertEquals(false,personeltest.personelMi(60));
	}
}

