﻿CREATE DATABASE projectVer2
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       CONNECTION LIMIT = -1;

\c qldv	
\encoding utf8	  

CREATE TABLE Department
(
DeptID VARCHAR(10) NOT NULL,
DeptName VARCHAR(50),
Tel VARCHAR(15),
Mail VARCHAR(50),
CONSTRAINT deptPry PRIMARY KEY (DeptID)
);	
 
CREATE TABLE Class
(
ClaID VARCHAR(10) NOT NULL,
ClaName VARCHAR(20),
Year INT,
MoniterID VARCHAR(20),
DeptID VARCHAR(10),
CONSTRAINT claPry PRIMARY KEY (ClaID),
CONSTRAINT claRef_Dept FOREIGN KEY (DeptID)
	REFERENCES Department (DeptID) MATCH SIMPLE	
);
 
CREATE TABLE Student
(
StuID VARCHAR(20) NOT NULL,
F_Name VARCHAR(20),
L_Name VARCHAR(20),
Gender BOOLEAN,
Birth DATE,
Tel VARCHAR(15),
Mail VARCHAR(50),
Address VARCHAR(50),
ClaID VARCHAR(10),
Des VARCHAR(100),
Status INT,
CONSTRAINT stuPry PRIMARY KEY (StuID),
CONSTRAINT stuRef_Cla FOREIGN KEY (ClaID)
	REFERENCES Class (ClaID) MATCH SIMPLE
);	

CREATE TABLE Organization
(
OrgID VARCHAR(10) NOT NULL,
OrgName VARCHAR(50),
Par VARCHAR(10),
Manager VARCHAR(50),
Mail VARCHAR(50),
Tel VARCHAR(15),
CONSTRAINT orgPry PRIMARY KEY (OrgID)
);

CREATE TABLE Participation
(
StuID VARCHAR(20),
OrgID VARCHAR(10),
Role VARCHAR(20),
TimeStart DATE,
TimeEnd DATE,
Description VARCHAR(256),
CONSTRAINT partPry PRIMARY KEY (StuID,OrgID),
CONSTRAINT partRef_Stu FOREIGN KEY (StuID)
	REFERENCES Student (StuID) MATCH SIMPLE,
CONSTRAINT partRef_Org FOREIGN KEY (OrgID)
	REFERENCES Organization (OrgID) MATCH SIMPLE
);

CREATE TABLE Event
(
EventID VARCHAR(10) NOT NULL,
EventName VARCHAR(50),
Location VARCHAR(50),
TimeStart DATE,
TimeEnd DATE,
NumOfPeople INT,
Rating INT,
CONSTRAINT eventPry PRIMARY KEY (EventID)
);

CREATE TABLE EvtOrg
(
OrgID VARCHAR(10),
EventID VARCHAR(10),
Description VARCHAR(256),
CONSTRAINT evtPry PRIMARY KEY (EventID,OrgID),
CONSTRAINT evtOrgRef_Stu FOREIGN KEY (OrgID)
	REFERENCES Organization (OrgID) MATCH SIMPLE,
CONSTRAINT evtOrgRef_Dept FOREIGN KEY (EventID)
	REFERENCES Event (EventID) MATCH SIMPLE
);
ALTER TABLE Class ADD FOREIGN KEY (MoniterID)
	REFERENCES Student(StuID) MATCH SIMPLE;

CREATE TABLE Account
(
UserName VARCHAR(100),
Contact VARCHAR(100),
Password VARCHAR(65),
Role INT,
CONSTRAINT Key PRIMARY KEY (UserName)
);

CREATE TABLE Log
(
UserName VARCHAR(100),
LoginTime VARCHAR(30),
LogoutTime VARCHAR(30),
Action VARCHAR(65),
CONSTRAINT Key2 FOREIGN KEY (UserName)
	REFERENCES Account (UserName) MATCH SIMPLE
);
--Insert data

