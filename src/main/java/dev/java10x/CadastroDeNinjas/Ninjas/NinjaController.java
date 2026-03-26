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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Listar todos os ninjas (READ)
    @GetMapping("/todos")
    public List<NinjaDTO> mostrarTodos() {
        return ninjaService.mostrarTodos();
    }

    // Listar um ninja por ID (READ)
    @GetMapping("/ninja/{id}")
    public NinjaDTO mostrarNinja(@PathVariable Long id) {
        return ninjaService.mostrarNinja(id);
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        return ninjaService.alterarNinja(id, ninja);
    }

    // Deletar um ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
    }
}