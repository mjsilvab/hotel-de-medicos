package br.edu.ifrn.hoteldemedicos;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController // Marca esta classe como um controlador REST (retorna dados diretamente)
public class OlaSpringBoot {

    @GetMapping("/") // Mapeia requisições GET para o caminho raiz "/"
    public String index() {
        return "olá spring boot"; // Retorna a string "olá spring boot" como resposta
    }

}
