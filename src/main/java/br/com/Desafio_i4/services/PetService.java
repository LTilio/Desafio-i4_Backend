package br.com.Desafio_i4.services;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.Desafio_i4.DTO.PetDto;
import br.com.Desafio_i4.model.Imagem;
import br.com.Desafio_i4.model.Pet;
import br.com.Desafio_i4.repository.PetRepository;
import jakarta.transaction.Transactional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ImagemService imagemService;
    
    @Autowired
    private ConsultaService consultaService;
	
    public PetDto addImageUrl(Pet pet) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/imagens/{id}")
                .buildAndExpand(pet.getImagem().getId())
                .toUri();

        PetDto petDto = new PetDto();
        petDto.setId(pet.getId());
        petDto.setNome(pet.getNome());
        petDto.setEspecie(pet.getEspecie()); 
        petDto.setRaca(pet.getRaca());
        petDto.setIdade(pet.getIdade());
        petDto.setPeso(pet.getPeso());
        petDto.setCorPelagem(pet.getCorPelagem());
        petDto.setObservacoes(pet.getObservacoes());
        petDto.setNomeDono(pet.getNomeDono());
        petDto.setContatoDono(pet.getContatoDono());
        petDto.setDataRegistro(pet.getDataRegistro());
        petDto.setImagemUrl(uri.toString());
        petDto.setConsultas(consultaService.getConsultasByPetId(pet.getId()));
        
        return petDto;
    }
    
    @Transactional
    public PetDto insert(PetDto petDto, MultipartFile file) throws IOException {
    	Pet pet = new Pet();
        pet.setNome(petDto.getNome());
        pet.setEspecie(petDto.getEspecie());
        pet.setRaca(petDto.getRaca());
        pet.setIdade(petDto.getIdade());
        pet.setPeso(petDto.getPeso());
        pet.setCorPelagem(petDto.getCorPelagem());
        pet.setObservacoes(petDto.getObservacoes());
        pet.setNomeDono(petDto.getNomeDono());
        pet.setContatoDono(petDto.getContatoDono());
        pet.setDataRegistro(LocalDate.now());

        Imagem imagem = imagemService.saveImage(file);
        pet.setImagem(imagem);

        pet = petRepository.save(pet);

        return addImageUrl(pet);
    }
    
    public List<PetDto> findAll() {
        List<Pet> pets = petRepository.findAll();
        return pets.stream()
                .map(this::addImageUrl)
                .collect(Collectors.toList());
    }
	
}
