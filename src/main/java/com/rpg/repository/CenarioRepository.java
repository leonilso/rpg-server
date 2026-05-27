package com.rpg.repository;

import com.rpg.model.Cenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CenarioRepository extends JpaRepository<Cenario, Long> {

    /**
     * Procura cenários por tipo de ambiente (ex: "Masmorra", "Cidade").
     * Útil para organizar o seletor de cenários no Builder.
     */
    List<Cenario> findByTipoAmbiente(String tipoAmbiente);

    /**
     * Procura cenários por nível de dificuldade.
     * Pode ser usado para sugerir locais apropriados para o nível do jogador.
     */
    List<Cenario> findByDificuldadeGeral(Integer dificuldadeGeral);

    /**
     * Procura cenários que contenham uma parte do nome.
     * Útil para a barra de pesquisa no painel administrativo.
     */
    List<Cenario> findByNomeContainingIgnoreCase(String nome);
}