-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 10, 2024 at 03:48 PM
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
-- Database: `sieuthimini`
--

-- --------------------------------------------------------

--
-- Table structure for table `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `maphieunhap` int(11) NOT NULL,
  `masp` int(11) NOT NULL,
  `makhuvuc` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `gianhap` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ctphieuxuat`
--

CREATE TABLE `ctphieuxuat` (
  `maphieuxuat` int(11) NOT NULL,
  `masp` int(11) NOT NULL DEFAULT 0,
  `soluong` int(11) NOT NULL DEFAULT 0,
  `dongia` decimal(10,2) NOT NULL DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `danhmucchucnang`
--

CREATE TABLE `danhmucchucnang` (
  `machucnang` int(10) NOT NULL,
  `tenchucnang` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `giamgia`
--

CREATE TABLE `giamgia` (
  `magiamgia` int(11) NOT NULL,
  `tenctgiamgia` varchar(50) NOT NULL,
  `mocgiamgia` int(11) NOT NULL,
  `sotienduocgiam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `giamgia`
--

INSERT INTO `giamgia` (`magiamgia`, `tenctgiamgia`, `mocgiamgia`, `sotienduocgiam`) VALUES
(1, 'Mừng đại lễ 2/9', 200000, 20000),
(2, 'Hành trình 10 năm', 150000, 9300);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` int(11) NOT NULL,
  `tenkhachhang` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `gioitinh` varchar(255) NOT NULL,
  `sdt` varchar(255) NOT NULL,
  `ngaythamgia` date NOT NULL DEFAULT current_timestamp(),
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`makh`, `tenkhachhang`, `diachi`, `gioitinh`, `sdt`, `ngaythamgia`, `trangthai`) VALUES
(1, 'Huỳnh Minh Đại', 'Quận 1', 'Nam', '0368387671', '2024-09-11', 1),
(2, 'Đỗ Thị Trâm Anh', 'Tiền Giang', 'Nữ', '0365387631', '2024-09-19', 1);

-- --------------------------------------------------------

--
-- Table structure for table `khuvuckho`
--

CREATE TABLE `khuvuckho` (
  `makhuvuc` int(11) NOT NULL,
  `tenkhuvuc` varchar(255) NOT NULL,
  `ghichu` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khuvuckho`
--

INSERT INTO `khuvuckho` (`makhuvuc`, `tenkhuvuc`, `ghichu`, `trangthai`) VALUES
(1, 'Kho Bình Dương', 'rau, củ, quả', 1),
(2, 'Kho HCM Express', 'bánh kẹo', 1),
(3, 'Kho Bình Trị Đông', 'đồ ăn', 1),
(4, 'Kho Hoàng Hà', 'đồ dùng học tập', 1),
(5, 'Kho Đồng Tháp Ultra', 'nước ngọt', 1);

-- --------------------------------------------------------

--
-- Table structure for table `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `maloai` int(11) NOT NULL,
  `tenloai` varchar(255) NOT NULL,
  `trangthai` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loaisanpham`
--

INSERT INTO `loaisanpham` (`maloai`, `tenloai`, `trangthai`) VALUES
(1, 'Đồ ăn', 1),
(2, 'Nước uống', 1),
(3, 'Rau củ quả', 1),
(4, 'Đồ dùng cá nhân', 1),
(5, 'Dụng cụ học tập', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `mancc` int(11) NOT NULL,
  `tenncc` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sdt` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`mancc`, `tenncc`, `diachi`, `email`, `sdt`, `trangthai`) VALUES
(1, 'Công Ty TNHH rau củ quả Thái An', ' Phòng 6.5, Tầng6, Tòa Nhà E. Town 2, 364 Cộng Hòa, P. 13, Q. Tân Bình, Tp. Hồ Chí Minh', 'lienhe@thegioididong.com', '02835100100', 1),
(2, 'Công ty bánh kẹo Việt Nam', 'Số 79 đường số 6, Hưng Phước 4, Phú Mỹ Hưng, quận 7, TPHCM', 'contact@paviet.vn', '19009477', 1),
(3, 'Công Ty TNHH đồ ăn nhanh', '8/38 Đinh Bô Lĩnh, P.24, Q. Bình Thạnh, Tp. Hồ Chí Minh', 'contact@baola.vn', '02835119060', 1),
(4, 'Công Ty THHHMTV An Nam ', 'Phòng 703, Tầng7, Tòa Nhà Metropolitan, 235 Đồng Khởi, P. Bến Nghé, Q. 1, Tp. Hồ Chí Minh (TPHCM)', 'chau.nguyen@nokia.com', '02838236894', 1),
(5, 'Hệ Thống Phân Phối nước ngọt', '261 Lê Lợi, P. Lê Lợi, Q. Ngô Quyền, Tp. Hải Phòng', 'info@mihome.vn', '0365888866', 1),
(6, 'Atech Group', 'Tòa nhà tài chính Bitexco, 2 Hải Triều, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh', 'contact@samsung.vn', '0988788456', 1),
(7, 'Công ty Suzuki Việt Nam', '27 Đ. Nguyễn Trung Trực, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh', 'oppovietnam@oppo.vn', '0456345234', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manv` int(11) NOT NULL,
  `hoten` varchar(255) NOT NULL,
  `gioitinh` varchar(11) NOT NULL,
  `ngaysinh` date NOT NULL,
  `sdt` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`manv`, `hoten`, `gioitinh`, `ngaysinh`, `sdt`, `email`, `trangthai`) VALUES
(1, 'admin', 'Nam', '2004-01-21', '0387913347', 'admin@gmail.com', 1),
(2, 'Nguyễn Bảo', 'Nam', '2004-10-22', '0355374321', 'bao@gmail.com', 1),
(3, 'Nguyễn Tấn Cảnh', 'Nam', '2000-01-11', '0989338281', 'canh@gmail.com', 1),
(4, 'Nguyễn Trung Trực', 'Nam', '2003-04-03', '0367890283', 'trungtruc@gmail.com', 1),
(5, 'Nguyễn Quang Dương', 'Nam', '2004-05-06', '0378119329', 'quangduong@gmail.com', 1),
(6, 'Huỳnh Lê Phúc', 'Nam', '2004-01-09', '0369308081', 'phucle@gmail.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhomquyen`
--

CREATE TABLE `nhomquyen` (
  `manhomquyen` int(11) NOT NULL,
  `tennhomquyen` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhomquyen`
--

INSERT INTO `nhomquyen` (`manhomquyen`, `tennhomquyen`, `trangthai`) VALUES
(1, 'admin', 1),
(2, 'Nhân viên nhập hàng', 1),
(3, 'Nhân viên xuất hàng', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `maphieunhap` int(11) NOT NULL,
  `mancc` int(11) NOT NULL,
  `manv` int(11) NOT NULL,
  `thoigian` datetime DEFAULT current_timestamp(),
  `tongtien` decimal(10,2) NOT NULL DEFAULT 0.00,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `maphieuxuat` int(11) NOT NULL,
  `thoigian` datetime NOT NULL DEFAULT current_timestamp(),
  `tongtien` decimal(10,2) DEFAULT NULL,
  `soluong` int(11) NOT NULL,
  `manv` int(11) NOT NULL,
  `makh` int(11) NOT NULL,
  `magiamgia` int(11) DEFAULT NULL,
  `trangthai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `masp` int(11) NOT NULL,
  `maloai` int(11) NOT NULL,
  `tensp` varchar(255) DEFAULT NULL,
  `hinhanh` varchar(255) DEFAULT NULL,
  `xuatxu` int(11) DEFAULT NULL,
  `NSX` date NOT NULL,
  `HSD` date NOT NULL,
  `thuonghieu` int(11) DEFAULT NULL,
  `gianhap` decimal(10,2) DEFAULT NULL,
  `soluongton` int(11) DEFAULT 0,
  `trangthai` tinyint(1) DEFAULT 1,
  `giaban` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`masp`, `maloai`, `tensp`, `hinhanh`, `xuatxu`, `NSX`, `HSD`, `thuonghieu`, `gianhap`, `soluongton`, `trangthai`, `giaban`) VALUES
(1, 2, 'pepsi', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-04-11', '2024-12-11', 1, 10000.00, 0, 1, 0.00),
(2, 1, 'bánh kem', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-04-11', '2024-12-11', 1, 400000.00, 0, 1, 0.00),
(3, 1, 'bánh quy', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-04-11', '2024-11-11', 1, 50000.00, 0, 1, 0.00),
(4, 3, 'cà rốt', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-04-11', '2024-04-11', 1, 6000.00, 0, 1, 0.00),
(5, 3, 'khoai tây', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-04-11', '2024-04-11', 1, 10000.00, 0, 1, 0.00),
(6, 1, 'rau muống', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-04-11', '2024-04-11', 1, 7000.00, 0, 1, 0.00),
(7, 1, 'coca', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-04-11', '2024-04-11', 1, 10000.00, 0, 1, 0.00),
(8, 1, 'bút xóa', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-04-11', '2024-04-11', 1, 15000.00, 0, 1, 0.00),
(9, 1, 'thước kẻ', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2024-09-11', '2025-10-11', 1, 123.00, 0, 1, 0.00),
(10, 2, 'bánh mì', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2024-09-12', '2025-09-12', 1, 10000.00, 0, 1, 0.00),
(11, 2, 'nước suối', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-06-11', '2024-06-11', 1, 5000.00, 0, 1, 0.00),
(12, 1, 'sữa chua', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-05-11', '2024-05-11', 1, 12000.00, 0, 1, 0.00),
(13, 2, 'kẹo dừa', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-07-01', '2024-11-01', 1, 45000.00, 0, 1, 0.00),
(14, 3, 'hành tây', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-08-11', '2024-10-11', 1, 7000.00, 0, 1, 0.00),
(15, 3, 'cà chua', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-09-01', '2024-09-01', 1, 9000.00, 0, 1, 0.00),
(16, 2, 'trái cây sấy', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-03-11', '2024-03-11', 1, 60000.00, 0, 1, 0.00),
(17, 1, 'bánh kẹo', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-02-11', '2024-02-11', 1, 30000.00, 0, 1, 0.00),
(18, 2, 'kẹo bạc hà', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-04-11', '2024-12-11', 1, 15000.00, 0, 1, 0.00),
(19, 1, 'kem đánh răng', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-05-11', '2024-05-11', 1, 20000.00, 0, 1, 0.00),
(20, 1, 'dầu gội', 'src/GUI/imageSanPham/comingsoon.jpg', 1, '2023-06-11', '2024-12-11', 1, 45000.00, 0, 1, 0.00);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `mataikhoan` int(11) NOT NULL,
  `manv` int(11) NOT NULL,
  `matkhau` char(255) NOT NULL,
  `manhomquyen` int(11) NOT NULL,
  `tendangnhap` varchar(50) NOT NULL DEFAULT '',
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`mataikhoan`, `manv`, `matkhau`, `manhomquyen`, `tendangnhap`, `trangthai`) VALUES
(1, 1, 'admin', 1, 'admin', 1),
(2, 3, '12345a@', 2, 'tancanh1', 1),
(3, 2, '12345a@', 3, 'xuanbao1', 1),
(4, 4, '12345a@', 2, 'truc1', 0),
(5, 5, '12345a@', 3, 'duong1', 0);

-- --------------------------------------------------------

--
-- Table structure for table `thuonghieu`
--

CREATE TABLE `thuonghieu` (
  `mathuonghieu` int(11) NOT NULL,
  `tenthuonghieu` varchar(255) NOT NULL,
  `trangthai` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `thuonghieu`
--

INSERT INTO `thuonghieu` (`mathuonghieu`, `tenthuonghieu`, `trangthai`) VALUES
(1, 'Acecook Viet Nam', 1),
(2, 'Thiên Long', 1),
(3, 'Thái Dương đồ dùng học tập', 1),
(4, 'Nerman Vietnam', 0),
(7, 'Noctural Studio', 0),
(8, 'Sly onstream', 0),
(9, 'Mỹ hảo', 1),
(10, 'Ava đồ dùng công nghệ', 1);

-- --------------------------------------------------------

--
-- Table structure for table `xuatxu`
--

CREATE TABLE `xuatxu` (
  `maxuatxu` int(11) NOT NULL,
  `tenxuatxu` varchar(50) NOT NULL,
  `trangthai` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `xuatxu`
--

INSERT INTO `xuatxu` (`maxuatxu`, `tenxuatxu`, `trangthai`) VALUES
(1, 'Trung Quốc', 1),
(2, 'Hàn Quốc', 1),
(3, 'Việt Nam', 1),
(4, 'USA', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD KEY `fk_ctphieunhap_maphieunhap` (`maphieunhap`),
  ADD KEY `fk_phieunhap_makhuvuc` (`makhuvuc`),
  ADD KEY `fk_ctphieunhap_masp` (`masp`);

--
-- Indexes for table `ctphieuxuat`
--
ALTER TABLE `ctphieuxuat`
  ADD KEY `fk_ctphieuxuat_masp` (`masp`),
  ADD KEY `fk_ctphieuxuat_maphieuxuat` (`maphieuxuat`);

--
-- Indexes for table `danhmucchucnang`
--
ALTER TABLE `danhmucchucnang`
  ADD PRIMARY KEY (`machucnang`);

--
-- Indexes for table `giamgia`
--
ALTER TABLE `giamgia`
  ADD PRIMARY KEY (`magiamgia`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`makh`);

--
-- Indexes for table `khuvuckho`
--
ALTER TABLE `khuvuckho`
  ADD PRIMARY KEY (`makhuvuc`);

--
-- Indexes for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`maloai`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`mancc`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`manv`);

--
-- Indexes for table `nhomquyen`
--
ALTER TABLE `nhomquyen`
  ADD PRIMARY KEY (`manhomquyen`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`maphieunhap`),
  ADD KEY `fk_phieunhap_mancc` (`mancc`),
  ADD KEY `fk_phieunhap_manv` (`manv`);

--
-- Indexes for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`maphieuxuat`),
  ADD KEY `fk_phieuxuat_manv` (`manv`),
  ADD KEY `fk_phieuxuat_makh` (`makh`),
  ADD KEY `fk_phieuxuat_magiamgia` (`magiamgia`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`masp`),
  ADD KEY `fk_sanpham_loaisanpham` (`maloai`),
  ADD KEY `fk_sanpham_thuonghieu` (`thuonghieu`),
  ADD KEY `fk_sanpham_xuatxu` (`xuatxu`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`mataikhoan`),
  ADD KEY `fk_taikhoan_manhomquyen` (`manhomquyen`),
  ADD KEY `fk_taikhoan_manv` (`manv`);

--
-- Indexes for table `thuonghieu`
--
ALTER TABLE `thuonghieu`
  ADD PRIMARY KEY (`mathuonghieu`);

--
-- Indexes for table `xuatxu`
--
ALTER TABLE `xuatxu`
  ADD PRIMARY KEY (`maxuatxu`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `danhmucchucnang`
--
ALTER TABLE `danhmucchucnang`
  MODIFY `machucnang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `giamgia`
--
ALTER TABLE `giamgia`
  MODIFY `magiamgia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `makh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `khuvuckho`
--
ALTER TABLE `khuvuckho`
  MODIFY `makhuvuc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `maloai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `mancc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `manv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `nhomquyen`
--
ALTER TABLE `nhomquyen`
  MODIFY `manhomquyen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `maphieunhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  MODIFY `maphieuxuat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `masp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `mataikhoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `thuonghieu`
--
ALTER TABLE `thuonghieu`
  MODIFY `mathuonghieu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `xuatxu`
--
ALTER TABLE `xuatxu`
  MODIFY `maxuatxu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD CONSTRAINT `fk_ctphieunhap_maphieunhap` FOREIGN KEY (`maphieunhap`) REFERENCES `phieunhap` (`maphieunhap`),
  ADD CONSTRAINT `fk_ctphieunhap_masp` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`),
  ADD CONSTRAINT `fk_phieunhap_makhuvuc` FOREIGN KEY (`makhuvuc`) REFERENCES `khuvuckho` (`makhuvuc`);

--
-- Constraints for table `ctphieuxuat`
--
ALTER TABLE `ctphieuxuat`
  ADD CONSTRAINT `fk_ctphieuxuat_maphieuxuat` FOREIGN KEY (`maphieuxuat`) REFERENCES `phieuxuat` (`maphieuxuat`),
  ADD CONSTRAINT `fk_ctphieuxuat_masp` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`);

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `fk_phieunhap_mancc` FOREIGN KEY (`mancc`) REFERENCES `nhacungcap` (`mancc`),
  ADD CONSTRAINT `fk_phieunhap_manv` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);

--
-- Constraints for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `fk_phieuxuat_magiamgia` FOREIGN KEY (`magiamgia`) REFERENCES `giamgia` (`magiamgia`),
  ADD CONSTRAINT `fk_phieuxuat_makh` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`),
  ADD CONSTRAINT `fk_phieuxuat_manv` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `fk_sanpham_loaisanpham` FOREIGN KEY (`maloai`) REFERENCES `loaisanpham` (`maloai`),
  ADD CONSTRAINT `fk_sanpham_thuonghieu` FOREIGN KEY (`thuonghieu`) REFERENCES `thuonghieu` (`mathuonghieu`),
  ADD CONSTRAINT `fk_sanpham_xuatxu` FOREIGN KEY (`xuatxu`) REFERENCES `xuatxu` (`maxuatxu`);

--
-- Constraints for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `fk_taikhoan_manhomquyen` FOREIGN KEY (`manhomquyen`) REFERENCES `nhomquyen` (`manhomquyen`),
  ADD CONSTRAINT `fk_taikhoan_manv` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
