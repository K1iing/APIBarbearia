package lf.studio.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lf.studio.api.domain.Repository.DonosRepository;
import lf.studio.api.domain.model.donos.DonosDTO;
import lf.studio.api.domain.model.donos.DonosEntity;

import lf.studio.api.domain.model.donos.DonosListagemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/donos")
public class DonosController {

    @Autowired
    private DonosRepository repository;

    @PostMapping("/cadastrar")
    @Transactional
    public void cadastrar(@RequestBody @Valid DonosDTO donos) {
        repository.save(new DonosEntity(donos));

    }

    @GetMapping("/listartodos")
    @Transactional
    public Page<DonosListagemDTO> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(DonosListagemDTO::new);
    }




}