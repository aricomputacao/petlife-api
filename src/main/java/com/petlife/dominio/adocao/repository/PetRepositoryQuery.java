package com.petlife.dominio.adocao.repository;

import com.petlife.api.adocao.filtro.PetFiltro;
import com.petlife.dominio.adocao.dto.DadosConsultaPet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PetRepositoryQuery {
    Page<DadosConsultaPet> filtrar(PetFiltro petFiltro, Pageable pageable);

}
