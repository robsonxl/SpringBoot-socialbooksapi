package com.rxl.socialbooks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rxl.socialbooks.domain.Autor;
import com.rxl.socialbooks.repository.AutorRepository;
import com.rxl.socialbooks.service.exception.AutorExistenteException;
import com.rxl.socialbooks.service.exception.AutorNaoEncontradoException;

@Service
public class AutorService {
	
	@Autowired
	AutorRepository autorRepository;
	
	public List<Autor> listarAutor(){
		return autorRepository.findAll();
	}
	
	public Autor salvarAutor(Autor autor){
		if(autor.getId()!=null) {
			Optional<Autor> autorAux= autorRepository.findById(autor.getId());
			if(autorAux.isPresent()) {
				throw new  AutorExistenteException("O autor ja exixte.");
			}
		}
		return autorRepository.save(autor);
	}
	
	public Autor bucarAutor(Long id) {
		Optional<Autor> autor = autorRepository.findById(id);
		if(!autor.isPresent()) {
			throw new AutorNaoEncontradoException("Autor Nao encontrado");
		}
		return autor.get();
	}

}
