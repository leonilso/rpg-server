package com.rpg.controller;

// Importações de utilitários do Java
import java.util.List;

// Importações do Spring Framework
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Importações dos seus Models (Onde os erros costumam estar)
import com.rpg.model.Cenario;
import com.rpg.model.Personagem; // Adicionado: Essencial para o método getNPCs
import com.rpg.model.Evento;    // Adicionado: Se você já criou o model de Evento

// Importação do seu Service
import com.rpg.service.CenarioService;

@RestController
@RequestMapping("/api/cenarios")
@CrossOrigin(origins = "*")
public class CenarioController {

    @Autowired
    private CenarioService service;

    @GetMapping("/{id}/npcs")
    public List<Personagem> getNPCs(@PathVariable Long id) {
        return service.findNpcsByScenario(id);
    }

    @GetMapping("/{id}/eventos")
    public List<Evento> getEvents(@PathVariable Long id) {
        // Nota: Certifique-se de que o Model 'Evento' e o método no Service existem
        return service.findEventsByScenario(id);
    }
    
    // Dica: Adicione o GET básico para bater com o world.js do front
    @GetMapping("/{id}")
    public Cenario getById(@PathVariable Long id) {
        return service.findById(id);
    }
}