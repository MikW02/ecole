package br.com.fiap.domain.repository;

import br.com.fiap.domain.entity.Instrutor;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class InstrutorRepository implements Repository<Instrutor,Long>{


    private Set<Instrutor> instrutores;


    public InstrutorRepository() {

        instrutores = new LinkedHashSet<>();
    }

    @Override
    public List<Instrutor> findAll() {
        return instrutores.stream().toList();
    }

    @Override
    public Instrutor findById(Long id) {
        return instrutores.stream().filter(c->c.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Instrutor> findByName(String texto) {
        return instrutores.stream()
                .filter(c->c.getNome().toLowerCase().contains( texto.toLowerCase() ) )
                .toList();
    }

    @Override
    public Instrutor persist(Instrutor instrutor) {
        if(Objects.isNull(instrutor))return null;
        if(Objects.isNull(instrutor.getId())) instrutor.setId(instrutores.size()+1L);
        instrutores.add(instrutor);
        return instrutor;
    }
}
