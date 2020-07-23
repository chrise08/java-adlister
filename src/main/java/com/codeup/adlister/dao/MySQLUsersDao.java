package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import models.Config;

import java.sql.*;


public class MySQLUsersDao implements Users {
	
	private Connection connection;
	
	public MySQLUsersDao(Config config) {
		try {
			DriverManager.registerDriver(new Driver());
			connection = DriverManager.getConnection(
					config.getUrl(),
					config.getUsername(),
					config.getPassword()
            );
		}
		catch (SQLException e) {
			throw new RuntimeException("Could not connect to database.", e);
		}
		
	}
	
	@Override
	public User findByUsername(String username) {
		String searchQuery = "SELECT * FROM users WHERE username = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(searchQuery);
			stmt.setString(1, username);
			return getUser(stmt.executeQuery());
		}
		catch (SQLException e) {
			throw new RuntimeException("Could not find user.", e);
		}
	}
	
	@Override
	public Long insert(User user) {
		String searchQuery = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(searchQuery, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			return rs.getLong(1);
		}
		catch (SQLException e) {
			throw new RuntimeException("Error creating new user.", e);
		}
	}
	
	private User getUser(ResultSet rs) throws SQLException {
		
		if (! rs.next()) {
			return null;
		}
		
		return new User (
				rs.getLong("id"),
				rs.getString("username"),
				rs.getString("email"),
				rs.getString("password")
		);
	}
}
