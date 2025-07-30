package br.edu.ifrn.hoteldemedicos.web.controladores;

import java.util.List; // Para trabalhar com listas de objetos
import java.math.BigDecimal; // Importa para usar o tipo BigDecimal

import org.springframework.beans.factory.annotation.Autowired; // Para injeção de dependências
import org.springframework.stereotype.Controller; // Marca a classe como um controlador Spring MVC
import org.springframework.ui.Model; // Para passar dados do controlador para a view (HTML)
import org.springframework.validation.BindingResult; // Para capturar erros de validação do formulário
import org.springframework.web.bind.annotation.GetMapping; // Mapeia requisições HTTP GET
import org.springframework.web.bind.annotation.ModelAttribute; // Vincula um parâmetro do método a um atributo do modelo
import org.springframework.web.bind.annotation.PostMapping; // Mapeia requisições HTTP POST
import org.springframework.web.bind.annotation.RequestMapping; // Define o caminho base para todas as URLs deste controlador

import br.edu.ifrn.hoteldemedicos.persistencia.modelo.Quartos; // Importa a entidade Quartos
import br.edu.ifrn.hoteldemedicos.persistencia.repositorio.QuartosRepository; // Importa o repositório de Quartos
import jakarta.validation.Valid; // Para habilitar a validação de beans (JSR-303)

@Controller // Esta classe é um controlador que lida com requisições web
@RequestMapping("/quartos") // Todas as requisições que começam com /quartos serão tratadas por este controlador
public class QuartosControler {

    @Autowired // O Spring injeta automaticamente uma instância de QuartosRepository aqui
    private QuartosRepository quartosRepository;

    // Método que lida com a requisição GET para /quartos
    // Exibe a lista de todos os quartos
    @GetMapping
    public String listar(Model model) {
        List<Quartos> quartos = quartosRepository.findAll(); // Busca todos os quartos no banco de dados
        model.addAttribute("quartos", quartos); // Adiciona a lista de quartos ao modelo para ser exibida na página HTML
        return "quartos/lista-quartos"; // Retorna o nome do template Thymeleaf (src/main/resources/templates/quartos/lista-quartos.html)
    }

    // Método que lida com a requisição GET para /quartos/novo
    // Exibe o formulário para cadastrar um novo quarto
    @GetMapping("/novo")
    public String formulario(Model model) {
        model.addAttribute("quartos", new Quartos()); // Adiciona um novo objeto Quartos vazio ao modelo para preencher o formulário
        return "quartos/formulario-quartos"; // Retorna o template do formulário de quarto
    }

    // Método que lida com a requisição POST para /quartos
    // Salva um quarto (novo ou existente) no banco de dados
    @PostMapping
    public String salvar(@Valid @ModelAttribute Quartos quartos, BindingResult result, Model model) {
        // Validação de duplicidade do número do quarto
        // Verifica se é um NOVO quarto (ID nulo)
        if (quartos.getId() == null) {
            if (quartosRepository.findByNumero(quartos.getNumero()).isPresent()) {
                // Se um quarto com o mesmo número já existe, adiciona um erro ao campo 'numero'
                result.rejectValue("numero", "erro.duplicado", "Já existe um quarto com esse número.");
            }
        } else { // Se é uma EDIÇÃO de quarto existente (ID não nulo)
            // Verifica se o número já existe em outro quarto (que não seja o próprio que está sendo editado)
            quartosRepository.findByNumero(quartos.getNumero()).ifPresent(existingQuarto -> {
                if (!existingQuarto.getId().equals(quartos.getId())) {
                    result.rejectValue("numero", "erro.duplicado", "Já existe outro quarto com esse número.");
                }
            });
        }

        // Se houver erros de validação (incluindo o de duplicidade de número)
        if (result.hasErrors()) {
            return "quartos/formulario-quartos"; // Retorna para o formulário para exibir os erros
        }

        quartosRepository.save(quartos); // Salva o objeto Quartos no banco de dados
        return "redirect:/quartos"; // Redireciona o navegador para a URL /quartos (que exibe a lista atualizada)
    }
}
