DROP SCHEMA IF EXISTS `maz-inventorydb`;
CREATE SCHEMA IF NOT EXISTS `maz-inventorydb` DEFAULT CHARACTER SET latin1;
USE `maz-inventorydb`;


CREATE TABLE IF NOT EXISTS `maz-inventorydb`.`user` (
    `username`      VARCHAR(40) NOT NULL,
    `password`      VARCHAR(100) NOT NULL,
    `salt`          VARCHAR(20) DEFAULT NULL,
    PRIMARY KEY (`username`)
);


CREATE TABLE IF NOT EXISTS `maz-inventorydb`.`inventory` (
    `item_id`       INT(11)      NOT NULL AUTO_INCREMENT,
    `serial_number` VARCHAR(40)  NOT NULL UNIQUE,
    `description`   VARCHAR(100) NOT NULL,
    `od`            VARCHAR(20)  NOT NULL,
    `pin_connect`   VARCHAR(20)  NOT NULL,
    `box_connect`   VARCHAR(20)  NOT NULL,
    `id`            VARCHAR(20)  NOT NULL,
    `length`        DECIMAL(13, 3)      NOT NULL,
    `status_name`   VARCHAR(20)  NOT NULL,
    PRIMARY KEY (`item_id`)
      
);

CREATE TABLE IF NOT EXISTS `maz-inventorydb`.`customer` (
    `customer_id`               INT NOT NULL AUTO_INCREMENT,
    `company`      		VARCHAR(100) NOT NULL,
    `address1`                  VARCHAR(100) NOT NULL,
	`address2`     	 	VARCHAR(100),
	`city`      		VARCHAR(40) NOT NULL,
	`province`      	VARCHAR(40) NOT NULL,
	`country`      		VARCHAR(40) NOT NULL,
	`postal_code`      	VARCHAR(10) NOT NULL,
	`email`      		VARCHAR(100),
	`contact_list`          VARCHAR(40),
	`phone`      		VARCHAR(20) NOT NULL,
	`extension`      	VARCHAR(20),
	`IsVendor` 		BIT NOT NULL,
    PRIMARY KEY (`customer_id`)
);

-- sha256 on password field
INSERT INTO `user` (`username`, `password`)
    VALUES ('admin', '5ad71d5fe5365d2d77d4584a3e15cdd5caf464e470cd7ab6a7251e41859e25f3');
INSERT INTO `inventory` (`serial_number`, `description`, `od`, `pin_connect`, `box_connect`, `id`, `length`, `status_name`)
    VALUES('GFG2523566dDG2', 'NM Slick Collar', '4 3/4', '3 1/2 IF', '3 1/2 IF', '2"', 1,'Available');