package com.rpg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "itens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long idItem;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    /**
     * Define o tipo do item (WEAPON, ARMOR, CONSUMABLE, QUEST).
     * Mapeado como String no banco para facilitar a leitura.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TipoItem tipo;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RaridadeItem raridade = RaridadeItem.COMMON;

    // Atributos de Combate e Efeito
    @Column(name = "bonus_ataque")
    private Integer bonusAtaque = 0;

    @Column(name = "bonus_defesa")
    private Integer bonusDefesa = 0;

    private Integer cura = 0;

    // Economia e Peso
    @Column(name = "valor_venda")
    private BigDecimal valorVenda = BigDecimal.ZERO;

    private Double peso = 0.0;

    @Column(name = "icon_name")
    private String iconName; // Ex: "sword", "flask-outline" (MaterialCommunityIcons)

    // Enums internos para manter a consistência com o frontend
    public enum TipoItem {
        WEAPON, ARMOR, CONSUMABLE, QUEST, MATERIAL
    }

    public enum RaridadeItem {
        COMMON, UNCOMMON, RARE, EPIC, LEGENDARY
    }
}