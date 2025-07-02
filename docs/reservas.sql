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

