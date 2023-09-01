package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Aluno;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class AlunoRepository implements Repository<Aluno,Long>{

    private Set<Aluno> alunos;


    public AlunoRepository() {
        alunos = new LinkedHashSet<>();

    }

    @Override
    public List<Aluno> findAll() {
        return alunos.stream().toList();
    }

    @Override
    public Aluno findById(Long id) {
        return alunos.stream().filter(a->a.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Aluno> findByName(String texto) {
        return alunos.stream()
                .filter(a->a.getNome().toLowerCase().contains( texto.toLowerCase() ) )
                .toList();
    }

    @Override
    public Aluno persist(Aluno aluno) {
        if(Objects.isNull(aluno))return null;
        if(Objects.isNull(aluno.getId())) aluno.setId(alunos.size()+1L);
        alunos.add(aluno);
        return aluno;
    }


}
