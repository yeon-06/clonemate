-- create User Table
CREATE TABLE USER (
    id VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    name VARCHAR(20) NOT NULL,
    password VARCHAR(100) NOT NULL,
    introText VARCHAR(100),
    deleteYn CHAR(1) NOT NULL DEFAULT 'N',
    deleteDate DATE,
    emailSearchYn CHAR(1) NOT NULL DEFAULT 'Y',
    randomYn CHAR(1) NOT NULL DEFAULT 'Y',
    PRIMARY KEY(id)
);
ALTER TABLE USER convert to charset UTF8;

-- 테스트 데이터
INSERT INTO USER(
    id,
    email,
    name,
    password,
    introText
)
VALUES (
    'test',
    'test123@gmail.com',
    '테스트',
    '1234',
    '반갑습니다!'
);