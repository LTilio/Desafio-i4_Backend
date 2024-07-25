package br.com.Desafio_i4.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.Desafio_i4.model.Imagem;
import br.com.Desafio_i4.services.ImagemService;

@RestController
@RequestMapping("/imagens")
public class ImagemController {

	@Autowired
	private ImagemService imagemService;

	@GetMapping("/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
		try {
			Imagem imagem = imagemService.getImageById(id);
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(imagem.getTipo()))
					.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + imagem.getNome() + "\"")
					.body(imagem.getDados());
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

}
