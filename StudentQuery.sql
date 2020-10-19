CREATE table Student (
	ID int NOT NULL AUTO_INCREMENT,
	NAME varchar(30) CHARSET utf8,
    AGE int(20),
    PROVINCE varchar(20) CHARSET utf8,
    CLASSES varchar(20) CHARSET utf8,
    PRIMARY KEY(ID),
    EXAM_ID int,
    FOREIGN KEY (EXAM_ID) REFERENCES ExamResult(ID)
);

INSERT into student (name, age, province, classes, exam_id) value ("Hải", 23, "Gia Lai", "12C1", 1);
INSERT into student (name, age, province, classes, exam_id) value ("Hải", 232, "Gia Lai", "12C1", 2);
INSERT into student (name, age, province, classes, exam_id) value ("Vũ", 99, "Gia Lai", "12C1", 3);


CREATE TABLE ExamResult (
	ID int NOT NULL AUTO_INCREMENT,
    POINT1 double,
    POINT2 double,
    POINT3 double,
    PRIMARY KEY (ID)
);

INSERT into ExamResult (POINT1, POINT2, POINT3) value (4, 5, 7);
INSERT into ExamResult (POINT1, POINT2, POINT3) value (10, 5, 7);
INSERT into ExamResult (POINT1, POINT2, POINT3) value (5, 8, 7);
SELECT * FROM Student;
SELECT * FROM ExamResult;
DROP TABLE student