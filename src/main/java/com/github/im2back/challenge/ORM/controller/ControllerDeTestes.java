package com.github.im2back.challenge.ORM.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.im2back.challenge.ORM.entities.Participante;
import com.github.im2back.challenge.ORM.repositories.ParticipanteRepository;

import lombok.RequiredArgsConstructor;

@RequestMapping("test")
@RestController
@RequiredArgsConstructor
public class ControllerDeTestes {

	private final ParticipanteRepository participanteRepository;
	

	@GetMapping("/{id}")
	public ResponseEntity<Participante> getParticipante(@PathVariable Long id){
		
		return ResponseEntity.ok(participanteRepository.findById(id).get());
	}
	

}
