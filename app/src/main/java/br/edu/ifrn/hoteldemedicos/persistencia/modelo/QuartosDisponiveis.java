package br.edu.ifrn.higeia.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "disponibilidade_quartos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisponibilidadeQuarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_quarto", nullable = false)
    private Integer idQuarto;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "status", length = 20)
    private String status = "disponível"; // valor padrão
}
