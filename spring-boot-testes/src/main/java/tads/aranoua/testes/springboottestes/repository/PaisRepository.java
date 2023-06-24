package tads.aranoua.testes.springboottestes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tads.aranoua.testes.springboottestes.model.Pais;

public interface PaisRepository extends JpaRepository<Pais,Long> {

    @Query("select e from Estado e")
    List<Pais> list();

    @Query("select p from Pais p where p.ibge = :parIbge")
    Pais findOneByIbge(String parIbge);

    List<Pais> findByNomeIgnoreCase(String nome);

}
