
-- DROP DATABASE IF EXISTS "DataGuardian";

CREATE DATABASE "DataGuardian"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;


drop table accountBalance;
drop table operation;
drop table account;
drop table contact; 
drop table client;

create table client(
    id             varchar(10)  not null  primary key,
    lastname       varchar(100) not null,
    firstname      varchar(100) not null,
    patronymic     varchar(100) not null,
    birthDate      date 	    not null,
    passportSeries varchar(4)   not null,
    passportNumber varchar(6)   not null,
    inn            varchar(12)  not null,
    address        varchar(200) not null
);
COMMENT ON TABLE client is 'Клиент банка, Физ. лицо';
COMMENT ON COLUMN client.id             IS 'Идентификатор клиента';
COMMENT ON COLUMN client.lastname 	    IS 'Фамилия клиента';
COMMENT ON COLUMN client.firstname      IS 'Имя клиента';
COMMENT ON COLUMN client.patronymic     IS 'Отчество клиента';
COMMENT ON COLUMN client.birthDate      IS 'Дата рождения клиента';
COMMENT ON COLUMN client.passportSeries IS 'Серия паспорта клиента';
COMMENT ON COLUMN client.passportNumber IS 'Номер паспорта клиента';
COMMENT ON COLUMN client.inn            IS 'ИНН клиента';
COMMENT ON COLUMN client.address        IS 'Адрес проживания клиента';


create table contact(
    id        varchar(10)  not null primary key,
    clientId  varchar(10)  not null references client(id),
    type      varchar(5)   not null,
    value     varchar(100) not null
);
COMMENT ON TABLE contact is 'Контактные данные клиента';
COMMENT ON COLUMN contact.id        IS 'Идентификатор контакта';
COMMENT ON COLUMN contact.clientId  IS 'Идентификатор клиента';
COMMENT ON COLUMN contact.type      IS 'Тип контакта: PHONE, EMAIL';
COMMENT ON COLUMN contact.value     IS 'Значение контакта';


create table account(
    number    varchar(100) not null primary key,
    clientId  varchar(10)  not null references client(id),
    type      varchar(10)  not null,
    currency  varchar(3)   not null,
    status    varchar(10)  not null,
    openDate  date 		   not null,
    closeDate date 		   not null,
    deferment int 		   not null
);
COMMENT ON TABLE account is 'Банковские счета клиента';
COMMENT ON COLUMN account.number    IS 'Номер счета';
COMMENT ON COLUMN account.clientId  IS 'Идентификатор клиента';
COMMENT ON COLUMN account.type      IS 'Тип счета:
										 - PAYMENT (Расчётный),
										 - BUDGET (Бюджетный),
										 - TRANSIT (Транзитный),
										 - OVERDRAFT (Овердрафт)
										';
COMMENT ON COLUMN account.currency  IS 'Валюта счета (RUR)';
COMMENT ON COLUMN account.status    IS 'Состояние счета:
										 - INACTIVE (Неактивный),
										 - ACTIVE (Активный),
										 - LOCKED (Заблокированный),
										 - CLOSED (Закрытый)
										';
COMMENT ON COLUMN account.openDate  IS 'Дата открытия счета, момент времени (UTC, с)';
COMMENT ON COLUMN account.closeDate IS 'Дата закрытия счета, момент времени (UTC, с)';
COMMENT ON COLUMN account.deferment IS 'Отсрочка платежа (дни) для счета Овердрафт';


create table operation(
    type          varchar(10)  not null,
    accountNumber varchar(100) not null references account(number),
    operDate      date         not null,
    amount        numeric(38,2) not null,
    description   varchar      not null
);
COMMENT ON TABLE operation is 'Банковские операции по счету';
COMMENT ON COLUMN operation.type  IS 'Тип операции:
									    - RECEIPT (Приходная),
									    - EXPENSE (Расходная)
									  ';
COMMENT ON COLUMN operation.accountNumber IS 'Номер счёта';
COMMENT ON COLUMN operation.operDate IS 'Дата операции, момент времени (UTC, с)';
COMMENT ON COLUMN operation.amount  IS 'Сумма операции';
COMMENT ON COLUMN operation.description  IS 'Описание операции';

create table accountBalance(
    accountNumber varchar(100) not null references account(number),
    balanceDate   date         not null,
    amount        numeric(38, 2) not null
);
COMMENT ON TABLE accountBalance is 'Подбитые балансы на счетах на начало месяца';
COMMENT ON COLUMN accountBalance.accountNumber IS 'Номер счёта';
COMMENT ON COLUMN accountBalance.balanceDate   IS 'Дата баланса (00:00:00 1-го числа месяца), момент времени (UTC, с)';
COMMENT ON COLUMN accountBalance.amount        IS 'Сумма баланса';

