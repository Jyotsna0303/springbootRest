CREATE DATABASE IF NOT EXISTS `Employee_Dirctory`;
USE  `Employee_Dirctory`;
DROP TABLE IF EXISTS `employee`;
CREATE TABLE  `employee`(
`Id` int(11) NOT NULL AUTO_INCREMENT,
`First_Name` varchar(45) DEFAULT NULL,
`Last_Name` varchar (45) DEFAULT NULL,
`email` varchar(45) DEFAULT NULL,
PRIMARY KEY(`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `employee` VALUES
(1,'Joe','Kukreti','joe@gmail.com'),
(2,'Koe','Kukreti','joe@gmail.com');
