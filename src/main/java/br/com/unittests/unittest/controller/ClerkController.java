package br.com.unittests.unittest.controller;

import br.com.unittests.unittest.dto.ClerkDTO;
import br.com.unittests.unittest.model.Clerk;
import br.com.unittests.unittest.service.ClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clerk")
public class ClerkController {

    @Autowired
    ClerkService service;

    @RequestMapping(value = "/home")
    public List<Clerk> getAll(){
        return service.getAll();
    }

    @RequestMapping(value = "/find/{nome}")
    public Clerk getByNome(@PathVariable String nome){
        return service.getByNome(nome);
    }

    @RequestMapping(value = "/findAllByName" ,method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Clerk> findAllByName(@RequestBody ClerkDTO dto){
        return service.getAllByName(dto);
    }

    @PostMapping(value = "/findByOneName")
    public Clerk findByName(){
        return service.findByName();
    }
}
