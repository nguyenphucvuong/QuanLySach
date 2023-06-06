-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3306
-- Thời gian đã tạo: Th12 25, 2022 lúc 11:30 AM
-- Phiên bản máy phục vụ: 5.7.36
-- Phiên bản PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qls`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sach`
--

DROP TABLE IF EXISTS `sach`;
CREATE TABLE IF NOT EXISTS `sach` (
  `maSach` varchar(30) CHARACTER SET latin1 NOT NULL,
  `tenSach` varchar(50) CHARACTER SET latin1 NOT NULL,
  `loaiSach` varchar(30) CHARACTER SET latin1 NOT NULL,
  `tacGia` varchar(30) CHARACTER SET latin1 NOT NULL,
  `gia` double NOT NULL,
  `ngayXB` datetime NOT NULL,
  PRIMARY KEY (`maSach`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sach`
--

INSERT INTO `sach` (`maSach`, `tenSach`, `loaiSach`, `tacGia`, `gia`, `ngayXB`) VALUES
('s001', 'Sach Nau An', 'l02', 'Trump', 10000, '2022-12-09 00:00:00'),
('s002', 'Thang gu o nha tho duc ba', 'l01', 'las', 20000, '2022-12-10 00:00:00'),
('s003', 'Bao thanh nien', 'l01', 'aaa', 30000, '2022-12-20 00:00:00'),
('s004', 'Than dong dat viet', 'l04', 'asdasd', 15000, '2022-12-11 00:00:00'),
('s005', 'Mot con bo', 'l05', 'cobe', 15700, '2022-12-03 00:00:00'),
('s007', 'Hai con bo', 'l05', 'cobe', 15800, '2002-03-02 00:00:00'),
('s009', 'Hai con bo', 'l05', 'cobe', 15400, '2002-03-02 00:00:00'),
('s006', 'asdasd', 'l01', 'asdasd', 123, '2001-12-12 00:00:00'),
('s010', 'ggggggggggggg', 'l02', 'ggggggggg', 33333333333, '0200-03-03 00:00:00');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