INSERT INTO Department VALUES ('CK','Viện Cơ Khí','2432009809','ck@gmail.com');
INSERT INTO Department VALUES ('CNTT','Viện Công Nghệ Thông Tin','0123456789','cntt@gmail.com');
INSERT INTO Department VALUES ('DTVT','Viện Điện Tử Viễn Thông','987654321','dtvt@gmail.com');
INSERT INTO Department VALUES ('GDQP','Khoa Giáo Dục Quốc Phòng','124144123','gdqp@gmail.com');
INSERT INTO Department VALUES ('NN','Viện Ngoại Ngữ','125353180','nn@gmail.com');
INSERT INTO Department VALUES ('GDTC','Khoa Giáo Dục Thể Chất','21421213123','gdtc@gmail.com');
INSERT INTO Department VALUES ('LLCT','Khoa Lý Luận Chính Trị','294020980','llct@gmail.com');
INSERT INTO Department VALUES ('CNSH','Viện Công Nghệ Sinh Học','8831990','cnsh@gmail.com');
INSERT INTO Department VALUES ('DM','Viện Dệt May','3252353215','dm@gmail.com');
INSERT INTO Department VALUES ('KTQL','Viện Kinh Tế và Quản Lý','9879809889','ktql@gmail.com');
INSERT INTO Department VALUES ('KTHH','Viện Kĩ Thuật Hóa Học','97989080','kthh@gmail.com');
INSERT INTO Department VALUES ('TDH','Viện Kỹ thuật Điều khiển và Tự động hóa','9798790981','tdh@gmail.com');
INSERT INTO Department VALUES ('SPKT','Viện Sư Phạm Kỹ Thuật','323532123','spkt@gmail.com');
INSERT INTO Department VALUES ('TTUD','Viện Toán ứng dụng và Tin học','1242142121','ttud@gmail.com');
INSERT INTO Department VALUES ('DTQT','Viện Đào tạo Quốc tế','990808217','dtqt@gmail.com');

INSERT INTO Class VALUES ('CK1','Cơ khí 1',2009,NULL,'CK');
INSERT INTO Class VALUES ('CK2','Cơ khí 2',2009,NULL,'CK');
INSERT INTO Class VALUES ('CK3','Cơ khí 3',2009,NULL,'CK');
INSERT INTO Class VALUES ('VN6A','Việt Nhật 6A',2011,NULL,'CNTT');
INSERT INTO Class VALUES ('VN6B','Việt Nhật 6B',2011,NULL,'CNTT');
INSERT INTO Class VALUES ('VN6C','Việt Nhật 6C',2011,NULL,'CNTT');
INSERT INTO Class VALUES ('DT1','Điện tử 1',2010,NULL,'DTVT');
INSERT INTO Class VALUES ('DT2','Điện tử 2',2010,NULL,'DTVT');
INSERT INTO Class VALUES ('DT3','Điện tử 3',2010,NULL,'DTVT');
INSERT INTO Class VALUES ('QSC1','Quân sự chung 1',2012,NULL,'GDQP');
INSERT INTO Class VALUES ('QSC2','Quân sự chung 2',2012,NULL,'GDQP');
INSERT INTO Class VALUES ('QSC3','Quân sự chung 3',2012,NULL,'GDQP');
INSERT INTO Class VALUES ('NB01','Nhật Bản 1',2010,NULL,'NN');
INSERT INTO Class VALUES ('NB02','Nhật Bản 2',2010,NULL,'NN');
INSERT INTO Class VALUES ('NB03','Nhật Bản 3',2010,NULL,'NN');
INSERT INTO Class VALUES ('NC1','Nhảy cao 1',2010,NULL,'GDTC');
INSERT INTO Class VALUES ('NC2','Nhảy cao 2',2010,NULL,'GDTC');
INSERT INTO Class VALUES ('NC3','Nhảy cao 3',2010,NULL,'GDTC');
INSERT INTO Class VALUES ('DL1','Đường lối 1',2010,NULL,'LLCT');
INSERT INTO Class VALUES ('DL2','Đường lối 2',2010,NULL,'LLCT');
INSERT INTO Class VALUES ('DL3','Đường lối 3',2010,NULL,'LLCT');
INSERT INTO Class VALUES ('VS1','Vi sinh 1',2011,NULL,'CNSH');
INSERT INTO Class VALUES ('VS2','Vi sinh 2',2011,NULL,'CNSH');
INSERT INTO Class VALUES ('VS3','Vi sinh 3',2011,NULL,'CNSH');
INSERT INTO Class VALUES ('DG1','Da giầy 1',2013,NULL,'DM');
INSERT INTO Class VALUES ('DG2','Da giầy 2',2013,NULL,'DM');
INSERT INTO Class VALUES ('DG3','Da giầy 3',2013,NULL,'DM');
INSERT INTO Class VALUES ('TC1','Tài chính 1',2013,NULL,'KTQL');
INSERT INTO Class VALUES ('TC2','Tài chính 2',2013,NULL,'KTQL');
INSERT INTO Class VALUES ('TC3','Tài chính 3',2013,NULL,'KTQL');
INSERT INTO Class VALUES ('HDC1','Hóa đại cương 1',2013,NULL,'KTHH');
INSERT INTO Class VALUES ('HDC2','Hóa đại cương 2',2013,NULL,'KTHH');
INSERT INTO Class VALUES ('HDC3','Hóa đại cương 3',2013,NULL,'KTHH');
INSERT INTO Class VALUES ('DK1','Điều khiển 1',2009,NULL,'TDH');
INSERT INTO Class VALUES ('DK2','Điều khiển 2',2009,NULL,'TDH');
INSERT INTO Class VALUES ('DK3','Điều khiển 3',2009,NULL,'TDH');
INSERT INTO Class VALUES ('VL1','Vật liệu 1',2010,NULL,'SPKT');
INSERT INTO Class VALUES ('VL2','Vật liệu 2',2010,NULL,'SPKT');
INSERT INTO Class VALUES ('VL3','Vật liệu 3',2010,NULL,'SPKT');
INSERT INTO Class VALUES ('TDC1','Toán đại cương 1',2010,NULL,'TTUD');
INSERT INTO Class VALUES ('TDC2','Toán đại cương 2',2010,NULL,'TTUD');
INSERT INTO Class VALUES ('TDC3','Toán đại cương 3',2010,NULL,'TTUD');
INSERT INTO Class VALUES ('VM1','Việt Mỹ 1',2010,NULL,'DTQT');
INSERT INTO Class VALUES ('VM2','Việt Mỹ 2',2010,NULL,'DTQT');
INSERT INTO Class VALUES ('VM3','Việt Mỹ 3',2010,NULL,'DTQT');


