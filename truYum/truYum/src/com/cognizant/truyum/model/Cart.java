package com.cognizant.truyum.model;

import java.util.List;

public class Cart {
	private List<MenuItem> MenuItemList;
	private double total;

	public Cart() {
		super();
	}

	public List<MenuItem> getMenuItemList() {
		return MenuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		MenuItemList = menuItemList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MenuItemList == null) ? 0 : MenuItemList.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (MenuItemList == null) {
			if (other.MenuItemList != null)
				return false;
		} else if (!MenuItemList.equals(other.MenuItemList))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

	

	
	
}
