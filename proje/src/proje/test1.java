package proje;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import proje.connection.personelConnect;

class test1 {
	personelConnect yoneticitest = new personelConnect();	
	@Test
	void test1() {
		assertEquals(true,yoneticitest.yoneticiMi(0));
	}
	@Test
	void test2() {
		assertEquals(true,yoneticitest.yoneticiMi(1));
	}
	@Test
	void test3() {
		assertEquals(false,yoneticitest.yoneticiMi(12));
	}
	@Test
	void test4() {
		assertEquals(false,yoneticitest.yoneticiMi(30));
	}
}
