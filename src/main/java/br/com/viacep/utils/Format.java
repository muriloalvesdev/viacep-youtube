package br.com.viacep.utils;

import br.com.viacep.exception.FormatIdException;

public enum Format {

	JSON(1L, "json"), XML(2L, "xml");

	private long id;
	private String description;

	private Format(long id, String description) {
		this.id = id;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public static final String getById(long id) {
		for (Format format : Format.values()) {
			if (format.getId() == id) {
				return format.getDescription();
			}
		}
		throw new FormatIdException("Formato de requisicao invalido");
	}

}
