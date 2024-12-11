package com.github.im2back.challenge.ORM.configuration;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.im2back.challenge.ORM.entities.Atividade;
import com.github.im2back.challenge.ORM.entities.Bloco;
import com.github.im2back.challenge.ORM.entities.Categoria;
import com.github.im2back.challenge.ORM.entities.Participante;
import com.github.im2back.challenge.ORM.repositories.AtividadeRepository;
import com.github.im2back.challenge.ORM.repositories.BlocoRepository;
import com.github.im2back.challenge.ORM.repositories.CategoriaRepository;
import com.github.im2back.challenge.ORM.repositories.ParticipanteRepository;

@Component
public class DatabaseSeeder implements CommandLineRunner {

	@Autowired
	AtividadeRepository atividadeRepository;

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	BlocoRepository blocoRepository;

	@Autowired
	ParticipanteRepository participanteRepository;

	@Override
	public void run(String... args) throws Exception {

		// Instanciando as categorias

		Categoria c1 = new Categoria("Curso");
		Categoria c2 = new Categoria("Oficina");

		categoriaRepository.saveAll(Arrays.asList(c1, c2));

		// Instanciando os Blocos
		Bloco b1 = new Bloco(ZonedDateTime.of(2017, 9, 25, 8, 0, 0, 0, ZoneId.of("UTC")).toInstant(),
				ZonedDateTime.of(2017, 9, 25, 11, 0, 0, 0, ZoneId.of("UTC")).toInstant());

		Bloco b2 = new Bloco(ZonedDateTime.of(2017, 9, 25, 14, 0, 0, 0, ZoneId.of("UTC")).toInstant(),
				ZonedDateTime.of(2017, 9, 25, 18, 0, 0, 0, ZoneId.of("UTC")).toInstant());

		Bloco b3 = new Bloco(ZonedDateTime.of(2017, 9, 26, 8, 0, 0, 0, ZoneId.of("UTC")).toInstant(),
				ZonedDateTime.of(2017, 9, 26, 11, 0, 0, 0, ZoneId.of("UTC")).toInstant());

		// Instanciando os participantes
		Participante p1 = new Participante("José Silva", "jose@gmail.com");
		Participante p2 = new Participante("Tiago Faria", "tiago@gmail.com");
		Participante p3 = new Participante("Maria do Rosário", "maria@gmail.com");
		Participante p4 = new Participante("Teresa Silva", "teresa@gmail.com");

		participanteRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

		// Instanciando as atividades
		Atividade atividade1 = new Atividade("Curso de HTML", "Aprenda HTML de forma facil", 80.00, c1);
		Atividade atividade2 = new Atividade("Oficina GitHub", "Versiona sua aplicacoes", 50.00, c2);

		b1.setAtividade(atividade1);
		b2.setAtividade(atividade2);
		b3.setAtividade(atividade2);

		atividade1.getBlocos().add(b1);
		atividade1.setCategoria(c1);

		atividade2.setCategoria(c2);
		atividade2.getBlocos().add(b2);
		atividade2.getBlocos().add(b3);

		atividadeRepository.saveAll(Arrays.asList(atividade1, atividade2));

		p1.getAtividades().addAll(Arrays.asList(atividade1, atividade2));
		p2.getAtividades().addAll(Arrays.asList(atividade1));
		p3.getAtividades().addAll(Arrays.asList(atividade1, atividade2));
		p4.getAtividades().addAll(Arrays.asList(atividade2));

		participanteRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

	}

}
