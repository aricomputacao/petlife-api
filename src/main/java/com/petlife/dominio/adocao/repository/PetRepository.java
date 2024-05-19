package com.petlife.dominio.adocao.repository;

import com.petlife.dominio.adocao.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository  extends JpaRepository<Pet, Long>, PetRepositoryQuery {

}

