package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {
    // CRUD
    // Criar uma missão (CREATE)
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão criada!";
    }

    // Listar todas as missões (READ)
    @GetMapping("/todas")
    public String mostrarMissoes() {
        return "Missões listadas!";
    }

    // Alterar dados das missões (UPDATE)
    @PutMapping("/alterar")
    public String alterarMissao() {
        return "Missão alterada!";
    }

    // Deletar uma missão (DELETE)
    @DeleteMapping("/deletar/{id}")
    public String deletarMissao() {
        return "Missão deletada!";
    }
}
