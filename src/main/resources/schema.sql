CREATE SCHEMA IF NOT EXISTS InventoryApp;
USE InventoryApp;

CREATE TABLE IF NOT EXISTS InventoryApp.products (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  product_name VARCHAR(45) NOT NULL,
  product_condition VARCHAR(45) NOT NULL,
  product_year VARCHAR(45) NOT NULL,
  product_price INT UNSIGNED NOT NULL,
  PRIMARY KEY (id));
  
  CREATE TABLE IF NOT EXISTS InventoryApp.customers (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(16) NOT NULL,
  last_name VARCHAR(16) NOT NULL,
  email VARCHAR(30) NOT NULL,
  phone_number VARCHAR(15) NOT NULL,
  PRIMARY KEY (id));
  
  CREATE TABLE IF NOT EXISTS InventoryApp.transactions (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  customer_id VARCHAR(16) NOT NULL,
  product_id VARCHAR(16) NOT NULL,
  transaction_date VARCHAR(40) NOT NULL,
  PRIMARY KEY (id));
  
  