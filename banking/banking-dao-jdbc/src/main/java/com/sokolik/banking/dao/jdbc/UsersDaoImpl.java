package com.sokolik.banking.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sokolik.banking.dao.UsersDao;
import com.sokolik.banking.dao.exceptions.DaoException;
import com.sokolik.banking.dao.jdbc.db.DbPool;
import com.sokolik.banking.entity.Users;

public class UsersDaoImpl implements UsersDao{

	private static final String SELECT_ALL_SQL = "SELECT id_user, login, password, role, del_status FROM users";
	
	private static final String SELECT_BY_ID_SQL = "SELECT id_user, login, password, role, del_status FROM users WHERE id_user=?";

	private static final String SELECT_BY_LOGIN_SQL = "SELECT id_user, login, password, role, del_status FROM users WHERE login=?";

	private static final String INSERT_SQL = "INSERT INTO users(login, password, role, del_status) VALUES (?, ?, ?, ?)";

	private static final String UPDATE_SQL = "UPDATE users SET login=?, password=?, role=?, del_status=? WHERE id_user=?";

	private static final String DELETE_SQL = "DELETE FROM users WHERE id_user=?";

	@Override
	public Integer insert(Users ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, ob.getLogin());
			statement.setString(2, ob.getPassword());
			statement.setInt(3, ob.getRole());
			statement.setInt(4, ob.getDel_status());
			
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
	public void update(Users ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(UPDATE_SQL);

			statement.setString(1, ob.getLogin());
			statement.setString(2, ob.getPassword());
			statement.setInt(3, ob.getRole());
			statement.setInt(4, ob.getDel_status());
			statement.setInt(5, ob.getId());

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbPool.getPool().closeDbResources(connection, statement, resultSet);
		}
	}

	@Override
	public void delete(Integer userId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(DELETE_SQL);

			statement.setInt(1, userId);

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbPool.getPool().closeDbResources(connection, statement, resultSet);
		}
	}

	@Override
	public Users getById(int id) {
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
				Integer role = resultSet.getInt("role");
				Integer del_status = resultSet.getInt("del_status");

				Users user = new Users();
				user.setId(idUser);
				user.setLogin(login);
				user.setPassword(password);
				user.setRole(role);
				user.setDel_status(del_status);

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
	public Users getByLogin(String name) {
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
				Integer role = resultSet.getInt("role");
				Integer del_status = resultSet.getInt("del_status");

				Users user = new Users();
				user.setId(idUser);
				user.setLogin(login);
				user.setPassword(password);
				user.setRole(role);
				user.setDel_status(del_status);

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
	public List<Users> getAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<Users> allUsers = new ArrayList<>();

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(SELECT_ALL_SQL);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Integer idUser = resultSet.getInt("id_user");
				String login = resultSet.getString("login");
				String password = resultSet.getString("password");
				Integer role = resultSet.getInt("role");
				Integer del_status = resultSet.getInt("del_status");

				Users user = new Users();
				user.setId(idUser);
				user.setLogin(login);
				user.setPassword(password);
				user.setRole(role);
				user.setDel_status(del_status);

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
