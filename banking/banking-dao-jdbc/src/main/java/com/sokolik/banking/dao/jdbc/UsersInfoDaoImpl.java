package com.sokolik.banking.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sokolik.banking.dao.UsersInfoDao;
import com.sokolik.banking.dao.exceptions.DaoException;
import com.sokolik.banking.dao.jdbc.db.DbPool;
import com.sokolik.banking.entity.UsersInfo;

public class UsersInfoDaoImpl implements UsersInfoDao{

	private static final String SELECT_ALL_SQL = "SELECT id_user, email, firstName, lastName, adress, sex FROM usersInfo";
	
	private static final String SELECT_BY_ID_SQL = "SELECT id_user, email, firstName, lastName, adress, sex FROM usersInfo WHERE id_user=?";

	private static final String SELECT_BY_EMAIL_SQL = "SELECT id_user, email, firstName, lastName, adress, sex FROM users WHERE email=?";

	private static final String INSERT_SQL = "INSERT INTO usersInfo(email, firstName, lastName, adress, sex) VALUES (?, ?, ?, ?, ?)";

	private static final String UPDATE_SQL = "UPDATE usersInfo SET email=?, firstName=?, lastName=?, adress=?, sex=? WHERE id_user=?";

	private static final String DELETE_SQL = "DELETE FROM usersInfo WHERE id_user=?";
	
	@Override
	public Integer insert(UsersInfo ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, ob.geteMail());
			statement.setString(2, ob.getFirstName());
			statement.setString(3, ob.getLastName());
			statement.setString(4, ob.getAdress());
			statement.setString(4, ob.getSex());
			
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
	public void update(UsersInfo ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(UPDATE_SQL);

			statement.setString(1, ob.geteMail());
			statement.setString(2, ob.getFirstName());
			statement.setString(3, ob.getLastName());
			statement.setString(4, ob.getAdress());
			statement.setString(5, ob.getSex());
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
	public UsersInfo getById(int id) {
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
				String Email = resultSet.getString("email");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String adress = resultSet.getString("adress");
				String sex = resultSet.getString("sex");
				

				UsersInfo user = new UsersInfo();
				user.setId(idUser);
				user.seteMail(Email);;
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setAdress(adress);
				user.setSex(sex);

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
	public UsersInfo getByEmail(String name) {
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
				String Email = resultSet.getString("email");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String adress = resultSet.getString("adress");
				String sex = resultSet.getString("sex");
				

				UsersInfo user = new UsersInfo();
				user.setId(idUser);
				user.seteMail(Email);;
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setAdress(adress);
				user.setSex(sex);

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
	public List<UsersInfo> getAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<UsersInfo> allUsers = new ArrayList<>();

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(SELECT_ALL_SQL);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Integer idUser = resultSet.getInt("id_user");
				String Email = resultSet.getString("email");
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				String adress = resultSet.getString("adress");
				String sex = resultSet.getString("sex");
				

				UsersInfo user = new UsersInfo();
				user.setId(idUser);
				user.seteMail(Email);;
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setAdress(adress);
				user.setSex(sex);

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
