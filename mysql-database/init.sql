drop schema if exists stamp_market;
create schema stamp_market;
use stamp_market;

create table user(
    id int auto_increment primary key,
    username varchar(32) not null,
    password varchar(32) not null,
    balance int default 0
);

insert into user(id, username, password) values (1, 'tom', '123456'), (2, 'jerry', '123456');

create table stamp(
    id int auto_increment primary key,
    name varchar(32) not null,
    description varchar(256),
    width int unsigned comment '宽度，单位毫米',
    height int unsigned comment '高度，单位毫米',
    publish_date date comment '发行日期',
    price double comment '单价'
);

INSERT INTO stamp (name, description, width, height, publish_date, price) VALUES
('蓝色花卉', '美丽的花卉邮票', 30, 40, '2023-01-15', 2.5),
('历史人物', '重要历史人物邮票', 25, 35, '2023-02-20', 3.0),
('动物世界', '精彩的动物邮票', 35, 45, '2023-03-10', 2.8);