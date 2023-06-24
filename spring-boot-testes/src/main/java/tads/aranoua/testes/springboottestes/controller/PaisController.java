package tads.aranoua.testes.springboottestes.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import tads.aranoua.testes.springboottestes.model.Pais;
import tads.aranoua.testes.springboottestes.repository.PaisRepository;

@RestController
@RequestMapping("/api/paises")
public class PaisController {


    @Autowired
    private PaisRepository paisRepository;

    @GetMapping
    public List<Pais> list(){
        List<Pais> paises = paisRepository.list();
        return paises;
    }


    @ResponseBody
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Pais find(@PathVariable("id") Long id){

        return paisRepository.findById(id).get();

    }

    @ResponseBody
    @GetMapping(value = "/ibge/{ibge}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Pais findByIBGE(@PathVariable("ibge") String ibge){

        return paisRepository.findOneByIbge(ibge);

    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pais> create(@RequestBody Pais pais, UriComponentsBuilder uriComponentsBuilder){

       Pais paisRetorno = paisRepository.save(pais);

//       status de retorno: 201 (ok)
//        path: uri da entidade
//        body: conteúdo do objeto em json

        URI uri = uriComponentsBuilder.path("/api/paises/{id}")
                                       .buildAndExpand(paisRetorno.getId()).toUri();

       return ResponseEntity.created(uri).body(paisRetorno);

    }






}
