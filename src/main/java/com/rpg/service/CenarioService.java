package com.rpg.service;

import com.rpg.model.Cenario;
import com.rpg.model.Personagem;
import com.rpg.model.Evento;
import com.rpg.repository.CenarioRepository;
import com.rpg.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CenarioService {

    @Autowired
    private CenarioRepository cenarioRepository;

    @Autowired
    private PersonagemRepository personagemRepository;

    /**
     * Busca um cenário pelo ID.
     * Lança uma exceção caso o cenário não exista.
     */
    public Cenario findById(Long id) {
        return cenarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cenário não encontrado com o ID: " + id));
    }

    /**
     * Busca todos os NPCs vinculados a um cenário específico.
     * Utiliza o PersonagemRepository que criamos anteriormente.
     */
    public List<Personagem> findNpcsByScenario(Long idCenario) {
        // Filtramos para retornar apenas quem tem isNpc = true
        return personagemRepository.findByIdCenario(idCenario)
                .stream()
                .filter(Personagem::getIsNpc)
                .collect(Collectors.toList());
    }

    /**
     * Busca eventos do cenário. 
     * Nota: Se ainda não criou a entidade 'Evento', este método pode ser 
     * comentado ou retornar uma lista vazia temporariamente.
     */
    public List<Evento> findEventsByScenario(Long idCenario) {
        // Por enquanto, retornamos uma lista vazia, mas do tipo correto (Evento)
        return java.util.Collections.emptyList(); 
    }

    /**
     * Retorna todos os cenários para o Builder do Mestre.
     */
    public List<Cenario> findAll() {
        return cenarioRepository.findAll();
    }

    /**
     * Salva ou atualiza um cenário.
     */
    public Cenario save(Cenario cenario) {
        return cenarioRepository.save(cenario);
    }
}