package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {
    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Cria um ninja (CREATE)
    @GetMapping("/criar")
    public String criarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "criarNinja";
    }

    // Listar todos os ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodos(Model model) {
        List<NinjaDTO> ninjas = ninjaService.mostrarTodos();
        model.addAttribute("ninjas", ninjas);
        return "mostrarTodos";
    }

    // Listar um ninja por ID (READ)
    @GetMapping("/ninja/{id}")
    public String mostrarNinja(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.mostrarNinja(id);
        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "detalhesNinja";
        } else {
            model.addAttribute("mensagem", "Ninja não encontrado.");
            return "mostrarTodos";
        }
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja criado com sucesso!");
        return "redirect:/ninjas/ui/todos";
    }

    // Alterar dados dos ninjas (UPDATE)

    // Deletar um ninja (DELETE)
    @GetMapping("/deletar/{id}")
    public String deletarNinja(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
        return "redirect:/ninjas/ui/todos";
    }
}
