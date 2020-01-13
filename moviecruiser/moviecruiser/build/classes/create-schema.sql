-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema moviecruiser
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema moviecruiser
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `moviecruiser` DEFAULT CHARACTER SET utf8 ;
USE `moviecruiser` ;

-- -----------------------------------------------------
-- Table `moviecruiser`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecruiser`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(60) NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moviecruiser`.`movie_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecruiser`.`movie_list` (
  `mo_id` INT NOT NULL AUTO_INCREMENT,
  `mo_title` VARCHAR(100) NULL,
  `mo_gross($)` DECIMAL NULL,
  `mo_active` VARCHAR(3) NULL,
  `mo_genre` VARCHAR(45) NULL,
  `mo_date_of_launch` DATE NULL,
  `mo_has_teaser` VARCHAR(3) NULL,
  PRIMARY KEY (`mo_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moviecruiser`.`favorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moviecruiser`.`favorite` (
  `fv_id` INT NOT NULL AUTO_INCREMENT,
  `fv_us_id` INT NULL,
  `fv_mo_id` INT NULL,
  PRIMARY KEY (`fv_id`),
  INDEX `fk_favorite_user_idx` (`fv_us_id` ASC),
  INDEX `fk_favorite_movie_list1_idx` (`fv_mo_id` ASC),
  CONSTRAINT `fv_us_id`
    FOREIGN KEY (`fv_us_id`)
    REFERENCES `moviecruiser`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fv_mo_id`
    FOREIGN KEY (`fv_mo_id`)
    REFERENCES `moviecruiser`.`movie_list` (`mo_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
