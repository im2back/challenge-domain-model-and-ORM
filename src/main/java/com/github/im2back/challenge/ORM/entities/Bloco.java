package com.github.im2back.challenge.ORM.entities;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bloco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Bloco(Instant inicio, Instant fim) {
		super();
		this.inicio = inicio;
		this.fim = fim;
	}

	private Instant inicio;
	private Instant fim;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="atividade_id")
	private Atividade atividade;
}
