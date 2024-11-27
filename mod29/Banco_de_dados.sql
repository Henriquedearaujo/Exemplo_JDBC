create sequence sq_cliente
start 1
increment 1
owned by tb_produto.id;

create table tb_cliente (
	id bigint,
	CODIGO VARCHAR(50) NOT NULL,
    NOME VARCHAR(100) NOT NULL,
    constraint pk_id_cliente primary key(id)
);



-----------------------------------------------------------------------------
create sequence sq_produto
start 1
increment 1
owned by tb_produto.id;

create table tb_produto (
	id bigint,
	CODIGO VARCHAR(50) NOT NULL,
    PRODUTO_NOME VARCHAR(100) NOT NULL,
    QUANTIDADE INT NOT NULL
    constraint pk_id_produto primary key(id)
);