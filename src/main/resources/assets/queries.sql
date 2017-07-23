create database connectIN;
CREATE TABLE Users (
  UserId    INT          NOT NULL PRIMARY KEY,
  FirstName VARCHAR(50)  NOT NULL,
  LastName  VARCHAR(50)  NOT NULL,
  Email     VARCHAR(100) NOT NULL,
  Password  VARCHAR(50)  NOT NULL
);

CREATE TABLE connectIN.Friends
(
  id       INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  userId   VARCHAR(50)     NOT NULL,
  friendId VARCHAR(50),
  FOREIGN KEY (userId) REFERENCES Users (UserId),
  FOREIGN KEY (friendId) REFERENCES Users (UserId)
);
