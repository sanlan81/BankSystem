create table bank (
id bigint not null, name varchar(255), primary key (id));

create table bank_account (
id bigint not null, amount double precision,
amount_of_credit double precision,
 currency double precision,
  client_id bigint not null, primary key (id));

  create table client (
  id bigint not null,
  address varchar(255),
  email varchar(255),
  first_name varchar(255),
  last_name varchar(255),
  phone_number varchar(255),
  bank_id bigint not null, primary key (id));

  create table worker (
  id bigint not null,
  first_name varchar(255),
  last_name varchar(255),
  phone_number varchar(255),
  status varchar(255), bank_id bigint not null, primary key (id));

alter table bank_account add index FK_thgcmdvyemj0yg060nvfictd6 (
client_id), add constraint FK_thgcmdvyemj0yg060nvfictd6
foreign key (client_id) references client (id);

 alter table client add index FK_e8oc3sulkpvxdascbnkpchunx (
 bank_id), add constraint FK_e8oc3sulkpvxdascbnkpchunx
 foreign key (bank_id) references bank (id);

 alter table worker add index FK_89c2qks2v6rs5fdov8iqcwfr7 (
 bank_id), add constraint FK_89c2qks2v6rs5fdov8iqcwfr7
 foreign key (bank_id) references bank (id);

 alter table bank_account
  drop foreign key FK_thgcmdvyemj0yg060nvfictd6;

 alter table client
  drop foreign key FK_e8oc3sulkpvxdascbnkpchunx;

 alter table worker
  drop foreign key FK_89c2qks2v6rs5fdov8iqcwfr7;

