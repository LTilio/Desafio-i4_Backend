package br.com.Desafio_i4.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ConsultaDto {

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

	public ConsultaDto() {
	}

	public ConsultaDto(Long id, LocalDate dataConsulta, String nomeVeterinario, String sintomas, String diagnostico,
			String tratamento, String observacoes) {
		super();
		this.id = id;
		this.dataConsulta = dataConsulta;
		this.nomeVeterinario = nomeVeterinario;
		this.sintomas = sintomas;
		this.diagnostico = diagnostico;
		this.tratamento = tratamento;
		this.observacoes = observacoes;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public String getNomeVeterinario() {
		return nomeVeterinario;
	}

	public void setNomeVeterinario(String nomeVeterinario) {
		this.nomeVeterinario = nomeVeterinario;
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

}
