package br.edu.ifrn.hoteldemedicos.persistencia.repositorio;

import java.util.Optional; // Importa Optional para métodos de busca que podem não retornar um resultado

import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface base do Spring Data JPA
import br.edu.ifrn.hoteldemedicos.persistencia.modelo.Quartos; // Importa a entidade Quartos

// Interface que oferece as operações CRUD (Create, Read, Update, Delete) para a entidade Quartos
// JpaRepository<Entidade, TipoDoId>: O primeiro parâmetro é a entidade, o segundo é o tipo da chave primária (ID)
public interface QuartosRepository extends JpaRepository<Quartos, Long> {

    // Método para buscar um quarto pelo número.
    // Retorna um Optional<Quartos> porque o quarto pode ou não ser encontrado.
    // Isso é útil para validação de duplicidade, garantindo que não haja quartos com o mesmo número.
    Optional<Quartos> findByNumero(String numero);
}
