package dev.java10x.CadastroDeNinjas.Ninjas;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso!");
    }

    // Listar todos os ninjas (READ)
    @GetMapping("/todos")
    public ResponseEntity<List<NinjaDTO>> mostrarTodos() {
        List<NinjaDTO> ninjas = ninjaService.mostrarTodos();
        return ResponseEntity.ok(ninjas);
    }

    // Listar um ninja por ID (READ)
    @GetMapping("/ninja/{id}")
    public ResponseEntity<String> mostrarNinja(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.mostrarNinja(id);

        if (ninja != null) {
            return ResponseEntity.ok("Ninja "+ ninja.getNome() + " encontrado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado!");
        }
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.alterarNinja(id, ninjaAtualizado);

        if (ninja != null) {
            return ResponseEntity.ok("Ninja alterado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado!");
        }
    }

    // Deletar um ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {
        if (ninjaService.mostrarNinja(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado!");
        }
    }
}