CREATE TABLE book (
	num NUMBER CONSTRAINT book_num_pk PRIMARY KEY,
	title varchar2(50),
	author varchar2(20),
	publisher varchar2(20),
	publisher_date DATE,
	price NUMBER
);

CREATE SEQUENCE book_num_pk
 START WITH 1
 INCREMENT BY 1
 nocache
 nocycle;
 
SELECT * FROM book;

INSERT INTO book(num, title, author, publisher, publisher_date, price)
VALUES(book_num_pk.nextval, '코스모스', '칼 세이건', '사이언스 북스', '2006-12-20', 19900);

COMMIT;