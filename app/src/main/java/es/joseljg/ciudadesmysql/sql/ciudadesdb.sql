-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ciudadesdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ciudadesdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ciudadesdb` DEFAULT CHARACTER SET utf8 ;
USE `ciudadesdb` ;

-- -----------------------------------------------------
-- Table `ciudadesdb`.`provincias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ciudadesdb`.`provincias` (
  `idprovincia` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idprovincia`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 31
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ciudadesdb`.`ciudades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ciudadesdb`.`ciudades` (
  `idciudad` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `habitantes` INT NULL DEFAULT NULL,
  `idprovincia` INT NOT NULL,
  PRIMARY KEY (`idciudad`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE,
  INDEX `fk_ciudades_provincias_idx` (`idprovincia` ASC) VISIBLE,
  CONSTRAINT `fk_ciudades_provincias`
    FOREIGN KEY (`idprovincia`)
    REFERENCES `ciudadesdb`.`provincias` (`idprovincia`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 42
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ciudadesdb`.`fotos_ciudades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ciudadesdb`.`fotos_ciudades` (
  `idfoto` INT NOT NULL AUTO_INCREMENT,
  `foto` MEDIUMBLOB NOT NULL,
  `idciudad` INT NOT NULL,
  PRIMARY KEY (`idfoto`),
  INDEX `fk_fotos_ciudades_ciudades1_idx` (`idciudad` ASC) VISIBLE,
  UNIQUE INDEX `idciudad_UNIQUE` (`idciudad` ASC) VISIBLE,
  CONSTRAINT `fk_fotos_ciudades_ciudades1`
    FOREIGN KEY (`idciudad`)
    REFERENCES `ciudadesdb`.`ciudades` (`idciudad`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 42
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
