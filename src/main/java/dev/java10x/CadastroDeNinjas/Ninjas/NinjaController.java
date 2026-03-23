package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    // CRUD
    // Cria um ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado!";
    }

    // Listar todos os ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodos() {
        return "Ninjas listados!";
    }

    // Listar um ninja por ID (READ)
    @GetMapping("/ninja{id}")
    public String mostrarNinja() {
        return "Ninja listado!";
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar{id}")
    public String alterarNinja()  {
        return "Ninja alterado!";
    }

    // Deletar um ninja (DELETE)
    @DeleteMapping("/deletar{id}")
    public String deletarNinja()  {
        return "Ninja deletado!";
    }

}