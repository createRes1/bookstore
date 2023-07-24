create database bookstore;
use bookstore;

create table users(
                      id int(4) auto_increment primary key,
                      username varchar(50) not null comment '用户名',
                      password varchar(50) not null comment '密码',
                      deleted tinyint(1) default 0 comment '逻辑删除0代表未删除1代表删除',
                      create_time timestamp default  now() comment '创建时间',
                      update_time timestamp default  now() comment '更新时间'
);

create table company(
                        id varchar(50) primary key ,
                        company_name varchar(50) not null comment '出版社名称',
                        tel  varchar(50) not null comment '联系电话',
                        deleted tinyint(1) default 0 comment '逻辑删除0代表未删除1代表删除',
                        create_time timestamp default  now() comment '创建时间',
                        update_time timestamp default  now() comment '更新时间'
);

create table book(
                     id varchar(50)  primary key ,
                     isbn varchar(50) not null comment '书号',
                     book_name varchar(50) not null comment '书名',
                     author varchar(50) not null comment '图书作者',
                     company_id varchar(50) not null comment '出版社',
                     dop varchar(50) not null comment '出版日期',
                     price double  comment '价格' ,
                     content varchar(100)  comment '内容摘要',
                     deleted tinyint(1) default 0 comment '逻辑删除0代表未删除1代表删除',
                     create_time timestamp default  now() comment '创建时间',
                     update_time timestamp default  now() comment '更新时间'

);


