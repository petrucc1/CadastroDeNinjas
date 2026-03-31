package dev.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
@Tag(name = "Ninjas", description = "API responsável pelo gerenciamento de ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // CREATE
    @PostMapping("/criar")
    @Operation(
            summary = "Criar ninja",
            description = "Cria um novo ninja e salva no banco de dados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar ninja (dados inválidos).")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso!");
    }

    // READ - LISTAR TODOS
    @GetMapping("/todos")
    @Operation(
            summary = "Listar todos os ninjas",
            description = "Retorna todos os ninjas cadastrados no sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso!"),
            @ApiResponse(responseCode = "204", description = "Nenhum ninja encontrado.")
    })
    public ResponseEntity<List<NinjaDTO>> mostrarTodos() {
        List<NinjaDTO> ninjas = ninjaService.mostrarTodos();
        return ResponseEntity.ok(ninjas);
    }

    // READ - POR ID
    @GetMapping("/ninja/{id}")
    @Operation(
            summary = "Buscar ninja por ID",
            description = "Retorna um ninja específico baseado no ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado.")
    })
    public ResponseEntity<String> mostrarNinja(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.mostrarNinja(id);

        if (ninja != null) {
            return ResponseEntity.ok("Ninja " + ninja.getNome() + " encontrado com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja não encontrado.");
    }

    // UPDATE
    @PutMapping("/alterar/{id}")
    @Operation(
            summary = "Atualizar ninja",
            description = "Atualiza os dados de um ninja existente com base no ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja atualizado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Erro na atualização (dados inválidos)."),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado.")
    })
    public ResponseEntity<String> alterarNinja(@PathVariable Long id,
                                               @RequestBody NinjaDTO ninjaAtualizado) {

        NinjaDTO ninja = ninjaService.alterarNinja(id, ninjaAtualizado);

        if (ninja != null) {
            return ResponseEntity.ok("Ninja alterado com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja não encontrado.");
    }

    // DELETE
    @DeleteMapping("/deletar/{id}")
    @Operation(
            summary = "Deletar ninja",
            description = "Remove um ninja do sistema com base no ID informado"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado.")
    })
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {

        NinjaDTO ninja = ninjaService.mostrarNinja(id);

        if (ninja != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja deletado com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja não encontrado.");
    }
}