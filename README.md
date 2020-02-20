# Organisational-News -(API)

## Description
-This application allows a user to input and recordquotes and also read quotes and picture story.


## prerequisites

1. Uses Jdk inorder for it to be compiled.
2. Uses Gradle inorder to built.
3.Uses Postman to be executed.

## Set-Up
- Install IntelliJ IDEAL Community Edition

- Open it within IntelliJ
- CREATE DATABASE organisationapi;
- \c organisationapi;
- CREATE TABLE departements (id serial PRIMARY KEY, dept_name VARCHAR, dept_description VARCHAR, dept_size INTEGER);
- CREATE TABLE users (id serial PRIMARY KEY, title VARCHAR body VARCHAR dept_Id INTEGER);
- CREATE TABLE news (id serial PRIMARY KEY, user_name VARCHAR,user_position VARCHAR, user_role VARCHAR);
- CREATE DATABASE organisationapi_Test WITH TEMPLATE organisationapi;

## Behaviour Driven Development

| Behaviour | Input | Output |
| --------- | ------| ------ |
|Gradle Run on server locally in port (4567)|open postman and put a path the add a json code|Click run and view the post or get|



## Live Website
View the complete site [here](https://github.com/jonahmakori/Organisational-(API))

## Contributors
 - Jonah Makori


## Technologies Used
- java
- Spark 
- postman
- Gson
- Json 
- Postgres

## Support and contact details

 - Email jonahmakori0@gmail.com
 - Tel: 0700222621

### License

The project is under[MIT license](/blob/master/LICENSE)
Copyright &copy; 2020.All rigths reserved



## License
---------
### MIT License

Copyright (c) 2020 Jonah Makori

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


## Author

**Jonah Makori**
