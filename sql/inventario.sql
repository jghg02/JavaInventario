# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: localhost (MySQL 5.7.18)
# Database: inventario
# Generation Time: 2017-08-05 17:15:22 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table Bodega
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Bodega`;

CREATE TABLE `Bodega` (
  `idBodega` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`idBodega`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table Product
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Product`;

CREATE TABLE `Product` (
  `idProduct` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` decimal(20,0) NOT NULL,
  `category` varchar(45) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idProduct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;

INSERT INTO `Product` (`idProduct`, `name`, `description`, `price`, `category`, `picture`)
VALUES
	(1,'Test test','test',12,'TES',NULL),
	(2,'Name','kdjfkdf',9348,'CAtegory',NULL),
	(3,'Name','kdjfkdf',9,'CAtegory',NULL),
	(4,'tew','eywtewyet',23,'etwy',NULL),
	(5,'josue','jdodoj',23,'jodur',NULL),
	(6,'irueir','kdjdj	',232,'iwuiew',NULL),
	(7,'josue','wjo',32,'jos',NULL);

/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Transaction
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Transaction`;

CREATE TABLE `Transaction` (
  `idTransaction` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `type` enum('IN','OUT') NOT NULL,
  `Product_idProduct` int(11) NOT NULL,
  `Bodega_idBodega` int(11) NOT NULL,
  `date` datetime(2) DEFAULT NULL,
  PRIMARY KEY (`idTransaction`),
  KEY `fk_Transaction_Product_idx` (`Product_idProduct`),
  KEY `fk_Transaction_Bodega1_idx` (`Bodega_idBodega`),
  CONSTRAINT `fk_Transaction_Bodega1` FOREIGN KEY (`Bodega_idBodega`) REFERENCES `Bodega` (`idBodega`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transaction_Product` FOREIGN KEY (`Product_idProduct`) REFERENCES `Product` (`idProduct`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
