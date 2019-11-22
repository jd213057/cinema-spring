-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: cinema
-- ------------------------------------------------------
-- Server version	8.0.17



--
-- Table structure for table `acteurs`
--

DROP TABLE IF EXISTS `acteurs`;

CREATE TABLE `acteurs` (
  `pk_acteur` int(11) NOT NULL AUTO_INCREMENT,
  `civilite` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nom` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prenom` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `date_deces` date DEFAULT NULL,
  PRIMARY KEY (`pk_acteur`)
) 


--
-- Dumping data for table `acteurs`
--

LOCK TABLES `acteurs` WRITE;

INSERT INTO `acteurs` VALUES (2,'Mme','Johansson','Scarlett',NULL,NULL),(3,'M','Soubeyrand','Erwan',NULL,NULL),(4,'M','Kucuk','Denis','1992-05-22',NULL);

UNLOCK TABLES;

--
-- Table structure for table `film_acteur`
--

DROP TABLE IF EXISTS `film_acteur`;

CREATE TABLE `film_acteur` (
  `fk_film` int(11) NOT NULL,
  `fk_acteur` int(11) NOT NULL,
  `role` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) 


--
-- Dumping data for table `film_acteur`
--

LOCK TABLES `film_acteur` WRITE;

INSERT INTO `film_acteur` VALUES (1,2,'Dave'),(1,3,'HAL9000'),(2,4,'Denis');

UNLOCK TABLES;

--
-- Table structure for table `films`
--

DROP TABLE IF EXISTS `films`;

CREATE TABLE `films` (
  `titre` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `realisateur` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_sortie` date DEFAULT NULL,
  `duree` int(11) DEFAULT NULL,
  `pk_film` int(11) NOT NULL AUTO_INCREMENT,
  `prixht` double DEFAULT '12.1',
  PRIMARY KEY (`pk_film`)
) 

--
-- Dumping data for table `films`
--

LOCK TABLES `films` WRITE;

INSERT INTO `films` VALUES ('2001, l\'odyssée de l\'espace','Stanley Kubrick','1968-04-03',156,1,8.5),('L\'étrange histoire de Denis Kucuk','Jean-Christophe Fagothey','2019-10-30',142,2,25),('Titanic','James Cameron','1997-12-14',194,3,10),('Avatar','James Cameron','2009-12-16',178,4,15.25),('OSS 117: Le Caire, nid d\'espions',' Michel Hazanavicius','2006-04-19',99,5,13),('Pulp Fiction','Quentin Tarantino','1994-10-14',154,6,1);

UNLOCK TABLES;

--
-- Dumping routines for database 'cinema'
--


-- Dump completed on 2019-11-20 10:21:54
