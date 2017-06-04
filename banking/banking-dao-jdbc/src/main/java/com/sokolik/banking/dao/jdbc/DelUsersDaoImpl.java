package com.sokolik.banking.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sokolik.banking.dao.DelUsersDao;
import com.sokolik.banking.dao.exceptions.DaoException;
import com.sokolik.banking.dao.jdbc.db.DbPool;
import com.sokolik.banking.entity.DelUsers;

public class DelUsersDaoImpl implements DelUsersDao{

	private static final String SELECT_ALL_SQL = "SELECT id_user, login, password, ip, status, email FROM del_users";
	
	private static final String SELECT_BY_ID_SQL = "SELECT id_user, login, password, ip, status, email FROM del_users WHERE id_user=?";

	private static final String SELECT_BY_LOGIN_SQL = "SELECT id_user, login, password, ip, status, email FROM del_users WHERE login=?";
	
	private static final String SELECT_BY_EMAIL_SQL = "SELECT id_user, login, password, ip, status, email FROM del_users WHERE email=?";

	private static final String INSERT_SQL = "INSERT INTO del_users(login, password, ip, status, email) VALUES (?, ?, ?, ?, ?)";

	private static final String UPDATE_SQL = "UPDATE del_users SET login=?, password=?, ip=?, status=?, email=? WHERE id_user=?";

	private static final String DELETE_SQL = "DELETE FROM del_users WHERE id_user=?";
	
	@Override
	public Integer insert(DelUsers ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, ob.getLogin());
			statement.setString(2, ob.getPassword());
			statement.setString(3, ob.getIp());
			statement.setInt(4, ob.getDel_status());
			statement.setString(5, ob.getEmail());
			
			statement.executeUpdate();

			resultSet = statement.getGeneratedKeys();
			resultSet.next();

			return resultSet.getInt(1);
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		
	}

	@Override
	public void update(DelUsers ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(UPDATE_SQL);

			statement.setString(1, ob.getLogin());
			statement.setString(2, ob.getPassword());
			statement.setString(3, ob.getIp());
			statement.setInt(4, ob.getDel_status());
			statement.setString(5, ob.getEmail());
			statement.setInt(6, ob.getId());

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		
	}

	@Override
	public void delete(Integer id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(DELETE_SQL);

			statement.setInt(1, id);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbPool.getPool().closeDbResources(connection, statement, resultSet);
		}
		
	}

	@Override
	public DelUsers getById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(SELECT_BY_ID_SQL);
			statement.setInt(1, id);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Integer idUser = resultSet.getInt("id_user");
				String login = resultSet.getString("login");
				String password = resultSet.getString("password");
				String ip = resultSet.getString("ip");
				Integer status = resultSet.getInt("status");
				String eMail = resultSet.getString("email");

				DelUsers user = new DelUsers();
				user.setId(idUser);
				user.setLogin(login);
				user.setPassword(password);
				user.setIp(ip);
				user.setDel_status(status);
				user.setEmail(eMail);

				return user;
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbPool.getPool().closeDbResources(connection, statement, resultSet);
		}

		return null;
	}

	@Override
	public DelUsers getByLogin(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(SELECT_BY_LOGIN_SQL);
			statement.setString(1, name);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Integer idUser = resultSet.getInt("id_user");
				String login = resultSet.getString("login");
				String password = resultSet.getString("password");
				String ip = resultSet.getString("ip");
				Integer status = resultSet.getInt("status");
				String eMail = resultSet.getString("email");

				DelUsers user = new DelUsers();
				user.setId(idUser);
				user.setLogin(login);
				user.setPassword(password);
				user.setIp(ip);
				user.setDel_status(status);
				user.setEmail(eMail);

				return user;
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbPool.getPool().closeDbResources(connection, statement, resultSet);
		}

		return null;
	}
	
	@Override
	public DelUsers getByEmail(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(SELECT_BY_EMAIL_SQL);
			statement.setString(1, name);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Integer idUser = resultSet.getInt("id_user");
				String login = resultSet.getString("login");
				String password = resultSet.getString("password");
				String ip = resultSet.getString("ip");
				Integer status = resultSet.getInt("status");
				String eMail = resultSet.getString("email");

				DelUsers user = new DelUsers();
				user.setId(idUser);
				user.setLogin(login);
				user.setPassword(password);
				user.setIp(ip);
				user.setDel_status(status);
				user.setEmail(eMail);

				return user;
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbPool.getPool().closeDbResources(connection, statement, resultSet);
		}

		return null;
	}

	@Override
	public List<DelUsers> getAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<DelUsers> allUsers = new ArrayList<>();

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(SELECT_ALL_SQL);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Integer idUser = resultSet.getInt("id_user");
				String login = resultSet.getString("login");
				String password = resultSet.getString("password");
				String ip = resultSet.getString("ip");
				Integer status = resultSet.getInt("status");
				String eMail = resultSet.getString("email");

				DelUsers user = new DelUsers();
				user.setId(idUser);
				user.setLogin(login);
				user.setPassword(password);
				user.setIp(ip);
				user.setDel_status(status);
				user.setEmail(eMail);

				allUsers.add(user);
			}

			return allUsers;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbPool.getPool().closeDbResources(connection, statement, resultSet);
		}
	}


}
