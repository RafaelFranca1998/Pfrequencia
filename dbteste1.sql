use dbteste1;

create table tb_usuario(
	id int primary key not null auto_increment,
    login varchar(10),
    senha int,
    tipo int
);

drop table tb_usuario;

SELECT * FROM tb_usuario WHERE login = "Admin" AND senha = 12345;

select * from tb_usuario;


ALTER TABLE tb_usuario AUTO_INCREMENT = 1;

UPDATE tb_usuario set id= 1 where id = 1;

insert into tb_usuario(id, login, senha, tipo) values (null,"admin",12345, 1)