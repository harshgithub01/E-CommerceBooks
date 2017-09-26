/*
	Create status-category table
*/
CREATE TABLE StatusCategories (
    id INT NOT NULL AUTO_INCREMENT,
	enabled BOOLEAN NOT NULL,
	activation BOOLEAN NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
	
	CONSTRAINT PK_StatusCategories PRIMARY KEY (id)
);