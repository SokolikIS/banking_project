package com.sokolik.banking.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sokolik.banking.dao.BankingCardsDao;
import com.sokolik.banking.dao.exceptions.DaoException;
import com.sokolik.banking.dao.jdbc.db.DbPool;
import com.sokolik.banking.entity.BankingCards;

public class BankingCardsDaoImpl implements BankingCardsDao{
	
	private static final String SELECT_ALL_SQL = "SELECT id_card, id_user, number, date, currency FROM banking_cards";
	
	private static final String SELECT_BY_ID_SQL = "SELECT id_card, id_user, number, date, currency FROM banking_cards WHERE id_user=?";

	private static final String SELECT_BY_NUMBER_SQL = "SELECT id_card, id_user, number, date, currency FROM banking_cards WHERE number=?";

	private static final String INSERT_SQL = "INSERT INTO banking_cards(id_user, number, date, currency) VALUES (?, ?, ?, ?)";

	private static final String UPDATE_SQL = "UPDATE banking_cards SET id_user=?, number=?, date=?, currency=? WHERE id_card=?";

	private static final String DELETE_SQL = "DELETE FROM banking_cards WHERE id_card=?";

	@Override
	public Integer insert(BankingCards ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
			
			statement.setInt(1, ob.getId_card());
			statement.setString(2, ob.getNumber());
			statement.setString(3, ob.getDate());
			statement.setInt(4, ob.getCurrency());
			
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
	public void update(BankingCards ob) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(UPDATE_SQL);

			statement.setInt(1, ob.getId_card());
			statement.setString(2, ob.getNumber());
			statement.setString(3, ob.getDate());
			statement.setInt(4, ob.getCurrency());
			statement.setInt(5, ob.getId_card());

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
	public BankingCards getById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(SELECT_BY_ID_SQL);
			statement.setInt(1, id);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Integer idCard = resultSet.getInt("id_card");
				Integer idUser = resultSet.getInt("id_user");
				String number = resultSet.getString("number");
				String date = resultSet.getString("date");
				Integer currency = resultSet.getInt("currency");
				

				BankingCards card = new BankingCards();
				card.setId_card(idCard);
				card.setId_user(idUser);
				card.setNumber(number);
				card.setDate(date);
				card.setCurrency(currency);

				return card;
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbPool.getPool().closeDbResources(connection, statement, resultSet);
		}

		return null;
	}

	@Override
	public BankingCards getByNumber(String name) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(SELECT_BY_NUMBER_SQL);
			statement.setString(1, name);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Integer idCard = resultSet.getInt("id_card");
				Integer idUser = resultSet.getInt("id_user");
				String number = resultSet.getString("number");
				String date = resultSet.getString("date");
				Integer currency = resultSet.getInt("currency");
				

				BankingCards card = new BankingCards();
				card.setId_card(idCard);
				card.setId_user(idUser);
				card.setNumber(number);
				card.setDate(date);
				card.setCurrency(currency);

				return card;
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbPool.getPool().closeDbResources(connection, statement, resultSet);
		}

		return null;
	}

	@Override
	public List<BankingCards> getAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		List<BankingCards> allCards = new ArrayList<>();

		try {
			connection = DbPool.getPool().getConnection();
			statement = connection.prepareStatement(SELECT_ALL_SQL);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Integer idCard = resultSet.getInt("id_card");
				Integer idUser = resultSet.getInt("id_user");
				String number = resultSet.getString("number");
				String date = resultSet.getString("date");
				Integer currency = resultSet.getInt("currency");
				

				BankingCards card = new BankingCards();
				card.setId_card(idCard);
				card.setId_user(idUser);
				card.setNumber(number);
				card.setDate(date);
				card.setCurrency(currency);

				allCards.add(card);
			}

			return allCards;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			DbPool.getPool().closeDbResources(connection, statement, resultSet);
		}
	}

}
