-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3307
-- Tiempo de generación: 25-11-2020 a las 00:27:39
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `inventario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `idInventario` int(11) NOT NULL,
  `Numero` int(40) NOT NULL,
  `Marca` varchar(45) NOT NULL,
  `Procesador` varchar(45) NOT NULL,
  `Estado` varchar(25) NOT NULL,
  `Almacenamiento` varchar(45) NOT NULL,
  `MemoriaRAM` varchar(45) NOT NULL,
  `MAC` varchar(45) NOT NULL,
  `Accesorios` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`idInventario`, `Numero`, `Marca`, `Procesador`, `Estado`, `Almacenamiento`, `MemoriaRAM`, `MAC`, `Accesorios`) VALUES
(1, 785486, 'LENOVO', 'INTEL CORE 5 ', 'Activo', '500 GB', '12 GB', 'AC:45:78:AS:85:SD', 'Todos'),
(2, 7485248, 'HP', 'AMD SEREA A PRO', 'Activo', '250 GB', '8 GB', 'JK:25:87:AS:87', 'Todos'),
(3, 5445224, 'ASUS', 'AMD RAYZEN 5 3600', 'Activo', '500 GB', '8 GB', 'KF:54:AS:CA:58', 'Todos'),
(4, 1234568, 'APPLE', 'INTEL CORE 5 ', 'Activo', '250 GB', '4 GB', 'LK:48:AS:98', 'Todos'),
(5, 85285241, 'ACER', 'INTEL CORE 7', 'Activo', '1 TERA', '12 GB', 'LK:SA:74:58:AS:WE', 'Todos'),
(6, 5485686, 'MSI', 'INTEL CORE 9', 'Activo', '250 GB', '16 GB', 'LO:45:87:74:LG', 'Morral '),
(7, 85987452, 'ACER', 'AMD RAYZEN 5 3600', 'Activo', '250 GB', '8 GB', 'AS:DF:ER:VC:PO', 'Todos'),
(8, 852546, 'APPLE', 'INTEL CORE 7', 'Activo', '500 GB', '12 GB', 'GF:SA:AS:45:87', 'Todos'),
(9, 85252541, 'APPLE', 'INTEL CORE 7', 'Activo', '250 GB', '8 GB', 'AS:AE:85:25:AS', 'Cargador'),
(10, 845618456, 'LENOVO', 'INTEL CORE 7', 'Activo', '1 TERA', '12 GB', 'LK:58:52:87:89', 'Todos'),
(11, 856456, 'ACER', 'AMD SEREA A PRO', 'Activo', '500 GB', '12 GB', 'LK:PO:85:52:87', 'Todos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) NOT NULL,
  `Telefono` int(20) NOT NULL,
  `Direccion` varchar(45) NOT NULL,
  `Correo` varchar(45) NOT NULL,
  `Contraseña` varchar(45) NOT NULL,
  `Tipo` varchar(50) NOT NULL,
  `Estado` varchar(45) NOT NULL,
  `Ciudad` varchar(45) NOT NULL,
  `Contrato` varchar(45) NOT NULL,
  `Inventario_idInventario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `Nombre`, `Apellido`, `Telefono`, `Direccion`, `Correo`, `Contraseña`, `Tipo`, `Estado`, `Ciudad`, `Contrato`, `Inventario_idInventario`) VALUES
(1, 'German', 'Saavedra', 7484501, 'calle 89 n 120 a 71', 'admin@gmail.com', '12345', 'Administrador', 'Activo', 'Bogota D.C', 'Fijo', 1),
(2, 'Julian', 'Orosco', 789457, 'Avenida 45 N 14 b', 'julian@gmail.com', '123456', 'Empleado', 'Inactivo', 'Bogota D.C', 'Termino Indefinido', 2),
(3, 'Camila', 'Flores', 85285, 'Calle 45 n 2', 'camila@gmail.com', 'camila1', 'Empleado', 'Activo', 'Villavicencio', 'Obra o Labor', 3),
(4, 'sara', 'orosco', 852852, 'cr 45 n119', 'sara@gmail.com', 'prueba', 'Empleado', 'Activo', 'Medellín', 'Prestación de servicios', 9),
(5, 'pepe', 'pepito', 123123, 'cr 43', 'pepe@gmail.com', 'pepe', 'Empleado', 'Activo', 'Medellín', 'Temporal', 11);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`idInventario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `idInventario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
