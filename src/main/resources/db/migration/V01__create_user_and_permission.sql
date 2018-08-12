CREATE TABLE user (
	code BIGINT(20) PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permission (
	code BIGINT(20) PRIMARY KEY,
	description VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_permission (
	code_user BIGINT(20) NOT NULL,
	code_permission BIGINT(20) NOT NULL,
	PRIMARY KEY (code_user, code_permission),
	FOREIGN KEY (code_user) REFERENCES user(code),
	FOREIGN KEY (code_permission) REFERENCES permission(code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user (code, name, email, password) values (1, 'Admin', 'iot@iot.com', '$2a$10$kXTUpzYtml5X6.NCHVZgvu5B.GoAnK.RDZaFYyoKF6VqPtLA8/2f.');

INSERT INTO permission (code, description) values (1, 'ROLE_CADASTRAR');
INSERT INTO permission (code, description) values (2, 'ROLE_PESQUISAR');
INSERT INTO permission (code, description) values (3, 'ROLE_REMOVER');
INSERT INTO permission (code, description) values (4, 'ROLE_UPDATE');


-- admin
INSERT INTO user_permission (code_user, code_permission) values (1, 1);
INSERT INTO user_permission (code_user, code_permission) values (1, 2);
INSERT INTO user_permission (code_user, code_permission) values (1, 3);
INSERT INTO user_permission (code_user, code_permission) values (1, 4);

