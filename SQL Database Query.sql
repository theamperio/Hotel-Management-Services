/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 8.0.33 : Database - hotel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hotel` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `hotel`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` varchar(25) DEFAULT NULL,
  `number` varchar(25) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `country` varchar(25) DEFAULT NULL,
  `deposit` varchar(25) DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `roomno` varchar(15) DEFAULT NULL,
  `time` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customer` */

/*Table structure for table `customers` */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `id` varchar(25) DEFAULT NULL,
  `idnum` varchar(25) DEFAULT NULL,
  `name` varchar(25) DEFAULT NULL,
  `country` varchar(25) DEFAULT NULL,
  `deposit` varchar(25) DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `room` varchar(15) DEFAULT NULL,
  `time` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customers` */

insert  into `customers`(`id`,`idnum`,`name`,`country`,`deposit`,`gender`,`room`,`time`) values 
('Aadhar card','1236','Rahul','India','1000','male','12','Tue Dec 26 19:03:10 IST 2023'),
('Passport','5246','Rahul','India','1000','male','12','Tue Dec 26 19:03:10 IST 2023');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `department` varchar(100) DEFAULT NULL,
  `budget` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `department` */

insert  into `department`(`department`,`budget`) values 
('Front office','530000'),
('Management','220000'),
('Housekeeping','500000'),
('Food AND beverage','900000'),
('Kitchen AND food production','400000'),
('Maintenance','1000000'),
('Accounts AND finance','700000'),
('SECURITY','200000');

/*Table structure for table `drivers` */

DROP TABLE IF EXISTS `drivers`;

CREATE TABLE `drivers` (
  `name` varchar(25) DEFAULT NULL,
  `age` varchar(25) DEFAULT NULL,
  `company` varchar(15) DEFAULT NULL,
  `model` varchar(30) DEFAULT NULL,
  `location` varchar(15) DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `available` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `drivers` */

insert  into `drivers`(`name`,`age`,`company`,`model`,`location`,`gender`,`available`) values 
('Gandhi','26','maruti','800','bus stand','Male','Available'),
('Honey','25','Honda','h444','Airport','Male','Available');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `name` varchar(25) DEFAULT NULL,
  `age` varchar(25) DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `job` varchar(30) DEFAULT NULL,
  `salary` varchar(15) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `aadhar` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `employee` */

insert  into `employee`(`name`,`age`,`gender`,`job`,`salary`,`phone`,`email`,`aadhar`) values 
('null','null','Male','Front Desk Clerk','null','null','null','null'),
('null','null','Male','Front Desk Clerk','null','null','null','null'),
('null','null','Male','Housekeeping','null','null','null','null'),
('null','null','null','Front Desk Clerk','null','null','null','null'),
('null','null','Male','Front Desk Clerk','null','null','null','null'),
('null','null','Male','Room Services','null','null','null','null'),
('Alok','54','Male','Housekeeping','86465964','8546546551','sdfsjlfiwhlf','8434645694'),
('','','null','Manager','','','','');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `ID` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `login` */

insert  into `login`(`ID`,`password`) values 
('management','@1234'),
('admin','1234');

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `room_no` varchar(25) DEFAULT NULL,
  `availabilty` varchar(25) DEFAULT NULL,
  `cleaning_stuts` varchar(15) DEFAULT NULL,
  `price` varchar(30) DEFAULT NULL,
  `bed_type` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `room` */

insert  into `room`(`room_no`,`availabilty`,`cleaning_stuts`,`price`,`bed_type`) values 
('10','Available','Cleaned','1000','Single'),
('144','Available','Cleaned','2000','Doubled');

/*Table structure for table `rooms` */

DROP TABLE IF EXISTS `rooms`;

CREATE TABLE `rooms` (
  `roomno` varchar(25) DEFAULT NULL,
  `availabilty` varchar(25) DEFAULT NULL,
  `cleaning_stuts` varchar(15) DEFAULT NULL,
  `price` varchar(30) DEFAULT NULL,
  `bed_type` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `rooms` */

insert  into `rooms`(`roomno`,`availabilty`,`cleaning_stuts`,`price`,`bed_type`) values 
('12','Available','dirty','2000','Single'),
('112','occuied','Cleaned','2500','Doubled'),
('10','Available','Cleaned','2000','Doubled'),
('10','Occupied','Cleaned','2000','Doubled'),
('45','Available','Cleaned','1500','Single');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
