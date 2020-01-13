package com.cognizant.truyum.dao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void testgetMenuItemListAdmin() {

		ArrayList<MenuItem> menuItemList11 = new MenuItemDaoSqlImpl().getMenuItemListAdmin();
		System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", "Id", "Name", "Price", "Active", "DOL", "Category",
				"Free Delivery");
		String active;
		String freeDelivery;
		for (MenuItem menuItem1 : menuItemList11) {
			if (menuItem1.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (menuItem1.getFreeDelivery() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}
			System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", menuItem1.getId(), menuItem1.getName(),
					menuItem1.getPrice(), active, menuItem1.getDateOfLaunch(), menuItem1.getCategory(), freeDelivery);

		}
	}

	public static void testgetMenuItemListCustomer() {
		ArrayList<MenuItem> menuItemList1 = new MenuItemDaoSqlImpl().getMenuItemListCustomer();
		System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", "Id", "Name", "Price", "Active", "DOL", "Category",
				"Free Delivery");
		String active1;
		String freeDelivery1;
		for (MenuItem menuItem1 : menuItemList1) {
			if (menuItem1.getActive() == true) {
				active1 = "Yes";
			} else {
				active1 = "No";
			}
			if (menuItem1.getFreeDelivery() == true) {
				freeDelivery1 = "Yes";
			} else {
				freeDelivery1 = "No";
			}
			System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", menuItem1.getId(), menuItem1.getName(),
					menuItem1.getPrice(), active1, menuItem1.getDateOfLaunch(), menuItem1.getCategory(), freeDelivery1);

		}
	}

	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(3L, "Rusk", 5.00f, true, new DateUtil().convertToDate("09/09/2019"), "Soft",
				true);
		new MenuItemDaoSqlImpl().modifyMenuItem(menuItem);
		ArrayList<MenuItem> menuItemList1 = new MenuItemDaoSqlImpl().getMenuItemListAdmin();
		System.out.println("AFTER MODIFICATION");
		System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", "Id", "Name", "Price", "Active", "DOL", "Category",
				"Free Delivery");
		String active1;
		String freeDelivery1;
		for (MenuItem menuItem1 : menuItemList1) {
			if (menuItem1.getActive() == true) {
				active1 = "Yes";
			} else {
				active1 = "No";
			}
			if (menuItem1.getFreeDelivery() == true) {
				freeDelivery1 = "Yes";
			} else {
				freeDelivery1 = "No";
			}
			System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", menuItem1.getId(), menuItem1.getName(),
					menuItem1.getPrice(), active1, menuItem1.getDateOfLaunch(), menuItem1.getCategory(), freeDelivery1);
		}

	}

	public static void testgetMenuItem() {

		long menuItemId = 4;
		MenuItem menuItem = new MenuItemDaoSqlImpl().getMenuItem(menuItemId);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("###.00");

		System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", "Id", "Name", "Price", "Active", "DOL", "Category",
				"Free Delivery");
		String active;
		String freeDelivery;

		if (menuItem.getActive() == true) {
			active = "Yes";
		} else {
			active = "No";
		}
		if (menuItem.getFreeDelivery() == true) {
			freeDelivery = "Yes";
		} else {
			freeDelivery = "No";
		}
		System.out.format("%-10s%-20s%-15s%-15s%-15s%-15s%-15s\n", menuItem.getId(), menuItem.getName(),
				df.format(menuItem.getPrice()), active, sdf.format(menuItem.getDateOfLaunch()), menuItem.getCategory(),
				freeDelivery);
	}

	public static void main(String[] args) {
		testgetMenuItemListAdmin();
		testgetMenuItemListCustomer();
		testModifyMenuItem();
		testgetMenuItem();
	}

}
