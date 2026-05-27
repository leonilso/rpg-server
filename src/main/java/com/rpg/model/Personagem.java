package com.rpg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personagens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personagem")
    private Long idPersonagem;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "id_raca")
    private Integer idRaca;

    @Column(name = "id_classe")
    private Integer idClasse;

    // Atributos de Status e Gameplay
    private Integer nivel = 1;
    private Integer xp = 0;

    @Column(name = "vida_maxima")
    private Integer vidaMaxima;

    @Column(name = "vida_atual")
    private Integer vidaAtual;

    private Integer forca;
    private Integer resistencia;
    private Integer destreza;
    private Integer inteligencia;

    // Flags de Identidade
    @Column(name = "is_npc")
    private Boolean isNpc = false;

    @Column(name = "id_cenario")
    private Long idCenario;

    /**
     * Mapeamento das Falas (Diálogos)
     * No MariaDB, isso criará uma tabela auxiliar 'personagem_falas' 
     * para suportar o array de strings que o front-end consome.
     */
    @ElementCollection
    @CollectionTable(
        name = "personagem_falas", 
        joinColumns = @JoinColumn(name = "id_personagem")
    )
    @Column(name = "fala", columnDefinition = "TEXT")
    private List<String> falas = new ArrayList<>();

    // Metadados para auditoria
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (vidaAtual == null) vidaAtual = vidaMaxima;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}