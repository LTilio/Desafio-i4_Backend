package br.com.Desafio_i4.services;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import br.com.Desafio_i4.model.Imagem;
import br.com.Desafio_i4.repository.ImagemRepository;
import jakarta.transaction.Transactional;

@Service
public class ImagemService {

	@Autowired
	private ImagemRepository imagemRepository;

	@Transactional
	public Imagem saveImage(MultipartFile file) throws IOException {
		Imagem imagem = new Imagem();
		imagem.setNome(file.getOriginalFilename());
		imagem.setTipo(file.getContentType());
		imagem.setDados(file.getBytes());

		return imagemRepository.save(imagem);
	}

	public Imagem getImageById(Long id) {
		return imagemRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Imagem não encontrada com o ID: " + id));
	}

}
