create database autentia;

use autentia;

create user 'autentia' identified by 'autentia';

grant all on autentia.* to 'autentia';

flush privileges;

CREATE TABLE `cliente` (
  `idcliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `fechanacimiento` datetime NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `password` varchar(8) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  PRIMARY KEY (`idcliente`)
);

