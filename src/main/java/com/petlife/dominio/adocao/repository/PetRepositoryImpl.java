package com.petlife.dominio.adocao.repository;

import com.petlife.api.adocao.filtro.PetFiltro;
import com.petlife.dominio.adocao.dto.DadosConsultaPet;
import com.petlife.dominio.adocao.entity.Pet;
import com.petlife.dominio.adocao.entity.Pet_;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PetRepositoryImpl implements PetRepositoryQuery{

    private final EntityManager manager;

    @Override
    public Page<DadosConsultaPet> filtrar(PetFiltro petFiltro, Pageable pageable) {

        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<DadosConsultaPet> criteria = builder.createQuery(DadosConsultaPet.class);
        Root<Pet> root = criteria.from(Pet.class);

        criteria.select(builder.construct(DadosConsultaPet.class,
                root.get(Pet_.especie),
                root.get(Pet_.porte),
                root.get(Pet_.status),
                root.get(Pet_.raca),
                root.get(Pet_.cartaoVacinacao),
                root.get(Pet_.idade),
                root.get(Pet_.endereco)
        ));

        //criar restrições
        Predicate[] predicates = criarRestricoes(petFiltro,builder,root);
        criteria.where(predicates);

        List<Order> orderList = new ArrayList();
        orderList.add(builder.asc(root.get(Pet_.especie)));
        orderList.add(builder.asc(root.get(Pet_.nome)));
        criteria.orderBy(orderList);

        TypedQuery<DadosConsultaPet> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query,pageable);

        return new PageImpl<>(query.getResultList(),pageable,total(petFiltro)) ;
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
        int paginalAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginalAtual*totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroDaPagina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    private Long total(PetFiltro petFiltro) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Pet> root = criteria.from(Pet.class);

        //criar restrições
        Predicate[] predicates = criarRestricoes(petFiltro,builder,root);
        criteria.where(predicates);

        criteria.select(builder.count(root));
        TypedQuery<Long> query = manager.createQuery(criteria);

        return query.getSingleResult();

    }

    private Predicate[] criarRestricoes(PetFiltro petFiltro, CriteriaBuilder builder, Root<Pet> root) {

        List<Predicate> predicates = new ArrayList<>();
        if ( petFiltro.getEspecie() != null && !petFiltro.getEspecie().getDescricao().isEmpty() ){
            predicates.add(builder.equal((root.get(Pet_.especie)), petFiltro.getEspecie()));
        }
        if ( petFiltro.getRaca() != null && !petFiltro.getRaca().isEmpty() ){
            predicates.add(builder.equal((root.get(Pet_.raca)), petFiltro.getRaca()));
        }
        if ( petFiltro.getIdade() != null && petFiltro.getIdade() > 0 ){
            predicates.add(builder.equal((root.get(Pet_.IDADE)), petFiltro.getIdade()));
        }
        if ( petFiltro.getPorte() != null && !petFiltro.getPorte().getDescricao().isEmpty() ){
            predicates.add(builder.equal((root.get(Pet_.PORTE)), petFiltro.getPorte()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
