package br.com.Desafio_i4.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pet_id")
	private Long id;

	@NotBlank(message = "O nome do pet não pode estar vazio")
	@Size(max = 50, message = "O nome do pet deve ter no máximo 50 caracteres")
	private String nome;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "A espécie do pet deve ser informada")
	private Especie especie;

	@Size(max = 30, message = "A raça do pet deve ter no máximo 30 caracteres")
	private String raca;

	@Positive(message = "A idade do pet deve ser um número positivo")
	private int idade;

	@Positive(message = "O peso do pet deve ser um número positivo")
	private double peso;

	@Size(max = 20, message = "A cor da pelagem deve ter no máximo 20 caracteres")
	private String corPelagem;

	@Size(max = 255, message = "As observações devem ter no máximo 255 caracteres")
	private String observacoes;

	@Size(max = 50, message = "O nome do dono deve ter no máximo 50 caracteres")
	private String nomeDono;

	@Size(max = 64, message = "O contato do dono deve ter no máximo 64 caracteres")
	private String contatoDono;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataRegistro;

	@OneToOne
	@JoinColumn(name = "imagem_id")
	private Imagem imagem;

	@OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
	private List<Consulta> consultas;

	public Pet() {
	}

	public Pet(Long id, String nome, Especie especie, String raca, int idade, double peso, String corPelagem,
			String observacoes, String nomeDono, String contatoDono, LocalDate dataRegistro, Imagem imagem,
			List<Consulta> consultas) {
		super();
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.idade = idade;
		this.peso = peso;
		this.corPelagem = corPelagem;
		this.observacoes = observacoes;
		this.nomeDono = nomeDono;
		this.contatoDono = contatoDono;
		this.dataRegistro = dataRegistro;
		this.imagem = imagem;
		this.consultas = consultas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getCorPelagem() {
		return corPelagem;
	}

	public void setCorPelagem(String corPelagem) {
		this.corPelagem = corPelagem;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getNomeDono() {
		return nomeDono;
	}

	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}

	public String getContatoDono() {
		return contatoDono;
	}

	public void setContatoDono(String contatoDono) {
		this.contatoDono = contatoDono;
	}

	public LocalDate getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDate dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
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
		Pet other = (Pet) obj;
		return Objects.equals(id, other.id);
	}

}
