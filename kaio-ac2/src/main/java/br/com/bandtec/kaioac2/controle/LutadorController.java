package br.com.bandtec.kaioac2.controle;

import br.com.bandtec.kaioac2.dominio.Lutador;
import br.com.bandtec.kaioac2.repositorio.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("lutadores")
public class LutadorController {
    @Autowired
    LutadorRepository repository;

    @PostMapping
    public ResponseEntity postLutador(@RequestBody @Valid Lutador novoLutador) {
        repository.save(novoLutador);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getLutador() {
        List<Lutador> lutadores = repository.findAllByOrderByForcaGolpeDesc();

        if (lutadores.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(lutadores);
        }
    }

    @GetMapping("/contagem-vivos")
    public ResponseEntity getContagemVivos() {
        long vivos = repository.countAllByVivoTrue();

        return ResponseEntity.status(200).body(vivos);
    }

    @GetMapping("/mortos")
    public ResponseEntity getMortos() {
        List<Lutador> mortos = repository.findAllByVivoFalse();

        if (mortos.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(mortos);
        }
    }
}
