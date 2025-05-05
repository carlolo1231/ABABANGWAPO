-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2025 at 08:21 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `supplytracker_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `u_id` int(11) DEFAULT NULL,
  `activity` varchar(255) NOT NULL,
  `log_time` datetime DEFAULT current_timestamp(),
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `u_id`, `activity`, `log_time`, `user_id`) VALUES
(1, NULL, 'A new user registered', '2025-05-05 12:41:58', 9),
(2, NULL, 'Admin Registered a user', '2025-05-05 13:06:33', 9),
(3, NULL, 'Admin logged in', '2025-05-05 13:13:32', 9),
(4, NULL, 'Admin updated a user', '2025-05-05 13:14:15', 9),
(5, NULL, 'User reset their password.', '2025-05-05 14:08:24', 9),
(6, NULL, 'Admin logged in', '2025-05-05 14:09:19', 9),
(7, NULL, 'Admin logged in', '2025-05-05 14:12:35', 9),
(8, NULL, 'Admin updated a user', '2025-05-05 14:14:15', 9),
(9, NULL, 'Admin logged in', '2025-05-05 14:16:28', 9),
(10, NULL, 'Admin logged in', '2025-05-05 14:17:49', 9),
(11, NULL, 'Admin logged in', '2025-05-05 14:18:12', 9);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `u_id` int(11) NOT NULL,
  `fn` varchar(255) NOT NULL,
  `ln` varchar(255) NOT NULL,
  `cn` varchar(255) NOT NULL,
  `em` varchar(255) NOT NULL,
  `us` varchar(255) NOT NULL,
  `ps` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `sq` varchar(255) DEFAULT NULL,
  `ans` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`u_id`, `fn`, `ln`, `cn`, `em`, `us`, `ps`, `type`, `status`, `image`, `sq`, `ans`) VALUES
(6, 'carlo', 'ababan', '0932435545', 'carlo123@gmail.com', 'carlo123', '16a6664ddc1bd19770f67d6f2b86634843e86a3cf93026d474e79b82c33b960f', 'Admin', 'Active', '', '', ''),
(7, 'james', 'ansali', '0932443545', 'james@gmail.com', 'james123', '7eff7d4d55e14f49975eeb4606d6cfeeea091671505b2d6c67deb22b548b8ba7', 'Admin', 'Active', '', '', ''),
(8, 'nameq', 'nameq', '01212112', 'nameless@gmail.com', 'BULOK', '72990959f2cb269eba43dce67e84649cabc9735bf2206f8808e99d10e708d23a', 'CLient', 'Active', '', '', ''),
(9, 'carlo', 'pumped', '09324343', 'carlo@gmail.com', 'carlo123456', '16a6664ddc1bd19770f67d6f2b86634843e86a3cf93026d474e79b82c33b960f', 'Admin', 'Active', 'src/Images/6.PNG', 'Are you gay?', 'yes'),
(10, 'konssss', 'kons', '0934343434', 'kons@gmail.com', 'kons123', 'd926ddf1855415fc11afffc07faa16f82d7794600067490aa30626bb99418e09', 'Admin', 'Pending', 'src/Images/2.PNG', NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `fk_logs_user_id` (`user_id`),
  ADD KEY `fk_logs_u_id` (`u_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`u_id`),
  ADD UNIQUE KEY `u_id` (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `fk_logs_u_id` FOREIGN KEY (`u_id`) REFERENCES `users` (`u_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_logs_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
