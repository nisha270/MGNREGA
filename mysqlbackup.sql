-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: mgnrega
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `gpm`
--

DROP TABLE IF EXISTS `gpm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gpm` (
  `GPM_ID` int NOT NULL AUTO_INCREMENT,
  `AADHAR_NUMBER` varchar(12) NOT NULL,
  `NAME` varchar(225) NOT NULL,
  `DOB` date NOT NULL,
  `GENDER` enum('MALE','FEMALE','OTHER') NOT NULL,
  `PANCHAYAT_NAME` varchar(225) NOT NULL,
  `DISTRIC` varchar(225) NOT NULL,
  `STATE` varchar(225) NOT NULL,
  `IS_DELETE` int DEFAULT '0',
  PRIMARY KEY (`GPM_ID`),
  UNIQUE KEY `UNIQUE_AADHAR` (`AADHAR_NUMBER`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gpm`
--

LOCK TABLES `gpm` WRITE;
/*!40000 ALTER TABLE `gpm` DISABLE KEYS */;
INSERT INTO `gpm` VALUES (1,'987654321321','kumari','2023-10-10','FEMALE','Gokak Panchayat','deoria','UP',0),(2,'123456789789','xcf','2022-10-10','FEMALE','tvgcrfed','vrcfxed','vcfdxw',0),(5,'123476789789','nisha','2000-07-27','FEMALE','rfd','Deoria','up',0),(6,'12345678978','kumar','2000-10-09','MALE','transl','gonda','up',0);
/*!40000 ALTER TABLE `gpm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gpm_project`
--

DROP TABLE IF EXISTS `gpm_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gpm_project` (
  `GPM_ID` int NOT NULL,
  `PROJECT_ID` int NOT NULL,
  PRIMARY KEY (`GPM_ID`,`PROJECT_ID`),
  KEY `PROJECT_ID` (`PROJECT_ID`),
  CONSTRAINT `gpm_project_ibfk_1` FOREIGN KEY (`GPM_ID`) REFERENCES `gpm` (`GPM_ID`) ON DELETE CASCADE,
  CONSTRAINT `gpm_project_ibfk_2` FOREIGN KEY (`PROJECT_ID`) REFERENCES `project` (`PROJECT_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gpm_project`
--

LOCK TABLES `gpm_project` WRITE;
/*!40000 ALTER TABLE `gpm_project` DISABLE KEYS */;
INSERT INTO `gpm_project` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `gpm_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `PROJECT_ID` int NOT NULL AUTO_INCREMENT,
  `PROJECT_NAME` varchar(225) NOT NULL,
  `START_DATE` date NOT NULL,
  `END_DATE` date NOT NULL,
  `WORKERS_NUMBER` int NOT NULL,
  `PER_DAY_WAGES` float NOT NULL,
  `IS_DELETE` int DEFAULT '0',
  PRIMARY KEY (`PROJECT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'Tree Plantation Project','2023-01-01','2023-10-10',10,700,0),(2,'cleanup','2022-10-10','2023-10-10',10,1000,0),(3,'Storm','2022-10-10','2023-10-10',5,1000,0);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `USER_ID` int NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(225) NOT NULL,
  `PASSWORD` varchar(225) NOT NULL,
  `USER_TYPE` enum('ADMIN','BDO','GPM') NOT NULL,
  `IS_DELETE` int DEFAULT '0',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'nisha@123','nisha@123','BDO',0),(2,'nisha','nisha@123','GPM',0),(3,'pooja@123','pooja@123','BDO',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker`
--

DROP TABLE IF EXISTS `worker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker` (
  `WORKER_ID` int NOT NULL AUTO_INCREMENT,
  `AADHAR_NUMBER` varchar(12) NOT NULL,
  `NAME` varchar(225) NOT NULL,
  `DOB` date NOT NULL,
  `GENDER` enum('MALE','FEMALE','OTHER') NOT NULL,
  `PANCHAYAT_NAME` varchar(225) NOT NULL,
  `DISTRIC` varchar(225) NOT NULL,
  `STATE` varchar(225) NOT NULL,
  `IS_DELETE` int DEFAULT '0',
  PRIMARY KEY (`WORKER_ID`),
  UNIQUE KEY `UNIQUE_AADHAR` (`AADHAR_NUMBER`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker`
--

LOCK TABLES `worker` WRITE;
/*!40000 ALTER TABLE `worker` DISABLE KEYS */;
INSERT INTO `worker` VALUES (1,'34567899871','kunal','1999-10-10','MALE','Gram_Panchyat','thane','maharastra',0),(2,'123456789789','sunil','1998-08-23','MALE','panchyat','pune','maharastra',0);
/*!40000 ALTER TABLE `worker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker_project`
--

DROP TABLE IF EXISTS `worker_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worker_project` (
  `WORKER_ID` int NOT NULL,
  `PROJECT_ID` int NOT NULL,
  PRIMARY KEY (`WORKER_ID`,`PROJECT_ID`),
  KEY `PROJECT_ID` (`PROJECT_ID`),
  CONSTRAINT `worker_project_ibfk_1` FOREIGN KEY (`WORKER_ID`) REFERENCES `worker` (`WORKER_ID`) ON DELETE CASCADE,
  CONSTRAINT `worker_project_ibfk_2` FOREIGN KEY (`PROJECT_ID`) REFERENCES `project` (`PROJECT_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker_project`
--

LOCK TABLES `worker_project` WRITE;
/*!40000 ALTER TABLE `worker_project` DISABLE KEYS */;
INSERT INTO `worker_project` VALUES (1,2);
/*!40000 ALTER TABLE `worker_project` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-02 22:38:29
