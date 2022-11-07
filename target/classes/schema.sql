CREATE TABLE IF NOT EXISTS User_Data (
    login VARCHAR(50) UNIQUE NOT NULL PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    first_Name VARCHAR(50) NOT NULL,
    last_Name VARCHAR(50) NOT NULL
    );

CREATE TABLE IF NOT EXISTS Flight (
     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     destination_City VARCHAR(50) NOT NULL,
     departure_City VARCHAR(50) NOT NULL,
     departure_Time VARCHAR(50) NOT NULL,
     arrival_Time VARCHAR(50) NOT NULL,
     price DOUBLE NOT NULL
     );

CREATE TABLE IF NOT EXISTS Orders(
    Order_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Flight_ID int,
    FOREIGN KEY(Flight_ID) REFERENCES Flight(id),
    User_Login VARCHAR(50),
    FOREIGN KEY(User_Login) REFERENCES User_Data(login)
);
