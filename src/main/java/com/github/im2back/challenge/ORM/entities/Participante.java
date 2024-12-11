package com.github.im2back.challenge.ORM.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String email;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="participante_atividades", joinColumns = @JoinColumn(name="participante_id"),inverseJoinColumns = @JoinColumn(name="atividade_id"))
	private List<Atividade> atividades = new ArrayList<>();

	public Participante(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
}
