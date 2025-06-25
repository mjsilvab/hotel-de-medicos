CREATE TABLE quartos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero VARCHAR(10) NOT NULL,
    -- Número ou código do quarto
    tipo VARCHAR(50),
    -- Ex: "Casal", "Solteiro", "Suíte"
    capacidade INT,
    -- Quantas pessoas o quarto comporta
    preco DECIMAL(10, 2),
    -- Preço da diária
    status VARCHAR(20) DEFAULT 'disponível' -- "disponível", "ocupado", "manutenção"
);
-- Selecionar todos os quartos cadastrados
SELECT * FROM quartos;

-- Selecionar apenas os quartos disponíveis
SELECT * FROM quartos WHERE status = 'disponível';

-- Selecionar apenas os quartos ocupados
SELECT * FROM quartos WHERE status = 'ocupado';