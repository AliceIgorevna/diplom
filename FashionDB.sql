SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema fashionDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fashionDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `fashionDB` ;

-- -----------------------------------------------------
-- Table `fashionDB`.`UserRole`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fashionDB`.`UserRole` (
  `idUserRole` INT NOT NULL AUTO_INCREMENT,
  `RoleName` VARCHAR(45) NOT NULL DEFAULT 'user',
  PRIMARY KEY (`idUserRole`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fashionDB`.`UserData`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fashionDB`.`UserData` (
  `idUserData` INT NOT NULL AUTO_INCREMENT,
  `Email` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `BirthDate` DATE NULL,
  `UserRole_idUserRole` INT NOT NULL,
  PRIMARY KEY (`idUserData`),
  INDEX `fk_UserData_UserRole1_idx` (`UserRole_idUserRole` ASC),
  CONSTRAINT `fk_UserData_UserRole1`
    FOREIGN KEY (`UserRole_idUserRole`)
    REFERENCES `fashionDB`.`UserRole` (`idUserRole`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fashionDB`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fashionDB`.`Product` (
  `idProduct` INT NOT NULL AUTO_INCREMENT,
  `ProductName` VARCHAR(45) NOT NULL,
  `ProductDesc` VARCHAR(45) NULL,
  PRIMARY KEY (`idProduct`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fashionDB`.`Discount`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fashionDB`.`Discount` (
  `idDiscount` INT NOT NULL AUTO_INCREMENT,
  `DiscountAmount` INT NOT NULL,
  `UniqCode` VARCHAR(45) NULL,
  `DiscountEndDate` DATE NULL,
  PRIMARY KEY (`idDiscount`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fashionDB`.`Total`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fashionDB`.`Total` (
  `idTotal` INT NOT NULL AUTO_INCREMENT,
  `UserData_idUserData` INT NOT NULL,
  `Discount_idDiscount` INT NOT NULL,
  `Product_idProduct` INT NOT NULL,
  PRIMARY KEY (`idTotal`),
  INDEX `fk_Total_UserData1_idx` (`UserData_idUserData` ASC),
  INDEX `fk_Total_Discount1_idx` (`Discount_idDiscount` ASC),
  INDEX `fk_Total_Product1_idx` (`Product_idProduct` ASC),
  CONSTRAINT `fk_Total_UserData1`
    FOREIGN KEY (`UserData_idUserData`)
    REFERENCES `fashionDB`.`UserData` (`idUserData`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Total_Discount1`
    FOREIGN KEY (`Discount_idDiscount`)
    REFERENCES `fashionDB`.`Discount` (`idDiscount`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Total_Product1`
    FOREIGN KEY (`Product_idProduct`)
    REFERENCES `fashionDB`.`Product` (`idProduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
