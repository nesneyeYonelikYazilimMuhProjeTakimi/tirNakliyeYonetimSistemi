package proje.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class connectdb {
	public ResultSet connection(String sqlQuery) {
		String url = "jdbc:postgresql://localhost:5432/veritabani";
		String user = "postgres";
		String password = "1234";
		try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            
            /*while (resultSet.next()) {
                String ad = resultSet.getString("ad");
                System.out.println(ad);
            }*/
            
            /*resultSet.close();
            statement.close();
            connection.close();*/
            return resultSet;
        } catch (ClassNotFoundException | SQLException e) {
        	e.printStackTrace();
        	return null;
        }
	}
}