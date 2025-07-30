package br.edu.ifrn.hoteldemedicos.persistencia.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal; // Importa para usar o tipo BigDecimal (para valores monetários)

@Entity // Marca esta classe como uma entidade JPA (representa uma tabela no banco de dados)
@Table(name = "quartos") // Mapeia esta entidade para a tabela 'quartos' no banco
@Getter // Anotação do Lombok: Gera automaticamente os métodos GET para todos os campos
@Setter // Anotação do Lombok: Gera automaticamente os métodos SET para todos os campos
@AllArgsConstructor // Anotação do Lombok: Gera um construtor com todos os argumentos
@NoArgsConstructor // Anotação do Lombok: Gera um construtor sem argumentos
public class Quartos {

    @Id // Marca este campo como a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática de valores para o ID (auto-incremento)
    private Long id; // ID do quarto

    @Column(name = "numero", nullable = false, length = 10) // Número do quarto, não pode ser nulo, com no máximo 10 caracteres
    private String numero;

    @Column(name = "tipo", length = 50) // Tipo do quarto (ex: "Casal", "Solteiro", "Suíte"), com no máximo 50 caracteres
    private String tipo;

    @Column(name = "capacidade") // Capacidade de pessoas no quarto
    private Integer capacidade;

    @Column(name = "preco", nullable = false, precision = 10, scale = 2) // Preço da diária, não pode ser nulo, DECIMAL(10, 2)
    private BigDecimal preco; // Usando BigDecimal para garantir precisão em cálculos monetários

    @Column(name = "status", length = 20) // Status do quarto (ex: "disponível", "ocupado", "manutenção"), com no máximo 20 caracteres
    private String status = "disponível"; // Valor padrão "disponível"

}
