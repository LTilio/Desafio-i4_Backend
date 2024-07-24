package br.com.Desafio_i4.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "consulta_id")
	private Long id;

	@NotNull(message = "O nome do veterinário deve ser informado")
	@Size(min = 1, max = 100, message = "O nome do veterinário deve ter entre 1 e 100 caracteres")
	private String nomeVeterinario;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataConsulta;

	@Size(max = 255, message = "Os sintomas devem ter no máximo 255 caracteres")
	private String sintomas;

	@Size(max = 255, message = "O diagnóstico deve ter no máximo 255 caracteres")
	private String diagnostico;

	@Size(max = 255, message = "O tratamento deve ter no máximo 255 caracteres")
	private String tratamento;

	@Size(max = 255, message = "Observações devem ter no máximo 255 caracteres")
	private String observacoes;

	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	public Consulta() {
	}

	public Consulta(Long id, String nomeVeterinario, LocalDate dataConsulta, String sintomas, String diagnostico,
			String tratamento, String observacoes, Pet pet) {
		super();
		this.id = id;
		this.nomeVeterinario = nomeVeterinario;
		this.dataConsulta = dataConsulta;
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
		this.tratamento = tratamento;
		this.observacoes = observacoes;
		this.pet = pet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeVeterinario() {
		return nomeVeterinario;
	}

	public void setNomeVeterinario(String nomeVeterinario) {
		this.nomeVeterinario = nomeVeterinario;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getSintomas() {
		return sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamento() {
		return tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		return Objects.equals(id, other.id);
	}

}
