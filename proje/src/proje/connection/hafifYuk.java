package proje.connection;

public class hafifYuk extends yukConnect{
	public hafifYuk(int yukagirligi,String teslimedilecekadres,String teslimalinacakil) {
		int ucret = yukagirligi * 1000;
		yukEkle(yukagirligi, teslimedilecekadres, teslimalinacakil, ucret);
	}
}