INSERT INTO Student VALUES ('20040001','LÊ ANH','NGỌC','1','1990-01-16','0123211001','20040001@gmail.com','Bắc Giang','CK1','Nghỉ học',1);
INSERT INTO Student VALUES ('20040002','NGUYỄN HỮU','PHƯỚC','1','1990-01-19','0123211001','20040002@gmail.com','Hưng Yên','CK1','Còn học',1);
INSERT INTO Student VALUES ('20040003','PHẠM LÊ DUY','QUANG','1','1990-02-07','0123211003','20040003@gmail.com','Thái Bình','CK2','Còn học',1);
INSERT INTO Student VALUES ('20040004','NGUYỄN HỒNG','QUÂN','1','1990-02-16','0123211004','20040004@gmail.com','Hà Nội','CK2','Còn học',1);
INSERT INTO Student VALUES ('20040005','VŨ VĂN','QUYỀN','0','1990-04-28','0123211005','20040005@gmail.com','Thanh Hóa','CK3','Còn học',1);
INSERT INTO Student VALUES ('20040006','BÙI VĂN','THỊNH','1','1990-05-25','0123211006','20040006@gmail.com','Thái Nguyên','VN6A','Còn học',1);
INSERT INTO Student VALUES ('20040007','DƯƠNG ĐỨC','THỊNH','1','1990-06-05','0123211007','20040007@gmail.com','Bắc Ninh','VN6A','Còn học',1);
INSERT INTO Student VALUES ('20040008','BÙI ĐỨC','THỌ','1','1990-06-07','0123211008','20040008@gmail.com','Thanh Hóa','VN6B','Còn học',1);
INSERT INTO Student VALUES ('20040009','LÊ VĂN','THỤC','1','1990-06-09','0123211009','20040009@gmail.com','Nam Định','VN6B','Còn học',1);
INSERT INTO Student VALUES ('20040010','DƯƠNG VĂN','TRÌNH','0','1990-07-01','0123211010','20040010@gmail.com','Bắc Giang','VN6C','Nghỉ học',1);
INSERT INTO Student VALUES ('20040011','NGUYỄN NGỌC','TRUNG','1','1990-07-17','0123211011','20040011@gmail.com','Bắc Giang','DT1','Còn học',1);
INSERT INTO Student VALUES ('20040012','NGUYỄN LÊ','TUẤN','1','1990-08-28','0123211012','20040012@gmail.com','Hưng Yên','DT1','Còn học',1);
INSERT INTO Student VALUES ('20040013','PHẠM MINH','TUẤN','1','1990-08-30','0123211013','20040013@gmail.com','Thái Bình','DT2','Còn học',1);
INSERT INTO Student VALUES ('20040014','TRẦN ANH','TUẤN','1','1990-09-03','0123211014','20040014@gmail.com','Hà Nội','DT2','Còn học',1);
INSERT INTO Student VALUES ('20040015','VŨ THANH','TUẤN','0','1990-10-01','0123211015','20040015@gmail.com','Thanh Hóa','DT3','Còn học',1);
INSERT INTO Student VALUES ('20040016','AN SƠN','TÙNG','1','1990-10-13','0123211016','20040016@gmail.com','Thái Nguyên','QSC1','Còn học',1);
INSERT INTO Student VALUES ('20040017','NGUYỄN HOÀNG','TÙNG','1','1990-10-27','0123211017','20040017@gmail.com','Bắc Ninh','QSC1','Nghỉ học',1);
INSERT INTO Student VALUES ('20040018','TRƯƠNG THANH','TÙNG','1','1990-11-12','0123211018','20040018@gmail.com','Thanh Hóa','QSC2','Còn học',1);
INSERT INTO Student VALUES ('20040019','TRẦN VĂN','TƯỜNG','1','1990-11-30','0123211019','20040019@gmail.com','Nam Định','QSC2','Còn học',1);
INSERT INTO Student VALUES ('20040020','NGUYỄN XUÂN','TƯỞNG','0','1990-12-04','0123211020','20040020@gmail.com','Bắc Giang','QSC3','Còn học',1);
INSERT INTO Student VALUES ('20040021','NGUYỄN VĂN','UÂN','1','1990-12-17','0123211021','20040021@gmail.com','Hưng Yên','NB01','Còn học',1);
INSERT INTO Student VALUES ('20040022','LƯU VĂN','VINH','1','1990-12-22','0123211022','20040022@gmail.com','Thái Bình','NB01','Còn học',1);
INSERT INTO Student VALUES ('20040023','LÊ TÂM','HUY','1','1991-01-15','0123211023','20040023@gmail.com','Hà Nội','NB02','Còn học',1);
INSERT INTO Student VALUES ('20040024','NGUYỄN BÁ','MINH','1','1991-01-20','0123211024','20040024@gmail.com','Thanh Hóa','NB02','Còn học',1);
INSERT INTO Student VALUES ('20040025','NGUYỄN HỮU TUẤN','ANH','0','1991-02-24','0123211025','20040025@gmail.com','Thái Nguyên','NB03','Còn học',1);
INSERT INTO Student VALUES ('20040026','NGUYỄN THỊ PHƯƠNG','ANH','1','1991-03-29','0123211026','20040026@gmail.com','Bắc Ninh','NC1','Còn học',1);
INSERT INTO Student VALUES ('20040027','NGUYỄN TUẤN','ANH','1','1991-03-31','0123211027','20040027@gmail.com','Thanh Hóa','NC1','Còn học',1);
INSERT INTO Student VALUES ('20040028','PHẠM TUẤN','ANH','1','1991-04-10','0123211028','20040028@gmail.com','Nam Định','NC2','Còn học',1);
INSERT INTO Student VALUES ('20040029','CHU NGỌC','ÁNH','1','1991-04-12','0123211029','20040029@gmail.com','Bắc Giang','NC2','Còn học',1);
INSERT INTO Student VALUES ('20040030','PHÙNG XUÂN','BÁCH','0','1991-04-18','0123211030','20040030@gmail.com','Bắc Giang','NC3','Còn học',1);
INSERT INTO Student VALUES ('20040031','NGUYỄN VĂN','BIÊN','1','1991-05-19','0123211031','20040031@gmail.com','Bắc Giang','DL1','Nghỉ học',1);
INSERT INTO Student VALUES ('20040032','NGUYỄN VĂN','BÌNH','1','1991-06-07','0123211032','20040032@gmail.com','Hưng Yên','DL1','Còn học',1);
INSERT INTO Student VALUES ('20040033','THÁI DUY','CHIẾN','1','1991-06-26','0123211033','20040033@gmail.com','Thái Bình','DL2','Còn học',1);
INSERT INTO Student VALUES ('20040034','NGUYỄN XUÂN','CHÍNH','1','1991-07-02','0123211034','20040034@gmail.com','Hà Nội','DL2','Còn học',1);
INSERT INTO Student VALUES ('20040035','BÙI CÔNG','CƯỜNG','0','1991-07-08','0123211035','20040035@gmail.com','Thanh Hóa','DL3','Còn học',1);
INSERT INTO Student VALUES ('20040036','CÙ XUÂN','CƯỜNG','1','1991-07-20','0123211036','20040036@gmail.com','Thái Nguyên','VS1','Còn học',1);
INSERT INTO Student VALUES ('20040037','VŨ VĂN','CÔNG','1','1991-07-21','0123211037','20040037@gmail.com','Bắc Ninh','VS1','Còn học',1);
INSERT INTO Student VALUES ('20040038','NGUYỄN HUY','CƯỜNG','1','1991-07-25','0123211038','20040038@gmail.com','Thanh Hóa','VS2','Còn học',1);
INSERT INTO Student VALUES ('20040039','BÙI VĂN','DOANH','1','1991-07-30','0123211039','20040039@gmail.com','Nam Định','VS2','Còn học',1);
INSERT INTO Student VALUES ('20040040','ĐẶNG QUANG','DUY','0','1991-09-16','0123211040','20040040@gmail.com','Bắc Giang','VS3','Nghỉ học',1);
INSERT INTO Student VALUES ('20040041','NGUYỄN PHƯƠNG','DUY','1','1991-10-04','0123211041','20040041@gmail.com','Bắc Giang','DG1','Còn học',1);
INSERT INTO Student VALUES ('20040042','DƯƠNG TUẤN','DŨNG','1','1991-10-09','0123211042','20040042@gmail.com','Bắc Giang','DG1','Còn học',1);
INSERT INTO Student VALUES ('20040043','NGUYỄN HOÀNG','DŨNG','1','1991-10-11','0123211043','20040043@gmail.com','Hưng Yên','DG2','Còn học',1);
INSERT INTO Student VALUES ('20040044','TRẦN THẾ','DŨNG','1','1991-10-18','0123211044','20040044@gmail.com','Thái Bình','DG2','Còn học',1);
INSERT INTO Student VALUES ('20040045','ĐỖ CÔNG','DƯƠNG','0','1991-11-14','0123211045','20040045@gmail.com','Hà Nội','DG3','Còn học',1);
INSERT INTO Student VALUES ('20040046','TRẦN QUANG','DƯƠNG','1','1991-11-28','0123211046','20040046@gmail.com','Thanh Hóa','TC1','Còn học',1);
INSERT INTO Student VALUES ('20040047','CHU ĐỨC','ĐẠO','1','1991-12-03','0123211047','20040047@gmail.com','Thái Nguyên','TC2','Còn học',1);
INSERT INTO Student VALUES ('20040048','NGUYỄN BÁ','ĐỊNH','1','1991-12-10','0123211048','20040048@gmail.com','Bắc Ninh','TC3','Còn học',1);
INSERT INTO Student VALUES ('20040049','VŨ QUÝ','ĐÔN','1','1992-01-09','0123211049','20040049@gmail.com','Thanh Hóa','TC1','Nghỉ học',1);
INSERT INTO Student VALUES ('20040050','PHẠM VĂN','ĐÔNG','0','1992-01-24','0123211050','20040050@gmail.com','Nam Định','TC2','Còn học',1);

