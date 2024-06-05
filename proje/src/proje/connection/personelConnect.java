package proje.connection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class personelConnect extends connectdb{
	public boolean personelMi (int input){
		
		ResultSet resultSet = connection("SELECT calisanno FROM calisan;");
		
		try {
			while (resultSet.next()) {
			    int id = resultSet.getInt("calisanno");
			    if(id == input) {
			    	return true;
			    }
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean yoneticiMi (int input){
		
		ResultSet resultSet = connection("SELECT yöneticino FROM garaj;");
		
		try {
			while (resultSet.next()) {
			    int id = resultSet.getInt("yöneticino");
			    if(id == input) {
			    	return true;
			    }
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public String bilgi (int soforno) {
		ResultSet resultSet = connection("SELECT * FROM public.yuktasiyanbilgisi where soforno ="+String.valueOf(soforno)+";");
		
		try {
			while (resultSet.next()) {
			    int sno = resultSet.getInt("soforno");
			    int garajnumarasi=resultSet.getInt("garajnumarasi");
			    int yukno=resultSet.getInt("yukno");
			    String ad = resultSet.getString("ad");
			    String soyad = resultSet.getString("soyad");
			    String tirplaka = resultSet.getString("tirplaka");
			    String dorseplaka = resultSet.getString("dorseplaka");
			    String sonuc="<html>sofor no: "+String.valueOf(sno)+" ad: "+ad+" soyadı: "+soyad+"<br>garaj numarası: "+String.valueOf(garajnumarasi)+" tır plakası:"+tirplaka+" dorse plakası: "+dorseplaka+"<br>yük no: "+String.valueOf(yukno);
			    
			    return sonuc;
			    
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		}
	}
}
