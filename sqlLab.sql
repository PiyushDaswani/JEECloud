-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.17 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table lab.book_master
CREATE TABLE IF NOT EXISTS `book_master` (
  `Book_code` int(10) NOT NULL,
  `Book_name` varchar(50) NOT NULL,
  `Book_pub_year` int(11) DEFAULT NULL,
  `Book_pub_author` varchar(50) NOT NULL,
  PRIMARY KEY (`Book_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table lab.book_master: ~9 rows (approximately)
DELETE FROM `book_master`;
/*!40000 ALTER TABLE `book_master` DISABLE KEYS */;
INSERT INTO `book_master` (`Book_code`, `Book_name`, `Book_pub_year`, `Book_pub_author`) VALUES
	(10000001, 'Let Us C++', 2000, 'Yashavant Kanetkar'),
	(10000002, 'Mastersing VC++', 2005, 'P.J Allen'),
	(10000003, 'JAVA Complete Reference', 2004, 'H.Schild'),
	(10000004, 'J2EE Complete Reference', 2000, 'H. Schild'),
	(10000005, 'Relational DBMS', 2000, 'B.C. Desai'),
	(10000006, 'Let Us C', 2000, 'Yashavant Kanetkar'),
	(10000007, 'Intoduction To Algorithams', 2001, 'Cormen'),
	(10000008, 'Computer Networks', 2000, 'Tanenbaum'),
	(10000009, 'Introduction to O/S', 2001, 'Millan');
/*!40000 ALTER TABLE `book_master` ENABLE KEYS */;

-- Dumping structure for table lab.book_transactions
CREATE TABLE IF NOT EXISTS `book_transactions` (
  `Book_code` int(10) DEFAULT NULL,
  `Student_code` int(6) DEFAULT NULL,
  `Staff_code` int(8) DEFAULT NULL,
  `Book_issue_Date` date NOT NULL,
  `Book_expected_return_date` date NOT NULL,
  `Book_actual_return_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table lab.book_transactions: ~8 rows (approximately)
DELETE FROM `book_transactions`;
/*!40000 ALTER TABLE `book_transactions` DISABLE KEYS */;
INSERT INTO `book_transactions` (`Book_code`, `Student_code`, `Staff_code`, `Book_issue_Date`, `Book_expected_return_date`, `Book_actual_return_date`) VALUES
	(10000006, 1012, NULL, '2011-02-02', '2011-02-09', NULL),
	(10000008, NULL, 100006, '2011-03-10', '2011-03-17', '2011-03-15'),
	(10000009, NULL, 100010, '2011-04-01', '2011-04-08', '2011-04-10'),
	(10000004, 1015, NULL, '2011-02-12', '2011-02-19', NULL),
	(10000005, NULL, 100007, '2011-03-14', '2011-03-21', '2011-03-21'),
	(10000007, NULL, 100007, '2011-04-01', '2011-04-07', '2011-04-06'),
	(10000007, NULL, 100006, '2010-04-01', '2010-04-07', '2010-04-06'),
	(10000005, 1009, NULL, '2011-05-31', '2011-06-08', '2011-06-08');
/*!40000 ALTER TABLE `book_transactions` ENABLE KEYS */;

-- Dumping structure for table lab.department_master
CREATE TABLE IF NOT EXISTS `department_master` (
  `Dept_code` int(2) NOT NULL,
  `Dept_Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Dept_code`),
  UNIQUE KEY `Dept_Name` (`Dept_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table lab.department_master: ~5 rows (approximately)
DELETE FROM `department_master`;
/*!40000 ALTER TABLE `department_master` DISABLE KEYS */;
INSERT INTO `department_master` (`Dept_code`, `Dept_Name`) VALUES
	(10, 'Computer Science'),
	(20, 'Electricals'),
	(30, 'Electronics'),
	(40, 'Mechanics'),
	(50, 'Robotics');
/*!40000 ALTER TABLE `department_master` ENABLE KEYS */;

-- Dumping structure for table lab.designation_master
CREATE TABLE IF NOT EXISTS `designation_master` (
  `Design_Code` int(3) NOT NULL,
  `Design_Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Design_Code`),
  UNIQUE KEY `Design_Name` (`Design_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table lab.designation_master: ~6 rows (approximately)
DELETE FROM `designation_master`;
/*!40000 ALTER TABLE `designation_master` DISABLE KEYS */;
INSERT INTO `designation_master` (`Design_Code`, `Design_Name`) VALUES
	(106, 'Director'),
	(101, 'HOD'),
	(105, 'Lecturer'),
	(102, 'Professor'),
	(103, 'Reader'),
	(104, 'Sr.Lecturer');
/*!40000 ALTER TABLE `designation_master` ENABLE KEYS */;

-- Dumping structure for table lab.emp
CREATE TABLE IF NOT EXISTS `emp` (
  `EMPNO` int(4) NOT NULL,
  `ENAME` varchar(10) DEFAULT NULL,
  `JOB` varchar(9) DEFAULT NULL,
  `MGR` int(4) DEFAULT NULL,
  `HIREDATE` date DEFAULT NULL,
  `SAL` double(7,2) DEFAULT NULL,
  `COMM` double(7,2) DEFAULT NULL,
  `DEPTNO` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table lab.emp: ~14 rows (approximately)
DELETE FROM `emp`;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` (`EMPNO`, `ENAME`, `JOB`, `MGR`, `HIREDATE`, `SAL`, `COMM`, `DEPTNO`) VALUES
	(7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800.00, NULL, 20),
	(7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600.00, 300.00, 30),
	(7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1250.00, 500.00, 30),
	(7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975.00, NULL, 20),
	(7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250.00, 1400.00, 30),
	(7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850.00, NULL, 30),
	(7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450.00, NULL, 10),
	(7788, 'SCOTT', 'ANALYST', 7566, '1982-12-09', 3000.00, NULL, 20),
	(7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 5000.00, NULL, 10),
	(7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500.00, 0.00, 30),
	(7876, 'ADAMS', 'CLERK', 7788, '1983-01-12', 1100.00, NULL, 20),
	(7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950.00, NULL, 30),
	(7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000.00, NULL, 20),
	(7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300.00, NULL, 10);
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;

-- Dumping structure for table lab.staff_master
CREATE TABLE IF NOT EXISTS `staff_master` (
  `Staff_Code` int(8) NOT NULL,
  `Staff_Name` varchar(50) NOT NULL,
  `Design_Code` int(11) DEFAULT NULL,
  `Dept_Code` int(11) DEFAULT NULL,
  `Staff_dob` date DEFAULT NULL,
  `Hiredate` date DEFAULT NULL,
  `Mgr_code` int(8) DEFAULT NULL,
  `Staff_sal` double(10,2) DEFAULT NULL,
  `Staff_address` varchar(240) DEFAULT NULL,
  PRIMARY KEY (`Staff_Code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table lab.staff_master: ~10 rows (approximately)
DELETE FROM `staff_master`;
/*!40000 ALTER TABLE `staff_master` DISABLE KEYS */;
INSERT INTO `staff_master` (`Staff_Code`, `Staff_Name`, `Design_Code`, `Dept_Code`, `Staff_dob`, `Hiredate`, `Mgr_code`, `Staff_sal`, `Staff_address`) VALUES
	(100001, 'Arvind', 102, 30, '1980-01-15', '2003-01-15', 100006, 17000.00, 'Bangalore'),
	(100002, 'Shyam', 102, 20, '1980-02-18', '2002-02-17', 100007, 20000.00, 'Chennai'),
	(100003, 'Mohan', 102, 10, '1980-03-23', '2002-01-19', 100006, 24000.00, 'Mumbai'),
	(100004, 'Anil', 102, 20, '1977-04-22', '2001-03-11', 100006, 20000.00, 'Hyderabad'),
	(100005, 'John', 106, 10, '1976-05-22', '2001-01-21', 100007, 32000.00, 'Bangalore'),
	(100006, 'Allen', 103, 30, '1980-01-22', '2001-04-23', 100005, 42000.00, 'Chennai'),
	(100007, 'Smith', 103, 20, '1973-07-19', '2002-03-12', 100005, 62000.00, 'Mumbai'),
	(100008, 'Raviraj', 102, 40, '1980-06-17', '2003-01-11', 100006, 18000.00, 'Bangalore'),
	(100009, 'Rahul', 102, 20, '1978-01-16', '2003-12-11', 100006, 22000.00, 'Hyderabad'),
	(100010, 'Ram', 103, 30, '1979-01-17', '2002-01-17', 100007, 32000.00, 'Bangalore');
/*!40000 ALTER TABLE `staff_master` ENABLE KEYS */;

-- Dumping structure for table lab.student_marks
CREATE TABLE IF NOT EXISTS `student_marks` (
  `Student_Code` int(6) DEFAULT NULL,
  `Student_Year` int(11) NOT NULL,
  `Subject1` int(3) DEFAULT NULL,
  `Subject2` int(3) DEFAULT NULL,
  `Subject3` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table lab.student_marks: ~42 rows (approximately)
DELETE FROM `student_marks`;
/*!40000 ALTER TABLE `student_marks` DISABLE KEYS */;
INSERT INTO `student_marks` (`Student_Code`, `Student_Year`, `Subject1`, `Subject2`, `Subject3`) VALUES
	(1001, 2010, 55, 45, 78),
	(1002, 2010, 66, 74, 88),
	(1003, 2010, 87, 54, 65),
	(1004, 2010, 65, 64, 90),
	(1005, 2010, 78, 88, 65),
	(1006, 2010, 65, 86, 54),
	(1007, 2010, 67, 79, 49),
	(1008, 2010, 72, 55, 55),
	(1009, 2010, 71, 59, 58),
	(1010, 2010, 68, 44, 92),
	(1011, 2010, 89, 96, 78),
	(1012, 2010, 78, 56, 55),
	(1013, 2010, 75, 58, 65),
	(1014, 2010, 73, 74, 65),
	(1015, 2010, 66, 45, 74),
	(1016, 2010, 68, 78, 74),
	(1017, 2010, 69, 44, 52),
	(1018, 2010, 65, 78, 56),
	(1019, 2010, 78, 58, 74),
	(1020, 2010, 45, 55, 65),
	(1021, 2010, 78, 79, 78),
	(1001, 2011, 68, 44, 92),
	(1002, 2011, 89, 96, 78),
	(1003, 2011, 78, 56, 55),
	(1004, 2011, 75, 58, 65),
	(1005, 2011, 73, 74, 65),
	(1006, 2011, 66, 45, 74),
	(1007, 2011, 68, 78, 74),
	(1008, 2011, 69, 44, 52),
	(1009, 2011, 65, 78, 56),
	(1010, 2011, 78, 58, 74),
	(1011, 2011, 45, 55, 65),
	(1012, 2011, 78, 79, 78),
	(1013, 2011, 66, 74, 88),
	(1014, 2011, 65, 64, 90),
	(1015, 2011, 78, 88, 65),
	(1016, 2011, 65, 86, 54),
	(1017, 2011, 67, 79, 49),
	(1018, 2011, 72, 55, 55),
	(1019, 2011, 71, 59, 58),
	(1020, 2011, 55, 45, 78),
	(1021, 2011, 87, 54, 65);
/*!40000 ALTER TABLE `student_marks` ENABLE KEYS */;

-- Dumping structure for table lab.student_master
CREATE TABLE IF NOT EXISTS `student_master` (
  `Student_Code` int(6) NOT NULL,
  `Student_Name` varchar(50) NOT NULL,
  `Dept_Code` int(2) DEFAULT NULL,
  `Student_Dob` date DEFAULT NULL,
  `Student_Address` varchar(240) DEFAULT NULL,
  PRIMARY KEY (`Student_Code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table lab.student_master: ~21 rows (approximately)
DELETE FROM `student_master`;
/*!40000 ALTER TABLE `student_master` DISABLE KEYS */;
INSERT INTO `student_master` (`Student_Code`, `Student_Name`, `Dept_Code`, `Student_Dob`, `Student_Address`) VALUES
	(1001, 'Amit', 10, '1980-01-11', 'chennai'),
	(1002, 'Ravi', 10, '1981-11-01', 'New Delhi'),
	(1003, 'Ajay', 20, '1982-01-13', NULL),
	(1004, 'Raj', 30, '1979-01-14', 'Mumbai'),
	(1005, 'Arvind', 40, '1983-01-15', 'Bangalore'),
	(1006, 'Rahul', 50, '1981-01-16', 'Delhi'),
	(1007, 'Mehul', 20, '1982-01-17', 'Chennai'),
	(1008, 'Dev', 10, '1981-03-11', 'Bangalore'),
	(1009, 'Vijay', 30, '1980-01-19', 'Bangalore'),
	(1010, 'Rajat', 40, '1980-01-20', 'Bangalore'),
	(1011, 'Sunder', 50, '1980-01-21', 'Chennai'),
	(1012, 'Rajesh', 30, '1980-01-22', NULL),
	(1013, 'Anil', 20, '1980-01-23', 'Chennai'),
	(1014, 'Sunil', 10, '1985-02-15', NULL),
	(1015, 'Kapil', 40, '1981-03-18', 'Mumbai'),
	(1016, 'Ashok', 40, '1980-11-26', NULL),
	(1017, 'Ramesh', 30, '1980-12-27', NULL),
	(1018, 'Amit Raj', 50, '1980-09-28', 'New Delhi'),
	(1019, 'Ravi Raj', 50, '1981-05-29', 'New Delhi'),
	(1020, 'Amrit', 10, '1980-11-11', NULL),
	(1021, 'Sumit', 20, '1980-01-01', 'Chennai');
/*!40000 ALTER TABLE `student_master` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
