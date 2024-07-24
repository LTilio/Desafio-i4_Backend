package br.com.Desafio_i4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Desafio_i4.model.Imagem;

@Repository
public interface ImagemRepository  extends JpaRepository<Imagem, Long>{

}
