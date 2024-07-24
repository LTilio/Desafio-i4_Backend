package br.com.Desafio_i4.model;

public enum Especie {

	CACHORRO("Cachorro"), GATO("Gato"), PASSARO("Pássaro"), OUTROS("Outros");

	private final String descricao;

	Especie(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Especie fromDescricao(String descricao) {
		for (Especie especie : Especie.values()) {
			if (especie.getDescricao().equals(descricao)) {
				return especie;
			}
		}
		throw new IllegalArgumentException("Espécie inválida: " + descricao);
	}
}
