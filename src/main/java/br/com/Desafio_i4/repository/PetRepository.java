package br.com.Desafio_i4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.Desafio_i4.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}
