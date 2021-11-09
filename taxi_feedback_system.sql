-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 09, 2021 at 04:58 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `taxi_feedback_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
CREATE TABLE IF NOT EXISTS `answers` (
  `attempt` int(11) NOT NULL,
  `q1_1` int(11) DEFAULT NULL,
  `q1_2` int(11) DEFAULT NULL,
  `q1_3` int(11) DEFAULT NULL,
  `q2_1` int(11) DEFAULT NULL,
  `q2_2` int(11) DEFAULT NULL,
  `q2_3` int(11) DEFAULT NULL,
  `q3_1` int(11) DEFAULT NULL,
  `q3_2` int(11) DEFAULT NULL,
  `q3_3` int(11) DEFAULT NULL,
  `q4_1` int(11) DEFAULT NULL,
  `q4_2` int(11) DEFAULT NULL,
  `q4_3` int(11) DEFAULT NULL,
  `q5_1` int(11) DEFAULT NULL,
  `q5_2` int(11) DEFAULT NULL,
  `q5_3` int(11) DEFAULT NULL,
  `q6_1` int(11) DEFAULT NULL,
  `q6_2` int(11) DEFAULT NULL,
  `q6_3` int(11) DEFAULT NULL,
  PRIMARY KEY (`attempt`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answers`
--

INSERT INTO `answers` (`attempt`, `q1_1`, `q1_2`, `q1_3`, `q2_1`, `q2_2`, `q2_3`, `q3_1`, `q3_2`, `q3_3`, `q4_1`, `q4_2`, `q4_3`, `q5_1`, `q5_2`, `q5_3`, `q6_1`, `q6_2`, `q6_3`) VALUES
(25, 14, 8, 3, 6, 15, 4, 4, 15, 6, 6, 12, 7, 5, 13, 7, 6, 10, 9);

-- --------------------------------------------------------

--
-- Table structure for table `complains`
--

DROP TABLE IF EXISTS `complains`;
CREATE TABLE IF NOT EXISTS `complains` (
  `count` int(11) NOT NULL AUTO_INCREMENT,
  `complain` varchar(10000) NOT NULL,
  PRIMARY KEY (`count`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `complains`
--

INSERT INTO `complains` (`count`, `complain`) VALUES
(1, 'gytgt'),
(2, ''),
(3, 'sdsdsd hdhfdf hfdhfdfd\nhdfdjf hfdfdhfjf'),
(4, 'dascvb nfdvgbnm rgfgfg fg'),
(5, 'testing 6'),
(21, 'venushi\n'),
(20, 'xzxzx');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `driver_name` varchar(100) NOT NULL,
  `vehicle_number` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`driver_name`, `vehicle_number`, `username`, `password`) VALUES
('Uditha', 'wp-XO4343', 'admin', 'admin'),
('sdsdsds', 'sd', 's', 's');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
