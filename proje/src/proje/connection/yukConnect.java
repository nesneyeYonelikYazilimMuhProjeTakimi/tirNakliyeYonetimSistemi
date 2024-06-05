package proje.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class yukConnect extends connectdb{
	public void yukEkle (int yukagirligi,String teslimedilecekadres,String teslimalinacakil,int ucret) {
		ResultSet resultSet =connection("select yukno from yuk order by yukno desc limit 1;");
		int i=0;
		try {
			while (resultSet.next()) {
			     i= resultSet.getInt("yukno");
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

            PreparedStatement st = connection.prepareStatement("INSERT INTO yuk VALUES (?, ?, ?, ?, ?, ?)");
            st.setInt(1, i+1);
            st.setInt(2, yukagirligi);
            st.setString(3, teslimedilecekadres);
            st.setString(4, teslimalinacakil);
            st.setString(5, "");
            st.setInt(6, ucret);
            st.executeUpdate();
            st.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
}
