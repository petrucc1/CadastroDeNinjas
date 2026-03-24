package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // CRUD
    // Cria um ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado!";
    }

    // Listar todos os ninjas (READ)
    @GetMapping("/todos")
    public List<NinjaModel> mostrarTodos() {
        return ninjaService.mostrarTodos();
    }

    // Listar um ninja por ID (READ)
    @GetMapping("/ninja/{id}")
    public NinjaModel mostrarNinja(@PathVariable Long id) {
        return ninjaService.mostrarNinja(id);
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public String alterarNinja()  {
        return "Ninja alterado!";
    }

    // Deletar um ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public String deletarNinja()  {
        return "Ninja deletado!";
    }

}