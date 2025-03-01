package br.com.fiap.domain.service;

import br.com.fiap.domain.entity.Aluno;
import br.com.fiap.domain.repository.AlunoRepository;
import br.com.fiap.exception.MetodoNaoImplementadoException;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class AlunoService implements Service<Aluno, Long> {


    private AlunoRepository repository;

    public AlunoService() {
        repository = new AlunoRepository();
    }

    @Override
    public List<Aluno> findAll() {
        return repository.findAll();
    }

    @Override
    public Aluno findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Aluno> findByName(String texto) {
        return repository.findByName(texto);
    }

    @Override
    public Aluno persist(Aluno aluno) {
        return repository.persist(aluno);
    }

    public String gerarMatricula() {
        Random r = new Random();
        var matricula = LocalDate.now().getYear() + "." + r.nextInt(1000, 9999) + "-" + r.nextInt(10, 99);
        return matricula;
    }

}
