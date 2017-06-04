package com.sokolik.banking.dao.jdbc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbPool {

	private static final String DS_NAME = "jdbc/banking";

	private static final DbPool pool;

	static {
		try {
			pool = new DbPool();
		} catch (NamingException e) {
			throw new RuntimeException("Some errors occurred during DB initialization! Application will not work corrctly!", e);
		}
	}

	public static DbPool getPool() {
		return pool;
	}

	private DataSource dataSource;

	private DbPool() throws NamingException {
		Context context = new InitialContext();
		Context root = (Context) context.lookup("java:/comp/env");
		dataSource = (DataSource) root.lookup(DS_NAME);
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public void closeDbResources(Connection connection) {
		closeDbResources(connection, null);
	}

	public void closeDbResources(Connection connection, PreparedStatement statement) {
		closeDbResources(connection, statement, null);
	}

	public void closeDbResources(Connection connection, PreparedStatement statement, ResultSet resultSet) {
		closeResultSet(resultSet);
		closeStatement(statement);
		closeConnection(connection);
	}

	public void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}

	public void closeStatement(PreparedStatement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
			}
		}
	}

	public void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
			}
		}
	}
}
