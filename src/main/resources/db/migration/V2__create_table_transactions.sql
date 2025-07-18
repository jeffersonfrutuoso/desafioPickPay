CREATE TABLE transactions (
    id BIGSERIAL PRIMARY KEY,
    valor_da_transferencia NUMERIC(19, 2) NOT NULL,
    enviador_id BIGINT NOT NULL,
    recebedor_id BIGINT NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    CONSTRAINT fk_enviador
        FOREIGN KEY (enviador_id)
        REFERENCES users (id),
    CONSTRAINT fk_recebedor
        FOREIGN KEY (recebedor_id)
        REFERENCES users (id)
);