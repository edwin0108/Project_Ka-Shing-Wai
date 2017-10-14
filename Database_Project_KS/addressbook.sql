DROP TABLE Addresses;

CREATE TABLE Addresses
(
	AddressID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
	FirstName VARCHAR (15) NOT NULL,
	LastName VARCHAR (30) NOT NULL,
	Email VARCHAR (30) NOT NULL,
	PhoneNumber VARCHAR (15) NOT NULL,
	USState VARCHAR (2) NOT NULL
);

INSERT INTO Addresses (FirstName,LastName,Email,PhoneNumber, USState)
	VALUES ('Mike','Green','demo1@deitel.com','555-5555','NY'),
	('Mary','Brown','demo2@deitel.com','555-1234','NJ');