-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for wrm
CREATE DATABASE IF NOT EXISTS `wrm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `wrm`;

-- Dumping structure for table wrm.shoplist
CREATE TABLE IF NOT EXISTS `shoplist` (
  `SHOP_ID` varchar(50) NOT NULL,
  `SHOP_NAME` varchar(50) DEFAULT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`SHOP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table wrm.shoplist: ~3 rows (approximately)
INSERT INTO `shoplist` (`SHOP_ID`, `SHOP_NAME`, `ADDRESS`) VALUES
	('0001', '43', '43'),
	('0002', 'Shop ACC', '44 võ chí công'),
	('0003', 'Nhật Tân Mới', '22 Hoàng Hoa thám');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
-- Dumping structure for table wrm.shopdetail
CREATE TABLE IF NOT EXISTS `shopdetail` (
  `SHOE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SHOP_ID` varchar(50) NOT NULL,
  `SHOE_NAME` varchar(40) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `SIZE` varchar(50) DEFAULT NULL,
  `COUNT` int(11) DEFAULT NULL,
  `PRICE` float DEFAULT NULL,
  `INVENTORY` int(11) DEFAULT NULL,
  PRIMARY KEY (`SHOE_ID`),
  KEY `FK1_SHOP_ID` (`SHOP_ID`),
  CONSTRAINT `FK1_SHOP_ID` FOREIGN KEY (`SHOP_ID`) REFERENCES `shoplist` (`SHOP_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- Dumping data for table wrm.shopdetail: ~7 rows (approximately)
INSERT INTO `shopdetail` (`SHOE_ID`, `SHOP_ID`, `SHOE_NAME`, `DATE`, `SIZE`, `COUNT`, `PRICE`, `INVENTORY`) VALUES
	(25, '0002', 'Real', '2022-12-12', '30', 12, 423, 43),
	(26, '0002', 'Fake', '2022-12-12', '23', 12, 23, 243),
	(27, '0002', 'REal fake', '2022-12-12', '30', 243, 423, 243),
	(31, '0002', '342', '2020-02-22', '34', 43, 34, 43),
	(32, '0001', '54', '2022-12-12', '44', 45, 45, 45),
	(33, '0002', 'ababba', '2020-12-15', '21', 12, 12, 24),
	(34, '0003', 'Real', '2022-12-12', '4', 33, 33, 66);


