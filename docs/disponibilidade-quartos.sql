CREATE TABLE disponibilidade_quartos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_quarto INT NOT NULL,
    data DATE NOT NULL,
    status VARCHAR(20) DEFAULT 'disponível',
    -- Ex: "disponível", "ocupado", "manutenção"
    FOREIGN KEY (id_quarto) REFERENCES quartos(id)
);

