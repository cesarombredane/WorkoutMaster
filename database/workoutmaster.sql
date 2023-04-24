-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2023 at 12:56 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `workoutmaster`
--

-- --------------------------------------------------------

--
-- Table structure for table `exercise`
--

CREATE TABLE `exercise` (
  `id` int(11) NOT NULL,
  `workout` int(11) NOT NULL,
  `nb_rep` int(11) NOT NULL,
  `nb_serie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `resultats`
--

CREATE TABLE `resultats` (
  `id` int(11) NOT NULL,
  `workout` int(11) NOT NULL,
  `res` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `workout`
--

CREATE TABLE `workout` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `exercise`
--
ALTER TABLE `exercise`
  ADD PRIMARY KEY (`id`),
  ADD KEY `workout_for_key` (`workout`);

--
-- Indexes for table `resultats`
--
ALTER TABLE `resultats`
  ADD PRIMARY KEY (`id`),
  ADD KEY `res_workout_for_key` (`workout`);

--
-- Indexes for table `workout`
--
ALTER TABLE `workout`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `exercise`
--
ALTER TABLE `exercise`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `resultats`
--
ALTER TABLE `resultats`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `workout`
--
ALTER TABLE `workout`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `exercise`
--
ALTER TABLE `exercise`
  ADD CONSTRAINT `workout_for_key` FOREIGN KEY (`workout`) REFERENCES `workout` (`id`);

--
-- Constraints for table `resultats`
--
ALTER TABLE `resultats`
  ADD CONSTRAINT `res_workout_for_key` FOREIGN KEY (`workout`) REFERENCES `workout` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
