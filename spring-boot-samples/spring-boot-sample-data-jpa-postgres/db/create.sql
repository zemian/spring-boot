create sequence hibernate_sequence start 1 increment 1;
create table city (id int8 not null, country varchar(255) not null, map varchar(255) not null, name varchar(255) not null, state varchar(255) not null, primary key (id));
create table hotel (id int8 not null, address varchar(255) not null, name varchar(255) not null, zip varchar(255) not null, city_id int8 not null, primary key (id));
create table review (id int8 not null, check_in_date date not null, details varchar(5000) not null, idx int4 not null, rating int4 not null, title varchar(255) not null, trip_type int4 not null, hotel_id int8 not null, primary key (id));
alter table hotel add constraint idx_hotel unique (city_id, name);
alter table hotel add constraint fk_hotel foreign key (city_id) references city;
alter table review add constraint fk_review foreign key (hotel_id) references hotel;
