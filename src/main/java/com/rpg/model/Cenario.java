package com.rpg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "cenarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cenario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cenario")
    private Long idCenario;

    @Column(nullable = false, length = 100)
    private String nome;

    /**
     * Descrição narrativa do local.
     * Usamos 'TEXT' no MariaDB para suportar textos longos de ambientação.
     */
    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "tipo_ambiente")
    private String tipoAmbiente; // Ex: Floresta, Taverna, Masmorra

    @Column(name = "tipo_clima")
    private String tipoClima; // Ex: Chuvoso, Árido, Nevoeiro

    @Column(name = "dificuldade_geral")
    private Integer dificuldadeGeral = 1;

    /**
     * URL ou nome da imagem de fundo que o front-end irá renderizar.
     */
    @Column(name = "imagem_fundo_url")
    private String imagemFundoUrl;

    // Metadados
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}