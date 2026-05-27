package com.rpg.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inventarios")
@Data
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private Long idInventario;

    @ManyToOne
    @JoinColumn(name = "id_personagem", nullable = false)
    private Personagem personagem;

    @ManyToOne
    @JoinColumn(name = "id_item", nullable = false)
    private Item item;

    private Integer quantidade = 1;

    @Column(name = "esta_equipado")
    private Boolean estaEquipado = false;
}