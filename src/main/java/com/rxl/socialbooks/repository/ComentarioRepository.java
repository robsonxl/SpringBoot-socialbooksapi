package com.rxl.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rxl.socialbooks.domain.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
