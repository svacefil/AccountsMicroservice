create table if not exists customer(
    customer_id bigint primary key,
    customer_name varchar(200) not null,
    email varchar(200) not null,
    mobile_number varchar(200) not null,
    created_at timestamp,
    created_by varchar(200),
    updated_at timestamp default null,
    updated_by varchar(200) default null
);

create table if not exists account(
    account_number bigint primary key,
    customer_id bigint,
    account_type varchar(100) not null,
    branch_address varchar(200) not null,
    created_at timestamp,
    created_by varchar(200),
    updated_at timestamp default null,
    updated_by varchar(200) default null,
    foreign key (customer_id) references customer(customer_id) on delete cascade
    );

create sequence customer_seq start with 1 increment by 1;
create sequence account_seq start with 1 increment by 1;