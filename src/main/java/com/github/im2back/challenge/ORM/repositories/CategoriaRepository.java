package com.github.im2back.challenge.ORM.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.im2back.challenge.ORM.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
