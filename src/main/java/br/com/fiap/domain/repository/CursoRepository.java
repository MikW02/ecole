package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Aluno;
import br.com.fiap.domain.entity.Curso;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CursoRepository implements Repository<Curso,Long>{

    private Set<Curso> cursos;

    public CursoRepository() {
        cursos = new LinkedHashSet<>();
    }

    @Override
    public List<Curso> findAll() {
        return cursos.stream().toList();
    }

    @Override
    public Curso findById(Long id) {
        return cursos.stream().filter(c->c.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Curso> findByName(String texto) {
        return cursos.stream()
                .filter(c->c.getNome().toLowerCase().contains( texto.toLowerCase() ) )
                .toList();
    }

    @Override
    public Curso persist(Curso curso) {
        if(Objects.isNull(curso))return null;
        if(Objects.isNull(curso.getId())) curso.setId(cursos.size()+1L);
        cursos.add(curso);
        return curso;
    }
}
