package br.com.Desafio_i4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Desafio_i4.DTO.ConsultaDto;
import br.com.Desafio_i4.services.ConsultaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;

	@GetMapping("/pet/{petId}")
	public ResponseEntity<List<ConsultaDto>> getConsultasByPetId(@PathVariable Long petId) {
		try {
			List<ConsultaDto> consultas = consultaService.getConsultasByPetId(petId);
			return ResponseEntity.ok(consultas);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PostMapping("/{petId}")
	public ResponseEntity<ConsultaDto> addConsulta(@PathVariable Long petId, @Valid @RequestBody ConsultaDto consultaDto) {
		try {
			ConsultaDto savedConsultaDto = consultaService.insert(petId, consultaDto);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedConsultaDto);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
