package br.com.Desafio_i4.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.Desafio_i4.DTO.PetDto;
import br.com.Desafio_i4.services.PetService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pets")
public class PetController {

	@Autowired
	private PetService petService;

	@GetMapping
	public ResponseEntity<List<PetDto>> getAllPets() {
		try {
			List<PetDto> pets = petService.findAll();
			return ResponseEntity.ok(pets);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping
	public ResponseEntity<PetDto> addPet(@RequestParam("file") MultipartFile file,
			@Valid @RequestParam("pet") PetDto petDto) {
		try {
			PetDto savedPetDto = petService.insert(petDto, file);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedPetDto);
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

}
