package br.com.Desafio_i4.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Desafio_i4.DTO.ConsultaDto;
import br.com.Desafio_i4.model.Consulta;
import br.com.Desafio_i4.model.Pet;
import br.com.Desafio_i4.repository.ConsultaRepository;
import br.com.Desafio_i4.repository.PetRepository;
import jakarta.transaction.Transactional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    
    @Autowired
    private PetRepository petRepository;
	
    public List<ConsultaDto> getConsultasByPetId(Long petId) {
        List<Consulta> consultas = consultaRepository.findByPetId(petId);
        return consultas.stream()
                .map(c -> new ConsultaDto(
                        c.getId(),
                        c.getDataConsulta(),
                        c.getNomeVeterinario(),
                        c.getSintomas(),
                        c.getDiagnostico(),
                        c.getTratamento(),
                        c.getObservacoes()
                        ))
                .collect(Collectors.toList());
    }
    
    @Transactional
    public ConsultaDto insert(Long petId, ConsultaDto consultaDto) {
        Optional<Pet> petOpt = petRepository.findById(petId);
        if (petOpt.isEmpty()) {
            throw new RuntimeException("Pet não encontrado"); 
        }
        Pet pet = petOpt.get();
        Consulta consulta = new Consulta();
        consulta.setNomeVeterinario(consultaDto.getNomeVeterinario());
        consulta.setSintomas(consultaDto.getSintomas());
        consulta.setDiagnostico(consultaDto.getDiagnostico());
        consulta.setTratamento(consultaDto.getTratamento());
        consulta.setObservacoes(consultaDto.getObservacoes());
        consulta.setDataConsulta(LocalDate.now());
        consulta.setPet(pet);
        
        Consulta savedConsulta = consultaRepository.save(consulta);
        return new ConsultaDto(
                savedConsulta.getId(),
                savedConsulta.getDataConsulta(),
                savedConsulta.getNomeVeterinario(),
                savedConsulta.getSintomas(),
                savedConsulta.getDiagnostico(),
                savedConsulta.getTratamento(),
                savedConsulta.getObservacoes()
                );
    }
    
}
