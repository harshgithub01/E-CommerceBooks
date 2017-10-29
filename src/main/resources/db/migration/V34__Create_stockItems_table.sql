/*
	Create stock-item table
*/
CREATE TABLE StockItems (
	id INT NOT NULL AUTO_INCREMENT,
	enabled BOOLEAN NOT NULL,
	unitaryPrice DOUBLE NOT NULL,

	id_stock INT NOT NULL,
	id_book INT NOT NULL,
	
	CONSTRAINT PK_StockItem PRIMARY KEY (id)
);

ALTER TABLE StockItems ADD FOREIGN KEY (id_stock) REFERENCES Stocks(id);
ALTER TABLE StockItems ADD FOREIGN KEY (id_book) REFERENCES Books(id);