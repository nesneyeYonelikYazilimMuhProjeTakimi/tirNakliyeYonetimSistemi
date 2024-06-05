package proje.connection;

public class agirYuk extends yukConnect{
	public agirYuk(int yukagirligi,String teslimedilecekadres,String teslimalinacakil) {
		int ucret = yukagirligi * 2000;
		yukEkle(yukagirligi, teslimedilecekadres, teslimalinacakil, ucret);
	}
}
