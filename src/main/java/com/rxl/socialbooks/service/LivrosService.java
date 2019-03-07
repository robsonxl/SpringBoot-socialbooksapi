package com.rxl.socialbooks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rxl.socialbooks.domain.Livro;
import com.rxl.socialbooks.repository.LivroRepository;
import com.rxl.socialbooks.service.exception.LivroNaoEncontradoException;

@Service
public class LivrosService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public List<Livro> listar(){
		return livroRepository.findAll();
	}
	public Livro buscarLivroPorId(Long id) {
		Optional<Livro> livro= livroRepository.findById(id);
		if(!livro.isPresent()) {
			throw new LivroNaoEncontradoException("O Livro não foi encontrado");
		}
		return livro.get();
	}
	
	public Livro salvar(Livro novoLivro) {
		novoLivro.setId(null);
		Livro livro = livroRepository.save(novoLivro);
		return livro;
	}
	
	public void deletar(Long id){
		try {
			livroRepository.deleteById(id); 
		} catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException("O Livro não foi encontrado");
		}
	}
	
	public void atualizar(Livro atualizarLivro) {
		verificarExistencia(atualizarLivro);
		livroRepository.save(atualizarLivro);
	}
	
	private void verificarExistencia(Livro livro) {
		buscarLivroPorId(livro.getId());
	}
}
