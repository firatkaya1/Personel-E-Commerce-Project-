DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS messages;

CREATE TABLE products (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  product_code VARCHAR(250) NOT NULL,
  product_title VARCHAR(250) NOT NULL,
  product_price VARCHAR(250) NOT NULL,
  product_test_link VARCHAR(250) NOT NULL,
  product_discount_code VARCHAR(250) NOT NULL,
  product_Tag VARCHAR(250) NOT NULL,
  product_owner VARCHAR(250) NOT NULL,
  product_owner_email VARCHAR(250) NOT NULL,
  product_description VARCHAR(250) NOT NULL,
  product_header_image VARCHAR(250) NOT NULL,
  product_slider1 VARCHAR(250) NOT NULL,
  product_slider2 VARCHAR(250) NOT NULL,
  product_slider3 VARCHAR(250) NOT NULL
  
 );
 
 
 CREATE TABLE comments (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  comment_id VARCHAR(250) NOT NULL,
  product_code VARCHAR(250) NOT NULL,
  comment_email VARCHAR(250) NOT NULL,
  comment_name VARCHAR(250) NOT NULL,
  comment_tag VARCHAR(250) NOT NULL,
  comment_date VARCHAR(250) NOT NULL,
  comment_hide VARCHAR(250) NOT NULL,
  comment_description VARCHAR(250) NOT NULL
  
 );
 
  
 CREATE TABLE messages (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  product_code VARCHAR(250) NOT NULL,
  message_type VARCHAR(250) NOT NULL,
  product_tag VARCHAR(250) NOT NULL,
  message_name VARCHAR(250) NOT NULL,
  message_from VARCHAR(250) NOT NULL,
  message_to VARCHAR(250) NOT NULL,
  message_date VARCHAR(250) NOT NULL,
  message_description VARCHAR(250) NOT NULL
  
 );
 INSERT INTO messages VALUES (1,'3333','BUY','FORM','FIRAT','message@admin.com','firat@admin.com','2019-11-12 23-19','bu bir açıklamadır.')
 
 
 
 
 
 
 
 
 