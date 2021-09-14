CREATE TABLE consulta(
	id BIGSERIAL PRIMARY KEY,
	peso REAL,
	cepOrigem VARCHAR(64),
	cepDestino VARCHAR(64),
	nomeDestinatario VARCHAR(255),
	vlTotalFrete REAL,
	dataPrevistaEntrega DATE,
	dataConsulta DATE
);