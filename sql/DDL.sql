create user 'mydrink'@'localhost' identified by '1234';

create database drinkshop;
use drinkshop;

grant all privileges on drinkshop.* to 'mydrink'@'localhost';

-- 기존 테이블
create table item (
item_id bigint not null auto_increment,
item_detail longtext not null,
item_nm varchar(50) not null,
item_sell_Status varchar(255),
price integer not null,
reg_time datetime(6),
update_time datetime(6),
created_by varchar(255),
modified_by varchar(255),
stock_number integer not null,
primary key(item_id)
);

create table item_img (
item_img_id bigint auto_increment,
item_id bigint not null,
img_name varchar(40),
ori_img_name varchar(255),
img_url varchar(255),
repimg_yn varchar(5),
reg_time datetime(6),
update_time datetime(6),
created_by varchar(255),
modified_by varchar(255),
primary key(item_img_id),
foreign key(item_id) references item(item_id)
);

create table member (
member_id bigint not null auto_increment,
name varchar(255) not null,
address varchar(255) not null,
phone varchar(255) not null,
email varchar(255) not null unique,
password varchar(255) not null,
reg_time datetime(6),
update_time datetime(6),
created_by varchar(255),
modified_by varchar(255),
role varchar(255) not null,
primary key(member_id)
);

create table cart(
cart_id bigint not null auto_increment,
member_id bigint,
reg_time datetime(6),
update_time datetime(6),
created_by varchar(255),
modified_by varchar(255),
primary key(cart_id),
foreign key(member_id) references member(member_id)
);

create table cart_item(
cart_item_id bigint not null auto_increment,
count integer not null,
cart_id bigint,
item_id bigint,
reg_time datetime(6),
update_time datetime(6),
created_by varchar(255),
modified_by varchar(255),
primary key(cart_item_id),
foreign key(cart_id) references cart(cart_id),
foreign key(item_id) references item(item_id)
);

create table orders(
order_id bigint auto_increment,
member_id bigint not null,
order_date datetime(6),
order_status varchar(255),
reg_time datetime(6),
update_time datetime(6),
created_by varchar(255),
modified_by varchar(255),
primary key(order_id),
foreign key(member_id) references member(member_id)

);

create table order_item(
order_item_id bigint auto_increment,
count integer,
order_price integer,
item_id bigint,
order_id bigint,
reg_time datetime(6),
update_time datetime(6),
created_by varchar(255),
modified_by varchar(255),
primary key(order_item_id),
foreign key(item_id) references item(item_id),
foreign key(order_id) references orders(order_id)
);

-- 새롭게 추가되는 엔티티 (배송, 게시판)
create table delivery(
delivery_id bigint auto_increment,
member_id bigint not null,
name varchar(255) not null,
phone varchar(255) not null,
address varchar(255) not null,
email varchar(255) not null,
primary key(delivery_id),
foreign key(member_id) references member(member_id)
-- ,foreign key(name) references member(name),
-- foreign key(address) references member(address),
-- foreign key(email) references member(email)
);
-- 게시판 타입 설정
create table board(
board_id bigint auto_increment,
board_title varchar(255),
board_content varchar(255),
reg_time datetime(6),
update_time datetime(6),
member_id bigint,
board_type integer not null, -- 1: 요청, 2: 공지, 3: 리뷰, 4: 문의
primary key(board_id,board_type),
foreign key(member_id) references member(member_id)
);

create table board_comment(
board_comment_id bigint auto_increment,
comment_title varchar(255),
comment_content varchar(255),
reg_time datetime(6),
update_time datetime(6),
created_by varchar(255),
modified_by varchar(255),
member_id bigint not null,
board_id bigint not null,
board_type integer not null, -- 1: 요청, 2: 공지, 3: 리뷰, 4: 문의
primary key(board_comment_id),
foreign key (member_id) references member(member_id),
foreign key (board_id,board_type) references board(board_id,board_type)
);