CREATE TABLE userinfo(
	id number(3) primary key, 
	name varchar2(30) not null,
	age number(3) NOT NULL,
	gender varchar2(30),
	tmp char(2) default 0

);

drop table userinfo


CREATE SEQUENCE id_seq
 increment by 1
 start with 1;  


insert into userinfo values(id_seq.nextval,'test',10,'m',1);
insert into userinfo values(id_seq.nextval,'test',10,'m',);
	
	