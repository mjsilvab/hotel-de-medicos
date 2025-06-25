CREATE TABLE reservas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_quarto INT NOT NULL,
    id_hospede INT NOT NULL,
    data_checkin DATE NOT NULL,
    data_checkout DATE NOT NULL,
    status VARCHAR(20) DEFAULT 'ativa',
    -- "ativa", "cancelada", "finalizada"
    FOREIGN KEY (id_quarto) REFERENCES quartos(id),
    FOREIGN KEY (id_hospede) REFERENCES hospedes(id)
);
-- Selecionar todas as reservas cadastradas
SELECT * FROM reservas;

-- Ver reservas com os dados do quarto e do hóspede (precisa da tabela `hospedes`)
SELECT r.id, h.nome AS hospede, q.numero AS quarto, r.data_checkin, r.data_checkout, r.status
FROM reservas r
JOIN hospedes h ON r.id_hospede = h.id
JOIN quartos q ON r.id_quarto = q.id;

-- Ver somente as reservas ativas
SELECT * FROM reservas WHERE status = 'ativa';

-- Ver somente as reservas canceladas
SELECT * FROM reservas WHERE status = 'cancelada';