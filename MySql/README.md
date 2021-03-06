### Base de datos Motos:
#### Estructura

##### Base de datos

```MySQL
CREATE TABLE `tienda_motos`.`moto` (
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci
COMMENT = 'tabla de registro de motos de la tienda';
```

##### Tabla de motos
```MySQL
CREATE TABLE `tienda_motos`.`moto` (
  `idmoto` INT NOT NULL,
  `marca` VARCHAR(45) NOT NULL COMMENT 'marcas como:\n\nyamaha\nbajaj\nhero \nbmw\n',
  `linea` VARCHAR(45) NOT NULL COMMENT 'lineas como:\n\nfzs\nr15\nboxer100',
  `modelo` CHAR(4) NOT NULL COMMENT 'año de la versión de la moto',
  `imagen` VARCHAR(120) NOT NULL COMMENT 'url de la fotografía',
  `color` VARCHAR(30) NOT NULL,
  `precio` INT NOT NULL,
  `descripcion` LONGTEXT NOT NULL,
  `cilindraje` INT NOT NULL,
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`idmoto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish2_ci
COMMENT = 'tabla de registro de motos de la tienda';
```

##### Tabla de clientes
```MySQL
CREATE TABLE `tienda_motos`.`cliente` (
  `cedula` INT NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `telefono` INT NULL,
  `correo` VARCHAR(80) NULL,
  `direccion` LONGTEXT NULL,
  `fech_nac` DATE NULL,
  `id_moto` INT NULL,
  PRIMARY KEY (`cedula`),
  INDEX `id_moto_idx` (`id_moto` ASC) VISIBLE,
  CONSTRAINT `id_moto`
    FOREIGN KEY (`id_moto`)
    REFERENCES `tienda_motos`.`moto` (`idmoto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
```
| **cédula** | **nombre** | **teléfono** | **correo** | **dirección** | **fecha nacimiento** | **ID moto** |
| ------------- | ------------- | ------------- | ------------- | ------------- | ------------- | ------------- |
| 1111111  | Carlos Antonio  | 9876543  | cantonio@gmail.com | Av. Siempre viva #123  | 1980-06-06  | NULL  |
| 2222222  | Celeste Pardo  | 9876544  | cpardo@gmail.com | Av. la libertad #123  | 1990-06-06  | NULL  |
| 3333333  | Andrés Castillo  | 8776544  | acastillo@gmail.com | Av. La Esperanza #123  | 1997-06-06  | NULL  |

##### Tabla de usuarios
```MySQL
CREATE TABLE `tienda_motos`.`usuario` (
  `cedula` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `correo` VARCHAR(80) NULL,
  `usuario` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `telefono` INT NULL,
  `cargo` VARCHAR(45) NULL,
  PRIMARY KEY (`cedula`));
 ```

| **cédula** | **nombre** | **correo** | **usuario** | **password** | **teléfono** | **cargo** |
| ------------- | ------------- | ------------- | ------------- | ------------- | ------------- | ------------- |
| 1024987654  | Miguel Angel Asturias  | mangela@gmail.com | mangela  | admin123  | 7654321  | Gerente  |
| 1028988654  | Margarita Salazar  | msalazar@gmail.com | msalazar  | admin123  | 4654551  | Asesor Ventas  |
| 1324686654  | Marco António  | mantonio@gmail.com | mantonio  | admin123  | 6654521  | Jefe  |
