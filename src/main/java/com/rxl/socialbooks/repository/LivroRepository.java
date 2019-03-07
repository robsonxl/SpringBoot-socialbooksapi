package com.rxl.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rxl.socialbooks.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
