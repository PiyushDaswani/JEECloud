CREATE TABLE IF NOT EXISTS author 
	(
		author_id bigint AUTO_INCREMENT,
		author_fname varchar(50) NOT NULL ,
		author_mname varchar(50) NOT NULL ,
		author_lname varchar(50) NOT NULL,
		author_phone bigint NOT NULL,
		CONSTRAINT pk_author PRIMARY KEY(author_id)
	);

CREATE TABLE IF NOT EXISTS book 
	(
		book_ISBN bigint AUTO_INCREMENT,
		book_title varchar(50) NOT NULL ,
		book_price double NOT NULL ,
		author_id bigint,
		CONSTRAINT pk_book PRIMARY KEY(book_ISBN),
		FOREIGN KEY (author_id) REFERENCES author(author_id)
	);