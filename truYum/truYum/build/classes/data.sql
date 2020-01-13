/*View Menu Item List Admin */
    
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'Sandwich', '99', '1', '2020-03-15', 'Main Course', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'Burger', '129', '1', '2020-03-14', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'Pizza', '149', '1', '2020-03-13', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'French Fries', '57', '0', '2020-03-12', 'Starters', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'Chocalate Brownie', '32', '1', '2020-03-11', 'Desserts', '1');

SELECT * FROM truyum.menu_item;

use truyum;

insert into user(us_id,us_name)values(1,'Tharini');
insert into user(us_id,us_name)values(2,'Srinithi');

/*	View Menu Item List Customer */

select * from truyum.menu_item
where me_date_of_launch >(select curdate()) AND me_active='1';

/*	Edit Menu Item */

select * from truyum.menu_item where me_id=1;

update truyum.menu_item set me_name="Fish" ,me_price=700, me_active='0',me_date_of_launch='2020-01-03',me_category="Starter",me_free_delivery='1' where me_id=1;

/*	Add to Cart */

INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_me_id`) VALUES ('1', '1');
INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_me_id`) VALUES ('1', '3');
INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_me_id`) VALUES ('1', '5');

/*	View Cart */

select me_name,me_free_delivery ,me_price from
truyum.cart
inner join
truyum.menu_item on menu_item.me_id=cart.ct_me_id
inner join user on user.us_id=cart.ct_us_id
where user.us_id=1;

select sum(me_price)as Total from truyum.menu_item
inner join
truyum.cart on ct_me_id=me_id
where ct_us_id=1;

/*	Remove Item from Cart */

delete from truyum.cart where ct_me_id=1 and ct_us_id=1;