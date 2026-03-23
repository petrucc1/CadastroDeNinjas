package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boas-vindas")
    public String boasVindas() {
        return "Boas-vindas!";
    }

    // CRUD
    // Adicionar ninja (CREATE)
    @PostMapping("/criar-ninja")
    public String criarNinja() {
        return "Ninja criado!";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/ninjas")
    public String mostrarTodos() {
        return "Lista de ninjas:";
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/ninja{id}")
    public String mostrarNinja() {
        return "Ninja:";
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar-ninja{id}")
    public String alterarNinja()  {
        return "Ninja alterado!";
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletar{id}")
    public String deletarNinja()  {
        return "Ninja deletado!";
    }

}