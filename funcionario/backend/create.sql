create table funcionario (id long generated by default as identity, nome String (255), idade Long(100,1), profissao String (255), salario numeric(1000,0));
INSERT INTO funcionario(nome, idade, profissao,salario) VALUES('Joao',50,'pedreiro',1000);
INSERT INTO funcionario(nome, idade, profissao,salario) VALUES('Maria',30,'escritora',5000);
INSERT INTO funcionario(nome, idade, profissao,salario) VALUES('Jonael',35,'motorista',2500);