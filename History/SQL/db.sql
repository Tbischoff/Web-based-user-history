-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 06. Mrz 2014 um 21:42
-- Server Version: 5.6.16-log
-- PHP-Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db`
--

-- --------------------------------------------------------

--
-- table structure for table `movie`
--

CREATE TABLE IF NOT EXISTS `movie` (
  `Title` varchar(20) NOT NULL,
  `Description` varchar(140) NOT NULL,
  `Rating_Star` int(1) NOT NULL,
  `idMovie` int(3) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idMovie`)
) ENGINE= InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- data for table `movie`
--	

INSERT INTO `movie` (`Title`, `Description`, `Rating_Star`) VALUES

;

-- --------------------------------------------------------

--
-- table structure for table `rating`
--

CREATE TABLE IF NOT EXISTS `rating` (
  `Text` varchar(140) NOT NULL,
  `Star` int(1) NOT NULL,
  `pscr` int(3) NOT NULL,
  `idRating` int(3) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idRating`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- data for table `rating`
--

INSERT INTO `rating` (`Text`, `Star`, `pscr`) VALUES
;

-- --------------------------------------------------------

--
-- table structure for table `screening`
--

CREATE TABLE IF NOT EXISTS `screening` (
  `screentime` date NOT NULL,
  `venue_Name` varchar(50) NOT NULL,
  `movie_Title` varchar(20) NOT NULL,
  `movie_idMovie` int(2) NOT NULL,
  `idScreening` int(3) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idScreening`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- data for table `screening`
--

INSERT INTO `screening` (`screentime`, `venue_Name`, `movie_Title`, `movie_idMovie`) VALUES
;

-- --------------------------------------------------------

--
-- table structure for table `tweet`
--

CREATE TABLE IF NOT EXISTS `tweet` (
  `Geo_Lat` float(10, 6) NOT NULL,
  `Geo_Long` float(10, 6) NOT NULL,
  `Text` varchar(140) NOT NULL,
  `user_idUser` int(3) NOT NULL,
  `tweettime` date NOT NULL, 
  `idTweet` int(3) NOT NULL AUTO_INCREMENT,
   PRIMARY KEY (`idTweet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- data for table `tweet`
--

INSERT INTO `tweet` (`Geo_Lat`, `Geo_Long`, `Text`, `user_idUser`,`tweettime`, `idTweet`) VALUES


 ;

-- --------------------------------------------------------

--
-- table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(3) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- data for table `user`
--

INSERT INTO `user` (`idUser`, `Name`) VALUES
;

-- --------------------------------------------------------

--
-- table structure for table `venue`
--

CREATE TABLE IF NOT EXISTS `venue` (
  `Name` varchar(50) NOT NULL,
  `Geo_Lat` float(10,4) NOT NULL,
  `Geo_Long` float(10,4) NOT NULL,
  `idVenue` int(3) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idVenue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- data for table `venue`
--

INSERT INTO `venue` (`Name`, `Geo_Lat`, `Geo_Long`, `idVenue`) VALUES
;

-- --------------------------------------------------------

--
-- table structure for table `history`
--

CREATE TABLE IF NOT EXISTS `participated_screening` (
	`idScreening` int(3) NOT NULL,
	`idParticipated_screening` int(3) NOT NULL AUTO_INCREMENT,
	`user_idUser` int(3) NOT NULL,
	PRIMARY KEY (`idParticipated_screening`)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
--
-- data for table `history`
--

INSERT INTO `participated_screening` (`idScreening`, `user_idUser`) VALUES

;
-- ------------------------------------------------------------
 
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
