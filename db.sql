/*
SQLyog Ultimate v8.32 
MySQL - 5.5.49 : Database - library
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`library` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `library`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bid` varchar(255) NOT NULL,
  `bname` varchar(50) NOT NULL,
  `bprice` double DEFAULT NULL,
  `bimage` varchar(200) DEFAULT NULL,
  `bdate` datetime DEFAULT NULL,
  `is_hot` int(11) DEFAULT NULL,
  `bdesc` varchar(255) DEFAULT NULL,
  `cid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`bid`,`bname`,`bprice`,`bimage`,`bdate`,`is_hot`,`bdesc`,`cid`) values ('1','深蓝的故事',38,'books/1.jpg','2018-09-04 00:00:00',1,'警察故事，纪实，社会','1'),('2','无中生有的世界',58,'books/2.jpg','2018-09-03 00:00:00',0,'科普，自然科学，物理','2'),('3','西西里柠檬',48,'books/3.jpg','2018-08-23 00:00:00',1,'亲情，感情','1'),('ab31187c-e7a5-41b4-8857-cbd9ef41bdb1','乔布斯传记',99,'books/1.jpg','2018-09-08 00:00:00',1,'乔布斯，传记，爱好','2');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `cid` varchar(32) NOT NULL,
  `cname` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`cid`,`cname`) values ('1','文学艺术'),('2','科普读物'),('3','考研辅导'),('4','青春文学');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
