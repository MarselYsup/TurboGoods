CREATE TABLE category(
    id uuid primary key,
    created timestamp,
    updated timestamp,
    name varchar(50) not null unique
);

CREATE TABLE product(
    id uuid primary key,
    created timestamp,
    updated timestamp,
    name varchar(100) not null,
    price_per_unit numeric(8, 2),
    count int not null,
    category_id uuid,
    foreign key (category_id) references category(id)
);

CREATE TABLE refresh_token(
      id uuid primary key,
      created timestamp,
      updated timestamp,
      expired_time timestamp not null
);

CREATE TABLE users(
      id uuid primary key,
      created timestamp,
      updated timestamp,
      role varchar(20) not null,
      email varchar(100) not null unique,
      password varchar(50) not null,
      status varchar(15) not null,
      confirm_code varchar(20) unique,
      first_name varchar(100) not null,
      last_name varchar(100),
      phone_number varchar(20),
      token_id uuid,
      foreign key (token_id) references refresh_token(id)
);

CREATE TABLE customer(
     id uuid primary key,
     created timestamp,
     updated timestamp,
     total numeric(10, 2) default 0.00,
     city varchar(30),
     street varchar(50),
     house_number varchar(10),
     user_id uuid not null ,
     foreign key (user_id) references users(id)

);

CREATE TABLE courier(
    id uuid primary key,
    created timestamp,
    updated timestamp,
    courier_type varchar(100) not null,
    user_id uuid not null ,
    foreign key (user_id) references users(id)
);

CREATE TABLE orders(
    id uuid primary key,
    created timestamp,
    updated timestamp,
    city varchar(30),
    street varchar(50),
    house_number varchar(10),
    delivery_date timestamp not null,
    courier_id uuid not null,
    customer_id uuid not null,
    foreign key (courier_id) references courier(id),
    foreign key (customer_id) references customer(id)
);

create table order_product(
    order_id uuid not null,
    product_id uuid not null,
    foreign key (order_id) references orders(id),
    foreign key (product_id) references product(id)
);
