package proje.connection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class yoneticiConnect extends connectdb {
	public int tirMasrafi(int yoneticiID) {
		ResultSet resultset = connection("select sum(tir.bakimmasraflari) as tirmasrafi,sum(dorse.bakimmasraflari) as dorsemasrafi, sum(yakitmasraflari) as yakit from tir join dorse on tir.dorseplaka = dorse.plaka join tasir on tir.plaka = tasir.tirplaka join calisan on tir.soforno = calisan.calisanno join garaj on calisan.garajnumarasi = garaj.garajnumarasi where garaj.yöneticino = " +String.valueOf(yoneticiID)+ " group by yöneticino;");
		int tirMasrafi = 0, dorseMasrafi = 0, yakitMasrafi = 0;
		
		try {
			while (resultset.next()) {
			    tirMasrafi = resultset.getInt("tirmasrafi");
			    dorseMasrafi = resultset.getInt("dorsemasrafi");
			    yakitMasrafi = resultset.getInt("yakit");
			}
			return tirMasrafi+dorseMasrafi+yakitMasrafi;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public int garajNo(int yoneticiID) {
		ResultSet resultset = connection("select * from garaj where yöneticino = " + yoneticiID + ";");
		int garajNo = 0;
		try {
			while (resultset.next()) {
			    garajNo = resultset.getInt("garajnumarasi");
			}
			return garajNo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public int personelMasrafi(int garajNo) {
		ResultSet resultset = connection("select sum(maaş) as masraf from calisan group by garajnumarasi having garajnumarasi =" +garajNo+ ";");
		int masraf = 0;
		try {
			while (resultset.next()) {
			    masraf = resultset.getInt("masraf");
			}
			return masraf;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public int gelir(int garajNo) {
		ResultSet resultset = connection("select sum(ucret) as gelir from yuk join tasir on yuk.yukno = tasir.yukno join tirpark on tirpark.tirplaka = tasir.tirplaka group by garajnumarasi having garajnumarasi = " +garajNo+ ";");
		int gelir = 0;
		try {
			while (resultset.next()) {
			    gelir = resultset.getInt("gelir");
			}
			return gelir;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public int tirSayisi(int garajNo) {
		ResultSet resultset = connection("select count(garajnumarasi) as sayi,garajnumarasi from tirpark group by garajnumarasi having garajnumarasi =" +garajNo+ ";");
		int tirSayisi = 0;
		try {
			while (resultset.next()) {
				tirSayisi = resultset.getInt("sayi");
			}
			return tirSayisi;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public int dorseSayisi(int garajNo) {
		ResultSet resultset = connection("select count(garajnumarasi) as sayi,garajnumarasi from dorsepark group by garajnumarasi having garajnumarasi =" +garajNo+ ";");
		int dorseSayisi = 0;
		try {
			while (resultset.next()) {
				dorseSayisi = resultset.getInt("sayi");
			}
			return dorseSayisi;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
