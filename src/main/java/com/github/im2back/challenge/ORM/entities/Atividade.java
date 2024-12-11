package com.github.im2back.challenge.ORM.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String descricao;
	
	private Double preco;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	public Atividade(String nome, String descricao, Double preco, Categoria categoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}

	@JsonIgnore
	@ManyToMany(mappedBy = "atividades", cascade = CascadeType.ALL)
	private  List<Participante> participantes = new ArrayList<>();
	
	@OneToMany(mappedBy = "atividade", cascade = CascadeType.ALL)
	private List<Bloco> blocos = new ArrayList<>();
}
