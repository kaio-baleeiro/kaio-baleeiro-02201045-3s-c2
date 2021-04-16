package br.com.bandtec.kaioac2.repositorio;

import br.com.bandtec.kaioac2.dominio.Lutador;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LutadorRepository extends JpaRepository<Lutador, Integer> {
    List<Lutador> findAllByOrderByForcaGolpeDesc();

    long countAllByVivoTrue();

    List<Lutador> findAllByVivoFalse();
}
