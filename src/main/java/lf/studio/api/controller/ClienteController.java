package lf.studio.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lf.studio.api.domain.Repository.ClienteRepository;
import lf.studio.api.domain.model.cliente.ClienteAtualizarDTO;
import lf.studio.api.domain.model.cliente.ClienteDTO;
import lf.studio.api.domain.model.cliente.ClienteEntity;
import lf.studio.api.domain.model.cliente.ClienteListagemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteRepository repository;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteDTO clienteDados) {
        repository.save(new ClienteEntity(clienteDados));
        return ResponseEntity.status(201).body(clienteDados);

    }

    @GetMapping("/listar")
    @Transactional
    public ResponseEntity<Page<ClienteListagemDTO>> listar(Pageable paginacao) {
        var clientes = repository.findAllByAtivoTrue(paginacao).map(ClienteListagemDTO::new);
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/atualizar")
    @Transactional
    public ResponseEntity<?> atualizar(@RequestBody @Valid ClienteAtualizarDTO dadoss) {
        var clientes = repository.getReferenceById(dadoss.id());
        clientes.atualizarDados(dadoss);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/desativar/{id}")
    @Transactional
    public ResponseEntity<?> desativar(@PathVariable Long id) {
        var cliente = repository.getReferenceById(id);
        cliente.inativar();
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/ativar/{id}")
    @Transactional
    public ResponseEntity<?> ativar(@PathVariable Long id) {
        var cliente = repository.getReferenceById(id);
        cliente.ativar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ClienteListagemDTO> listarid(@PathVariable Long id) {
        var cliente = repository.getReferenceById(id);
        var clienteDTO = cliente.listar();

        return ResponseEntity.ok(clienteDTO);
    }
}

