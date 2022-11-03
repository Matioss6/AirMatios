CREATE TABLE IF NOT EXISTS User_Data (
    login VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    first_Name VARCHAR(50) NOT NULL,
    last_Name VARCHAR(50) NOT NULL
    );

CREATE TABLE IF NOT EXISTS Flight (
     id INT NOT NULL PRIMARY KEY,
     destination_City VARCHAR(50) NOT NULL,
     arrival_City VARCHAR(50) NOT NULL,
     departure_Time VARCHAR(50) NOT NULL,
     arrival_Time VARCHAR(50) NOT NULL,
     price DOUBLE NOT NULL
     );


