if NOT EXISTS CREATE TABLE UserData {
    login VARCHAR(50) NOT NULL PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL
    );
}

if NOT EXISTS CREATE TABLE Flight {
    id INT NOT NULL PRIMARY KEY,
    login VARCHAR(50) NOT NULL PRIMARY KEY,
    destinationCity VARCHAR(50) NOT NULL,
    arrivalCity VARCHAR(50) NOT NULL,
    departureTime VARCHAR(50) NOT NULL,
    arrivalTime VARCHAR(50) NOT NULL,
    price DOUBLE NOT NULL
    );
}