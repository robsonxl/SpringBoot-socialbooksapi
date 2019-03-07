package com.rxl.socialbooks.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rxl.socialbooks.domain.Comentario;
import com.rxl.socialbooks.domain.Livro;
import com.rxl.socialbooks.repository.ComentarioRepository;

@Service
public class ComentarioService {
	
	@Autowired
	ComentarioRepository comentarioRepository;
	@Autowired
	LivrosService livroService;
	
	public Comentario salvarComentario(Long livroId, Comentario comentario) {
		Livro livro = livroService.buscarLivroPorId(livroId);
		comentario.setLivro(livro);
		comentario.setData(new Date());
		return comentarioRepository.save(comentario);
	}
	
	public List<Comentario> listarComentarios(Long livroId){
		Livro livro = livroService.buscarLivroPorId(livroId);
		return livro.getComentarios();	
	}
}