UPDATE Class SET MoniterID = '20040001' WHERE ClaID = 'CK1';
UPDATE Class SET MoniterID = '20040003' WHERE ClaID = 'CK2';
UPDATE Class SET MoniterID = '20040005' WHERE ClaID = 'CK3';
UPDATE Class SET MoniterID = '20040006' WHERE ClaID = 'VN6A';
UPDATE Class SET MoniterID = '20040008' WHERE ClaID = 'VN6B';
UPDATE Class SET MoniterID = '20040010' WHERE ClaID = 'VN6C';
UPDATE Class SET MoniterID = '20040011' WHERE ClaID = 'DT1';
UPDATE Class SET MoniterID = '20040013' WHERE ClaID = 'DT2';
UPDATE Class SET MoniterID = '20040015' WHERE ClaID = 'DT3';
UPDATE Class SET MoniterID = '20040016' WHERE ClaID = 'QSC1';
UPDATE Class SET MoniterID = '20040018' WHERE ClaID = 'QSC2';
UPDATE Class SET MoniterID = '20040020' WHERE ClaID = 'QSC3';
UPDATE Class SET MoniterID = '20040021' WHERE ClaID = 'NB01';
UPDATE Class SET MoniterID = '20040023' WHERE ClaID = 'NB02';
UPDATE Class SET MoniterID = '20040025' WHERE ClaID = 'NB03';
UPDATE Class SET MoniterID = '20040026' WHERE ClaID = 'NC1';
UPDATE Class SET MoniterID = '20040028' WHERE ClaID = 'NC2';
UPDATE Class SET MoniterID = '20040030' WHERE ClaID = 'NC3';
UPDATE Class SET MoniterID = '20040031' WHERE ClaID = 'DL1';
UPDATE Class SET MoniterID = '20040033' WHERE ClaID = 'DL2';
UPDATE Class SET MoniterID = '20040035' WHERE ClaID = 'DL3';
UPDATE Class SET MoniterID = '20040036' WHERE ClaID = 'VS1';
UPDATE Class SET MoniterID = '20040038' WHERE ClaID = 'VS2';
UPDATE Class SET MoniterID = '20040040' WHERE ClaID = 'VS3';
UPDATE Class SET MoniterID = '20040041' WHERE ClaID = 'DG1';
UPDATE Class SET MoniterID = '20040043' WHERE ClaID = 'DG2';
UPDATE Class SET MoniterID = '20040045' WHERE ClaID = 'DG3';
UPDATE Class SET MoniterID = '20040046' WHERE ClaID = 'TC1';
UPDATE Class SET MoniterID = '20040048' WHERE ClaID = 'TC2';
UPDATE Class SET MoniterID = '20040050' WHERE ClaID = 'TC3';

