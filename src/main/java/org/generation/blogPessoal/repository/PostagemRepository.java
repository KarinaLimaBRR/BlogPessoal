package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.PostagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemModel, Long>{

//	public List<PostagemModel> findAllByTituloContainingIgnoreCase(String titulo);

	@Query(value = "select * from postagem where ano > 2011", nativeQuery = true)
	List<PostagemModel> findAllMaior();

	@Query(value = "SELECT * FROM postagem where ano > 2011 ORDER BY ano DESC", nativeQuery = true)
	List<PostagemModel> anosDesc();

	@Query(value = "SELECT * FROM postagem where ano > 2011 ORDER BY ano ASC", nativeQuery = true)
	List<PostagemModel> anosAsc();

	@Query(value = "SELECT * FROM postagem where ano >= 2011 and ano<=2013", nativeQuery = true)
	List<PostagemModel> anosIntervalos();
	
}
