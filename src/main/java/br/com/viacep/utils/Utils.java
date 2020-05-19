package br.com.viacep.utils;

import br.com.viacep.exception.FormatIdException;

public class Utils {

	private Utils() {
	}

	public static final void validateZipCode(String zipCode) {
		if (zipCode.length() > 8 || zipCode.length() < 8) {
			throw new FormatIdException("CEP informado é invalido");
		}
	}
}
