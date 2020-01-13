
/*	View Movie List Admin */

INSERT INTO `moviecruiser`.`movie_list` (`mo_title`, `mo_gross($)`, `mo_active`, `mo_genre`, `mo_date_of_launch`, `mo_has_teaser`) VALUES ('Avatar', '2787965087', '1', 'Science Fiction', '2020-01-06', '1');
INSERT INTO `moviecruiser`.`movie_list` (`mo_title`, `mo_gross($)`, `mo_active`, `mo_genre`, `mo_date_of_launch`, `mo_has_teaser`) VALUES ('The Avengers', '1518812988', '1', 'Superhero', '2020-01-07', '0');
INSERT INTO `moviecruiser`.`movie_list` (`mo_title`, `mo_gross($)`, `mo_active`, `mo_genre`, `mo_date_of_launch`, `mo_has_teaser`) VALUES ('Titanic', '2187463944', '1', 'Romance', '2020-01-08', '0');
INSERT INTO `moviecruiser`.`movie_list` (`mo_title`, `mo_gross($)`, `mo_active`, `mo_genre`, `mo_date_of_launch`, `mo_has_teaser`) VALUES ('Jurassic World', '1671713208', '0', 'Science Fiction', '2020-01-01', '1');
INSERT INTO `moviecruiser`.`movie_list` (`mo_title`, `mo_gross($)`, `mo_active`, `mo_genre`, `mo_date_of_launch`, `mo_has_teaser`) VALUES ('Avengers:End Game', '2750760348', '1', 'Superhero', '2020-01-02', '1');

SELECT * FROM moviecruiser.movie_list;

use moviecruiser;

insert into user(us_id,us_name)values(1,'Tharini');
insert into user(us_id,us_name)values(2,'Srinithi');

/*	View Movie List Customer */

select * from moviecruiser.movie_list
where mo_date_of_launch >(select curdate()) AND mo_active='1';

/*	Edit Movie List */

select * from moviecruiser.movie_list where mo_id=1;

update moviecruiser.movie_list set mo_title="Robot" ,mo_gross=200000000, mo_active='0',mo_date_of_launch='2020-01-03',mo_genre="Thriller",mo_has_teaser='1' where mo_id=1;

/*Add to Favorite */

INSERT INTO `moviecruiser`.`favorite` (`fv_us_id`, `fv_mo_id`) VALUES ('1', '1');
INSERT INTO `moviecruiser`.`favorite` (`fv_us_id`, `fv_mo_id`) VALUES ('1', '3');
INSERT INTO `moviecruiser`.`favorite` (`fv_us_id`, `fv_mo_id`) VALUES ('1', '5');

/*	View Favorite */

select mo_title,mo_gross,mo_genre from
moviecruiser.movie_list
inner join
moviecruiser.favorite on fv_mo_id=mo_id
where fv_us_id=1;

select count(movie_list.mo_id) as NumberofFavorites from
moviecruiser.movie_list
inner join
moviecruiser.favorite on fv_mo_id=mo_id
where fv_us_id=1;

/*	Remove Movie from Favorite */

delete from moviecruiser.favorite where fv_mo_id=1 and fv_us_id=1;

