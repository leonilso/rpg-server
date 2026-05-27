package com.rpg.repository;

import com.rpg.model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

    /**
     * Procura todos os personagens que pertencem a um cenário específico.
     * Necessário para a rota: GET /cenarios/{id}/npcs
     */
    List<Personagem> findByIdCenario(Long idCenario);

    /**
     * Procura apenas por NPCs ou apenas por Jogadores.
     * Útil para filtrar listas no Dashboard do Mestre.
     */
    List<Personagem> findByIsNpc(Boolean isNpc);

    /**
     * Procura um personagem pelo nome exato.
     * Útil para o sistema de Login que definimos na LoginScreen.
     */
    Optional<Personagem> findByNome(String nome);

    /**
     * Procura personagens por cenário e que sejam NPCs.
     * Combina dois filtros para popular o mapa do WorldContext.
     */
    List<Personagem> findByIdCenarioAndIsNpc(Long idCenario, Boolean isNpc);
}