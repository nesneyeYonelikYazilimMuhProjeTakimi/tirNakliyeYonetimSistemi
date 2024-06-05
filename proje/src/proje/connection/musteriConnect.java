package proje.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class musteriConnect extends connectdb {
	public boolean musteriMi(int input) {
ResultSet resultSet = connection("SELECT musterino FROM musteri;");
		
		try {
			while (resultSet.next()) {
			    int id = resultSet.getInt("musterino");
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
	public String yukbilgi(int musterino) {
ResultSet resultSet = connection("select yuk.yukno as yukno,teslimalinacakil,teslimedilecekadres,ucret,teslimalinmatarihi,teslimedilmetarihi from yuk join musteriister on yuk.yukno=musteriister.yukno where musteriister.musterino= "+String.valueOf(musterino)+";");
		
		try {
			while (resultSet.next()) {
			    int id = resultSet.getInt("yukno");
			    String ail=resultSet.getString("teslimalinacakil");
			    String vil=resultSet.getString("teslimedilecekadres");
			    int ucret =resultSet.getInt("ucret");
			    String vtarih=resultSet.getString("teslimedilmetarihi");
			    String atarih =resultSet.getString("teslimalinmatarihi");
			    String sonuc="<html>Yük no: "+String.valueOf(id)+"<br>teslim alinacak il: "+ail+" teslim edilecek adres: "+vil+"<br>ücret: "+String.valueOf(ucret)+"<br>teslim edilme tarihi: "+vtarih+" teslim alınma tarihi: "+atarih+"</html>";
			    return sonuc;
			    
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
			
		}
		}
	public void musterikayit (String kimlikno,String ad,String soyad,String dogum) {
		ResultSet resultSet =connection("select musterino from musteri order by musterino desc limit 1;");
		int i=0;
		try {
			while (resultSet.next()) {
			     i= resultSet.getInt("musterino");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
		String url = "jdbc:postgresql://localhost:5432/veritabani";
		String user = "postgres";
		String password = "1234";
		try {
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement st = connection.prepareStatement("INSERT INTO musteri VALUES (?, ?, ?, ?, ?)");
            st.setInt(1, i+1);
            st.setString(2, ad);
            st.setString(3, soyad);
            st.setString(4, dogum);
            st.setString(5, kimlikno);
            st.executeUpdate();
            st.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	

}
