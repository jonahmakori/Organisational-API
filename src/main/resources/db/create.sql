
SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments(
 departmentId int  PRIMARY KEY auto_increment,
 departmentName VARCHAR,
 description VARCHAR,
 numberOfEmployees INTEGER
);

CREATE TABLE IF NOT EXISTS users (
 id int PRIMARY KEY auto_increment,
 userName VARCHAR,
 positionLevel VARCHAR,
 role VARCHAR,
 departmentId INTEGER
);

CREATE TABLE IF NOT EXISTS news (
 id int PRIMARY KEY auto_increment,
 topic VARCHAR,
 content VARCHAR,
 description VARCHAR,
 departmentId INTEGER
 );