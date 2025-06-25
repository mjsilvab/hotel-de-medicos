CREATE TABLE disponibilidade_quartos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_quarto INT NOT NULL,
    data DATE NOT NULL,
    status VARCHAR(20) DEFAULT 'disponível',
    -- Ex: "disponível", "ocupado", "manutenção"
    FOREIGN KEY (id_quarto) REFERENCES quartos(id)
);

-- Verificar disponibilidade de todos os quartos em uma data específica
SELECT q.numero, dq.data, dq.status
FROM disponibilidade_quartos dq
JOIN quartos q ON dq.id_quarto = q.id
WHERE dq.data = '2025-06-25';

-- Ver todos os registros de disponibilidade
SELECT * FROM disponibilidade_quartos;

-- Ver só os quartos disponíveis em determinada data
SELECT q.numero, dq.data
FROM disponibilidade_quartos dq
JOIN quartos q ON dq.id_quarto = q.id
WHERE dq.data = '2025-06-25' AND dq.status = 'disponível';

-- Ver quartos ocupados em determinada data
SELECT q.numero, dq.data
FROM disponibilidade_quartos dq
JOIN quartos q ON dq.id_quarto = q.id
WHERE dq.data = '2025-06-25' AND dq.status = 'ocupado';