INSERT INTO Organization VALUES ('CLBTA','Câu lạc bộ Tiếng Anh',NULL,'Nguyễn Văn B','clbta@gmail.com','23949204032');
INSERT INTO Organization VALUES ('CLBTN','Câu lạc bộ Tiếng Nhật',NULL,'Nguyễn Văn A','clbtn@gmail.com','1294023851');
INSERT INTO Organization VALUES ('DTN','Đội tình nguyện',NULL,'PHẠM VĂN ĐÔNG','dtn@gmail.com','2349829089');

INSERT INTO Participation VALUES ('20040003','CLBTN','Thành viên','2011-09-19','2012-09-19','Xuất Sắc');
INSERT INTO Participation VALUES ('20040015','CLBTA','Thành viên','2011-07-24','2012-12-19','Nghiêm Túc');
INSERT INTO Participation VALUES ('20040050','DTN','Đội trưởng','2009-09-19','2012-04-19','Nhiệt tình');

INSERT INTO Event VALUES ('OSHOU11','Tết truyền thống Nhật Bản 2011','Kí túc xá B6','2011-01-19','2011-01-19',1000,3);
INSERT INTO Event VALUES ('OSHOU12','Lễ hội Tết truyền thống Nhật Bản 2012','Kí túc xá B6','2012-01-19','2012-01-19',3000,4);

INSERT INTO EvtOrg VALUES ('CLBTN','OSHOU11','Vui vẻ');
INSERT INTO EvtOrg VALUES ('CLBTN','OSHOU12','Náo nhiệt');

SELECT * FROM Department,
\c postgres
DROP DATABASE projectVer2,