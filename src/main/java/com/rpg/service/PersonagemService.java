package com.rpg.service;

import com.rpg.model.Personagem;
import com.rpg.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository repository;

    // Dentro do PersonagemService.java
    public Personagem save(Personagem p) {
        return repository.save(p);
    }
    
    public Personagem ganharXP(Long id, Integer quantidade) {
        Personagem p = repository.findById(id).orElseThrow();
        p.setXp(p.getXp() + quantidade);
        
        // Lógica simples de Level Up baseada no que discutimos no front
        // XP_NECESSARIO = 100 * (Nivel ^ 1.5)
        double xpNecessario = 100 * Math.pow(p.getNivel(), 1.5);
        
        if (p.getXp() >= xpNecessario) {
            p.setNivel(p.getNivel() + 1);
            p.setVidaMaxima(p.getVidaMaxima() + 20); // Bônus de vida
            p.setVidaAtual(p.getVidaMaxima());       // Cura ao subir de nível
        }
        
        return repository.save(p);
    }
}