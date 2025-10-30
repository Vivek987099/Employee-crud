#  Java JDBC – Employee Database App

A simple Java console-based application that connects to a **MySQL**  database using **JDBC** and performs **CRUD** operations (Create, Read, Update salary, Delete) on an Employee table.

##  Objective
To understand and implement **Java Database Connectivity (JDBC)** by creating a database-driven console app.

---

##  Tools & Technologies
- **Java (JDK 8 or above)**
- **MySQL **
- **JDBC Driver (MySQL Connector/J)**
- **VS Code **

---

##  Setup Instructions

### 1. Database Setup
Run the following SQL commands in MySQL:

```sql
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employee_table (
  id INT  PRIMARY KEY,
  name VARCHAR(100),
  department VARCHAR(100),
  salary DOUBLE
);
