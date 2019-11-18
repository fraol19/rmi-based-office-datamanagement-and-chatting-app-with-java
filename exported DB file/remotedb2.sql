-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 13, 2019 at 09:06 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `remotedb2`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `ID` varchar(191) NOT NULL,
  `Name` varchar(191) NOT NULL,
  `Address` varchar(191) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`ID`, `Name`, `Address`) VALUES
('bole123', 'Bole', 'Bole Addis ababa'),
('kali123', 'Kality', 'Kality Addis Ababa');

-- --------------------------------------------------------

--
-- Table structure for table `budget`
--

CREATE TABLE `budget` (
  `id` int(11) NOT NULL,
  `Amount` double NOT NULL,
  `Fundings` double NOT NULL,
  `Date` date NOT NULL,
  `BranchName` varchar(191) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `budget`
--

INSERT INTO `budget` (`id`, `Amount`, `Fundings`, `Date`, `BranchName`) VALUES
(1, 1000000, 20000, '2019-05-06', 'kality');

-- --------------------------------------------------------

--
-- Table structure for table `buy`
--

CREATE TABLE `buy` (
  `Name` varchar(255) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Price` double NOT NULL,
  `Totalprice` double NOT NULL,
  `Seller` varchar(255) NOT NULL,
  `Branch` varchar(191) NOT NULL,
  `Date` date NOT NULL,
  `Report` longtext,
  `TransactionID` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buy`
--

INSERT INTO `buy` (`Name`, `Qty`, `Price`, `Totalprice`, `Seller`, `Branch`, `Date`, `Report`, `TransactionID`) VALUES
('Printer', 2, 5000, 10000, 'Si Tech', 'kality', '2019-05-06', 'we bought printers from si tech', 'print2222');

-- --------------------------------------------------------

--
-- Table structure for table `chat`
--

CREATE TABLE `chat` (
  `ID` int(11) NOT NULL,
  `MessageType` int(2) NOT NULL DEFAULT '1',
  `Message` longtext,
  `Url` varchar(255) DEFAULT NULL,
  `FileName` varchar(255) DEFAULT NULL,
  `SentBy` int(11) NOT NULL DEFAULT '0',
  `RecievedBy` int(11) NOT NULL DEFAULT '0',
  `Created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Seen` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chat`
--

INSERT INTO `chat` (`ID`, `MessageType`, `Message`, `Url`, `FileName`, `SentBy`, `RecievedBy`, `Created`, `Seen`) VALUES
(1, 1, 'hey man', NULL, NULL, 1, 4, '2019-05-21 16:58:43', 1),
(2, 1, 'hey bra', NULL, NULL, 1, 5, '2019-05-21 16:59:03', 1),
(3, 1, 'hey bra flr', NULL, NULL, 4, 1, '2019-05-21 17:00:10', 1),
(4, 1, 'her', NULL, NULL, 1, 4, '2019-05-21 17:06:08', 1),
(5, 1, 'as', NULL, NULL, 1, 4, '2019-05-21 17:10:12', 1),
(6, 1, 'sasasas', NULL, NULL, 1, 4, '2019-05-21 17:20:45', 1),
(7, 1, 'sasasas', NULL, NULL, 1, 4, '2019-05-21 17:20:55', 1),
(8, 1, 'sasasasasas', NULL, NULL, 1, 5, '2019-05-21 17:30:53', 1),
(9, 1, 'whats up', NULL, NULL, 4, 5, '2019-05-21 17:48:06', 1),
(11, 1, 'asasas', NULL, NULL, 1, 4, '2019-05-21 20:49:00', 1),
(12, 1, 'hey', NULL, NULL, 1, 2, '2019-05-21 22:46:46', 0),
(13, 1, 'hahahss', NULL, NULL, 1, 4, '2019-05-22 17:25:25', 1),
(14, 1, 'heya', NULL, NULL, 1, 4, '2019-05-22 17:29:01', 1),
(15, 1, 'hey man', NULL, NULL, 1, 4, '2019-05-22 17:38:28', 1),
(16, 1, ' nasnsa', '', '', 1, 4, '2019-05-22 17:38:57', 1),
(18, 2, '', 'cloud.svg', 'cloud.svg', 1, 4, '2019-05-23 02:11:49', 1),
(19, 1, 'bxxbbxcxc', NULL, NULL, 1, 4, '2019-05-25 08:04:31', 1),
(20, 1, 'bxxbbxcxc', NULL, NULL, 1, 4, '2019-05-25 08:05:48', 1),
(23, 1, 'pis nw', NULL, NULL, 1, 2, '2019-11-11 19:27:54', 0),
(24, 1, 'flex', NULL, NULL, 4, 1, '2019-11-11 19:32:41', 1),
(25, 1, 'pis nw', NULL, NULL, 1, 4, '2019-11-11 19:33:11', 1),
(27, 1, 'ena manua', NULL, NULL, 4, 1, '2019-11-13 08:01:37', 1);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `ID` int(11) NOT NULL,
  `Name` varchar(191) NOT NULL,
  `Sex` varchar(6) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Age` int(2) NOT NULL,
  `DOA` date NOT NULL,
  `Phone` varchar(15) NOT NULL,
  `Salary` double NOT NULL,
  `Field` varchar(191) NOT NULL,
  `Report` longtext,
  `Branch` varchar(191) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`ID`, `Name`, `Sex`, `Address`, `Age`, `DOA`, `Phone`, `Salary`, `Field`, `Report`, `Branch`) VALUES
(1, 'Anatolly', 'Male', 'Addis Ababa', 21, '2019-02-05', '091-2121212', 12000, 'programmer', '', 'Kality'),
(2, 'Kidus', 'Male', 'Addis Ababa', 21, '2018-01-12', '091-2121212', 12000, 'software engineer', '', 'Kality'),
(3, 'feraol abebe', 'Male', 'addis ababa', 21, '2019-02-01', '092-2112122', 12000, 'designer', '', 'Kality');

-- --------------------------------------------------------

--
-- Table structure for table `holder`
--

CREATE TABLE `holder` (
  `ID` int(11) NOT NULL,
  `Name` varchar(191) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(191) NOT NULL,
  `BranchID` varchar(191) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `holder`
--

INSERT INTO `holder` (`ID`, `Name`, `Email`, `Password`, `BranchID`) VALUES
(1, 'Feraol Abebe', 'feraolabebe@gmail.com', 'flex123', 'kali123'),
(2, 'SomeOne', 'someman19@gmail.com', '123456', 'kali123'),
(4, 'Abdi', 'abdiabu@gmail.com', 'abd123', 'bole123'),
(5, 'Kemal', 'kemal@gmail.com', 'kg1234', 'bole123'),
(7, 'fraol', 'flex@gmail.com', '123456', 'bole123');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `TransactionID` varchar(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Qty` int(11) NOT NULL,
  `Price` double NOT NULL,
  `TotalPrice` double NOT NULL,
  `Buyer` varchar(255) NOT NULL,
  `Branch` varchar(191) NOT NULL,
  `Profit` double NOT NULL,
  `Totalprofit` double NOT NULL,
  `Date` date NOT NULL,
  `Report` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`TransactionID`, `Name`, `Qty`, `Price`, `TotalPrice`, `Buyer`, `Branch`, `Profit`, `Totalprofit`, `Date`, `Report`) VALUES
('comp1234', 'Computer', 5, 10000, 40000, 'El Tech', 'kality', 1000, 5000, '2019-05-06', 'this computers are sold out to el tech with profit of 1000 from each computer'),
('dssd222', 'Sample', 2, 21121, 21121, 'ssasa', 'Kality', 2222, 4444, '2018-05-23', ''),
('sajhasvgsaj', 'printer', 10, 3000, 30000, 'elelele', 'Bole', 800, 8000, '2017-05-25', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `budget`
--
ALTER TABLE `budget`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `buy`
--
ALTER TABLE `buy`
  ADD PRIMARY KEY (`TransactionID`);

--
-- Indexes for table `chat`
--
ALTER TABLE `chat`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `SentBy` (`SentBy`),
  ADD KEY `RecievedBy` (`RecievedBy`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `holder`
--
ALTER TABLE `holder`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`TransactionID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `budget`
--
ALTER TABLE `budget`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `chat`
--
ALTER TABLE `chat`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `holder`
--
ALTER TABLE `holder`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chat`
--
ALTER TABLE `chat`
  ADD CONSTRAINT `chat_ibfk_1` FOREIGN KEY (`SentBy`) REFERENCES `holder` (`ID`),
  ADD CONSTRAINT `chat_ibfk_2` FOREIGN KEY (`RecievedBy`) REFERENCES `holder` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
