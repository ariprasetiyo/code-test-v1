
create table alami_member(
id bigserial not null,
name varchar(100) not null,
date_of_birth DATE not null,
address text not null,
CONSTRAINT alami_member_id_pkey PRIMARY KEY (id)
);

create table alami_transaction(
id bigserial not null,
member_id bigint,
trx_type varchar(50) not null,
amount numeric not null,
currency varchar(5) not null,
trx_date  DATE not null,
created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT alami_transaction_id_pkey PRIMARY KEY (id)
);
CREATE INDEX alami_transaction_member_id_index on alami_transaction(member_id);
CREATE INDEX alami_transaction_trx_date_index on alami_transaction(trx_date);


GRANT ALL ON ALL TABLES IN SCHEMA "public" TO ari_user;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO ari_user;

INSERT INTO alami_member(name, date_of_birth, address)
VALUES
('Wawan setiawan', '1990-01-10', 'Kompleks Asia Serasi No 100'),
('Teguh Sudibyantoro', '1991-02-10', 'Jalan Pamekaran no 99'),
('Joko Widodo', '1990-03-10', 'Dusun pisang Rt 10 Rw 20');

INSERT INTO alami_transaction(member_id, trx_type, amount, currency, trx_date)
VALUES
(1, 'menyerahkan', 1000000, 'IDR', '2020-08-17'),
(2, 'menyerahkan', 5000000, 'IDR', '2020-08-18'),
(3, 'meminjam', 2000000, 'IDR', '2020-09-30'),
(3, 'meminjam', 1000000, 'IDR', '2020-11-10'),
(1, 'menyerahkan', 5000000, 'IDR', '2020-08-01'),
(2, 'mengambil', 2000000, 'IDR', '2020-12-01');


