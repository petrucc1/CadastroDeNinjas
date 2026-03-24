package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Criar um ninja (CREATE)
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    // Listar todos os ninjas (READ)
    public List<NinjaModel> mostrarTodos() {
        return ninjaRepository.findAll();
    }

    // Listar um ninja por ID (READ)
    public NinjaModel mostrarNinja(Long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.orElse(null);
    }

    // Alterar dados dos ninjas (UPDATE)
    public NinjaModel alterarNinja(Long id, NinjaModel ninja) {
        if (ninjaRepository.existsById(id)) {
            ninja.setId(id);
            return ninjaRepository.save(ninja);
        }
        return null;
    }

    // Deletar um ninja por ID (DELETE) - Precisa ser um método void
    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }
}
