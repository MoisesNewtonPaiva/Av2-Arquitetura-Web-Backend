package com.pratica.AvProject2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratica.AvProject2.Entities.Curso;
import com.pratica.AvProject2.Repository.CursoRepository;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    
    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<Curso> criarCurso(@RequestBody Curso curso) {
        Curso novoCurso = cursoRepository.save(curso);
        return ResponseEntity.ok(novoCurso);
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listarCurso() {
        List<Curso> cursos = cursoRepository.findAll();
        return ResponseEntity.ok(cursos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizarCurso(@PathVariable Long id, @RequestBody Curso cursoDetails) {
        
        return cursoRepository.findById(id)
                .map(curso -> { 
                    curso.setNome(cursoDetails.getNome());
                    curso.setCargaHoraria(cursoDetails.getCargaHoraria());
                    Curso cursoAtualizado = cursoRepository.save(curso);
                    return ResponseEntity.ok(cursoAtualizado);
                })
                .orElse(ResponseEntity.notFound().build()); 
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCurso(@PathVariable Long id) {
        
        return cursoRepository.findById(id)
                .map(curso -> {

                    
                    cursoRepository.delete(curso);
                    return ResponseEntity.ok().build(); 
                })
                .orElse(ResponseEntity.notFound().build()); 
    }
    
}
