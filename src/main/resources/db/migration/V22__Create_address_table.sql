/*
	Create address table
*/
CREATE TABLE Addresses (
  id INT NOT NULL AUTO_INCREMENT,
  enabled BOOLEAN NOT NULL,
  alias VARCHAR(255) NOT NULL,
  observation VARCHAR(255),
  publicPlaceType VARCHAR(255) NOT NULL,
  publicPlace VARCHAR(255) NOT NULL,
  number VARCHAR(255) NOT NULL,
  district VARCHAR(255) NOT NULL,
  postalCode VARCHAR(255) NOT NULL,
  homeType VARCHAR(255) NOT NULL,

  id_city INT NOT NULL,
	
	CONSTRAINT PK_Address PRIMARY KEY (id)
);

ALTER TABLE Addresses ADD FOREIGN KEY (id_city) REFERENCES Cities(id);