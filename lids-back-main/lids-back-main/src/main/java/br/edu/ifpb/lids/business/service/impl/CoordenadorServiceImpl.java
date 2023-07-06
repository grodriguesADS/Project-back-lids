package br.edu.ifpb.lids.business.service.impl;

import br.edu.ifpb.lids.business.service.CoordenadorService;
import br.edu.ifpb.lids.model.entity.Coordenador;
import br.edu.ifpb.lids.model.repository.CoordenadorRepository;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CoordenadorServiceImpl implements CoordenadorService {

    
    private final CoordenadorRepository coordenadorRepository;

    @Override
    public Coordenador create(Coordenador coordenador) {
        return coordenadorRepository.save(coordenador);
    }

    @Override
    public Coordenador update(Coordenador coordenador) {
        return coordenadorRepository.save(coordenador);
    }

    @Override
    public void delete(Long id) {
        coordenadorRepository.deleteById(id);
    }

    @Override
    public List<Coordenador> findAll() {
        return ( List<Coordenador> ) coordenadorRepository.findAll();
    }

    @Override
    public Coordenador findById(Long id) {
        Coordenador entity = coordenadorRepository.findById(id).get();
        return entity;
    }
}
