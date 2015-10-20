SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema phoneBook_database
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema phoneBook_database
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `phoneBook_database` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `phoneBook_database` ;

-- -----------------------------------------------------
-- Table `phoneBook_database`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `phoneBook_database`.`address` (
  `id_address` INT NOT NULL COMMENT '',
  `city` VARCHAR(45) NULL COMMENT '',
  `street` VARCHAR(45) NULL COMMENT '',
  `houseNumber` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id_address`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phoneBook_database`.`number`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `phoneBook_database`.`number` (
  `id_phoneNumber` INT NOT NULL COMMENT '',
  `prefix` VARCHAR(45) NULL COMMENT '',
  `number` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id_phoneNumber`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phoneBook_database`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `phoneBook_database`.`person` (
  `id_person` INT NOT NULL COMMENT '',
  `firstname` VARCHAR(45) NULL COMMENT '',
  `surname` VARCHAR(45) NULL COMMENT '',
  `number_id_phoneNumber` INT NOT NULL COMMENT '',
  `address_id_address` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id_person`, `number_id_phoneNumber`, `address_id_address`)  COMMENT '',
  INDEX `fk_person_number_idx` (`number_id_phoneNumber` ASC)  COMMENT '',
  INDEX `fk_person_address1_idx` (`address_id_address` ASC)  COMMENT '',
  CONSTRAINT `fk_person_number`
    FOREIGN KEY (`number_id_phoneNumber`)
    REFERENCES `phoneBook_database`.`number` (`id_phoneNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_person_address1`
    FOREIGN KEY (`address_id_address`)
    REFERENCES `phoneBook_database`.`address` (`id_address`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `phonebook_database`.`address` (`id_address`, `city`, `street`, `houseNumber`) VALUES ('1', 'Lodz', 'Sterlinga', '1');
INSERT INTO `phonebook_database`.`address` (`id_address`, `city`, `street`, `houseNumber`) VALUES ('2', 'Warszawa', 'Zelazna', '4');
INSERT INTO `phonebook_database`.`address` (`id_address`, `city`, `street`, `houseNumber`) VALUES ('3', 'Barcelona', 'Major', '89');
INSERT INTO `phonebook_database`.`address` (`id_address`, `city`, `street`, `houseNumber`) VALUES ('4', 'Lleida', 'Fleming', '5');

INSERT INTO `phonebook_database`.`number` (`id_phoneNumber`, `prefix`, `number`) VALUES ('1', '48', '567432789');
INSERT INTO `phonebook_database`.`number` (`id_phoneNumber`, `prefix`, `number`) VALUES ('2', '34', '435645375');
INSERT INTO `phonebook_database`.`number` (`id_phoneNumber`, `prefix`, `number`) VALUES ('3', '48', '324756967');

INSERT INTO `phonebook_database`.`person` (`id_person`, `firstname`, `surname`, `number_id_phoneNumber`, `address_id_address`) VALUES ('1', 'Jan', 'Kowalski', '1', '2');
INSERT INTO `phonebook_database`.`person` (`id_person`, `firstname`, `surname`, `number_id_phoneNumber`, `address_id_address`) VALUES ('2', 'Jacek', 'Nowak', '2', '2');
INSERT INTO `phonebook_database`.`person` (`id_person`, `firstname`, `surname`, `number_id_phoneNumber`, `address_id_address`) VALUES ('3', 'Anna', 'Hanna', '3', '1');



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
