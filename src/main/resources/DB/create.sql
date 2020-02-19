SET MODE PostgreSQL;
CREATE DATABASE organisational_api;
\c organisational_api;

CREATE TABLE IF NOT EXISTS departments(
 id serial PRIMARY KEY,
 departmentname VARCHAR,
 description VARCHAR,
 numberofemployees int
);

CREATE TABLE IF NOT EXISTS users (
 id serial PRIMARY KEY,
 username VARCHAR,
 departmentId int,
 role VARCHAR
);

CREATE TABLE IF NOT EXISTS news (
 id serial PRIMARY KEY,
 topic VARCHAR,
 content varchar,
 departmentId int,
 description VARCHAR
 );
CREATE DATABASE organisational_api_test WITH TEMPLATE organisational_api;