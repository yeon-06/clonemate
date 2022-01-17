-- create User Table
CREATE TABLE USER (
    user_id INT NOT NULL,
    account VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    name VARCHAR(20) NOT NULL,
    password VARCHAR(100) NOT NULL,
    intro_text VARCHAR(100),
    delete_yn CHAR(1) NOT NULL DEFAULT 'N',
    delete_date DATE,
    email_search_yn CHAR(1) NOT NULL DEFAULT 'Y',
    random_yn CHAR(1) NOT NULL DEFAULT 'Y',
    PRIMARY KEY(id)
);
ALTER TABLE USER convert to charset UTF8;
