package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Criar um ninja

    // Listar todos os ninjas
    public List<NinjaModel> mostrarTodos() {
        return ninjaRepository.findAll();
    }

    // Listar um ninja por ID
    public String mostrarNinja() {
        return ninjaRepository.findById(1L).toString();
    }
}
