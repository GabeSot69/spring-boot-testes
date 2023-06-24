package tads.aranoua.testes.springboottestes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tads.aranoua.testes.springboottestes.model.Voluntario;

public interface VoluntarioRepository extends CrudRepository<Voluntario,Long> {

    @Query("select v from Voluntario v")
    List<Voluntario> list();

    @Query("select v from Voluntario v where v.passaporte = :parPassaporte")
    Voluntario findOneByPassaporte(String parPassaporte);

    @Query("select v from Voluntario v where v.email = :parEmail")
    Voluntario findOneByEmail(String parEmail);

}
