package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	public static final String ADD_MENUITEM_TO_CART = "insert into cart(ct_us_id,ct_me_id) values (?,?)";

	public void addCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(ADD_MENUITEM_TO_CART);
			statement.setLong(1, userId);
			statement.setLong(2, menuItemId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number Of Rows Affected" + noOfRows);
		} catch (SQLException e) {
			System.out.println("Items Not Added into Cart");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
		}
	}

	public static final String GET_CARTITEM = "select menu_item.me_id,menu_item.me_name,menu_item.me_free_delivery,menu_item.me_price from cart\r\n"
			+ "inner join menu_item on menu_item.me_id=cart.ct_me_id\r\n"
			+ "inner join user on user.us_id = cart.ct_us_id\r\n" + "where user.us_id = ?";

	public static final String GET_TOTAL = "select user.us_id,sum(menu_item.me_price) as Total from cart\r\n"
			+ "inner join menu_item on menu_item.me_id = cart.ct_me_id\r\n"
			+ "inner join user on user.us_id = cart.ct_us_id\r\n" + "where user.us_id = ?";

	public Cart getAllCartItems(long userId) throws CartEmptyException {
		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ResultSet resultSettotal = null;
		Cart cart = new Cart();
		try {
			statement = connection.prepareStatement(GET_CARTITEM);
			statement.setLong(1, userId);
			resultSet = statement.executeQuery();
			System.out.println("Number Of Rows Affected" + resultSet);
			while (resultSet.next()) {
				MenuItem menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItemList.add(menuItem);
			}
			if (menuItemList.size() == 0) {
				throw new CartEmptyException();
			}
			cart.setMenuItemList(menuItemList);
			preparedStatement = connection.prepareStatement(GET_TOTAL);
			preparedStatement.setLong(1, userId);
			resultSettotal = preparedStatement.executeQuery();
			System.out.println("Number Of Rows Affected" + resultSettotal);
			double total = 0.0;
			while (resultSettotal.next()) {
				total = resultSettotal.getDouble("Total");
			}
			System.out.println(total);
			cart.setTotal(total);
		} catch (SQLException e) {
			System.out.println("Data Not Displayed");
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (resultSettotal != null)
					resultSettotal.close();
				if (statement != null)
					statement.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}
		return cart;
	}

	public static final String REMOVE_CARTITEM = "delete from cart where ct_us_id = ? AND ct_me_id = ? limit 1";

	public void removeCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(REMOVE_CARTITEM);
			statement.setLong(1, userId);
			statement.setLong(2, menuItemId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number Of Rows Affected" + noOfRows);
		} catch (SQLException e) {
			System.out.println("Items Not Removed from Cart");
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {

			}
		}
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
		}
	}

}
