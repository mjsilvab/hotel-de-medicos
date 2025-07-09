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

@Entity
@Table(name = "quartos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quartos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false, length = 10)
    private String numero;

    @Column(name = "tipo", length = 50)
    private String tipo;

    @Column(name = "capacidade")
    private Integer capacidade;

    @Column(name = "preco", precision = 10, scale = 2)
    private Double preco;

    @Column(name = "status", length = 20)
    private String status;

}