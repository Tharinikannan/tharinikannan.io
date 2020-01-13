package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {
	public static void testCartDaoSqlImpl() {
		new CartDaoSqlImpl().addCartItem(1, 7);
	}

	public static void testgetAllCartItems() throws CartEmptyException {
		Cart cart = new CartDaoSqlImpl().getAllCartItems(1);
		List<MenuItem> MenuItemlist = cart.getMenuItemList();
		double Total = cart.getTotal();
		System.out.format("%-20s%-20s%-20s%-15s\n", "Id", "Name", "FreeDelivery", "Price");
		String freeDelivery;
		for (MenuItem menuItem : MenuItemlist) {
			if (menuItem.getFreeDelivery() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}

			System.out.format("%-20s%-20s%-20s%-15s\n", menuItem.getId(), menuItem.getName(), freeDelivery,
					menuItem.getPrice());
			System.out.println();
		}
		System.out.format("%-10s\n", "Total" + Total);
	}

	public static void testremoveCartItem() throws CartEmptyException {
		new CartDaoSqlImpl().removeCartItem(1, 7);
		testgetAllCartItems();
	}

	public static void main(String[] args) throws CartEmptyException {
		testCartDaoSqlImpl();
		testgetAllCartItems();
		testremoveCartItem();
	}

}
