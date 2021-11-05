create table game (
                        id int primary key,
                        item  varchar(256) NOT NULL,
                        completed boolean default false
);
