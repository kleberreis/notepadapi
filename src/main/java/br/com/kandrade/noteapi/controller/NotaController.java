package br.com.kandrade.noteapi.controller;

import br.com.kandrade.noteapi.component.NotaComponent;
import br.com.kandrade.noteapi.model.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/nota")
public class NotaController {

    @Autowired
    private NotaComponent notaComponent;

    public NotaController(NotaComponent notaComponent) {
        this.notaComponent = notaComponent;
    }

    @GetMapping
    private List<Nota> findAll() {
        return notaComponent.buscarTodos();
    }

    @GetMapping(value = "/titulo/{titulo}")
    private Nota findAll(@PathVariable(value = "titulo") String titulo) {
        return notaComponent.buscarNota(titulo);
    }

    @PostMapping
    private void save(@RequestBody Nota nota) {
        notaComponent.salvar(nota);
    }

    @DeleteMapping
    private void deleteAll() {
        notaComponent.apagarTodos();
    }
}