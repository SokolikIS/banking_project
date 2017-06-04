package com.sokolik.banking.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sokolik.banking.dao.TransactionsDao;
import com.sokolik.banking.dao.exceptions.DaoException;
import com.sokolik.banking.dao.jdbc.db.DbPool;
import com.sokolik.banking.entity.Transactions;


public class TransactionsDaoImpl implements TransactionsDao{

	private static final String SELECT_ALL_SQL = "SELECT id_transaction, id_from, id_to, amount FROM transactions";
	
	private static final String SELECT_BY_ID_SQL = "SELECT id_transaction, id_from, id_to, amount FROM transactions WHERE id_transaction=?";

	private static final String INSERT_SQL = "INSERT INTO transactions(id_from, id_to, amount) VALUES (?, ?, ?)";

	private static final String UPDATE_SQL = "UPDATE transactions SET id_from=?, id_to=?, amount=? WHERE id_transaction=?";

	private static final String DELETE_SQL = "DELETE FROM transactions WHERE id_transaction=?";
	
	@Override
	public Integer insert(Transactions ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
			
			statement.setInt(1, ob.getIdFrom());
			statement.setInt(2, ob.getIdTo());
			statement.setInt(3, ob.getAmount());
			
			
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
	public void update(Transactions ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(UPDATE_SQL);

			statement.setInt(1, ob.getIdFrom());
			statement.setInt(2, ob.getIdTo());
			statement.setInt(3, ob.getAmount());
			statement.setInt(3, ob.getId_transaction());

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
	public Transactions getById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(SELECT_BY_ID_SQL);
			statement.setInt(1, id);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Integer idTrans = resultSet.getInt("id_transaction");
				Integer idFrom = resultSet.getInt("id_from");
				Integer idTo = resultSet.getInt("id_to");
				Integer amount = resultSet.getInt("amount");
				

				Transactions trans = new Transactions();
				trans.setId_transaction(idTrans);
				trans.setIdFrom(idFrom);
				trans.setIdTo(idTo);
				trans.setAmount(amount);
				

				return trans;
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbPool.getPool().closeDbResources(connection, statement, resultSet);
		}

		return null;
	}

	@Override
	public List<Transactions> getAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<Transactions> allTrans = new ArrayList<>();

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(SELECT_ALL_SQL);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Integer idTrans = resultSet.getInt("id_transaction");
				Integer idFrom = resultSet.getInt("id_from");
				Integer idTo = resultSet.getInt("id_to");
				Integer amount = resultSet.getInt("amount");
				

				Transactions trans = new Transactions();
				trans.setId_transaction(idTrans);
				trans.setIdFrom(idFrom);
				trans.setIdTo(idTo);
				trans.setAmount(amount);

				allTrans.add(trans);
			}

			return allTrans;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbPool.getPool().closeDbResources(connection, statement, resultSet);
		}
	}
	
	

}
