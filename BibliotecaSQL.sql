--- Tomas Martínez Sempere
--- Ejercicio libreria Acceso a Datos

DROP TABLE `prestamos`;
DROP TABLE `libros`;
DROP TABLE `socios`;

CREATE TABLE IF NOT EXISTS `libros` (
  `titulo` varchar(100) NOT NULL,
  `autor` varchar(100) NOT NULL,
  `ISBN` varchar(20) NOT NULL,
  `n_paginas` int(3) DEFAULT NULL,
  `n_ejemplares` int(2) DEFAULT NULL,
  `editorial` varchar(100) DEFAULT NULL,
  `anno_edicion` int(4) DEFAULT NULL,
	CONSTRAINT pk_libros PRIMARY KEY (ISBN)
);

CREATE TABLE IF NOT EXISTS `socios` (
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `edad` int(2) DEFAULT NULL,
  `telefono` int(9) DEFAULT NULL,
  `DNI` varchar(9) NOT NULL,
	CONSTRAINT pk_libros PRIMARY KEY (DNI)
);

CREATE TABLE IF NOT EXISTS `prestamos` (
  `dni_e` varchar(9) NOT NULL,
  `isbn_e` varchar(20) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_final` date NOT NULL,
  `fecha_devuelto` date DEFAULT NULL,
 	CONSTRAINT pk_prestamos PRIMARY KEY (dni_e, isbn_e, fecha_inicio),
	CONSTRAINT fk_pres_libros FOREIGN KEY (isbn_e) REFERENCES libros (ISBN),
    CONSTRAINT fk_pres_socios FOREIGN KEY (dni_e) REFERENCES socios (DNI)
);

INSERT INTO `libros` (`titulo`, `autor`, `ISBN`, `n_paginas`, `n_ejemplares`, `editorial`, `anno_edicion`) VALUES
('El cisne negro', 'Nassim Nicholas Taleb', '8408008544', 592, 1, 'Booket', 2012),
('El nombre de la rosa', 'Umberto Eco', '8426418805', 752, 3, 'Lumen', 2010),
('Antifrágil', 'Nassim Nicholas Taleb', '8449328640', 656, 1, 'Paidos', 2013),
('Pensar rápido, pensar despacio', 'Daniel Kahneman', '8490322503', 672, 2, 'DEBOLSILLO', 2013),
('El Aleph', 'Jorge Luis Borges', '8499089518', 216, 5, 'DEBOLSILLO', 2011);

INSERT INTO `socios` (`nombre`, `apellido`, `direccion`, `edad`, `telefono`, `DNI`) VALUES
('Tomás', 'Martínez Sempere', 'C/ Poeta Zorrilla Nº63', 29, 616787764, '48570440Y'),
('Esteban', 'Ruiz Aldeguer', 'C/ Desesperación Nº52', 19, 852963254, '75386425J'),
('Alberto', 'Gonzalez Arregui', 'C/ Zurbaran Nº7', 23, 739182564, '76564552A'),
('María', 'Piedecausa Bou', 'C/ Mayor Nº85', 52, 456852963, '87463259F');

INSERT INTO `prestamos` (`dni_e`, `isbn_e`, `fecha_inicio`, `fecha_final`, `fecha_devuelto`) VALUES
('48570440Y', '8449328640', '2014-09-03', '2014-11-02', '2014-10-23'),
('75386425J', '8490322503', '2014-11-05', '2014-11-06', NULL),
('76564552A', '8408008544', '2014-11-01', '2014-11-04', NULL),
('87463259F', '8426418805', '2014-11-05', '2014-11-14', NULL),
('87463259F', '8499089518', '2014-08-04', '2014-09-09', '2014-09-01');
