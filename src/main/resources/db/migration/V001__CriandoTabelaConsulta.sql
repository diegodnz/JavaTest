CREATE TABLE consulta(
	id BIGSERIAL PRIMARY KEY NOT NULL,
	peso DECIMAL NOT NULL,
	cep_origem VARCHAR(64) NOT NULL,
	cep_destino VARCHAR(64) NOT NULL,
	nome_destinatario VARCHAR(255),
	vl_total_frete DECIMAL NOT NULL,
	data_prevista_entrega DATE NOT NULL,
	data_consulta DATE NOT NULL
);