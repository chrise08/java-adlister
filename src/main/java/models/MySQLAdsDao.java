package models;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements Ads{
	
	private Connection connection;
	
	public MySQLAdsDao(Config config) {
		try {
			DriverManager.registerDriver(new Driver());
			this.connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Ad> all() {
		List<Ad> ads = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
			
			while (rs.next()) {
				ads.add(new Ad(
						rs.getLong("id"),
						rs.getLong("user_id"),
						rs.getString("title"),
						rs.getString("description")
				));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return ads;
	}
	
	@Override
	public Long insert(Ad ad) {
		long lastInsertedId = 0;
		
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(String.format("INSERT INTO ads (user_id, title, description) VALUES (%d, "
			                                 + "'%s', '%s')", ad.getUserId(), ad.getTitle(),
			                                 ad.getDescription()), Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				lastInsertedId = rs.getLong(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return lastInsertedId;
	}
}
