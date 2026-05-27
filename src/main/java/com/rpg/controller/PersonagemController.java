package com.rpg.controller;

import com.rpg.model.Personagem;
import com.rpg.service.PersonagemService;
import com.rpg.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // Importação corrigida
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/personagens")
@CrossOrigin(origins = "*") // Permite que o App mobile acesse a API
public class PersonagemController {

    @Autowired
    private PersonagemService service;
    @Autowired
    private PersonagemRepository repository;

    @GetMapping("/cenario/{id}")
    public List<Personagem> listarPorCenario(@PathVariable Long id) {
        return repository.findByIdCenario(id);
    }

    @PostMapping
    public Personagem salvar(@RequestBody Personagem personagem) {
        return repository.save(personagem);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Personagem> registrar(@RequestBody Personagem novoPersonagem) {
        // Aqui você pode adicionar lógica para verificar se o nome já existe
        Personagem salvo = service.save(novoPersonagem);
        return ResponseEntity.ok(salvo);
    }
    
    @GetMapping("/{id}")
    public Personagem buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }
}