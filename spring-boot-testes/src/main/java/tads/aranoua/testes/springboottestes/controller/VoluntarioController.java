package tads.aranoua.testes.springboottestes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tads.aranoua.testes.springboottestes.model.Voluntario;
import tads.aranoua.testes.springboottestes.repository.VoluntarioRepository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/voluntarios")
public class VoluntarioController {
    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @GetMapping
    public List<Voluntario> list(){
        List<Voluntario> voluntarios = voluntarioRepository.list();
        return voluntarios;
    }


    @ResponseBody
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Voluntario find(@PathVariable("id") Long id){

        return voluntarioRepository.findById(id).get();

    }

    @ResponseBody
    @GetMapping(value = "/passaporte/{passaporte}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Voluntario findByPassaporte(@PathVariable("passaporte") String passaporte){

        return voluntarioRepository.findOneByPassaporte(passaporte);

    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Voluntario> create(@RequestBody Voluntario voluntario , UriComponentsBuilder uriComponentsBuilder){

        Voluntario voluntarioRetorno = voluntarioRepository.save(voluntario);

//       status de retorno: 201 (ok)
//        path: uri da entidade
//        body: conteúdo do objeto em json

        URI uri = uriComponentsBuilder.path("/api/voluntarios/{id}")
                .buildAndExpand(voluntarioRetorno.getId()).toUri();

        return ResponseEntity.created(uri).body(voluntarioRetorno);

    }

}
