-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 18, 2016 at 10:57 PM
-- Server version: 10.0.23-MariaDB-log
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `zp9439_ochar`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `user_id` int(8) NOT NULL,
  `username` varchar(35) NOT NULL,
  `password` char(32) NOT NULL,
  `email` varchar(80) NOT NULL,
  `display_name` varchar(140) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`user_id`, `username`, `password`, `email`, `display_name`) VALUES
(1, 'a', '1', 'a@hotmail.com', 'Aigdy'),
(2, 'aigdy', '1234', 'arinofjung@hotmail.com', 'aigdy'),
(4, 's', 's', '', ''),
(5, '$username', '$password', '$email', '$display_name'),
(6, 'w', 'w', '', ''),
(7, 'root', '', '', ''),
(8, 'd', 'd', '', ''),
(9, 'bbb', 'bbb', '', ''),
(12, 'dsfdsf', 'sdf', '', ''),
(13, 'gg', 'gg', '', ''),
(14, 'ff', 'dddds', '', ''),
(15, 'aaa', 'aaaaaaaa', '', ''),
(20, '', '', '', ''),
(21, 'username', 'password', 'email', ''),
(26, '1', '1', '1', '1'),
(28, 'e', '1', '1', ''),
(31, 'usernagme', '1', '1', ''),
(32, '$usefddfrname', '$password', '$email', ''),
(33, 'aaaaa', 'aa11wq', '', ''),
(34, 'aaab', 'a', '', ''),
(35, 'sssfdf', 'sss', '', ''),
(36, 'g', 'g', '', ''),
(37, '$usedrname', '$password', '$email', ''),
(38, 'wrrwrwgdfgd', 'wrwrwrw', '', ''),
(39, 'sdsds', 'sdsds', '', ''),
(40, 'dfgdftydktyjdjs', 'dfhdf', '', ''),
(41, 'sdggsj', 'tjsr', '', ''),
(42, 'abcdefg', 'fs', '', ''),
(43, 'df', 'dfh', 'sdfsdfdsf', ''),
(44, 'sdfsdf', 'sdgsdgsdg', 'sdgsdgsdgs@', ''),
(45, 'sss', 'fdf', 'sss', ''),
(48, '$ussdername', '$password', '$email', ''),
(49, 'bbbbbbbb', 'bbb', 'bbbb', ''),
(53, 'kwan', '1234', 'nonthawach.kwan@gmail.com', '');

-- --------------------------------------------------------

--
-- Table structure for table `material`
--

CREATE TABLE `material` (
  `material_id` int(11) NOT NULL,
  `material_name` varchar(25) NOT NULL,
  `material_amount` int(11) NOT NULL,
  `material_unit` varchar(10) DEFAULT NULL,
  `food_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `menu_food`
--

CREATE TABLE `menu_food` (
  `food_id` int(11) NOT NULL,
  `food_name` varchar(25) NOT NULL,
  `food_cooking_method` text NOT NULL,
  `food_type` varchar(4) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menu_food`
--

INSERT INTO `menu_food` (`food_id`, `food_name`, `food_cooking_method`, `food_type`, `user_id`) VALUES
(1, '$foodname', 'food', '0', 1),
(2, 'fire rice', 'food', '0', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(25) NOT NULL,
  `user_email` varchar(30) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_amount_food` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_email`, `user_password`, `user_amount_food`) VALUES
(1, 'admin', 'enqueteplu@gmail.com', '123456', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`material_id`),
  ADD KEY `fk_material_menu_food_idx` (`food_id`);

--
-- Indexes for table `menu_food`
--
ALTER TABLE `menu_food`
  ADD PRIMARY KEY (`food_id`),
  ADD KEY `fk_menu_food_user1_idx` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `user_id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;
--
-- AUTO_INCREMENT for table `material`
--
ALTER TABLE `material`
  MODIFY `material_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `menu_food`
--
ALTER TABLE `menu_food`
  MODIFY `food_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `fk_material_menu_food` FOREIGN KEY (`food_id`) REFERENCES `menu_food` (`food_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `menu_food`
--
ALTER TABLE `menu_food`
  ADD CONSTRAINT `fk_menu_food_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
