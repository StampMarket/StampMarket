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