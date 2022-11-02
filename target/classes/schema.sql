CREATE TABLE IF NOT EXISTS UserData (
    login VARCHAR(50) NOT NULL PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL
    );
    
CREATE TABLE IF NOT EXISTS Flight (
     id INT NOT NULL PRIMARY KEY,
     login VARCHAR(50) NOT NULL,
     destinationCity VARCHAR(50) NOT NULL,
     arrivalCity VARCHAR(50) NOT NULL,
     departureTime VARCHAR(50) NOT NULL,
     arrivalTime VARCHAR(50) NOT NULL,
     price DOUBLE NOT NULL
     );


