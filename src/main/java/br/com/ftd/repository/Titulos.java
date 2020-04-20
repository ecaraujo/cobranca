package br.com.ftd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ftd.model.Titulo;

public interface Titulos extends JpaRepository<Titulo, Long>{

}
